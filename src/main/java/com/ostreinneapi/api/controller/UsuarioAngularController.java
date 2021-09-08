package com.ostreinneapi.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ostreinneapi.domian.model.UsuarioAngular;
import com.ostreinneapi.domian.repository.UsuarioAngularRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioAngularController {

	@Autowired
	private UsuarioAngularRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvar(@Valid @RequestBody UsuarioAngular usuario) {
		repository.save(usuario);
	}
	
}
