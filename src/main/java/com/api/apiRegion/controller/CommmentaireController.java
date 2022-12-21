package com.api.apiRegion.controller;

import com.api.apiRegion.DAO.HabitantAnnees;
import com.api.apiRegion.DAO.UserRegion;
import com.api.apiRegion.modele.Collaborateurs;
import com.api.apiRegion.modele.Commentaires;
import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.repository.CollaborateursRepository;
import com.api.apiRegion.repository.CommentaireRepository;
import com.api.apiRegion.repository.regionsRepository;
import com.api.apiRegion.security.services.CommentairesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/commentaire")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
public class CommmentaireController {

    @Autowired
    CommentairesService commentairesService;

    @Autowired
    CollaborateursRepository collaborateursRepository;

    @Autowired
    regionsRepository regionsRepo;

    @Autowired
    CommentaireRepository commentaireRepository;

    @PostMapping("/ajouter")
    public Commentaires ajouterCommentaire(@RequestParam(value = "commentaire") String commentairesVenant) throws JsonProcessingException {

        Commentaires commentairesRecuperer = new JsonMapper().readValue(commentairesVenant, Commentaires.class);

        System.err.println(commentairesRecuperer);
        Collaborateurs user = collaborateursRepository.findById(commentairesRecuperer.getAuteur().getId()).get();

        Regions rr = regionsRepo.findById(commentairesRecuperer.getRegion().getId()).get();

        commentairesService.incrementNombreCommentaire(rr.getId());

       commentairesRecuperer.setAuteur(user);
       commentairesRecuperer.setRegion(rr);
        commentairesRecuperer.setDate(new Date());
        return commentairesService.ajouterUnCommentaire(commentairesRecuperer);
    }

    @GetMapping("/recuperCommentairesRegion/{id}")
    public List<Commentaires> recuperCommentairesParRegion(@PathVariable Long id){
        Regions regions = regionsRepo.findById(id).get();

        List<Commentaires> comm = commentaireRepository.findByRegion(regions);
        System.out.println(comm);
        return comm;
    }
/*
    @GetMapping("/recuperCommentairesRegion/{id}")
    public Regions increment(@PathVariable Long id){
        Regions regions = regionsRepo.findById(id).get();

        List<Commentaires> comm = commentaireRepository.findByRegion(regions);
        System.out.println(comm);
        return comm;
    }

 */
}
