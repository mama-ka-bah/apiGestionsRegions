package com.api.apiRegion.security.services;

import com.api.apiRegion.modele.Commentaires;
import com.api.apiRegion.repository.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireServiceImpl implements CommentairesService{

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public Commentaires ajouterUnCommentaire(Commentaires commentaires) {
        return commentaireRepository.save(commentaires);
    }
}
