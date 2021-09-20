package com.ostreinneapi.api.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	//configuração dos locais de acessos 
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		  .authorizeRequests()
		  		.antMatchers("/api/usuarios").permitAll() // permite o cadastro sem precisar do token
		  		.antMatchers("/clientes-angular").authenticated() // precisa do token para fazer o login
		  		.antMatchers("/clientes-angular/*").authenticated() 
		  		.anyRequest().denyAll();
	}
}
