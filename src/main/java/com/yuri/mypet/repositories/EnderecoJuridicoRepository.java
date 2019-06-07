package com.yuri.mypet.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yuri.mypet.domain.EnderecoJuridico;

@Repository
public interface EnderecoJuridicoRepository extends JpaRepository<EnderecoJuridico, Integer>{
  
}  
