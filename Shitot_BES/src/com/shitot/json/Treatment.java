package com.shitot.json;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;



public class Treatment {
	
	int id;
	private int payment;
    private String checkNumber;
    boolean isAlternativeDoctor;
    private String nameUser;
    private String infSourse;
    //private String doctor;
    
    @Temporal(TemporalType.DATE)
    private Date dateApplication;
    @Temporal(TemporalType.DATE)
    private Date dateMeeting;
    @Temporal(TemporalType.DATE)
    private Date datePayment;
    
    List<Problems> problems;
    Doctor doctor;
    Doctor alternativeDoctor;
	
    public Treatment() {	}
    
    
	public Treatment(int payment, String checkNumber, boolean isAlternativeDoctor, String nameUser, String infSourse,
			Date dateApplication, Date dateMeeting, Date datePayment, List<Problems> problems, Doctor doctor,
			Doctor alternativeDoctor) {
		this.payment = payment;
		this.checkNumber = checkNumber;
		this.isAlternativeDoctor = isAlternativeDoctor;
		this.nameUser = nameUser;
		this.infSourse = infSourse;
		this.dateApplication = dateApplication;
		this.dateMeeting = dateMeeting;
		this.datePayment = datePayment;
		this.problems = problems;
		this.doctor = doctor;
		this.alternativeDoctor = alternativeDoctor;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public Date getDateMeeting() {
		return dateMeeting;
	}

	public void setDateMeeting(Date dateMeeting) {
		this.dateMeeting = dateMeeting;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public List<Problems> getProblems() {
		return problems;
	}

	public void setProblems(List<Problems> problems) {
		this.problems = problems;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public boolean isAlternativeDoctor() {
		return isAlternativeDoctor;
	}

	public void setAlternativeDoctor(boolean isAlternativeDoctor) {
		this.isAlternativeDoctor = isAlternativeDoctor;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getInfSourse() {
		return infSourse;
	}

	public void setInfSourse(String infSourse) {
		this.infSourse = infSourse;
	}

	public Doctor getAlternativeDoctor() {
		return alternativeDoctor;
	}

	public void setAlternativeDoctor(Doctor alternativeDoctor) {
		this.alternativeDoctor = alternativeDoctor;
	}


	public Date getDateApplication() {
		return dateApplication;
	}


	public void setDateApplication(Date dateApplication) {
		this.dateApplication = dateApplication;
	}


	@Override
	public String toString() {
		return "Treatment [id=" + id + ", payment=" + payment + ", checkNumber=" + checkNumber
				+ ", isAlternativeDoctor=" + isAlternativeDoctor + ", nameUser=" + nameUser + ", infSourse=" + infSourse
				+ ", dateApplication=" + dateApplication + ", dateMeeting=" + dateMeeting + ", datePayment="
				+ datePayment + ", problems=" + problems + ", doctor=" + doctor + ", alternativeDoctor="
				+ alternativeDoctor + "]";
	}

	
	

}
