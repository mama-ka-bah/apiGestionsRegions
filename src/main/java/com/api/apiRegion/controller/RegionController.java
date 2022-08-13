package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.services.regionServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
@Api(value = "hello", description = "Sample hello world application")
public class RegionController {
    private final regionServices regionservice;

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PostMapping("/create")
    public Regions create(@RequestBody Regions regions){
        return regionservice.creer(regions);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @GetMapping("/read")
    public List<Regions> read(){
        return regionservice.lire();
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @PutMapping("/update/{id}")
    public Regions update(@PathVariable Long id, @RequestBody Regions regions){
        return regionservice.modifier(id, regions);
    }

    @ApiOperation(value = "Just to test the sample test api of My App Service")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return regionservice.supprimer(id);
    }
}
