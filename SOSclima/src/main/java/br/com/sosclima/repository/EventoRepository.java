package br.com.sosclima.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sosclima.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query("SELECT e FROM Evento e JOIN FETCH e.local JOIN FETCH e.recomendacao")
    List<Evento> findAllComRelacionamentos();

    @Query("SELECT e FROM Evento e JOIN FETCH e.local JOIN FETCH e.recomendacao WHERE e.id = :id")
    Optional<Evento> findByIdComRelacionamentos(@Param("id") Long id);
}