package com.algaworks.vitor.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.vitor.domain.repository.ClienteRepository;
import com.algaworks.vitor.models.Cliente;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteController {

	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findByNomeContaining("a");
	}
	
	
}
