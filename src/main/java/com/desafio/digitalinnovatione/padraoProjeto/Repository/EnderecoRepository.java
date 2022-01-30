package com.desafio.digitalinnovatione.padraoProjeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.digitalinnovatione.padraoProjeto.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {

	void deleteByCep(String cep);

}
