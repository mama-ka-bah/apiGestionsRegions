package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.services.regionServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/region")
@AllArgsConstructor
public class RegionController {
    private final regionServices regionservice;

    @PostMapping("/create")
    public Regions create(@RequestBody Regions regions){
        return regionservice.creer(regions);
    }

    @GetMapping("/read")
    public List<Regions> read(){
        return regionservice.lire();
    }

    @PutMapping("/update/{id}")
    public Regions update(@PathVariable Long id, @RequestBody Regions regions){
        return regionservice.modifier(id, regions);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return regionservice.supprimer(id);
    }
}
