package br.com.iacademy.model;

public enum AplicSerie {
	
	SERIE1 ("1 série"),
	SERIE2 ("2 séries"),
	SERIE3 ("3 séries"),
	SERIE4 ("4 séries"),
	SERIE5 ("5 séries"),
	SERIE6 ("6 séries"),
	SERIE7 ("7 séries"),
	SERIE8 ("8 séries"),
	SERIE9 ("9 séries"),
	SERIE10 ("10 séries"),
	SERIE11 ("11 séries"),
	SERIE12 ("12 séries"),
	SERIE13 ("13 séries"),
	SERIE14 ("14 séries"),
	SERIE15 ("15 séries");
	
	private String descricao;

	AplicSerie(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
