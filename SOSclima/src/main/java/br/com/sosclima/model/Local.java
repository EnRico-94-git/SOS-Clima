package br.com.sosclima.model;

public class Local {

	private String cidade;
	private String pais;
	

	public Local() {
		
	}
	
	public Local(String cidade, String pais) {
		super();
		this.cidade = cidade;
		this.pais = pais;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
}
