package com.shitot.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="treatment")
public class TreatmentDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="treatment_id")
	int id;
	
	private int payment;
    private String checkNumber;
    boolean isAlternativeDoctor;
    //private String doctor;
    
    @Temporal(TemporalType.DATE)
    private Date dateApplication;
    @Temporal(TemporalType.DATE)
    private Date dateMeeting;
    @Temporal(TemporalType.DATE)
    private Date datePayment;
    private String nameUser;
    private String infSourse;
    
    @OneToMany
    List<ProblemsDAO> problems;
    @OneToOne
    DoctorDAO doctor;
    @OneToOne
    DoctorDAO alternativeDoctor;
	
    public TreatmentDAO() {	}

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

	public List<ProblemsDAO> getProblems() {
		return problems;
	}

	public void setProblems(List<ProblemsDAO> problems) {
		this.problems = problems;
	}

	public DoctorDAO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDAO doctor) {
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

	public DoctorDAO getAlternativeDoctor() {
		return alternativeDoctor;
	}

	public void setAlternativeDoctor(DoctorDAO alternativeDoctor) {
		this.alternativeDoctor = alternativeDoctor;
	}

	public Date getDateApplication() {
		return dateApplication;
	}

	public void setDateApplication(Date dateApplication) {
		this.dateApplication = dateApplication;
	}
	
    
	

}
