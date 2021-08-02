package com.platform.usecase.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.platform.adapter.controller.ClientResponse;
import com.platform.domain.entity.Client;
import com.platform.usecase.validator.AgeCalculator;

public class ClientMapper {

	public static ClientResponse mapper(Optional<Client> clientOpt) {
		Client client = clientOpt.get();
		return mapper(client);
	}
	
	public static ClientResponse mapper(Client client) {
		return	ClientResponse.builder()
				.id(client.getId())
				.firstName(client.getFirstName())
				.lastName(client.getLastName())
				.email(client.getEmail())
				.birthDate(client.getBirthDate())
				.passWord("****")
				.idade(AgeCalculator.calutateAge(client.getBirthDate()))
				.build();
	}
	
	public static List<ClientResponse> mapper(List<Client> clients){
		List<ClientResponse> collect = clients.stream().map(c -> mapper(c))
				.collect(Collectors.toList());
		return collect;
	}
}
