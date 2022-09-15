package com.algaworks.vitor.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

	private long id;

	private String nome;
	
	private String email;
	
	private String telefone;
	
	
}
