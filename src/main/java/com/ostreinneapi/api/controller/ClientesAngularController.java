package com.ostreinneapi.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ostreinneapi.domian.model.Cliente;
import com.ostreinneapi.domian.model.ClienteAngular;
import com.ostreinneapi.domian.repository.ClienteAngularRepository;
import com.ostreinneapi.domian.repository.ClienteRepository;
import com.ostreinneapi.domian.service.CadastroClienteService;

@RestController
@RequestMapping("/clientes-angular")
@CrossOrigin("http://localhost:4200")
public class ClientesAngularController {

	@Autowired
	private ClienteAngularRepository clienteRepository;
	
	@Autowired
	private CadastroClienteService cadastroCliente;
	
	
	@GetMapping
	public List<ClienteAngular> listar() {
		return clienteRepository.findAll();
		//return clienteRepository.findByNomeContaining("san");		
	}
 
	@GetMapping("/{clienteId}")
	public ResponseEntity<ClienteAngular> buscar(@PathVariable Long clienteId) {
		Optional<ClienteAngular> cliente = clienteRepository.findById(clienteId);		
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteAngular adicionar(@Valid @RequestBody ClienteAngular cliente) {		
		return cadastroCliente.salvarClientesAngular(cliente);		 
	}
	
	@PutMapping("/{clienteAngularId}")
	public ResponseEntity<ClienteAngular> atualizar(@Valid @PathVariable Long clienteId, 
			@RequestBody ClienteAngular cliente) {
		
		if(!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(clienteId);
		cliente = clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente);				
	}
 	
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId ){
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build(); 
		}
		
		clienteRepository.deleteById(clienteId);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
