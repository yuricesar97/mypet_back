package com.mypet.myPetApp.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Inheritance(strategy = InheritanceType.JOINED)// para mapear instacias no banco de dados
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private   String email;
    
    @JsonIgnore
    private  String password;
   
    
 

  
	public User() {

    }





	public User(Integer id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
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





	public void setPassword(String password) {
		this.password = password;
	}
	
 
    

	
	
	
    
}
  
