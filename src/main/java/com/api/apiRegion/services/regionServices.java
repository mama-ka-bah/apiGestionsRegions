package com.api.apiRegion.services;

import com.api.apiRegion.modele.Regions;

import java.util.List;

public interface regionServices {

    //DECLARATION DE LA METHODE CREER
    Regions creer(Regions regions);

    //DECLARATION DE LA METHODE LIREAVECPAYS
    List<Object[]> lire();

    //DECLARATION DE LA METHODE LIRESANSPAYS
    Iterable<Object[]> lireSansPays();

    //DECLARATION DE LA METHODE MODIFICATION
    Regions modifier(Long id, Regions regions);

    //DECLARATION DE LA METHODE SUPPRIMER
    String supprimer(Long id);
}
