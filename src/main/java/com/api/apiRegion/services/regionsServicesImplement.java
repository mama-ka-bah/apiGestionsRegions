package com.api.apiRegion.services;

import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.repository.regionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class regionsServicesImplement implements regionServices{

    private  final regionsRepository regionsrepository;

    @Override
    public Regions creer(Regions regions) {
        return regionsrepository.save(regions);
    }

    @Override
    public List<Object[]> lire() {
        return regionsrepository.FINDALLREGION();
    }

    @Override
    public List<Object[]> lireRegionHbtAnnee() {
        return  regionsrepository.FINDREGION_HBT_ANNEE();
    }

    @Override
    public List<Object[]> lireRegionOfPays(String pays) {
        return  regionsrepository.FINDREGIONSOFPAYS(pays);
    }

    @Override
    public List<Object[]> lireSansPays(){return regionsrepository.FINDALLREGIONWITHOUTPAYS();}
    @Override
    public Regions modifier(Long id, Regions regions) {
        return regionsrepository.findById(id)
                .map(r-> {
                    r.setCode_region(regions.getCode_region());
                    r.setDomaine_activite(regions.getDomaine_activite());
                    r.setDomaine_activite(regions.getDomaine_activite());
                    r.setLangue_majoritaire(regions.getLangue_majoritaire());
                    r.setSuperficie(regions.getSuperficie());
                    return regionsrepository.save(r);
                }).orElseThrow(() -> new RuntimeException("Region non trouvé !"));
    }

    /*
    @Override
    public List<Regions> trouverRegionParNom(String name) {
        return regionsrepository.findByName(name);
    }
*/
    @Override
    public String supprimer(Long id) {
        regionsrepository.deleteById(id);
        return "Region supprimé";
    }

    //methode permettant d'ajouter region habitant pays et annee en meme temps
    @Override
    public int ajouterRegionAvecHabitant(String nom_region, String code_region, String domaine_activite, String langue_majoritaire, String superficie, String photoaregion, String description, Long idpays) {
        return regionsrepository.INSERTREGIONWITHHABITANT(nom_region,code_region, domaine_activite, langue_majoritaire, superficie, photoaregion, description, idpays);

    }

    @Override
    public Regions trouverRegionParNom(String nom) {
        return regionsrepository.findByNom(nom);
    }
}