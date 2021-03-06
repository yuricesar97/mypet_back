package com.yuri.mypet.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yuri.mypet.domain.PetClient;
import com.yuri.mypet.domain.enums.TipoCliente;
import com.yuri.mypet.dto.PetClientDTO;
import com.yuri.mypet.dto.PetClientNewDTO;
import com.yuri.mypet.repositories.EnderecoFisicoRepository;
import com.yuri.mypet.repositories.PetClientRepository;
import com.yuri.mypet.service.exceptions.DataInternalException;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;

@Service
public class PetClientService {

	@Autowired
	PetClientRepository petClientRepository;
	@Autowired
	EnderecoFisicoRepository enderecoRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public PetClient find(Integer id) {
		Optional<PetClient> op = petClientRepository.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetClient.class.getName()));
	}

	@Transactional
	public PetClient insert(PetClient obj) {
		obj.setId(null);
		obj = petClientRepository.save(obj); // salva cliente
		// enderecoRepository.saveAll(obj.getEndereço()); // salva endereço
		return obj;
	}

	public PetClient update(PetClient obj) {
		PetClient newObj = find(obj.getId()); // instanciar um cliente a parir do banco dados
		updateData(newObj, obj); // atulaiza os dados como o obj que foi enviado na requisição
		return petClientRepository.save(newObj); // save vale quanto para inserir quanto para update unica coisa que ele olha é
									// se o Id esta nulo ele insere se não atualiza
	}

	public void delete(Integer id) {
		find(id);
		try {
			petClientRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há pedidos relacionadas");
		}
	}

	public List<PetClient> findAll() {
		return petClientRepository.findAll();
	}

	public Page<PetClient> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {// Page
																												// vai
																												// encapsular
																												// informações
																												// e
																												// operações
																												// sobre
																												// a
																												// paginação

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy); // prepara
																												// as
																												// informações
																												// para
																												// que
																												// faça
																												// a
																												// consulta
																												// que
																												// retorne
																												// a
																												// pagina
																												// de
																												// dados
		return petClientRepository.findAll(pageRequest); // Direction convertendo do tipo String para o tipo Direction
	}

	public PetClient fromDto(PetClientDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um
															// DTO
		System.out.println("fromDto objDto.getNomeCompleto(): " + objDto.getNomeCompleto());
		System.out.println("fromDto objDto.getEmail(): " + objDto.getEmail());
		System.out.println("fromDto objDto.getActive(): " + objDto.getActive());

		return new PetClient(objDto.getId(), objDto.getUsername(), objDto.getNomeCompleto(), objDto.getEmail(), null,
				null, null, null, null,  objDto.getDataNascimento(),
				null, null, null, null, null, null, null,
				objDto.getActive()); // nulo
																														// porque
																														// não
																														// temos
																														// os
		// daddos no DTO
		// PessoaFisica p = new PessoaFisica(id, nomeCompleto, email, cpf, tipoPerfil,
		// senha, fotoPerfil, descricao, petWalker, dataNascimento)
	}

	public PetClient fromDto(PetClientNewDTO objDto) { // metado auxiliar que instacia uma categoria a partir de
																// um DTO
		System.out.println("NEWDTO fromDto objDto.getNomeCompleto(): " + objDto.getNomeCompleto());
		System.out.println("NEWDTO fromDto objDto.getEmail(): " + objDto.getEmail());
		System.out.println("NEWDTO fromDto objDto.getActive(): " + objDto.getActive());

		PetClient cli1 = new PetClient(objDto.getId(), objDto.getUsername(), objDto.getNomeCompleto(), objDto.getEmail(),
				objDto.getCpf(), TipoCliente.toEnum(objDto.getTipoPerfil()),
				bCryptPasswordEncoder.encode(objDto.getSenha()), null, objDto.getDescricao(),
				objDto.getDataNascimento(), objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(),
				objDto.getBairro(), objDto.getCep(), objDto.getCidade(), objDto.getEstado(), objDto.getActive());

		// EnderecoFisico end = new EnderecoFisico(null, objDto.getLogradouro(),
		// objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(),
		// objDto.getCep(),objDto.getCidade(),objDto.getEstado(), cli1);//endereços
		// conhece os clientes
		// cli1.getEndereço().add(end); // cliente conhece seus endereços
		cli1.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli1.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli1.getTelefones().add(objDto.getTelefone3());
		}
		System.out.println("fromDto cli1: " + cli1);
		return cli1;
	}

	private void updateData(PetClient newObj, PetClient obj) { // metado aux para atualizar os campos do cliente,
																		// pegando o
		// novo e colocando no antigo
		newObj.setUsername(obj.getUsername());
		newObj.setEmail(obj.getEmail());
		newObj.setActive(obj.getActive());

	}
}
