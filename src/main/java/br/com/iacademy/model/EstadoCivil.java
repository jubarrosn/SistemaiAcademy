package br.com.iacademy.model;

public enum EstadoCivil {
	
	SOLTEIRO ("Solteiro(a)"),
	CASADO ("Casado(a)"),
	DIVORCIADO ("Divorciado(a)"),
	SEPARADO("Separado(a)"),
	VIUVO("Viúvo(a)");
	
	private String descricao;

	EstadoCivil(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}