package com.api.apiRegion.repository;

import com.api.apiRegion.modele.Commentaires;
import com.api.apiRegion.modele.Regions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaires, Long> {
    List<Commentaires> findByRegion(Regions region);
}
