package com.api.apiRegion.services;

import com.api.apiRegion.modele.Regions;
import com.api.apiRegion.repository.regionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class regionsServicesImplement implements regionServices{

    private  final regionsRepository regionsrepository;

    //IMPLEMENTAION DE LA METHODE CREER
    @Override
    public Regions creer(Regions regions) {
        return regionsrepository.save(regions);
    }

    //IMPLEMENTATION DE LA METHODE LIREAVECPAYS
    @Override
    public List<Object[]> lire() {
        return (List<Object[]>) regionsrepository.FINDALLREGION();
    }

    //IMPLEMENTATION DE LA METHODE LIRESANSPAYS
    @Override
    public Iterable<Object[]> lireSansPays(){return regionsrepository.FINDALLREGIONWITHOUTPAYS();}

    //IMLEMENTATION DE LA METHODE MODIFICATION
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

    //IMPLEMENTATION DE LA METHODE SUPPRIMER
    @Override
    public String supprimer(Long id) {
        regionsrepository.deleteById(id);
        return "Region supprimé";
    }
}
