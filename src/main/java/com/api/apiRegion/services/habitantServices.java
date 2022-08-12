package com.api.apiRegion.services;

import com.api.apiRegion.modele.Habitant;

import java.util.List;

public interface habitantServices {
    Habitant creer(Habitant habitant);
    List<Habitant> lire();
    Habitant modifier(Long id, Habitant habitant);
    String supprimer(Long id);
}
