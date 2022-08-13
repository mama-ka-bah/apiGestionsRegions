package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.services.habitantServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/habitant")
@AllArgsConstructor
@Api(value = "hello", description = "Sample hello world application")
public class HabitantController {

    @Autowired
    final private habitantServices habitantservice;

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/creer")
    public Habitant creer(@RequestBody Habitant habitant){
        return habitantservice.creer(habitant);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/lister")
    public List<Habitant> lister(){
        return habitantservice.lire();
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PutMapping("/modifier/{id}")
    public Habitant modifier(@PathVariable Long id, @RequestBody Habitant habitant){
        return habitantservice.modifier(id, habitant);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return habitantservice.supprimer(id);
    }
}
