package com.shitot.json;

import java.util.*;


public class Patient {

    private int id;

    private String name;
    private String telNumber;
    private int age;
    private String description;

    
    List<Treatment> treatments;

	public Patient() {}

	public Patient(String name, String telNumber, int age, String description) {
		this.name = name;
		this.telNumber = telNumber;
		this.age = age;
		this.description = description;
		//this.treatments = treatments;
	}

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

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", telNumber=" + telNumber + ", age=" + age + ", description="
				+ description + ",  treatments=" + treatments + "]";
	}
	


}
