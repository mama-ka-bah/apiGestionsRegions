package com.api.apiRegion.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "habitants")
@Getter
@Setter
@NoArgsConstructor
public class Habitant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15)
    private Long nbre_habitant;
    @Column(length = 20)
    private Long annee;

}
