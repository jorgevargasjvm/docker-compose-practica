package com.vargas.DockerComposePractica.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vargas.DockerComposePractica.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
}
