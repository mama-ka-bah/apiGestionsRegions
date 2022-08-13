package com.api.apiRegion.controller;

import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.services.avoirHabitantServices;
import com.api.apiRegion.services.habitantServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annee")
@AllArgsConstructor
public class AvoirHabitantController {
    @Autowired
    final private avoirHabitantServices avoirhabitantService;

    @PostMapping("/ajouter")
    public AvoirHabitant creer(@RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.creer(avoirhabitant);
    }

    @GetMapping("/lister")
    public List<AvoirHabitant> lister(){
        return avoirhabitantService.lire();
    }

    @PutMapping("/modifier/{id}")
    public AvoirHabitant modifier(@PathVariable Long id, @RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.modifier(id, avoirhabitant);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return avoirhabitantService.supprimer(id);
    }
}
