package com.platform.usecase.mapper;

import java.util.Optional;

import com.platform.adapter.controller.ClientResponse;
import com.platform.domain.entity.Client;
import com.platform.usecase.validator.AgeCalculator;

public class ClientMapper {

	public static ClientResponse mapper(Optional<Client> clientOpt) {
		Client client = clientOpt.get();
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
}
