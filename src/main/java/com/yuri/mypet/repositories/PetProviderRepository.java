package com.yuri.mypet.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yuri.mypet.domain.EnderecoJuridico;
import com.yuri.mypet.domain.PetProvider;


@Repository
public interface PetProviderRepository extends JpaRepository<PetProvider, Integer>{
  
     @Transactional(readOnly = true) // diz que transação não necessita ser envolvida no banco de dados
     PetProvider findByEmail(String email); // cria busca com o campo Email
     



		}  
