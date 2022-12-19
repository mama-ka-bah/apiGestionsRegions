package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.services.habitantServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/habitant")
@AllArgsConstructor
@Api(value = "habitant", description = "MANIPULATION DES DONNEES DE LA TABLE PAYS")
public class HabitantController {

    @Autowired
    final private habitantServices habitantservice;

    /*
    @ApiOperation(value = "AJOUT DES DONNEE DANS LA TABLE HABITANT")
    @PostMapping("/ajout_habitant")
    public void creer(@RequestBody Habitant habitant){
        habitantservice.creer(habitant);
    }
*/
    @ApiOperation(value = "AJOUT DES DONNEE DANS LA TABLE HABITANT")
    @PostMapping("/ajout_habitant/{nbre_habitant}/{id_region_id}/{id_avoirhabitant_id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void ajout_habitant(@PathVariable Long nbre_habitant,@PathVariable Long id_region_id, @PathVariable Long id_avoirhabitant_id){
        habitantservice.ajouterHabitant(nbre_habitant, id_region_id, id_avoirhabitant_id);
    }

    @ApiOperation(value = "LISTE HABITANT")
    @GetMapping("/liste_habitant")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Habitant> lister(){
        return habitantservice.lire();
    }

    @ApiOperation(value = "MODIFIER DES DONNEES DE LA TABLE HABITANT")
    @PutMapping("/modifier_habitant/{indique_identifiant_habitant_à_modifier}")
    public Habitant modifier(@PathVariable Long indique_identifiant_habitant_à_modifier, @RequestBody Habitant habitant){
        return habitantservice.modifier(indique_identifiant_habitant_à_modifier, habitant);
    }

    @ApiOperation(value = "SUPPRESSION DES DONNEES DE LA TABLE HABITANT")
    @DeleteMapping("/supprimer_habitant/{indique_identifiant_habitant_à_supprimer}")
    @PreAuthorize("hasRole('ADMIN')")
    public String supprimer(@PathVariable Long indique_identifiant_habitant_à_supprimer){
        return habitantservice.supprimer(indique_identifiant_habitant_à_supprimer);
    }
}
