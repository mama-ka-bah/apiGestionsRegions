package com.api.apiRegion.services;

import com.api.apiRegion.modele.Regions;

import java.util.List;

public interface regionServices {

    Regions creer(Regions regions);
    List<Regions> lire();
    Iterable<Object[]> lireSansPays();
    Regions modifier(Long id, Regions regions);
    String supprimer(Long id);
}
