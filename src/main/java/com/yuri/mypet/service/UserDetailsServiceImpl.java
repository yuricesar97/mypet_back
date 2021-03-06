package com.yuri.mypet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yuri.mypet.domain.PetProvider;
import com.yuri.mypet.repositories.PetProviderRepository;
import com.yuri.mypet.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {  // permite busca pelo nome do usuario 

	@Autowired
	private PetProviderRepository pessoaJuridicaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		PetProvider ju = pessoaJuridicaRepository.findByEmail(email);
		
		if(ju == null) {
			throw new UsernameNotFoundException(email);	
		}
		
	
		
		return new UserSS(ju.getId(), ju.getEmail(), ju.getSenha(), ju.getPerfis());
	}
	


}
