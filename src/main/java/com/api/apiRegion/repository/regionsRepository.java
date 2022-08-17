package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.modele.Regions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface regionsRepository extends JpaRepository<Regions, Long> {

    /*
    * Definition des requetes native pour selection des region sans pays et avec pays
    *
    * */
    //@Query(value = "INSERT INTO Regions (code_region, nom_region, domaine_activite, superficie, langue_majoritaire, idpays, ")
    //Region sans pays
    @Query(value = "SELECT code_region,nom,domaine_activite,superficie,langue_majoritaire FROM regions", nativeQuery = true )
    public List<Object[]> FINDALLREGIONWITHOUTPAYS();

    //Region avec pays
    @Query(value = "SELECT regions.nom, pays.nom FROM regions, pays where regions.idpays_id = pays.id", nativeQuery = true )
    public List<Object[]> FINDALLREGION();

    //Une region donnée avec ses polpulation dans des differentes année
    @Query(value = "select habitants.nbre_habitant, regions.nom, avoirhabitant.annee from habitants, regions, avoirhabitant where habitants.id_region_id = regions.id and habitants.id_avoirhabitant_id = avoirhabitant.id;", nativeQuery = true )
    public List<Object[]> FINDREGION_HBT_ANNEE();

    //Trouvé les regions à partir d'un pays d'un pays donnée
    @Query(value = "select regions.nom from regions, pays where regions.idpays_id = pays.id and  pays.nom =:pays", nativeQuery = true )
    public List<Object[]> FINDREGIONSOFPAYS(@Param("pays") String pays);//@param fait reference parametre à afficher


    @Modifying
    @Transactional
    @Query(value = "insert into regions(nom,code_region,domaine_activite,langue_majoritaire,superficie,idpays_id) values (:nom,:code_region,:domaine_activite,:langue_majoritaire,:superficie,:idpays_id);", nativeQuery = true)
    public int INSERTREGIONWITHHABITANT(@Param("nom") String region,@Param("code_region") String code_region, @Param("domaine_activite") String domaine_activite, @Param("langue_majoritaire") String langue_majoritaire, @Param("superficie") String superficie, @Param("idpays_id") Long idpays_id);//@param fait reference parametre à afficher

    Regions findByNom(String nom);

}
