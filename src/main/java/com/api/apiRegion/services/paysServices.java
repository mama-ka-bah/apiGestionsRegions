package com.api.apiRegion.services;

import com.api.apiRegion.modele.Pays;

import java.util.List;

public interface paysServices {
    Pays creer(Pays pays);
    List<Pays> lire();
    Pays modifier(Long id, Pays pays);
    String supprimer(Long id);
}
