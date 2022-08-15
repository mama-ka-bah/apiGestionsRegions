package com.api.apiRegion.services;

import com.api.apiRegion.modele.Habitant;

import java.util.List;

public interface habitantServices {
    //DECLARATION DE LA METHODE CREER
    Habitant creer(Habitant habitant);

    //DECLARATION DE LA METHODE LIRE
    List<Habitant> lire();

    //DECLARATION DE LA METHODE MODIFIER
    Habitant modifier(Long id, Habitant habitant);

    //DECLARATION DE LA METHODE SUPPRIMER
    String supprimer(Long id);
}
