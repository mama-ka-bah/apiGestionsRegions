package com.api.apiRegion.services;

import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.repository.avoirhabitantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor //Annotation qui va nous permettre de gerer les problèmes de constructeur pour tous les champs
@Service
public class avoirHabitantServicesImplement implements avoirHabitantServices{

    //DECLARATION D'UNE VARIABLE DE TYPE REPOSITORY
    private avoirhabitantRepository avoirhabitantrepository;

    //IMPLEMENTATION DE LA METHODE CREER
    @Override
    public int creer(Long annee) {

        return avoirhabitantrepository.INSERTANNEE(annee);
    }
//Averifier peut etre qu'il une duplication de fonction, confusion avec la derniere fonction
    @Override
    public AvoirHabitant trouverAnnee(Long annee) {
        return avoirhabitantrepository.findByAnnee(annee);
    }

    //IMPLEMENTATION DE LA METHODE LIRE
    @Override
    public List<AvoirHabitant> lire() {
        return avoirhabitantrepository.findAll();
    }

    //IMPLEMENTATION DE LA METHODE MODIFIER
    @Override
    public AvoirHabitant modifier(Long id, AvoirHabitant avoirhabitant) {
        return avoirhabitantrepository.findById(id)
                .map(ah->{
                    ah.setAnnee(avoirhabitant.getAnnee());
                    return avoirhabitantrepository.save(ah);
                }).orElseThrow(() -> new RuntimeException("Habitant non trouver"));
    }

    //IMPLEMENTATION DE LA METHODE SUPPRIMER
    @Override
    public String supprimer(Long id) {
        avoirhabitantrepository.deleteById(id);
        return "Habitant Supprimer";
    }

}
