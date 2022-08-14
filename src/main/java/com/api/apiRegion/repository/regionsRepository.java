package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    //Une region donnée avec ses polpulation dans des differentes année
    @Query(value = "select regions.nom_region,habitants.nbre_habitant,avoirhabitant.annee from regions, habitants,avoirhabitant where regions.nb_habitant_id = habitants.id and habitants.id_avoirhabitant_id = avoirhabitant.id;", nativeQuery = true )
    public List<Object[]> FINDREGION_HBT_ANNEE();

    //Trouvé les regions à partir d'un pays d'un pays donnée
    @Query(value = "select regions.nom_region from regions, pays where regions.idpays_id = pays.id and  pays.nom =:pays", nativeQuery = true )
    public List<Object[]> FINDREGIONSOFPAYS(@Param("pays") String pays);//@param fait reference parametre à afficher

}
