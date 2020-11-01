package com.vargas.DockerComposePractica.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="polls")
public class Poll {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private Integer question1;
	private Integer question2;
	private Integer question3;
	private String question4;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuestion1() {
		return question1;
	}
	public void setQuestion1(Integer question1) {
		this.question1 = question1;
	}
	public Integer getQuestion2() {
		return question2;
	}
	public void setQuestion2(Integer question2) {
		this.question2 = question2;
	}
	public Integer getQuestion3() {
		return question3;
	}
	public void setQuestion3(Integer question3) {
		this.question3 = question3;
	}
	public String getQuestion4() {
		return question4;
	}
	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	
}
