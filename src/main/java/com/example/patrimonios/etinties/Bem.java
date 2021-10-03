package com.example.patrimonios.etinties;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.patrimonios.etinties.enums.EstadoBem;
import com.example.patrimonios.etinties.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BENS")
public class Bem implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   codBem;
	private String produto;
	private String marca;
	private String serie;
	private int	   status;
	private int    estado;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cd_colaborador")
	private Colaborador colaborador;
	
	
	public Bem() {
	}

	public Bem(Long codBem, String produto, String marca, String serie, Status status, EstadoBem estado, Colaborador colaborador) {
		this.codBem  = codBem;
		this.produto = produto;
		this.marca   = marca;
		this.serie   = serie;
		this.status  = status.getCode();
		this.estado  = estado.getCode();
		this.colaborador = colaborador;
	}

	public Long getCodBem() {
		return codBem;
	}

	public void setCodBem(Long codBem) {
		this.codBem = codBem;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Status getStatus() {
		return Status.valueOf(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCode();
	}

	public EstadoBem getEstado() {
		return EstadoBem.valueOf(this.estado);
	}

	public void setEstado(EstadoBem estado) {
		this.estado = estado.getCode();
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codBem);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bem other = (Bem) obj;
		return Objects.equals(codBem, other.codBem);
	}

	@Override
	public String toString() {
		return "Bens [codBem=" + codBem + ", produto=" + produto + ", marca=" + marca + ", serie=" + serie + ", status="
				+ status + ", estado=" + estado + "]";
	}
	
	
	
	
}
