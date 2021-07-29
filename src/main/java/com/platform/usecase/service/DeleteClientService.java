package com.platform.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.domain.port.ClientRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class DeleteClientService {

	@Autowired
	private ClientRepository repository;
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
