package com.example.patrimonios.etinties.enums;

public enum Cargo {
	ANALISTA(1),
	AUXILIAR(2),
	DIRETOR(3) ,
	GERENTE(4) ;
	
	private int code;

	private Cargo(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
	
	public static Cargo valueOf(int code) {
		for(Cargo x : Cargo.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Valor Inválido.");
	}
	
}
