package com.api.apiRegion.services;

import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.repository.paysRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor

@Service
public class paysSeImplement implements paysServices {

    private  paysRepository paysrepository;

    @Override
    public Pays creer(Pays pays) {
        return paysrepository.save(pays);
    }

    @Override
    public List<Pays> lire() {
        return paysrepository.findAll();
    }

    @Override
    public Pays modifier(Long id, Pays pays) {
        return paysrepository.findById(id)
                .map(r->{
                    r.setNom(pays.getNom());
                    return paysrepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Pays nom trouver"));
    }

    @Override
    public String supprimer(Long id) {
        paysrepository.deleteById(id);
        return "Pays Supprimer";
    }
}
