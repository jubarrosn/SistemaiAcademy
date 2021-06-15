package br.com.iacademy.model;

public enum InfoMessages{
	
	CADASTRO_DELETE_OK("Cadastro deletado com sucesso!"), 
	CADASTRO_SAVE_OK("Cadastro salvo com sucesso!"), 
	CADASTRO_USER_OK("Usuário salvo com sucesso!"), 
	CADASTRO_SENHA_OK("Senha salva com sucesso!"),
	CADASTRO_DELETE_ERROR("Ocorreu um erro ao excluir o cadastro"), 
	CADASTRO_ADD_ERROR("Ocorreu um erro ao adicionar o cadastro"), 
	CADASTRO_UPDATE_ERROR("Ocorreu um erro ao atualizar o cadastro"), 
	CADASTRO_CNPJ_ERROR("CNPJ inválido"), 
	CADASTRO_CPF_ERROR("CPF inválido"), 
	CADASTRO_USER_SENHA_ERROR("Usuário ou senha não encontrado"), 
	CADASTRO_DELETE_CONFIRMAR("Deseja realmente excluir o cadastro?");
	
	
	private String descricao;

	InfoMessages(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}