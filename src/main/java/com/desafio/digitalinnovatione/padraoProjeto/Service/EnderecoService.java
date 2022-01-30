package com.desafio.digitalinnovatione.padraoProjeto.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.digitalinnovatione.padraoProjeto.Repository.ClienteRepository;
import com.desafio.digitalinnovatione.padraoProjeto.Repository.EnderecoRepository;
import com.desafio.digitalinnovatione.padraoProjeto.entity.Cliente;
import com.desafio.digitalinnovatione.padraoProjeto.entity.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	
	public Iterable<Endereco> findAll() {
		// Buscar todos os Clientes.
		return enderecoRepository.findAll();
	}

	
	public Endereco findById(String cep) {
		// Buscar Cliente por ID.
		Optional<Endereco> endereco = enderecoRepository.findById(cep);
		return endereco.get();
	}

	
	public void save(Cliente cliente) {
		saveClienteCep(cliente);
	}

	
	public void update(String id, Cliente cliente) {
		// Buscar endereço por ID, caso exista:
		Optional<Endereco> enderecoBd = enderecoRepository.findById(id);
		if (enderecoBd.isPresent()) {
			saveClienteCep(cliente);
		}
	}

	
	public void delete(String cep) {
		// Deletar endereço por ID.
		enderecoRepository.deleteByCep(cep);
	}

	private void saveClienteCep(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}


	


	


	

}
