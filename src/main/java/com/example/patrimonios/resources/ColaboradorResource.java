package com.example.patrimonios.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.patrimonios.etinties.Colaborador;
import com.example.patrimonios.services.ColaboradorService;
@RestController
@RequestMapping(value = "/colaborador")
public class ColaboradorResource {
	@Autowired
	private ColaboradorService cs;
	
	@GetMapping
	public ResponseEntity<List<Colaborador>> findAll(){
		List cobs = cs.findAll();
		return ResponseEntity.ok().body(cobs);
	}
	
	@GetMapping(value = "/{cod}")
	public ResponseEntity<Colaborador> findById(@PathVariable Long cod){
		Colaborador cob = cs.findById(cod);
		return ResponseEntity.ok().body(cob);
	}
	
	@PostMapping
	public ResponseEntity<Colaborador> insert(@RequestBody Colaborador cob){
		Colaborador cob1 = cs.insert(cob);
		return ResponseEntity.ok().body(cob1);
	}
	
	@PutMapping(value = "/{cod}")
	public ResponseEntity<Colaborador> update(@PathVariable Long cod, @RequestBody Colaborador cob){
		Colaborador cob1 = cs.update(cod, cob);
		return ResponseEntity.ok().body(cob1);
	}

	@DeleteMapping(value = "/{cod}")
	public ResponseEntity<Void> delete(@PathVariable Long cod){
		cs.delete(cod);
		return ResponseEntity.noContent().build();
	}
}
