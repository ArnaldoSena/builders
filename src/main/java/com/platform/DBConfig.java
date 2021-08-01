package com.platform;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.platform.adapter.repository.MapRepository;
import com.platform.usecase.port.ClientRepository;
import com.platform.usecase.service.CreateClientService;
import com.platform.usecase.service.DeleteClientService;
import com.platform.usecase.service.FindClientService;
import com.platform.usecase.service.UpdateClientService;

@Configuration
public class DBConfig {
	
	private final ClientRepository clientRepository = new MapRepository();
	
	@Bean
	public CreateClientService createClientService() {
		return new CreateClientService(clientRepository);
	}
	@Bean
	public FindClientService findClientService() {
		return new FindClientService(clientRepository);
	}
	@Bean
	public DeleteClientService deleteClientService() {
		return new DeleteClientService(clientRepository);
	}
	@Bean
	public UpdateClientService updateClientService() {
		return new UpdateClientService(clientRepository);
	}
}
