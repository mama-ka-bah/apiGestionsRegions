package com.api.apiRegion.repository;

import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.modele.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface avoirhabitantRepository extends JpaRepository<AvoirHabitant, Long> {

}
