package com.desafio.digitalinnovatione.padraoProjeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.digitalinnovatione.padraoProjeto.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {

	void deleteByCep(String cep);

}
