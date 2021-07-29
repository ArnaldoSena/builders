package com.platform.domain.port;

import java.util.List;
import java.util.Optional;

import com.platform.domain.entity.Client;

public interface ClientRepository {
	public Client create(Client newClient);
	public Optional<Client> findById(Long idClient);
	public Optional<Client> findByEmail(String email);
	public List<Client> findAll();
	public Client update(Client client);
	public void delete(Long idClient);
}
