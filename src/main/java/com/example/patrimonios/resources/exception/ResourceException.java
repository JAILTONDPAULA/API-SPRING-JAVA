package com.example.patrimonios.resources.exception;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceException {
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<StandardError> exececao(NoSuchElementException er){
		StandardError error = new StandardError(true, "Registro Não Encontrado", er.getMessage());
		return ResponseEntity.ok().body(error);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<StandardError> exececao(EmptyResultDataAccessException er){
		StandardError error = new StandardError(true, "Registro Não Encontrado", er.getMessage());
		return ResponseEntity.ok().body(error);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<StandardError> exececao(RuntimeException er){
		StandardError error = new StandardError(true, "Não Encontrado padrão", er.toString());
		return ResponseEntity.ok().body(error);
	}
}
