package com.shitot.json;

import java.util.*;

public class Doctor {

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
    
    List<Clinic> clinics;
    

    public Doctor() {  }
    
    


	public Doctor(String nameLogin, String password, String telNumber, String telHouse, String email, String address,
			String specialty, String targetAudience, String otherSpecialty, String preferential, String expert,
			String certification, String lectors, String comments) {
		this.nameLogin = nameLogin;
		this.password = password;
		this.telNumber = telNumber;
		this.telHouse = telHouse;
		this.email = email;
		this.address = address;
		this.specialty = specialty;
		this.targetAudience = targetAudience;
		this.otherSpecialty = otherSpecialty;
		this.preferential = preferential;
		this.expert = expert;
		this.certification = certification;
		this.lectors = lectors;
		this.comments = comments;
		//this.clinics = clinics;
	}




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


	public List<Clinic> getClinics() {
		return clinics;
	}


	public void setClinics(List<Clinic> clinics) {
		this.clinics = clinics;
	}




	@Override
	public String toString() {
		return "Doctor [id=" + id + ", nameLogin=" + nameLogin + ", password=" + password + ", telNumber=" + telNumber
				+ ", telHouse=" + telHouse + ", email=" + email + ", address=" + address + ", specialty=" + specialty
				+ ", targetAudience=" + targetAudience + ", otherSpecialty=" + otherSpecialty + ", preferential="
				+ preferential + ", expert=" + expert + ", certification=" + certification + ", lectors=" + lectors
				+ ", comments=" + comments + ", clinics=" + clinics + "]";
	}


	
    
    


}
