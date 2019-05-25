package com.yuri.mypet.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.yuri.mypet.domain.PessoaFisica;
import com.yuri.mypet.dto.PessoaFisicaDTO;
import com.yuri.mypet.repositories.PessoaFisicaRepository;
import com.yuri.mypet.service.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, PessoaFisicaDTO> {
	
	@Autowired
	private HttpServletRequest request; //permite pegar o parametro da uri
	@Autowired
	private PessoaFisicaRepository repo;
	
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	public boolean isValid(PessoaFisicaDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		//Map estrutura de dados, chave e valor exemplo(chave id, valor 2)
		
		List<FieldMessage> list = new ArrayList<>();
		
		PessoaFisica aux = repo.findByEmail(objDto.getEmail());
		if(aux != null && !aux.getId().equals(uriId)) { // verificando se email já existe
			list.add(new FieldMessage("Email", "Email já existente"));
		}
		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}