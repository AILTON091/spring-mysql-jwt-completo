package com.ostreinneapi.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Problema {
	
	private Integer status;
	private OffsetDateTime dataHora;
	private String mensagem;
	private List<Campo> campos;
	
	public static class Campo {
		
		private String nome;
		private String mensagemCampo;		
		
		public Campo(String nome, String mensagemCampo) {
			super();
			this.nome = nome;
			this.mensagemCampo = mensagemCampo;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getMensagemCampo() {
			return mensagemCampo;
		}
		public void setMensagemCampo(String mensagemCampo) {
			this.mensagemCampo = mensagemCampo;
		}
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OffsetDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(OffsetDateTime localDateTime) {
		this.dataHora = localDateTime;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public List<Campo> getCampos() {
		return campos;
	}
	public void setCampos(List<Campo> campos) {
		this.campos = campos;
	}

	
}
