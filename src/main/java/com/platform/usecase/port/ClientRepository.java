package com.platform.usecase.port;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.platform.domain.entity.Client;

public interface ClientRepository {
	public Client create(Client newClient);
	public Optional<Client> findById(Long idClient);
	public Optional<Client> findByEmail(String email);
	public List<Client> findAll();
	public Page<Client> findAll(Pageable pageble);
	public Client update(Client client);
	public void delete(Long idClient);
}
