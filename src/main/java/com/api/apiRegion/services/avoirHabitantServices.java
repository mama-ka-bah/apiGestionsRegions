package com.api.apiRegion.services;

import com.api.apiRegion.modele.AvoirHabitant;

import java.util.List;

public interface avoirHabitantServices {
    //DECLARATION DE LA METHODE CREER
    int creer(Long annee);
    AvoirHabitant trouverAnnee(Long annee);
    //DECLARATION DE LA METHODE LIRE
    List<AvoirHabitant> lire();

    //DECLARATION DE LA METHODE MODIFIER
    AvoirHabitant modifier(Long id, AvoirHabitant avoirhabitant);

    //DECLARATION DE LA METHODE SUPPRIMER
    String supprimer(Long id);

    //Trouvez L'Annee
    AvoirHabitant VerifierHabitant(Long annee);
}
