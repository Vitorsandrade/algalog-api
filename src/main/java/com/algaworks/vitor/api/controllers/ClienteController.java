package com.algaworks.vitor.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.vitor.domain.repository.ClienteRepository;
import com.algaworks.vitor.domain.service.CatalogoClienteService;
import com.algaworks.vitor.domain.models.Cliente;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;
	private CatalogoClienteService catalogoClienteService;
	
	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{clienteId}")
	// ResponseEntity serve para manipular a resposta do status
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {

		// Modo simplificado
		return clienteRepository.findById(clienteId).map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());

//		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//		
//		if (cliente.isPresent()) {
////			se o cliente estiver presente retorna o cliente e o status 200 OK
//			return ResponseEntity.ok(cliente.get());
//		}
////		se não estiver retorna status notfound 404
//		return ResponseEntity.notFound().build();

	}
	
	@PostMapping
	// serve para passar a repsosta de status 201 Created
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return catalogoClienteService.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,@Valid @RequestBody Cliente cliente){
		 if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		 
		 // forçando para que o cliente continue com o mesmo ID e n precise criar outro cliente
		 cliente.setId(clienteId);
		 cliente = catalogoClienteService.salvar(cliente);
		 
		 return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		catalogoClienteService.excluir(clienteId);
		
		return ResponseEntity.noContent().build();
	}
}
