package br.com.sosclima.model;

public class Recomendacao {

	private String descricao;

	
	public Recomendacao() {}
	
	public Recomendacao(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
