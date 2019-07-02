package com.yuri.mypet.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yuri.mypet.domain.enums.Perfil;
import com.yuri.mypet.domain.enums.TipoCliente;

@Entity
public class PetClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String nomeCompleto;

	@Column(unique = true) // faz o banco de dados garantir que não vai ter repetição com esse campo
	private String email;
	private String cpf;
	private Integer tipoPerfil;

	@JsonIgnore // para não aparecer no json
	private String senha;

	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;

	private String fotoPerfil;
	private String descricao;
	private String dataNascimento;

	/**
	 * @OneToMany(mappedBy = "pessoaFisica",cascade = CascadeType.ALL) // cascade,
	 *                     toda modificação que ocorrer no cliente ocorre em
	 *                     endereço com efeito cascata (quando apgar um cliente
	 *                     apaga um endereço tb) private List<EnderecoFisico>
	 *                     enderecos = new ArrayList<>();
	 */
	@JsonIgnore // pedidos do clinete não sera serealizados.
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "TELEFONE_PETCLIENT") // username da tabela
	private Set<String> telefones = new HashSet<>();// permite não repetir valores(represanta os conjuntos de valores )

	@ElementCollection(fetch = FetchType.EAGER) // traz o perfil junto
	@CollectionTable(name = "PERFIS_PETCLIENT")
	private Set<Integer> perfis = new HashSet<>();

	public PetClient() {
		addPerfil(Perfil.CLIENTE); // ja colocar que é um cliente
	}

	public PetClient(Integer id, String username, String nomeCompleto, String email, String cpf, TipoCliente tipoPerfil,
			String senha, String fotoPerfil, String descricao, String dataNascimento,
			String logradouro, String numero, String complemento, String bairro, String cep, String cidade,
			String estado) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.cpf = cpf;
		this.tipoPerfil = (tipoPerfil == null) ? null : tipoPerfil.getCod(); // operador ternario .. na intaciação não
																				// aceita nullo precisa de uma
																				// condicional por conta do getCod
		this.senha = senha;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.fotoPerfil = fotoPerfil;
		this.descricao = descricao;
		this.dataNascimento = dataNascimento;
		this.nomeCompleto = nomeCompleto;
		addPerfil(Perfil.CLIENTE);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoCliente getTipoPerfil() {
		return TipoCliente.toEnum(tipoPerfil);
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet()); // converte para perfil
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public void setTipoPerfil(TipoCliente tipoPerfil) {
		this.tipoPerfil = tipoPerfil.getCod();
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PetClient other = (PetClient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	/**
	 * @return the nomeCompleto
	 */
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	/**
	 * @param nomeCompleto the nomeCompleto to set
	 */
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

}
