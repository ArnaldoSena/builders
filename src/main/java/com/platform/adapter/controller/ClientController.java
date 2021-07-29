package com.platform.adapter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.domain.entity.Client;
import com.platform.usecase.service.CreateClientService;
import com.platform.usecase.service.DeleteClientService;
import com.platform.usecase.service.FindClientService;
import com.platform.usecase.service.UpdateClientService;

@RestController
@RequestMapping("/api/v1/builders/")
public class ClientController {
	
	@Autowired private CreateClientService createService;
	@Autowired private DeleteClientService deleteService;
	@Autowired private UpdateClientService updateService;
	@Autowired private FindClientService findService;
	
	@GetMapping("clientes")
	List<Client> getAllClients(){
		return findService.findAll();
	}

	@GetMapping("clientes/{id}")
	public Optional<Client> getClienteById(Long idClient) {
		return findService.findById(idClient);
	}
}
