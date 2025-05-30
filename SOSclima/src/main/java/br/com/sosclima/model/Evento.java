package br.com.sosclima.model;

public class Evento {
	
	private String tipo;
	private int nivel;
	
	public Evento() {
		
	}
	
	public Evento(String tipo, int nivel) {
		super();
		this.tipo = tipo;
		this.nivel = nivel;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
