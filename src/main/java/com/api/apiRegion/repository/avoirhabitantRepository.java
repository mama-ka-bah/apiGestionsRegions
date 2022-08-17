package com.api.apiRegion.repository;

import com.api.apiRegion.modele.AvoirHabitant;
import com.api.apiRegion.modele.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface avoirhabitantRepository extends JpaRepository<AvoirHabitant, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert into avoirhabitant(annee) values (:annee);", nativeQuery = true)
    public int INSERTANNEE(@Param("annee") Long annee);

    AvoirHabitant findByAnnee(Long annee);

}