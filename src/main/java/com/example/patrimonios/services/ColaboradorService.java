package com.example.patrimonios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.patrimonios.etinties.Colaborador;
import com.example.patrimonios.repositories.ColaboradorRepository;
@Service
public class ColaboradorService {
	@Autowired
	private ColaboradorRepository cr;
	
	public List<Colaborador> findAll(){
		List<Colaborador> cob = cr.findAll();
		return cob;
	}
	
	public Colaborador findById(Long id) {
		Optional<Colaborador> cob = cr.findById(id);
		return cob.get();
	}
	
	public Colaborador insert(Colaborador cob) {
		Colaborador cob1 = cr.save(cob);
		return cob1;
	}
	
	public void delete(Long id) {
		cr.deleteById(id);
	}
	
	public Colaborador update(Long id, Colaborador cob) {
		Colaborador cob1 = cr.getById(id);
		cob1.setNome(cob.getNome());
		cob1.setCargo(cob.getCargo());
		
		return cr.save(cob1);
	}

}
