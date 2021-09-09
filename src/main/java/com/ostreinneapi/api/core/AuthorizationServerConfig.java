package com.ostreinneapi.api.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	@Autowired
	private AuthenticationManager authenticationManager;
	
	//@Value("${security.jwt.signing-key}")
	//private String signingKey;
	
	
	/* AQUI ERA PARA USAR OUTRA AUTENTICAÇÃO, DOS DADOS EM MEMORIA E A BAIXO FOI UTILIZADA AUTENTICAÇÃO COM JWT
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
	
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		     	.tokenStore(tokenStore())
		     	.authenticationManager(authenticationManager);
	}
	*
	*/
	
	//chave de assinatura
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
	//conversor de token
	@Bean 
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		//tokenConverter.setSigningKey(signingKey);
		return tokenConverter;
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		     	.tokenStore(tokenStore())
		     	.accessTokenConverter(accessTokenConverter())
		     	.authenticationManager(authenticationManager);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
				.inMemory()
				.withClient("app-angular")
				.secret("@456")
				.scopes("read", "write")
				.authorizedGrantTypes("password")
				.accessTokenValiditySeconds(1800);
		
	}
	
}
