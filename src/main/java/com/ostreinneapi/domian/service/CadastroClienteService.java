package com.ostreinneapi.domian.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ostreinneapi.domian.exceprion.NegocioException;
import com.ostreinneapi.domian.model.Cliente;
import com.ostreinneapi.domian.model.ClienteAngular;
import com.ostreinneapi.domian.repository.ClienteAngularRepository;
import com.ostreinneapi.domian.repository.ClienteRepository;

@Service
public class CadastroClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteAngularRepository clienteAngularRepository;
	
	public Cliente salvar(Cliente cliente) {
		
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente) ) {
			throw new NegocioException("já existe cliente cadastrado com esse e-mail"); 
		}
		
		return clienteRepository.save(cliente);
	}
	
	public ClienteAngular salvarClientesAngular(ClienteAngular cliente) {
		
		ClienteAngular clienteExistente = clienteAngularRepository.findByCpf(cliente.getCpf());
		
		cliente.setDataCadastro(OffsetDateTime.now());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente) ) {
			throw new NegocioException("já existe cliente cadastrado com esse cpf"); 
		}
		
		return clienteAngularRepository.save(cliente);
	}
	
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
}


