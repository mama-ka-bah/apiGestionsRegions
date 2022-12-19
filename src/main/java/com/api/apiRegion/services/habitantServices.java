package com.api.apiRegion.services;

import com.api.apiRegion.modele.Habitant;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface habitantServices {
    //DECLARATION DE LA METHODE CREER
    Habitant creer(Habitant habitant);

    //ajoutant de l'habitant avec la requete
    int ajouterHabitant(Long nbre_habitant,Long id_region_id, Long id_avoirhabitant_id);

    //DECLARATION DE LA METHODE LIRE
    List<Habitant> lire();

    //DECLARATION DE LA METHODE MODIFIER
    Habitant modifier(Long id, Habitant habitant);

    //DECLARATION DE LA METHODE SUPPRIMER
    String supprimer(Long id);
}
