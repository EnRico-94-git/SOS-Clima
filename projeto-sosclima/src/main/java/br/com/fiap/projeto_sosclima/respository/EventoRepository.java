package br.com.fiap.projeto_sosclima.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_sosclima.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
