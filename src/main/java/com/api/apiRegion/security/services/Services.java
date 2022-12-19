package com.api.apiRegion.security.services;

import com.api.apiRegion.modele.Collaborateurs;

import javax.management.relation.Role;
import java.util.List;

public interface Services {

    String modifierCollaborateur(Collaborateurs collaborateurs);
    /*
    List<Role> afficherRoles();
    String modifierRole(Role roles);
    String supprimerRole(Long id);
    String supprimerCollaborateur(Long id);

     */
}
