package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.services.habitantServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/habitant")
@AllArgsConstructor
public class HabitantController {
    final private habitantServices habitantservice;

    @PostMapping("/creer")
    public Habitant creer(@RequestBody Habitant habitant){
        return habitantservice.creer(habitant);
    }

    @GetMapping("/lister")
    public List<Habitant> lister(){
        return habitantservice.lire();
    }

    @PutMapping("/modifier/{id}")
    public Habitant modifier(@PathVariable Long id, @RequestBody Habitant habitant){
        return habitantservice.modifier(id, habitant);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return habitantservice.supprimer(id);
    }
}
