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
    @Column(length = 15)
    private String code_region;
    @Column(length = 15)
    private String domaine_activite;
    @Column(length = 150)
    private String superficie;
    @Column(length = 100)
    private String langue_majoritaire;


    //@ManyToOne
    @ManyToOne
    @JoinColumn(name = "nb_habitant_id")
    private Habitant nbHabitant;

    @ManyToOne
    @JoinColumn(name = "idpays_id")
    private Pays idpays;

}
