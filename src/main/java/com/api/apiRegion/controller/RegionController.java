package com.api.apiRegion.controller;

import com.api.apiRegion.DAO.HabitantAnnees;
import com.api.apiRegion.img.ConfigImage;
import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.repository.paysRepository;
import com.api.apiRegion.repository.regionsRepository;
import com.api.apiRegion.services.habitantServices;

import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.services.avoirHabitantServices;
import com.api.apiRegion.services.habitantServices;
import com.api.apiRegion.services.paysServices;

import com.api.apiRegion.services.regionServices;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*
    @PostMapping gère les requêtes HTTP de type post
    @GetMapping gère les requêtes HTTP de type post
    @PutMapping gère les requêtes HTTP de type put
    @DeleteMapping gère les requêtes HTTP de type Delete
    @RequestBody mappe le corps HttpRequest à un objet de transfert
    @PathVariable //disposition des parametre
    un type List est garanti être un Iterable mais un type  Iterable peut ne pas être un List
*/

@RestController//permet de specifier que la classe ci-dessus est un controlleur
@RequestMapping("/api/region")//l'url permettant d'appeler le controlleur de region
@AllArgsConstructor//Permet d'inclure le constructeur avec argument(lomboc)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@Api(value = "region", description = "MANIPULATION DES DONNEES DE LA TABLE REGION")//permet de configurer une classe en tant que ressource Swagger
//le controlleur ci-dessous permet de manupiler la region
public class RegionController {
    private final regionServices regionservice;//final permet rendre regionServices inchangeable

    private final habitantServices habitantservices;

    //private final Pays pays;
    private  final paysServices paysservice;
    private  final habitantServices habitantervice;
    private  final avoirHabitantServices avoirhabitantservices;
    private final paysServices paysservices;
    private final regionsRepository rregionsRepository;

    @Autowired
    com.api.apiRegion.repository.paysRepository paysRepository;

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE REGION") //décrit une opération ou généralement une méthode HTTP par rapport à un chemin spécifique.
    @PostMapping("/ajout_region")
    public Regions create(@RequestBody Regions regions){

        return regionservice.creer(regions);
    }


    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE REGION avec habitant") //décrit une opération ou généralement une méthode HTTP par rapport à un chemin spécifique.
    //@PreAuthorize("hasRole('ADMIN')")
    //{nom}/{coderegion}/{domaineactivite}/{langue_majoritaire}/{superficie}/{nompays}/{nombre_habitant}/{annee}
    @PostMapping("/ajout_region_habitant")
    public String ajouterRegionAvecHabitant(@RequestParam(value = "file", required = true) MultipartFile file,
                                            @RequestParam(value = "region") String regionsVenant,
                                            @RequestParam(value = "habitantAnnee") String habitantAnneVenant
                                            ) throws IOException {

        //@PathVariable String nom, @PathVariable String coderegion, @PathVariable String domaineactivite, @PathVariable String langue_majoritaire, @PathVariable String superficie, @PathVariable String nompays, @PathVariable String nombre_habitant, @PathVariable Long annee

        String url= "C:/Users/mkkeita/Desktop/projects/angular/interfaceMaliTourist/src/assets/images";

        String nomfile = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(nomfile);

        ConfigImage.saveimgA(url, nomfile, file);

        HabitantAnnees habitantAnneeRecuperer = new JsonMapper().readValue(habitantAnneVenant, HabitantAnnees.class);
        Regions regionsRecuperer = new JsonMapper().readValue(regionsVenant, Regions.class);
        regionsRecuperer.setPhotoaregion(nomfile);
        regionsRecuperer.setEtatr(true);
        String nompays = paysservice.trouverPaysParNom(regionsRecuperer.getIdpays().getNomp()).getNomp();
        System.out.println(nompays);

        //ajout du pays s'il n'existait pas
        if (paysservice.trouverPaysParNom(regionsRecuperer.getIdpays().getNomp()) == null){
            Pays pays = paysRepository.findByNomp(nompays);
            paysservice.ajouterPays(pays);
        }
        //ajout de l'annee s'il n'existait pas
        if (avoirhabitantservices.trouverAnnee(habitantAnneeRecuperer.getAnnne()) == null){
            avoirhabitantservices.creer(habitantAnneeRecuperer.getAnnne());
        }
        //recuperation de l'objet pays entré par l'utilisateur pour enfin extraire l'id
        Pays pays = paysservice.trouverPaysParNom(nompays);
        if(regionservice.trouverRegionParNom(regionsRecuperer.getNom()) == null){//si le pays entré n'a pas été trouvé dans la base on l'ajoute
            regionservice.ajouterRegionAvecHabitant(regionsRecuperer.getNom(), regionsRecuperer.getCode_region(), regionsRecuperer.getDomaine_activite(), regionsRecuperer.getLangue_majoritaire(), regionsRecuperer.getSuperficie(),regionsRecuperer.getPhotoaregion(), regionsRecuperer.getDescription(), pays.getId());//l'ajout de la region
            Regions region = regionservice.trouverRegionParNom(regionsRecuperer.getNom());//recuperation de la region enregistré
            AvoirHabitant avoirhabitant = avoirhabitantservices.trouverAnnee(habitantAnneeRecuperer.getAnnne());//recuperation de l'annee
            habitantervice.ajouterHabitant(habitantAnneeRecuperer.getNombreHabitant(), region.getId(), avoirhabitant.getId());//remplisage de la table avoirhabitant
            return "Region ajouté avec succes";
        }else {//si le pays existe déjà dans base
            return "Cette region existe déjà";
        }
    }



    @GetMapping("/detailregion/{id}")
    public Optional<Regions> detailRegion(@PathVariable Long id) {
        if (rregionsRepository.findById(id) != null){
            return rregionsRepository.findById(id);
        }else {
            return null;
        }
    }


    @ApiOperation(value = "LISTE DES REGIONS AVEC PAYS")
    @GetMapping("/liste_region")
    public List<Object[]> read(){
        return regionservice.lire();
    }

    @ApiOperation(value = "LISTE DES REGIONS AVEC PAYS")
    @GetMapping("/liste_regions")
    public List<Regions> lesregions(){

        /*
        List<Regions> mesregions = new ArrayList<>();
        //List<Regions> regionsValide = new ArrayList<>();
        mesregions = rregionsRepository.findAll();
        System.err.println(mesregions);
        if(mesregions.size() > 0){
           // for(int i=1 ; i<mesregions.size(); i++){
                //if(mesregions.get(i).getEtatr() == false)
                    //System.err.println(mesregions.size());
                    //mesregions.remove(mesregions.get(i));
            //}
            for (Regions r:mesregions) {
                if(r.getEtatr().equals(false)){
                    System.err.println(mesregions.size());
                    mesregions.remove(r);
                    System.err.println(mesregions.size());
                }
            }
        }



        System.err.println(mesregions);

         */

        return rregionsRepository.regionsFavorits();
    }

    @ApiOperation(value = "LISTE DES REGIONS SANS PAYS")
    @GetMapping("/liste_region_sans_pays")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Object[]> list(){return regionservice.lireSansPays();}

    @ApiOperation(value = "LISTE DES REGIONS ET L'EVOLUTION DE SON NOMBRE HABITANT")
    @GetMapping("/liste_region_avec_habitant_annee")
    public List<Object[]> lireRegionHbtAnnee(){return regionservice.lireRegionHbtAnnee();}

    //liste des regions d'un pays donnée
    @ApiOperation(value = "LISTE DES REGIONS D'UN PAYS DONNEE")
    @GetMapping("/liste_region_pays/{pays}")
    public List<Object[]> lireRegionOfPays(@PathVariable String pays){
        return regionservice.lireRegionOfPays(pays);
    }

    @ApiOperation(value = "MODIFICATION DES DONNEES DE LA TABLE REGION")
    @PutMapping("/modifier_region")
    //@PreAuthorize("hasRole('ADMIN')")
    public Regions update(@RequestParam(value = "file", required = true) MultipartFile file,
                          @RequestParam(value = "region") String regionsVenant
    ) throws IOException{


        String url= "C:/Users/mkkeita/Desktop/projects/angular/interfaceMaliTourist/src/assets/images";

        String nomfile = StringUtils.cleanPath(file.getOriginalFilename());
        System.out.println(nomfile);

        ConfigImage.saveimgA(url, nomfile, file);

        Regions regionsRecuperer = new JsonMapper().readValue(regionsVenant, Regions.class);

        regionsRecuperer.setPhotoaregion(nomfile);
        regionsRecuperer.setNbreCommentairte(0L);

        return regionservice.modifier(regionsRecuperer.getId(), regionsRecuperer);
    }

    @ApiOperation(value = "SUPPRESION DES DONNEES DE LA TABLE REGION")
    @DeleteMapping("/supprimer_region/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Regions delete(@PathVariable Long id){
        return regionservice.supprimer(id);
    }

    @ApiOperation(value = "LISTE DES REGIONS D'UN PAYS DONNEE")
    @GetMapping("/favouriteRegions")
    public List<Regions> lireRegionOfPays(){
        return regionservice.regionsFavories();
    }

}
