package com.example.patrimonios.services.exception;

public class ResourceNotFound extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFound(String id) {
		super("Código "+id+" não encontrado");
	}
}
