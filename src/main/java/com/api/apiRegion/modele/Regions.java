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

    private String description;

    //@Column(nullable = true, length = 90)
    private String photoaregion;

    @Column(unique = true)
    private String nom;

    //JOINTURE ENTRE LA TABLE REGION ET PAYS
    //@ManyToOne
    //@JoinColumn(name = "idpays_id")

    @ManyToOne
    @JoinColumn(name = "idpays_id")
    private Pays idpays;


}
