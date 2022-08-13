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
@Api(value = "hello", description = "Sample hello world application")
public class AvoirHabitantController {
    @Autowired
    final private avoirHabitantServices avoirhabitantService;

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/ajouter")
    public AvoirHabitant creer(@RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.creer(avoirhabitant);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/lister")
    public List<AvoirHabitant> lister(){
        return avoirhabitantService.lire();
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PutMapping("/modifier/{id}")
    public AvoirHabitant modifier(@PathVariable Long id, @RequestBody AvoirHabitant avoirhabitant){
        return avoirhabitantService.modifier(id, avoirhabitant);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return avoirhabitantService.supprimer(id);
    }
}
