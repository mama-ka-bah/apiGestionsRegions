package com.api.apiRegion;

import com.api.apiRegion.modele.Collaborateurs;
import com.api.apiRegion.modele.Pays;
import com.api.apiRegion.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class ApiRegionApplication implements CommandLineRunner{


	final private CollaborateursRepository collaborateursRepository;
	final private RoleRepository roleRepository;
	final private com.api.apiRegion.repository.paysRepository paysRepository;

	@Autowired
	PasswordEncoder encoder;

	public static void main(String[] args)  {
		SpringApplication.run(ApiRegionApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		if(roleRepository.findAll().size() == 0){
			roleRepository.save(new Role(ERole.ROLE_USER));
			roleRepository.save(new Role(ERole.ROLE_ADMIN));
		}
		if (collaborateursRepository.findAll().size() == 0){
			Set<Role> roles = new HashSet<>();
			Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
			roles.add(adminRole);
			Collaborateurs collaborateurs = new Collaborateurs("keita@123",
					"kmahamadou858@gmail.com",
					encoder.encode("keita@pass"));
			collaborateurs.setRoles(roles);
			collaborateursRepository.save(collaborateurs);
		}
		if(paysRepository.findAll().size() == 0){
			Pays pays = new Pays();
			pays.setNomp("Mali");

			paysRepository.save(pays);
		}
	}



}
