package com.shitot.json;

import java.util.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DoctorPatient {
	
	private int idPatient;
	private Date datePayment;
	private int payment;
	private String checkNumber;
	private String description;
	private int doctorId;
	@Temporal(TemporalType.DATE)
	private Date dateMeeting;
	
	public DoctorPatient() {}


	public DoctorPatient(int idPatient, Date datePayment, int payment, String checkNumber, String description,
			int doctorId, Date dateMeeting) {
		this.idPatient = idPatient;
		this.datePayment = datePayment;
		this.payment = payment;
		this.checkNumber = checkNumber;
		this.description = description;
		this.doctorId = doctorId;
		this.dateMeeting = dateMeeting;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getCheckNumber() {
		return checkNumber;
	}


	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public Date getDateMeeting() {
		return dateMeeting;
	}


	public void setDateMeeting(Date dateMeeting) {
		this.dateMeeting = dateMeeting;
	}


	@Override
	public String toString() {
		return "DoctorPatient [idPatient=" + idPatient + ", datePayment=" + datePayment + ", payment=" + payment
				+ ", checkNumber=" + checkNumber + ", description=" + description + ", doctorId=" + doctorId
				+ ", dateMeeting=" + dateMeeting + "]";
	}


	

}
