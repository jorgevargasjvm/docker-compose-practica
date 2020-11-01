package com.vargas.DockerComposePractica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vargas.DockerComposePractica.models.Poll;
import com.vargas.DockerComposePractica.repositories.PollRepository;

@Service
public class PollService {
	
	@Autowired
	private PollRepository pollRepository;
	
	public Boolean savePoll(Poll poll) {
		if (pollRepository.save(poll) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Poll> getPollsList(){
		return pollRepository.findAll();
	}

}
