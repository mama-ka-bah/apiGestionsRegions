package com.api.apiRegion.modele;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "regions")
@Getter
@Setter
@NoArgsConstructor
public class Regions{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    private Long id;

    private String code_region;

    private String domaine_activite;

    private String superficie;

    private String langue_majoritaire;

    private String nom_region;


    //@ManyToOne
    //JOINTURE ENTRE LA TABLE REGION ET HABITANT
    @ManyToOne
    @JoinColumn(name = "nb_habitant_id")
    private Habitant nbHabitant;

    //JOINTURE ENTRE LA TABLE REGION ET PAYS
    @ManyToOne
    @JoinColumn(name = "idpays_id")
    private Pays idpays;

}
