package com.api.apiRegion.controller;

import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.services.avoirHabitantServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annee")
@AllArgsConstructor
@Api(value = "annee", description = "MANIPULATION DES DONNEES DE LA TABLE AVOIRHABITANT")
public class AvoirHabitantController {
    @Autowired
    final private avoirHabitantServices avoirhabitantService;

    @ApiOperation(value = "AJOUT DES DONNEE DANS LA TABLE AVOIRHABITANT ")
    @PostMapping("/ajout_annee")
    public String creer(@RequestBody AvoirHabitant avoirhabitant){
        if (avoirhabitantService.VerifierHabitant(avoirhabitant.getAnnee()) == null)
        {
            avoirhabitantService.creer(avoirhabitant);
            return "Annee Bien Ajouter";
        }
        else
            return "L'annee Existe Deja";
    }

    @ApiOperation(value = "LISTE ANNEE")
    @GetMapping("/liste_annee")
    public List<AvoirHabitant> lister(){
        return avoirhabitantService.lire();
    }

    @ApiOperation(value = "MODIFIER LES DONNER DE LA TABLE AVOIRHABITANT")
    @PutMapping("/modifier_annee/{indique_identifiant_annee_à_modifier}")
    public AvoirHabitant modifier(@PathVariable Long indique_identifiant_annee_à_modifier, @RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.modifier(indique_identifiant_annee_à_modifier, avoirhabitant);
    }

    @ApiOperation(value = "SUPPRIMER LES DONNEES DE LA TABLE AVOIRHABITANT")
    @DeleteMapping("/supprimer_annee/{indique_identifiant_annee_à_supprimer}")
    public String supprimer(@PathVariable Long indique_identifiant_annee_à_supprimer){
        return avoirhabitantService.supprimer(indique_identifiant_annee_à_supprimer);
    }
}
