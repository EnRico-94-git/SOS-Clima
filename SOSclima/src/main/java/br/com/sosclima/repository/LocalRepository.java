package br.com.sosclima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sosclima.model.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {
}