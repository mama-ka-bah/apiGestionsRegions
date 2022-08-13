package com.api.apiRegion.services;

import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.repository.habitantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@AllArgsConstructor

@Service
public class habitantServicesImplement implements habitantServices{


    private habitantRepository habitantrepository;

    @Override
    public Habitant creer(Habitant habitant) {
        return habitantrepository.save(habitant);
    }

    @Override
    public List<Habitant> lire() {
        return habitantrepository.findAll();
    }

    @Override
    public Habitant modifier(Long id, Habitant habitant) {
        return habitantrepository.findById(id)
                .map(r->{
                    r.setNbre_habitant(habitant.getNbre_habitant());
                    return habitantrepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Habitant non trouver"));
    }

    @Override
    public String supprimer(Long id) {
        habitantrepository.deleteById(id);
        return "Habitant Supprimer";
    }
}