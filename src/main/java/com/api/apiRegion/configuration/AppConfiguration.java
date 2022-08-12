package com.api.apiRegion.configuration;

import com.api.apiRegion.modele.Habitant;
import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.repository.habitantRepository;
import com.api.apiRegion.repository.paysRepository;
import com.api.apiRegion.services.habitantServices;
import com.api.apiRegion.services.paysServices;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@AllArgsConstructor
@Configuration
public class AppConfiguration {
    //configuration du habitant
    private  final paysRepository paysrepository ;
    private  final habitantRepository habitantrepository;
    @Bean
    public habitantServices habitantserviceConfiguration(){
        return new habitantServices() {
            @Override
            public Habitant creer(Habitant habitant) {
                return habitantrepository.save(habitant);
            }

            @Override
            public List<Habitant> lire() {
                return habitantrepository.findAll();
            }

            @Override
            public Habitant modifier(Long id, Habitant habitant) {
                return habitantrepository.findById(id)
                        .map(r->{
                            r.setNbre_habitant(habitant.getNbre_habitant());
                            r.setAnnee(habitant.getAnnee());
                            return habitantrepository.save(r);
                        }).orElseThrow(() -> new RuntimeException("Habitant non trouver"));
            }

            @Override
            public String supprimer(Long id) {
                habitantrepository.deleteById(id);
                return "Habitant Supprimer";
            }
        };
    }
    //configuration du pays
    @Bean
    public paysServices paysservicesconfiguration(){
        return new paysServices() {
            @Override
            public Pays creer(Pays pays) {
                return paysrepository.save(pays);
            }

            @Override
            public List<Pays> lire() {
                return paysrepository.findAll();
            }

            @Override
            public Pays modifier(Long id, Pays pays) {
                return paysrepository.findById(id)
                        .map(r->{
                            r.setNom(pays.getNom());
                            return paysrepository.save(r);
                        }).orElseThrow(() -> new RuntimeException("Pays nom trouver"));
            }

            @Override
            public String supprimer(Long id) {
                paysrepository.deleteById(id);
                return "Pays Supprimer";
            }
        };
    }
}
