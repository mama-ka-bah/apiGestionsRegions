package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Habitant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface habitantRepository extends JpaRepository<Habitant,Long> {
}
