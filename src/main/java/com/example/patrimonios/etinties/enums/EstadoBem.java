package com.example.patrimonios.etinties.enums;

public enum EstadoBem {
	NOVO(1)		  ,
	BOM(2)		  ,
	DANIFICADO(3) ,
	INUTILIZADO(4),
	PEDIDO(5);
	
	private int code;

	private EstadoBem(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static EstadoBem valueOf(int code) {
		for(EstadoBem x : EstadoBem.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Valor Invalido");
	}

}
