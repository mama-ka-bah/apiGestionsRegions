package com.api.apiRegion.controller;

import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.services.avoirHabitantServices;
import com.api.apiRegion.services.habitantServices;
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
    public AvoirHabitant creer(@RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.creer(avoirhabitant);
    }

    @ApiOperation(value = "LISTE ANNEE")
    @GetMapping("/liste_annee")
    public List<AvoirHabitant> lister(){
        return avoirhabitantService.lire();
    }

    @ApiOperation(value = "MODIFIER LES DONNER DE LA TABLE AVOIRHABITANT")
    @PutMapping("/modifier_annee/{id}")
    public AvoirHabitant modifier(@PathVariable Long id, @RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.modifier(id, avoirhabitant);
    }

    @ApiOperation(value = "SUPPRIMER LES DONNEES DE LA TABLE AVOIRHABITANT")
    @DeleteMapping("/supprimer_annee/{id}")
    public String supprimer(@PathVariable Long id){
        return avoirhabitantService.supprimer(id);
    }
}
