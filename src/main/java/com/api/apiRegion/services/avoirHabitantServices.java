package com.api.apiRegion.services;

import com.api.apiRegion.modele.AvoirHabitant;

import java.util.List;

public interface avoirHabitantServices {
    AvoirHabitant creer(AvoirHabitant avoirhabitant);
    List<AvoirHabitant> lire();
    AvoirHabitant modifier(Long id, AvoirHabitant avoirhabitant);
    String supprimer(Long id);
}
