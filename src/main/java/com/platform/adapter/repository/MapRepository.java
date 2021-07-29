package com.platform.adapter.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.platform.domain.entity.Client;
import com.platform.domain.port.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MapRepository implements ClientRepository {

	private final Map<Long, Client> mapDB = new HashMap<>();
	
	@Override
	public Client create(Client newClient) {
		mapDB.put(newClient.getId(), newClient);
		return newClient;
	}

	@Override
	public Optional<Client> findById(Long idClient){
		try {
			return Optional.ofNullable(mapDB.get(idClient));
		}catch(ClassCastException cce) {
			log.error("Cast inválido para o tipo Client", cce);
		}catch(NullPointerException npe) {
			log.error("Inválido Tipo id do cliente", npe);
		}catch(Exception e) {
			log.error("Error: ", e);
		}
		return null;
	}

	@Override
	public Optional<Client> findByEmail(String email) {
		return mapDB.entrySet().stream()
				.filter(map -> email.equals(map.getValue().getEmail()))
				.map(map -> map.getValue())
				.findFirst();
	}

	@Override
	public List<Client> findAll() {
		return mapDB.values().stream().collect(Collectors.toList());
	}

	@Override
	public Client update(Client client) {
		return mapDB.merge(client.getId(), client, null);
	}

	@Override
	public void delete(Long idClient) {
		mapDB.remove(idClient);
	}

}
