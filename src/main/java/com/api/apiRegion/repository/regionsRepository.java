package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface regionsRepository extends JpaRepository<Regions, Long> {

    /*
    * Definition des requetes native pour selection des region sans pays et avec pays
    *
    * */

    //Region sans pays
    @Query(value = "SELECT code_region,nom_region,domaine_activite,superficie,langue_majoritaire FROM regions", nativeQuery = true )
    public Iterable<Object[]> FINDALLREGIONWITHOUTPAYS();

    //Region avec pays
    @Query(value = "SELECT regions.nom_region, pays.nom FROM regions, pays where regions.idpays_id = pays.id", nativeQuery = true )
    public Iterable<Object[]> FINDALLREGION();

}
