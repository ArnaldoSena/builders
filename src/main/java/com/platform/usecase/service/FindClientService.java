package com.platform.usecase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.domain.entity.Client;
import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class FindClientService {
	
	@Autowired
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
