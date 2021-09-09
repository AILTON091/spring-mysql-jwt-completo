package com.ostreinneapi.domian.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ostreinneapi.domian.model.UsuarioAngular;
import com.ostreinneapi.domian.repository.UsuarioAngularRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioAngularRepository usuarioAngularRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioAngular usuarioAngular = usuarioAngularRepository
										.findByUsername(username)
										.orElseThrow(() -> new UsernameNotFoundException("Login não encontrado."));
		
		return User
				.builder()
				.username(usuarioAngular.getUsername())
				.password(usuarioAngular.getPassword())
				.roles("USER")
				.build();
	}

}
