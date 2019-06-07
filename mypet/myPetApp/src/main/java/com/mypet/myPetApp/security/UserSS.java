package com.mypet.myPetApp.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mypet.myPetApp.grupos.Role;



public class UserSS implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String password;

	public UserSS() {

	}




	public UserSS(Integer id, String email, String password, Set<Role> perfis) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorrities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
		System.out.println("Logado com sucesso !");
	}




	private Collection<? extends GrantedAuthority> authorrities;


	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorrities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {

		// para uma futuro, ver se a conta do usuario expira ou não (tempo logado)

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// conta bloqueada
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// credenciais vencidas
		return true;
	}

	@Override
	public boolean isEnabled() {
		// usuario esta ativo
		return true;
	}
}