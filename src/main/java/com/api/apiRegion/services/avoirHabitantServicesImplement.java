package com.api.apiRegion.services;

import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.repository.avoirhabitantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class avoirHabitantServicesImplement implements avoirHabitantServices{

    private avoirhabitantRepository avoirhabitantrepository;

    @Override
    public AvoirHabitant creer(AvoirHabitant avoirhabitant) {
        return avoirhabitantrepository.save(avoirhabitant);
    }

    @Override
    public List<AvoirHabitant> lire() {
        return avoirhabitantrepository.findAll();
    }

    @Override
    public AvoirHabitant modifier(Long id, AvoirHabitant avoirhabitant) {
        return avoirhabitantrepository.findById(id)
                .map(ah->{
                    ah.setAnnee(avoirhabitant.getAnnee());
                    return avoirhabitantrepository.save(ah);
                }).orElseThrow(() -> new RuntimeException("Habitant non trouver"));
    }

    @Override
    public String supprimer(Long id) {
        avoirhabitantrepository.deleteById(id);
        return "Habitant Supprimer";
    }

}
