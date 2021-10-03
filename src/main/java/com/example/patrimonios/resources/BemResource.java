package com.example.patrimonios.resources;

import java.net.URI;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.patrimonios.etinties.Bem;
import com.example.patrimonios.services.BemService;

@RestController
@RequestMapping(value = "/bens")
public class BemResource {
	@Autowired
	private BemService bs;
	
	@GetMapping
	public ResponseEntity<List<Bem>> findAll(){
		List<Bem> bens = bs.findAll();
		return ResponseEntity.ok().body(bens);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bem> findById(@PathVariable Long id){
		Bem bem = bs.findById(id);
		return ResponseEntity.ok().body(bem);
	}
	
	@PostMapping
	public ResponseEntity<Bem> insert(@RequestBody Bem bem){
		bem = bs.insert(bem);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bem.getCodBem()).toUri();
		return ResponseEntity.ok().body(bem);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		bs.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Bem> update(@PathVariable Long id,@RequestBody Bem bem){
		Bem bem1 = bs.update(id, bem);
		return ResponseEntity.ok().body(bem1);
	}
}
