package br.com.iacademy.model;

public enum Exercicios {
	
	ESTEIRA("Esteira"),
	BICICLETA("Bicicleta"),
	SUPINO("Supino"),
	HALTERE("Haltere"),
	REMADA("Remada");
	
	private String descricao;

	Exercicios(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}