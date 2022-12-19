package com.api.apiRegion.controller;

import com.api.apiRegion.modele.Commentaires;
import com.api.apiRegion.security.services.CommentairesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commentaire")
public class CommmentaireController {

    @Autowired
    CommentairesService commentairesService;

    @PostMapping("/ajouter")
    public Commentaires ajouterCommentaire(@RequestBody Commentaires commentaires){
       return commentairesService.ajouterUnCommentaire(commentaires);
    }
}
