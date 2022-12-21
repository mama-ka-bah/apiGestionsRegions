package com.api.apiRegion.security.services;

import com.api.apiRegion.modele.Commentaires;
import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.repository.CommentaireRepository;
import com.api.apiRegion.repository.regionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireServiceImpl implements CommentairesService{

    @Autowired
    CommentaireRepository commentaireRepository;

    @Autowired
    regionsRepository regionsRepo;

    @Override
    public Commentaires ajouterUnCommentaire(Commentaires commentaires) {
        System.err.println("***************************************: "+commentaires);
        return commentaireRepository.save(commentaires);
    }

    @Override
    public Regions incrementNombreCommentaire(Long id) {
        Regions regions = regionsRepo.findById(id).get();
        return regionsRepo.findById(id)
                .map(r-> {
                    r.setNbreCommentairte(r.getNbreCommentairte()+1);
                    return regionsRepo.save(r);
                }).orElseThrow(() -> new RuntimeException("Region non trouvé !"));
    }

}
