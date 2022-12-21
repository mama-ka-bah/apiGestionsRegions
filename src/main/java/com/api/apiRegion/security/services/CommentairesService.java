package com.api.apiRegion.security.services;

import com.api.apiRegion.modele.Commentaires;
import com.api.apiRegion.modele.Regions;

public interface CommentairesService {
    Commentaires ajouterUnCommentaire(Commentaires commentaires);

    Regions incrementNombreCommentaire(Long id);
}
