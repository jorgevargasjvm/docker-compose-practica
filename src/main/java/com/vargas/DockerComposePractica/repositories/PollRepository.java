package com.vargas.DockerComposePractica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vargas.DockerComposePractica.models.Poll;

public interface PollRepository extends JpaRepository<Poll, Long>{
	
}
