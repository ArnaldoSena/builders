package com.platform.domain.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String passWord;
	private Date birthDate;
}
