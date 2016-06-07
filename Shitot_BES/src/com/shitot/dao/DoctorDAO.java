package com.shitot.dao;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class DoctorDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int id;

    private String nameLogin;
    private String password;
    private String telNumber;
    private String telHouse;
    private String email;
    private String address;
    private String specialty;
    private String targetAudience;
    private String otherSpecialty;
    private String preferential;
    private String expert;
    private String certification;
    private String lectors;
    private String comments;
    
    @OneToMany(mappedBy="doctor")
    List<ClinicDAO> clinics;
    

    public DoctorDAO() {  }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNameLogin() {
		return nameLogin;
	}


	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getTelNumber() {
		return telNumber;
	}


	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}


	public String getTelHouse() {
		return telHouse;
	}


	public void setTelHouse(String telHouse) {
		this.telHouse = telHouse;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSpecialty() {
		return specialty;
	}


	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}


	public String getTargetAudience() {
		return targetAudience;
	}


	public void setTargetAudience(String targetAudience) {
		this.targetAudience = targetAudience;
	}


	public String getOtherSpecialty() {
		return otherSpecialty;
	}


	public void setOtherSpecialty(String otherSpecialty) {
		this.otherSpecialty = otherSpecialty;
	}


	public String getPreferential() {
		return preferential;
	}


	public void setPreferential(String preferential) {
		this.preferential = preferential;
	}


	public String getExpert() {
		return expert;
	}


	public void setExpert(String expert) {
		this.expert = expert;
	}


	public String getCertification() {
		return certification;
	}


	public void setCertification(String certification) {
		this.certification = certification;
	}


	public String getLectors() {
		return lectors;
	}


	public void setLectors(String lectors) {
		this.lectors = lectors;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public List<ClinicDAO> getClinics() {
		return clinics;
	}


	public void setClinics(List<ClinicDAO> clinics) {
		this.clinics = clinics;
	}


	
    
    


}
