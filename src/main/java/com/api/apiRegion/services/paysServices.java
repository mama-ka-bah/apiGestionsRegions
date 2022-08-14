package com.api.apiRegion.services;

import com.api.apiRegion.modele.Pays;

import java.util.List;

public interface paysServices {

    //DECLARATION DE LA METHODE CREER
    Pays creer(Pays pays);

    //DECLARATION DE LA METHODE LIRE
    List<Pays> lire();

    //DECLARATION DE LA METHODE MODIFIER
    Pays modifier(Long id, Pays pays);

    //DECLARATION DE LA METHODE SUPPRIMER
    String supprimer(Long id);
}
