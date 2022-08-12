package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.services.paysServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/pays")
@RestController
public class PaysController {

    @Autowired
    paysServices paysservice;

    /*public PaysController(){
        this.paysservice = null;
    }*/

    @PostMapping("/create")
    public Pays create(@RequestBody Pays pays){
        return paysservice.creer(pays);
    }

    @GetMapping("/read")
    public List<Pays> read(){
        return paysservice.lire();
    }

    @PutMapping("/update/{id}")
    public Pays update(@PathVariable Long id, @RequestBody Pays pays){
        return paysservice.modifier(id, pays);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return paysservice.supprimer(id);
    }
}
