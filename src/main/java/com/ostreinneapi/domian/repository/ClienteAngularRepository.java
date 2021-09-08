package com.ostreinneapi.domian.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ostreinneapi.domian.model.ClienteAngular;

@Repository
public interface ClienteAngularRepository extends  JpaRepository<ClienteAngular, Long> {

	List<ClienteAngular> findByNome(String nome);	
	List<ClienteAngular> findByNomeContaining(String nome);
	ClienteAngular findByCpf(String cpf);
}
