package br.com.iacademy.model;

public enum Turno {
	MATUTINO("Matutino"), 
	VESPERTINIO("Vespertino"),
	NOTURNO("Noturno"),
	INTEGRAL("Integral");
	
	private String descricao;

	Turno(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}