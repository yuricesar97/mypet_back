package com.mypet.myPetApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;

import com.mypet.myPetApp.service.PetWalkerService;


import com.mypet.myPetApp.dto.PetWalkerDTO;
import com.mypet.myPetApp.dto.PetWalkerInsertDTO;
import com.mypet.myPetApp.entity.PetWalker;



@RestController
@RequestMapping(value = "/petwalkers")
public class PetwalkerController {

	@Autowired
	private PetWalkerService service;

	@RequestMapping(method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<List<PetWalkerDTO>> findAll(Integer id) {
		List<PetWalker> list = service.findAll();
		List<PetWalkerDTO> listDto = list.stream().map(obj -> new PetWalkerDTO(obj)).collect(Collectors.toList()); // stream
																													// percorre
																													// a
																													// lista,
																													// map
																													// realiza
																													// uma
																													// operação
																													// para
																													// cada
																													// elemento
																													// da
																													// lista,collector
																													// realiza
																													// a
																													// transformação
																													// para
																													// lista
																													// novamente

		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<PetWalker> find(@PathVariable Integer id) {

		PetWalker obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PetWalkerInsertDTO objDto) { // requestBody faz o json ser
																						// convertido para obj
		// java automaticamente
		PetWalker obj = service.fromDto(objDto);// coverto Dto para objeto entidade
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetWalkerDTO objDto, @PathVariable Integer id) {// receber o
																											// obejto
																											// json e
		// tambem o parametro da
		PetWalker obj = service.fromDto(objDto); // URL
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // para bater em um end pont com id
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}