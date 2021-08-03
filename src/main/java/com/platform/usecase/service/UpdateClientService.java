package com.platform.usecase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.domain.entity.Client;
import com.platform.usecase.erros.Erro;
import com.platform.usecase.port.ClientRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@AllArgsConstructor
@Slf4j
public class UpdateClientService {
	
	@Autowired
	private ClientRepository repository;
	
	public Client update(final Client upClient) {
		if(upClient == null) {
			log.error(Erro.CLIENTE_NULO);
			return null; //TODO tratar erro
		}
		if(upClient.getId()==null) {
			log.error(Erro.ID_NULO);
			return null; //TODO tratar erro
		}
		try {
			Client client = repository.findById(upClient.getId()).get();
			log.info("Atualizando cliente id:{}", client.getId());
			return repository.update(mapper(client, upClient));
		}catch(NullPointerException npe) {
			log.error(Erro.CLIENTE_INEXISTENTE, upClient.getId());
			npe.printStackTrace();
			return null;
		}
	}
	private Client mapper(Client client, Client upClient) {
		client.setFirstName(upClient.getFirstName());
		client.setLastName(upClient.getLastName());
		client.setBirthDate(upClient.getBirthDate());
		return client;
	}
}
