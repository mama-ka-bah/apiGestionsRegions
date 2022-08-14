package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface regionsRepository extends JpaRepository<Regions, Long> {
    @Query(value = "SELECT code_region,nom_region,domaine_activite,superficie,langue_majoritaire FROM regions", nativeQuery = true )
    public Iterable<Object[]> FINDALLREGIONWITHOUTPAYS();

}
