package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface paysRepository extends JpaRepository<Pays, Long> {
    Pays findByNomp(String nom);
}
