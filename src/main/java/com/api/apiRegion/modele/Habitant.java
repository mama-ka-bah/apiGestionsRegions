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

    private Long nbre_habitant;

    //JOINTURE ENTRE LA TABLE HABITANT ET LA TABLE
    @OneToOne
    @JoinColumn(name = "id_avoirhabitant_id")
    private AvoirHabitant id_avoirhabitant;
}
