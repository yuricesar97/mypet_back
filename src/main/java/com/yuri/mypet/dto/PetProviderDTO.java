package com.yuri.mypet.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.service.validation.JuridicoUpdate;

@JuridicoUpdate
public class PetProviderDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	/*@NotEmpty(message = "Prenchimento obrigatório")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")*/
	private String razaoSocial;

	/*@NotEmpty(message = "Preechimento obrigatório")
	@Email(message = "Email inválido")*/
	private String email;
	private String cnpj;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	private String fotoPerfil;
	private String descricao;
	private String descricaoPetHome;
	private String situacaoAprovacao;

	private boolean checkStatus = false;
	private boolean farmacia = false;
	private boolean banho = false;
	private boolean tosa = false;
	private boolean loja = false;
	
	private boolean petVet = false;
	private boolean petClient = false;
	private boolean petHome = false;
	private boolean petShop = false;

	private boolean vacinacao = false;
	private boolean consulta = false;
	private boolean exames = false;

	private boolean apartamento = false;
	private boolean casa = false;
	private boolean fumante = false;
	private boolean telado = false;

	// private EnderecoFisico endereco;

	@Column(name="is_active")
	private Boolean active;

	public PetProviderDTO(PetProvider obj) { // construtor sera respnosavel por instanciar um DTO com os dados que
		// desejo

		id = obj.getId();
		active = obj.getActive();
		razaoSocial = obj.getRazaoSocial();
		email = obj.getEmail();
		cnpj = obj.getCpfOuCnpj();
		logradouro = obj.getLogradouro();
		numero = obj.getNumero();
		complemento = obj.getComplemento();
		cep = obj.getCep();
		bairro = obj.getBairro();
		cidade = obj.getCidade();
		estado = obj.getEstado();
		fotoPerfil = obj.getFotoPerfil();
		farmacia = obj.isFarmacia();
		banho = obj.isBanho();
		tosa = obj.isTosa();
		loja = obj.isLoja();
		vacinacao = obj.isVacinacao();
		consulta = obj.isConsulta();
		 exames = obj.isExames();
		 apartamento = obj.isApartamento();
		 casa = obj.isCasa();
		 fumante = obj.isFumante();
		 telado = obj.isTelado();
		 petVet = obj.isPetVet();
		 petClient = obj.isPetClient();
		 petHome = obj.isPetHome();
		 petShop = obj.isPetShop();
		 descricaoPetHome = obj.getDescricaoPetHome();
		 descricao =  obj.getDescricao();
		 situacaoAprovacao = obj.getSituacaoAprovacao();

	}

	public PetProviderDTO() {

	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public EnderecoFisico getEndereco() { return endereco; }
	 * 
	 * public void setEndereco(EnderecoFisico endereco) { this.endereco = endereco;
	 * }
	 */

	public String getDescricao() {
		return descricao;
	}

	public void setDescricaoPetShop(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoPetHome() {
		return descricaoPetHome;
	}

	public void setDescricaoPetHome(String descricaoPetHome) {
		this.descricaoPetHome = descricaoPetHome;
	}


	public boolean isFarmacia() {
		return farmacia;
	}

	public void setFarmacia(boolean farmacia) {
		this.farmacia = farmacia;
	}

	public boolean isBanho() {
		return banho;
	}

	public void setBanho(boolean banho) {
		this.banho = banho;
	}

	public boolean isTosa() {
		return tosa;
	}

	public void setTosa(boolean tosa) {
		this.tosa = tosa;
	}

	public boolean isLoja() {
		return loja;
	}

	public void setLoja(boolean loja) {
		this.loja = loja;
	}

	public boolean isVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(boolean vacinacao) {
		this.vacinacao = vacinacao;
	}

	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	public boolean isExames() {
		return exames;
	}

	public void setExames(boolean exames) {
		this.exames = exames;
	}

	public boolean isApartamento() {
		return apartamento;
	}

	public void setApartamento(boolean apartamento) {
		this.apartamento = apartamento;
	}

	public boolean isCasa() {
		return casa;
	}

	public void setCasa(boolean casa) {
		this.casa = casa;
	}

	public boolean isFumante() {
		return fumante;
	}

	public void setFumante(boolean fumante) {
		this.fumante = fumante;
	}

	public boolean isTelado() {
		return telado;
	}

	public void setTelado(boolean telado) {
		this.telado = telado;
	}

	public String getSituacaoAprovacao() {
		return situacaoAprovacao;
	}

	public void setSituacaoAprovacao(String situacaoAprovacao) {
		this.situacaoAprovacao = situacaoAprovacao;
	}

	public boolean isCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(boolean checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public boolean isPetVet() {
		return petVet;
	}

	public void setPetVet(boolean petVet) {
		this.petVet = petVet;
	}

	public boolean isPetClient() {
		return petClient;
	}

	public void setPetClient(boolean petClient) {
		this.petClient = petClient;
	}

	public boolean isPetHome() {
		return petHome;
	}

	public void setPetHome(boolean petHome) {
		this.petHome = petHome;
	}

	public boolean isPetShop() {
		return petShop;
	}

	public void setPetShop(boolean petShop) {
		this.petShop = petShop;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
