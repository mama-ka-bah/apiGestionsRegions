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
    @PostMapping("/ajout_annee/{anneee}")
    public int creer(@PathVariable Long anneee){
        avoirhabitantService.creer(anneee);
        return 1;
    }

    @ApiOperation(value = "LISTE ANNEE")
    @GetMapping("/liste_annee")
    public List<AvoirHabitant> lister(){
        return avoirhabitantService.lire();
    }

    @ApiOperation(value = "MODIFIER LES DONNER DE LA TABLE AVOIRHABITANT")
    @PutMapping("/modifier_annee/{id}")
    public AvoirHabitant modifier(@PathVariable Long indique_identifiant_annee_à_modifier, @RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.modifier(indique_identifiant_annee_à_modifier, avoirhabitant);
    }

    @ApiOperation(value = "SUPPRIMER LES DONNEES DE LA TABLE AVOIRHABITANT")
    @DeleteMapping("/supprimer_annee/{id}")
    public String supprimer(@PathVariable Long indique_identifiant_annee_à_supprimer){
        return avoirhabitantService.supprimer(indique_identifiant_annee_à_supprimer);
    }
}
