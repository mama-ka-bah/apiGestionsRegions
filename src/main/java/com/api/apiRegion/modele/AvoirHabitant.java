package com.api.apiRegion.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "avoirhabitant")
@Getter
@Setter
@NoArgsConstructor
public class AvoirHabitant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long annee;

}
