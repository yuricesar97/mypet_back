package com.mypet.myPetApp.dto;

import java.io.Serializable;

public class CredenciasDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;

	public CredenciasDTO() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String senha) { this.password = senha; }



}
