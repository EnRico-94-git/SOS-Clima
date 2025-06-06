package br.com.fiap.projeto_musica.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_musica.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
