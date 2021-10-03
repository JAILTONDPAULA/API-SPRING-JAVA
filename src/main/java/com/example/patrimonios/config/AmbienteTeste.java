package com.example.patrimonios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.patrimonios.etinties.Bem;
import com.example.patrimonios.etinties.Colaborador;
import com.example.patrimonios.etinties.enums.Cargo;
import com.example.patrimonios.etinties.enums.EstadoBem;
import com.example.patrimonios.etinties.enums.Status;
import com.example.patrimonios.repositories.BemRepository;
import com.example.patrimonios.services.BemService;
import com.example.patrimonios.services.ColaboradorService;

@Configuration
@Profile("tst")
public class AmbienteTeste implements CommandLineRunner{

	@Autowired
	private BemService bs;
	@Autowired
	private ColaboradorService cs;
	
	@Override
	public void run(String... args) throws Exception {
		
		Colaborador cob = new Colaborador(null, "JAILTON DPAULA", Cargo.ANALISTA);
		cs.insert(cob);
		
		Bem bem = new Bem(null, "NOTEBOKK", "DELL", "N0005X", Status.ATIVO, EstadoBem.NOVO, cob);
		bs.insert(bem);

	}

}
