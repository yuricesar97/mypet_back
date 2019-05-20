package com.mypet.myPetApp.grupos;

public enum Role {


	ADMIN(1, "ROLE_ADMIN"), //ROLE É EXIGENCIA DO SPRING
	CLIENTE(2, "ROLE_CLIENTE"),
	SERVICOS(3,"ROLE_SERVICOS");



	private Integer cod;
	private String descricao;


	private Role(Integer cod,String descricao) {

		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}


	public static Role toEnum(Integer cod) { //static porque essa operação precisa ser executada mesmo sem instaciar objetos

		if(cod == null) {
			return null;
		}

		for(Role x : Role.values()) { //percorre todos os valores possiveis do tipoEnumerado
		   if(cod.equals(x.getCod())) {//varrendo todas as possibilidades
			 return x;
		   }

		} 
		   throw new IllegalArgumentException("Id inválido: " + cod);





	}
}
