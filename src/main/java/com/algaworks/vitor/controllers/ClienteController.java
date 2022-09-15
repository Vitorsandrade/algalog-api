package com.algaworks.vitor.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.vitor.models.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar(){
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("vitor");
		cliente1.setTelefone("4235345-45");
		cliente1.setEmail("jksdhfkojdshklfgsd@gmail.com");
		
		return Arrays.asList(cliente1);
	}
}
