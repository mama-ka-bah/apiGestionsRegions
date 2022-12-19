package com.api.apiRegion.modele;

import lombok.Data;

import javax.persistence.*;
import javax.swing.plaf.synth.Region;
import java.util.Date;

@Entity
@Data
public class Commentaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    private String contenu;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "auteur_commentaire")
    private Collaborateurs auteur;

    @ManyToOne
    @JoinColumn(name = "region_concerne")
    private Regions region;

}
