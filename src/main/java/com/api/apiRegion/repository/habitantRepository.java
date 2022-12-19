package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface habitantRepository extends JpaRepository<Habitant,Long> {

    @Modifying
    @Transactional
    @Query(value = "insert into habitants(nbre_habitant, id_region_id, id_avoirhabitant_id) values (:nbre_habitant,:id_region_id,:id_avoirhabitant_id);", nativeQuery = true)
    public int INSERTHABITANT(@Param("nbre_habitant") Long nbre_habitant, @Param("id_region_id") Long id_region_id, @Param("id_avoirhabitant_id") Long id_avoirhabitant_id);//@param fait reference parametre à afficher

}
