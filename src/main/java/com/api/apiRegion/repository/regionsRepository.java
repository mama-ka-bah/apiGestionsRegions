package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface regionsRepository extends JpaRepository<Regions, Long> {

}
