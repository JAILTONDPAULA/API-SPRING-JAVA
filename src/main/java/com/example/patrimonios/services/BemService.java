package com.example.patrimonios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patrimonios.etinties.Bem;
import com.example.patrimonios.repositories.BemRepository;
import com.example.patrimonios.services.exception.ResourceNotFound;

@Service
public class BemService {
	@Autowired
	private BemRepository br;
	
	public List<Bem> findAll(){
		List<Bem> bens = br.findAll();
		return bens;
	}
	
	public Bem findById(Long id) {
			Optional<Bem> bem = br.findById(id);
			return bem.get();
	}
	
	public Bem insert(Bem bem) {
		return br.save(bem);
	}
	
	public void delete(Long id) {
		br.deleteById(id);
	}
	
	public Bem update(Long id, Bem bem) {
		Bem bemBanco = br.getById(id);
		bemBanco.setEstado(bem.getEstado());
		bemBanco.setStatus(bem.getStatus());
		bemBanco.setMarca(bem.getMarca());
		bemBanco.setProduto(bem.getProduto());
		
		return br.save(bemBanco); 
	}
}
