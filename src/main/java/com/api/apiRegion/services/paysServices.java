package com.api.apiRegion.services;

import com.api.apiRegion.modele.Pays;

import java.util.List;//permettant d'importer les outils necessaire pour la creation des liste

public interface paysServices {
    //methode permettant de creer un pays
    Pays creer(Pays pays);
    //methode permettant de lister les pays
    List<Pays> lire();
    //methode permettant de creer un pays
    Pays modifier(Long id, Pays pays);
    //methode permettant de supprimer un pays
    String supprimer(Long id);
}
