package com.desafio.digitalinnovatione.padraoProjeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.digitalinnovatione.padraoProjeto.Service.EnderecoService;
import com.desafio.digitalinnovatione.padraoProjeto.entity.Endereco;

@RestController
public class EnderecoController {
	

	@Autowired
    private EnderecoService enderecoService;

	

	@GetMapping
	public ResponseEntity<Iterable<Endereco>> findAll(String name) {
		return ResponseEntity.ok(enderecoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable String id) {
		return ResponseEntity.ok(enderecoService.findById(id));
	}	
	
	@DeleteMapping
	public ResponseEntity<Void> delete() {
		enderecoService.delete(null);
		return ResponseEntity.ok().build();
	}
	
	
}


