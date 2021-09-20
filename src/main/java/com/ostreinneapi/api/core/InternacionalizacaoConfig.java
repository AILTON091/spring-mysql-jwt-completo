package com.ostreinneapi.api.core;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


//configuração para ler as frases de validação no messages.properties
@Configuration
public class InternacionalizacaoConfig {

		// configurações basicas para ler o message
		@Bean
		public MessageSource messageSource() {
			ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
			messageSource.setBasename("classpath:messages"); // local onde estão as frases 
			messageSource.setDefaultEncoding("ISO-8859-1"); //encode português
			messageSource.setDefaultLocale(Locale.getDefault()); //busca o local da maquina		
			return messageSource; 		
		}

		
		// carrega o message source 
		@Bean
		public LocalValidatorFactoryBean validatorFactoryBean() {
			LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
			bean.setValidationMessageSource(messageSource());
			return bean;
		}
	
}
