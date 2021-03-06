package com.yuri.mypet.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yuri.mypet.domain.PetClient;

import com.yuri.mypet.dto.PetClientDTO;
import com.yuri.mypet.dto.PetClientNewDTO;
import com.yuri.mypet.service.PetClientService;

@RestController
@RequestMapping(value = "/pessoafisica")
public class PessoaFisicaResource {

	@Autowired
	private PetClientService service;

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<PetClient> buscar(@PathVariable Integer id) {
		PetClient obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PetClientNewDTO objDto) { // requestBody faz o json ser
																						// convertido para obj// java
																						// automaticamente
		PetClient obj = service.fromDto(objDto);// coverto Dto para objeto entidade
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetClientDTO objDto, @PathVariable Integer id) {// receber
		PetClient obj = service.fromDto(objDto);
		obj.setId(id);
		obj = service.update(obj);
		//System.out.println("ENTROU NO PUT obj.getActive(): " + obj.getActive());
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // para bater em um end pont com id
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@CrossOrigin
	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PetClientDTO>> findAll() {

		List<PetClient> list = service.findAll();
		List<PetClientDTO> listDto = list.stream().map(obj -> new PetClientDTO(obj)).collect(Collectors.toList()); // stream
		return ResponseEntity.ok().body(listDto); // obj função anonima que recebece uma obj com argumento
	}

	@CrossOrigin
	// @PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/page", method = RequestMethod.GET) // paginação
	public ResponseEntity<Page<PetClientDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<PetClient> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PetClientDTO> listDto = list.map(obj -> new PetClientDTO(obj)); // stream percorre a lista, map
																					// realiza uma operação para cada
																					// elemento da lista
		return ResponseEntity.ok().body(listDto); // obj função anonima que recebece uma obj com argumento
		// collector realiza a transformação para lista novamente
	}



}
