package com.mypet.myPetApp.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mypet.myPetApp.entity.Endereco;
import com.mypet.myPetApp.entity.PetVet;
import com.mypet.myPetApp.entity.Petclient;
import com.mypet.myPetApp.grupos.TipoGrupo;
import com.mypet.myPetApp.repository.EnderecoRepository;
import com.mypet.myPetApp.repository.PetVetRepository;
import com.mypet.myPetApp.repository.PetclientRepository;

@Service
public class DBService {
	
	@Autowired
	private PetclientRepository petClientRepository;
	@Autowired
	private EnderecoRepository enderecoRepositoty;
	@Autowired
	private PetVetRepository petVetRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public void instantiateTestDataBase() {
	Petclient pet1 = new Petclient(null, "Yuricesarr@gmail.com", bCryptPasswordEncoder.encode("12345"), TipoGrupo.CLIENTE, "Yur1 Cesar", "210405", 0, null);
	//petClientRepository.save(pet1);

	Petclient pet2 = new Petclient(null, "ronaldinho@gmail.com",bCryptPasswordEncoder.encode("r10") , TipoGrupo.CLIENTE, "ronaldinho brilha", "210405", 0, null);
	//petClientRepository.save(pet2);
	
	
	Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", pet2);
	Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "centro", "8777012", pet1);
	
	pet1.getEndereco().addAll(Arrays.asList(e2)); // cliente conhecendo seu endereços
	pet2.getEndereco().addAll(Arrays.asList(e1));
	
	petClientRepository.saveAll(Arrays.asList(pet1,pet2));
	enderecoRepositoty.saveAll(Arrays.asList(e1, e2));
	
	
	
	PetVet petV = new PetVet(null, "Gatos&Cia", "1234567",TipoGrupo.JURIDICA, "cia@gmail.com", bCryptPasswordEncoder.encode("cia1245"), 0,"Av, glicerio","126","centro","13012100" );	
    petVetRepository.saveAll(Arrays.asList(petV));
	
	}
	
	
}


