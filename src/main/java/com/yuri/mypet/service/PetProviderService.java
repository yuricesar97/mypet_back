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


import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.domain.enums.TipoCliente;

import com.yuri.mypet.dto.PetProviderDTO;
import com.yuri.mypet.dto.PetProviderNewDTO;
import com.yuri.mypet.repositories.EnderecoJuridicoRepository;

import com.yuri.mypet.repositories.PetProviderRepository;
import com.yuri.mypet.service.exceptions.DataInternalException;
import com.yuri.mypet.service.exceptions.ObjectNotFoundException;

@Service
public class PetProviderService {

	@Autowired
	PetProviderRepository 	petProviderRepository;
	@Autowired
	EnderecoJuridicoRepository enderecoRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	public PetProvider find(Integer id) {

		Optional<PetProvider> op = petProviderRepository.findById(id);

		return op.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + PetProvider.class.getName()));
	}

	@Transactional // para que tudo ocorra de forma trasicional (salava endereço e cliente em uma// tra)
	public PetProvider insert(PetProvider obj) {
		obj.setId(null);
		obj = petProviderRepository.save(obj); // salva cliente
	//	enderecoRepository.saveAll(obj.getEnderecos()); // salva endereço
		return obj;
	}


	public PetProvider update(PetProvider obj) {
		PetProvider newObj = find(obj.getId()); // instanciar um cliente a parir do banco dados
		updateData(newObj, obj); // atulaiza os dados como o obj que foi enviado na requisição
		return petProviderRepository.save(newObj); // save vale quanto para inserir quanto para update unica coisa que ele olha é
									// se o Id esta nulo ele insere se não atualiza
	}

	public void delete(Integer id) {
		find(id);
		try {
			petProviderRepository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new DataInternalException("Não é possivel exclui porque há pedidos relacionadas");
		}
	}

	public List<PetProvider> findAll() {
		return petProviderRepository.findAll();
	}
	


	public Page<PetProvider> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {// Page vai
																											// encapsular
																											// informações
																											// e
																											// operações
																											// sobre a
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
		return petProviderRepository.findAll(pageRequest); // Direction convertendo do tipo String para o tipo Direction
	}

	public PetProvider fromDto(PetProviderDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um DTO

		
		return new PetProvider(objDto.getId(), objDto.getRazaoSocial(), objDto.getEmail(), objDto.getCnpj(),
				null, null, null,objDto.getDescricao(),
				objDto.getDescricaoPetHome(),objDto.getSituacaoAprovacao(), objDto.isFarmacia(),
				objDto.isBanho(), objDto.isTosa(), objDto.isLoja(), objDto.isVacinacao(), objDto.isConsulta(), objDto.isExames(),
				objDto.isApartamento(),objDto.isCasa(), objDto.isFumante(), objDto.isTelado(),objDto.isPetVet(),objDto.isPetClient(),
				objDto.isPetHome(),objDto.isPetShop(),objDto.isCheckStatus(),objDto.getLogradouro(),objDto.getNumero(),
				objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),objDto.getCidade(),objDto.getEstado());
	}

	public PetProvider fromDto(PetProviderNewDTO objDto) { // metado auxiliar que instacia uma categoria a partir de um DTO
			
		//PessoaJuridica cli1 = new PessoaJuridica(id, razaoSocial, email, cnpj, tipoPerfil, senha, fotoPerfil, descricaoPetShop, descricaoPetVet, descricaoPetHome, descricaoPetClient, situacaoAprovacao, farmacia, banho, tosa, loja, vacinacao, consulta, exames, apartamento, casa, fumante, telado, petVet, petClient, petHome, petShop, checkStatus, logradouro, numero, complemento, bairro, cep, cidade, estado)
		PetProvider cli1 = new PetProvider(null, objDto.getRazaoSocial(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipoPerfil()),bCryptPasswordEncoder.encode(objDto.getSenha()),null,objDto.getDescricaoPetHome(),null,objDto.getDescricao(),objDto.isFarmacia(),
				              objDto.isBanho(),objDto.isTosa(),objDto.isLoja(),objDto.isVacinacao(),objDto.isConsulta(),objDto.isExames(),objDto.isApartamento(),objDto.isCasa(),objDto.isFumante(),objDto.isTelado(), objDto.isPetVet(),objDto.isPetClient(),objDto.isPetHome(),objDto.isPetShop(),objDto.isCheckStatus(),objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep()
				              ,objDto.getCidade(),objDto.getEstado());
	
	//	EnderecoJuridico end = new EnderecoJuridico(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(),objDto.getCidade(),objDto.getEstado(), cli1);//endereços conhece os clientes
	//	cli1.getEnderecos().add(end); // cliente conhece seus endereços
		cli1.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone2() != null) {
			cli1.getTelefones().add(objDto.getTelefone2());
		}
		if(objDto.getTelefone3() != null) {
			cli1.getTelefones().add(objDto.getTelefone3());
		}
		
		return cli1;
	}

	private void updateData(PetProvider newObj, PetProvider obj) { // metado aux para atualizar os campos do cliente, pegando o
															// novo e colocando no antigo
		newObj.setRazaoSocial(obj.getRazaoSocial());
		newObj.setEmail(obj.getEmail());
		newObj.setId(obj.getId());
		newObj.setApartamento(obj.isApartamento());
		newObj.setBairro(obj.getBairro());
		newObj.setBanho(obj.isBanho());
		newObj.setCasa(obj.isCasa());
		newObj.setCep(obj.getCep());
		newObj.setCheckStatus(obj.isCheckStatus());
		newObj.setCidade(obj.getCidade());
		newObj.setCpfOuCnpj(obj.getCpfOuCnpj());
		newObj.setComplemento(obj.getComplemento());
		newObj.setConsulta(obj.isConsulta());
		newObj.setDescricaoPetHome(obj.getDescricaoPetHome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setEstado(obj.getEstado());
		newObj.setExames(obj.isExames());
		newObj.setFarmacia(obj.isFarmacia());
		newObj.setFotoPerfil(obj.getFotoPerfil());
		newObj.setFumante(obj.isFumante());
		newObj.setLogradouro(obj.getLogradouro());
		newObj.setLoja(obj.isLoja());
		newObj.setNumero(obj.getNumero());
		newObj.setPetClient(obj.isPetClient());
		newObj.setPetHome(obj.isPetHome());
		newObj.setPetShop(obj.isPetShop());
		newObj.setPetVet(obj.isPetVet());
		newObj.setSenha(obj.getSenha());
		newObj.setSituacaoAprovacao(obj.getSituacaoAprovacao());
		newObj.setTelado(obj.isTelado());
		//newObj.setTelefones(obj.getTelefones());
		//newObj.setTipoPerfil(obj.getTipoPerfil());
		newObj.setTosa(obj.isTosa());
		newObj.setVacinacao(obj.isVacinacao());
		
	}
}
