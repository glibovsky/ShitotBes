package com.shitot.dao;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "problems")
public class ProblemsDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problems_id")
    private int id;

    private String nameProblem;
    private String description;
    
    @ManyToMany
    List<SymptomsDAO> symptoms;
   

    public ProblemsDAO() { }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNameProblem() {
		return nameProblem;
	}


	public void setNameProblem(String nameProblem) {
		this.nameProblem = nameProblem;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<SymptomsDAO> getSymptoms() {
		return symptoms;
	}


	public void setSymptoms(List<SymptomsDAO> symptoms) {
		this.symptoms = symptoms;
	}




    


}
