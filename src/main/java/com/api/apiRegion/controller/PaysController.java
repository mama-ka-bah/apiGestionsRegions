package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.services.paysServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pays")
@RestController
@Api(value = "hello", description = "Sample hello world application")
public class PaysController {

    @Autowired
    paysServices paysservice;

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/create")
    public Pays create(@RequestBody Pays pays){
        return paysservice.creer(pays);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/read")
    public List<Pays> read(){
        return paysservice.lire();
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PutMapping("/update/{id}")
    public Pays update(@PathVariable Long id, @RequestBody Pays pays){
        return paysservice.modifier(id, pays);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return paysservice.supprimer(id);
    }
}
