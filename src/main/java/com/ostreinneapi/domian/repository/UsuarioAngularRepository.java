package com.ostreinneapi.domian.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ostreinneapi.domian.model.UsuarioAngular;

@Repository
public interface UsuarioAngularRepository extends JpaRepository<UsuarioAngular, Long> {
	Optional<UsuarioAngular> findByUsername(String username);
}
