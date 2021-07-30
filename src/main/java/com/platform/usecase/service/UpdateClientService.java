package com.platform.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.domain.entity.Client;
import com.platform.domain.erros.Erro;
import com.platform.domain.exception.ClientAlreadyExistsException;
import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class UpdateClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client update(final Client client) {
		if(client == null) {
			log.error(Erro.CLIENTE_NULO);
			return null; //TODO tratar erro
		}
		if(client.getId()==null) {
			log.error(Erro.ID_NULO);
			return null; //TODO tratar erro
		}
		try {
			log.info("Atualizando cliente id:{}", client.getId());
			return repository.update(client);
		}catch(NullPointerException npe) {
			log.error(Erro.CLIENTE_INEXISTENTE, client.getId());
			npe.printStackTrace();
			return null;
		}
	}
}
