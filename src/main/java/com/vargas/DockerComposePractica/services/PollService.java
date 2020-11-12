package com.vargas.DockerComposePractica.services;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	
	public Map<String, Double> getBarGraphData() {
		Map<String, Double> graphData = new TreeMap<>();
		List<Poll> polls = pollRepository.findAll();
		
		Integer question1_summation = 0;
		Integer question2_summation = 0;
		Integer question3_summation = 0;
		
		for (Poll poll : polls) {
			question1_summation = question1_summation + poll.getQuestion1();
			question2_summation = question2_summation + poll.getQuestion2();
			question3_summation = question3_summation + poll.getQuestion3();
		}
		
		Double average1 = question1_summation / Double.valueOf(polls.size());
		Double average2 = question2_summation / Double.valueOf(polls.size());
		Double average3 = question3_summation / Double.valueOf(polls.size());
		
		graphData.put("question1", average1);
		graphData.put("question2", average2);
		graphData.put("question3", average3);
		
		return graphData;
	}

}
