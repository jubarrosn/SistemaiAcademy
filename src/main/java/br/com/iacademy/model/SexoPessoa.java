package br.com.iacademy.model;

public enum SexoPessoa {
		
		FEMININO("Feminino"),
		MASCULINO("Masculino"),
		NAODEFINIDO("Não Definido");

		private String descricao;

		SexoPessoa(String descricao) {
			this.descricao = descricao;
		}
		
		public String getDescricao() {
			return descricao;
		}
}
