package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.services.paysServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/pays")
@RestController
@Api(value = "pays", description = "MANIPULATION DES DONNEES DE LA TABLE PAYS")
public class PaysController {

    @Autowired
    paysServices paysservice;

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE PAYS")
    @PostMapping("/ajout_pays/{npays}")

//@RequestBody Pays pays
    public String create(@PathVariable String npays){

        //verification si le pays existe déjà dans la base ou pas
        Pays veryfierNomPays = paysservice.trouverPaysParNom(npays);//recuperation du pays dans la base
        System.out.println(npays);
        if (veryfierNomPays == null)
        {
            Pays monPays = new Pays();
            monPays.setNomp(npays);
            paysservice.ajouterPays(monPays);
            return "le pays est bien ajouter";
        }
        else
            return "Le pays Exist Deja";

    }

    @ApiOperation(value = "LISTE PAYS")
    @GetMapping("/liste_pays")
    public List<Pays> read(){
        return paysservice.lire();
    }

    @ApiOperation(value = "MODIFICATION DES DONNEES DE LA TABLE PAYS")
    @PutMapping("/modifier_pays/{indique_identifiant_Pays_à_modifier}")
    @PreAuthorize("hasRole('ADMIN')")
    public Pays update(@PathVariable Long indique_identifiant_Pays_à_modifier, @RequestBody Pays pays){
        return paysservice.modifier(indique_identifiant_Pays_à_modifier, pays);
    }

    @ApiOperation(value = "SUPPRESION DES DONNEE DANS LA TABLE PAYS")
    @DeleteMapping("/supprimer_pays/{indique_identifiant_Pays_à_modifier}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long indique_identifiant_Pays_à_modifier){
        return paysservice.supprimer(indique_identifiant_Pays_à_modifier);
    }
}
