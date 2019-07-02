package com.yuri.mypet.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yuri.mypet.domain.EnderecoJuridico;
import com.yuri.mypet.domain.PetProvider;

import com.yuri.mypet.dto.PetProviderDTO;
import com.yuri.mypet.dto.PetProviderNewDTO;
import com.yuri.mypet.service.PetProviderService;


@RestController
@RequestMapping(value = "/pessoajuridica")
public class PetProviderResource {

	@Autowired
	private PetProviderService petProviderService;

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // para bater em um end pont com id
	public ResponseEntity<PetProvider> buscar(@PathVariable Integer id) {
		PetProvider obj = petProviderService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PetProviderNewDTO objDto) { // requestBody faz o json ser
																							// convertido para obj//
																							// java automaticamente
		PetProvider obj = petProviderService.fromDto(objDto);// coverto Dto para objeto entidade
		obj = petProviderService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PetProviderDTO objDto, @PathVariable Integer id) {// receber
																												// o
																												// obejto
																												// json
																												// e
		// tambem o parametro da
		PetProvider obj = petProviderService.fromDto(objDto); // URL
		obj.setId(id);
		obj = petProviderService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // para bater em um end pont com id
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		petProviderService.delete(id);
		return ResponseEntity.noContent().build();

	}

	// @PreAuthorize("hasAnyRole('ADMIN')")

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PetProviderDTO>> findAll() {

		List<PetProvider> list = petProviderService.findAll();
		List<PetProviderDTO> listDto = list.stream().map(obj -> new PetProviderDTO(obj))
				.collect(Collectors.toList()); // stream percorre a lista, map realiza uma operação para cada elemento
												// da lista
		return ResponseEntity.ok().body(listDto); // obj função anonima que recebece uma obj com argumento
		// collector realiza a transformação para lista novamente
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@CrossOrigin
	@RequestMapping(value = "/page", method = RequestMethod.GET) // paginação
	public ResponseEntity<Page<PetProviderDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<PetProvider> list = petProviderService.findPage(page, linesPerPage, orderBy, direction);
		Page<PetProviderDTO> listDto = list.map(obj -> new PetProviderDTO(obj)); // stream percorre a lista, map
																						// realiza uma operação para
																						// cada elemento da lista
		return ResponseEntity.ok().body(listDto); // obj função anonima que recebece uma obj com argumento
		// collector realiza a transformação para lista novamente
	}

}
