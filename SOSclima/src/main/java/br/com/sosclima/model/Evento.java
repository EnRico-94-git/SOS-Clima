package br.com.sosclima.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tipo;
    private int nivel;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_id", referencedColumnName = "id")
    private Local local;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recomendacao_id", referencedColumnName = "id")
    private Recomendacao recomendacao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    
    public Local getLocal() { return local; }
    public void setLocal(Local local) { this.local = local; }
    
    public Recomendacao getRecomendacao() { return recomendacao; }
    public void setRecomendacao(Recomendacao recomendacao) { this.recomendacao = recomendacao; }
}