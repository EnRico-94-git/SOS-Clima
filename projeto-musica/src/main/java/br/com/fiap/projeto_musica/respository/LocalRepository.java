package br.com.fiap.projeto_musica.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.projeto_musica.model.Local;

public interface LocalRepository extends JpaRepository<Local, Long>{

}
