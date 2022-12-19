package com.api.apiRegion.services;

import com.api.apiRegion.modele.Pays;

import java.util.List;

public interface paysServices {
    //Pays creer(Pays pays);
    List<Pays> lire();
    Pays modifier(Long id, Pays pays);
    String supprimer(Long id);

    //recherche d'un pays par son nom
    Pays trouverPaysParNom(String name);

    //fonction permettant d'ajouter un pays avec des requete native
    Pays ajouterPays(Pays pays);

}
