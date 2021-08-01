package com.platform.adapter.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.platform.domain.entity.Client;
import com.platform.usecase.erros.Erro;
import com.platform.usecase.mapper.ClientMapper;
import com.platform.usecase.service.CreateClientService;
import com.platform.usecase.service.DeleteClientService;
import com.platform.usecase.service.FindClientService;
import com.platform.usecase.service.UpdateClientService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api/v1/builders/")
public class ClientController {
	
	@Autowired private CreateClientService createService;
	@Autowired private DeleteClientService deleteService;
	@Autowired private UpdateClientService updateService;
	@Autowired private FindClientService findService;
	
	@GetMapping("clientes")
	@ResponseStatus(HttpStatus.OK)
	List<Client> getAllClients(){
		return findService.findAll();
	}

	@GetMapping("clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClientResponse getClienteById(@PathVariable("id") Long idClient) {
		Optional<Client> client = findService.findById(idClient); 
		return ClientMapper.mapper(client);
	}
	
	@GetMapping("clientes/email/{email}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Client> getClienteByEmail(@PathVariable("email") String email){
		return findService.findByEmail(email);
	}
	
	@PostMapping("clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Client>> saveClient(@RequestBody Client client,
			BindingResult result) throws NoSuchAlgorithmException{
		
		log.info("Cadastrando o cliente {}.", client.getFirstName());
		Response<Client> response = new Response<Client>();
		validarClienteExistente(client, result);
		//TODO dto mapper
		if(result.hasErrors()) {
			log.error(Erro.EMAIL_CADASTRADO, result.getAllErrors());
			result.getAllErrors()
				.forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(createService.create(client));
		return ResponseEntity.ok(response);
	}
	
	@PatchMapping("clientes")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Response<Client>> updateClient(@RequestBody Client client,
			BindingResult result) throws NoSuchAlgorithmException{
		log.info("Atualizando cliente {}", client.getFirstName());
		Response<Client> response = new Response<Client>();
		validarClienteInexistente(client, result);
		//TODO Dto mapper
		if(result.hasErrors()) {
			log.error(Erro.CLIENTE_INEXISTENTE, client.getId());
			result.getAllErrors()
			.forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(updateService.update(client));
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteClient(@PathVariable("id") Long id) {
		deleteService.delete(id);	
	}
	
	private void validarClienteExistente(Client client, BindingResult result) {
		this.findService.findByEmail(client.getEmail())
			.ifPresent(cli -> result.addError(new ObjectError("Client", Erro.EMAIL_CADASTRADO)));
	}
	
	private void validarClienteInexistente(Client client, BindingResult result) {
		if(this.findService.findById(client.getId()).isEmpty()) {
			result.addError(new ObjectError("Client", Erro.CLIENTE_INEXISTENTE));
		}
	}
}
