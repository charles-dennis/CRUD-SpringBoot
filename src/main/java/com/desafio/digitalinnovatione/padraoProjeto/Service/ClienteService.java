package com.desafio.digitalinnovatione.padraoProjeto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.digitalinnovatione.padraoProjeto.Repository.ClienteRepository;
import com.desafio.digitalinnovatione.padraoProjeto.entity.Cliente;

@Service
public class ClienteService{

		// Singleton: Injetar os componentes do Spring com @Autowired.
		@Autowired
		private ClienteRepository clienteRepository;
			
		
		public List<Cliente> findAll(String name) {
			return clienteRepository.findAll();
			
		}

		public Cliente findById(Long id) {
			return clienteRepository.findById(id).orElse(null);
		}

		

		public Cliente save(Cliente cliente) {
			cliente.setId(null);
			return save(cliente);
		}

		public Cliente update(Cliente cliente) {
			Long id = cliente.getId();
			if (id != null && clienteRepository.existsById(id)) {
				return save(cliente);
			} else {
				return null;
			}
		}

		public void deleteById(Long id) {
			if (id != null && clienteRepository.existsById(id)) {
				clienteRepository.deleteById(id);
			}
		}

		public void deleteAll() {
			clienteRepository.deleteAllInBatch();
		}

		
	}

