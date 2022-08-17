package com.api.apiRegion.controller;


import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.services.habitantServices;
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
    private final habitantServices habitantservices;

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE REGION") //décrit une opération ou généralement une méthode HTTP par rapport à un chemin spécifique.
    @PostMapping("/ajout_region")
    //Methode permettant d'ajouter des regions et habitant en meme tant
    public Regions create(@RequestBody Regions regions){
        /*regionservice.creer(regions);
        habitantservices.creer(habitant);*/
        return regionservice.creer(regions);
    }

    //Methothode permettant de lire les regions avec pays
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
    @DeleteMapping("/supprimer_region/{identifiant_region}")
    public String delete(@PathVariable Long identifiant_region){
        return regionservice.supprimer(identifiant_region);
    }
}
