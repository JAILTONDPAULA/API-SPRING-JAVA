package com.example.patrimonios.etinties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.patrimonios.etinties.enums.Cargo;

@Entity
@Table(name = "COLABORADOR")
public class Colaborador implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   cdColaborador;
	private String nome;
	private int    cargo;
	
	@OneToMany(mappedBy = "colaborador")
	private List<Bem> bem = new ArrayList<>();
	
	
	public Colaborador() {
	}

	public Colaborador(Long cdColaborador, String nome, Cargo cargo) {
		this.cdColaborador = cdColaborador;
		nome 			   = nome;
		this.cargo 		   = cargo.getCode();
	}

	public Long getCdColaborador() {
		return cdColaborador;
	}

	public void setCdColaborador(Long cdColaborador) {
		this.cdColaborador = cdColaborador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return Cargo.valueOf(cargo);
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo.getCode();
	}

	public List<Bem> getBem() {
		return bem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cdColaborador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		return Objects.equals(cdColaborador, other.cdColaborador);
	}

	@Override
	public String toString() {
		return "Colaborador [cdColaborador=" + cdColaborador + ", nome=" + nome + ", cargo=" + cargo + "]";
	}
	
}
