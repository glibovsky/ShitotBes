package com.shitot.dao;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "patient")
public class PatientDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private int id;

    private String name;
    private String telNumber;
    private int age;
    private String description;

    @OneToMany
    List<TreatmentDAO> treatments;

	public PatientDAO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TreatmentDAO> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<TreatmentDAO> treatments) {
		this.treatments = treatments;
	}

    

}
