package br.com.sosclima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sosclima.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}