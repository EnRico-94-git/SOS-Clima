package br.com.sosclima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sosclima.model.Recomendacao;

public interface RecomendacaoRepository extends JpaRepository<Recomendacao, Long> {
}
