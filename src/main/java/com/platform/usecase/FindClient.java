package com.platform.usecase;

import java.util.List;
import java.util.Optional;

import com.platform.domain.entity.Client;
import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindClient {
	private final ClientRepository repository;
	
	public Optional<Client> findById(final Long id){
		return repository.findById(id);
	}
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Optional<Client> findByEmail(final String email){
		return repository.findByEmail(email);
	}
}
