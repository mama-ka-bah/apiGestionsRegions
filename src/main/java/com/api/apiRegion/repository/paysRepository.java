package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface paysRepository extends JpaRepository<Pays, Long> {

    //enregistrement du pays avec des requetes native
    @Modifying
    @Transactional
    @Query(value = "insert into pays(nomp) values (:nomp);", nativeQuery = true)
    public int INSERTPAYS(@Param("nomp") String nomp);

    Pays findByNomp(String nom);
}
