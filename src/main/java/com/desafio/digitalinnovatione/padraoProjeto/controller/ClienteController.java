package com.desafio.digitalinnovatione.padraoProjeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.digitalinnovatione.padraoProjeto.Service.ClienteService;
import com.desafio.digitalinnovatione.padraoProjeto.entity.Cliente;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
    private ClienteService clienteService;

	

	@GetMapping
	public ResponseEntity<Iterable<Cliente>> findAll(String name) {
		return ResponseEntity.ok(clienteService.findAll(name));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		return ResponseEntity.ok(clienteService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
		return ResponseEntity.ok(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
		clienteService.update(cliente);
		return ResponseEntity.ok(cliente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		clienteService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteAll() {
		clienteService.deleteAll();
		return ResponseEntity.ok().build();
	}
	
	
}