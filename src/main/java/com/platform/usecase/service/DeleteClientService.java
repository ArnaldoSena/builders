package com.platform.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.usecase.erros.Erro;
import com.platform.usecase.port.ClientRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Slf4j
public class DeleteClientService {

	@Autowired
	private ClientRepository repository;
	
	public void delete(Long id){
		if(id == null) {
			log.error(Erro.ID_NULO);
		}
		try {
			repository.delete(id);
		}catch(NullPointerException npe) {
			log.error(Erro.CLIENTE_INEXISTENTE, id);
			npe.printStackTrace();
		}catch(Exception e) {
			log.error(Erro.ERRO_GERAL);
			e.printStackTrace();
		}
	}
}
