package com.api.apiRegion.services;

import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.modele.Regions;

import java.util.List;

public interface regionServices {
    //methode ajouter Regions en indiquant les le pays et l'habitant
    //List<Object[]> CrePays(Regions regions, Pays pays, Habitant habitant, AvoirHabitant avoirHabitant);
    //methode permettant de creer une region
    Regions creer(Regions regions);
    //methode permettant de lister une region
    List<Object[]> lire();
    //methode permettant de lister des regions sans pays
    List<Object[]> lireSansPays();
    //methode permettant de lister des regions avec l'évolutiongit
    List<Object[]> lireRegionHbtAnnee();
    //methode permettant de lister les regions d'un pays
    List<Object[]> lireRegionOfPays(String pays);
    //methode permettant de modifier une region
    Regions modifier(Long id, Regions regions);
    //methode permettant de de supprimer une region

    String supprimer(Long id);

    int ajouterRegionAvecHabitant(String nom_region, String code_region, String domaine_activite, String langue_majoritaire, String superficie, Long idpays);

    //Regions trouverPaysParNom();
}
