package com.example.patrimonios.etinties.enums;

public enum Status {
	ATIVO(1)       ,
	DESABILITADO(2);
	
	private int code;

	private Status(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}
	
	public static Status valueOf(int code) {
		for(Status x : Status.values()) {
			if(x.getCode() == code) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Não Aceito valor");
	}
}
