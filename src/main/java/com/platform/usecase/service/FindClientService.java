package com.platform.usecase.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.platform.domain.entity.Client;
import com.platform.usecase.erros.Erro;
import com.platform.usecase.port.ClientRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@AllArgsConstructor
@Slf4j
public class FindClientService {
	
	@Autowired
	private final ClientRepository repository;
	
	public Optional<Client> findById(final Long id){
		if(id == null) {
			log.error(Erro.ID_NULO);
		}
		return repository.findById(id);
	}
	
	public List<Client> findAll(){
		return repository.findAll();
	}
		
	public Optional<Client> findByEmail(final String email){
		return repository.findByEmail(email);
	}

	public Page<Client> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
