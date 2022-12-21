package com.api.apiRegion.modele;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
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
