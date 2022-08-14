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
@Api(value = "region", description = "MANIPULATION DES DONNEES DE LA TABLE REGION")
public class RegionController {
    private final regionServices regionservice;

    @ApiOperation(value = "AJOUT DES DONNEES DANS LA TABLE REGION")
    @PostMapping("/ajout_region")
    public Regions create(@RequestBody Regions regions){
        return regionservice.creer(regions);
    }

    @ApiOperation(value = "LISTE DES REGIONS AVEC PAYS")
    @GetMapping("/liste_region")
    public List<Regions> read(){
        return regionservice.lire();
    }

    @ApiOperation(value = "LISTE DES REGIONS SANS PAYS")
    @GetMapping("/liste_region_sans_pays")
    public Iterable<Object[]> list(){return regionservice.lireSansPays();}

    @ApiOperation(value = "MODIFICATION DES DONNEES DE LA TABLE REGION")
    @PutMapping("/modifier_region/{id}")
    public Regions update(@PathVariable Long id, @RequestBody Regions regions){
        return regionservice.modifier(id, regions);
    }

    @ApiOperation(value = "SUPPRESION DES DONNEES DE LA TABLE REGION")
    @DeleteMapping("/supprimer_region/{id}")
    public String delete(@PathVariable Long id){
        return regionservice.supprimer(id);
    }
}
