package com.example.patrimonios.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Boolean error;
	private String  mensagem;
	private String  expecificacao;
	
	public StandardError() {
		super();
	}

	public StandardError(Boolean error, String mensagem, String expecificacao) {
		super();
		this.error 		   = error;
		this.mensagem      = mensagem;
		this.expecificacao = expecificacao;
	}

	public Boolean getError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setExpecificacao(String expecificacao) {
		this.expecificacao = expecificacao;
	}

	public String getExpecificacao() {
		return expecificacao;
	}
	
}
