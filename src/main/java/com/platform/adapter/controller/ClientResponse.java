package com.platform.adapter.controller;

import java.util.Date;

import com.platform.usecase.validator.AgeCalculator;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@Builder
public class ClientResponse{
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	@Setter(AccessLevel.NONE)
	private String passWord;
	private Date birthDate;
	@Setter(AccessLevel.NONE)
	private int idade;
	
	public void setIdade(int idade) {
		this.idade = AgeCalculator.calutateAge(birthDate);
	}
	
	public void setPassWord(String valor) {
		this.passWord = "****";
	}
}
