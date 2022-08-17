package com.api.apiRegion.controller;

<<<<<<< HEAD
import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.services.habitantServices;
=======
import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.services.avoirHabitantServices;
import com.api.apiRegion.services.habitantServices;
import com.api.apiRegion.services.paysServices;
>>>>>>> correction
import com.api.apiRegion.services.regionServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
@RequestMapping("/region")//l'url permettant d'appeler le controlleur de region
@AllArgsConstructor//Permet d'inclure le constructeur avec argument(lomboc)
@Api(value = "region", description = "MANIPULATION DES DONNEES DE LA TABLE REGION")//permet de configurer une classe en tant que ressource Swagger
//le controlleur ci-dessous permet de manupiler la region
public class RegionController {
    private final regionServices regionservice;//final permet rendre regionServices inchangeable
<<<<<<< HEAD
    private final habitantServices habitantservices;

=======
    //private final Pays pays;
    private  final paysServices paysservice;
    private  final habitantServices habitantervice;
    private  final avoirHabitantServices avoirhabitantservices;
>>>>>>> correction
    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE REGION") //décrit une opération ou généralement une méthode HTTP par rapport à un chemin spécifique.
    @PostMapping("/ajout_region")
    public Regions create(@RequestBody Regions regions, Habitant habitant){
        regionservice.creer(regions);
        habitantservices.creer(habitant);
        return regionservice.creer(regions);
    }

<<<<<<< HEAD
=======

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE REGION avec habitant") //décrit une opération ou généralement une méthode HTTP par rapport à un chemin spécifique.
    @PostMapping("/ajout_region_habitant/{nom}/{code_region}/{domaine_activite}/{langue_majoritaire}/{superficie}/{nom_pays}/{nombre_habitant}/{annee}")
    public int ajouterRegionAvecHabitant(@PathVariable String nom, @PathVariable String code_region, @PathVariable String domaine_activite, @PathVariable String langue_majoritaire, @PathVariable String superficie, @PathVariable String nom_pays, @PathVariable String nombre_habitant, @PathVariable Long annee){

        Pays pays = paysservice.trouverPaysParNom(nom_pays);

        regionservice.ajouterRegionAvecHabitant(nom, code_region, domaine_activite, langue_majoritaire, superficie, pays.getId());
        Regions region = regionservice.trouverRegionParNom(nom);
        AvoirHabitant avoirhabitant = avoirhabitantservices.trouverAnnee(annee);
        habitantervice.ajouterHabitant(nombre_habitant, region.getId(), avoirhabitant.getId());

        return 1;
    }
    
    

>>>>>>> correction
    @ApiOperation(value = "LISTE DES REGIONS AVEC PAYS")
    @GetMapping("/liste_region")
    public List<Object[]> read(){
        return regionservice.lire();
    }

    @ApiOperation(value = "LISTE DES REGIONS SANS PAYS")
    @GetMapping("/liste_region_sans_pays")
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
    @PutMapping("/modifier_region/{identifiant_region}")
    public Regions update(@PathVariable Long identifiant_region, @RequestBody Regions regions){
        return regionservice.modifier(identifiant_region, regions);
    }

    @ApiOperation(value = "SUPPRESION DES DONNEES DE LA TABLE REGION")
    @DeleteMapping("/supprimer_region/{id}")
    public String delete(@PathVariable Long id){
        return regionservice.supprimer(id);
    }
}
