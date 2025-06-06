package br.com.fiap.projeto_sosclima.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cidade;
    private String pais;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}