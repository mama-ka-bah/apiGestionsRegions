package com.api.apiRegion.services;

import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.repository.paysRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor //Annotation qui va nous permettre de gerer les problèmes de constructeur pour tous les champs

@Service
public class paysSeImplement implements paysServices {

    //DECLARATION D'UN ATTRIBUT DE TYPE REPOSITORY'
    @Autowired
    private  paysRepository paysrepository;

    //IMPLEMENTATION DE LA METHODE CREER

   /*
   @Override
    public Pays creer(Pays pays) {
         return paysrepository.save(pays);
    }
   */
    @Override
    public Pays ajouterPays(Pays pays) {
        return paysrepository.save(pays);
    }

    //IMPLEMENTATION DE LA METHODE LIRE
    @Override
    public List<Pays> lire() {
        return paysrepository.findAll();
    }

    //IMPLEMENTATION DE LA METHODE MODIFIER
    @Override
    public Pays modifier(Long id, Pays pays) {
        return paysrepository.findById(id)
                .map(r->{
                    r.setNomp(pays.getNomp());
                    return paysrepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Pays nom trouver"));
    }

    //IMPLEMENTATION DE LA METHODE SUPPRIMER
    @Override
    public String supprimer(Long id) {
        paysrepository.deleteById(id);
        return "Pays Supprimer";
    }

    @Override
    public Pays trouverPaysParNom(String nom) {
        return paysrepository.findByNomp(nom);
    }
}
