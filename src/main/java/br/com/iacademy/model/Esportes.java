package br.com.iacademy.model;

public enum Esportes {

	MUSCULACAO("Musculação"),
	PILATES("Pilates"),
	LUTAS("Lutas Livres");
	
	private String descricao;

	Esportes(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}