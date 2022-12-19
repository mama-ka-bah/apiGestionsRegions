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

    //La fonction utilisé pour ajouter la region avec des requete native le nom "ajouterRegionAvecHabitant" ne siginfie pas que c'est elle seul qui ajoute la region avec l'habitant elle juste utilsé dans le controlleur qui permet d'ajouter la region avec habitant et l'année
    int ajouterRegionAvecHabitant(String nom_region, String code_region, String domaine_activite, String langue_majoritaire, String superficie,String photoaregion, String description, Long idpays);

    //recherche du region par son nom, elle retourne l'objet de type region
    Regions trouverRegionParNom(String nom);
}
