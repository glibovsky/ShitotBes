package com.shitot.dao;

import javax.persistence.*;

@Entity
@Table(name="intervals")
public class IntervalDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="interval_id")
	private int id;
	
	private String hours;
	
	@OneToOne
	TreatmentDAO treatment;

	public IntervalDAO() {	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}


	public TreatmentDAO getTreatment() {
		return treatment;
	}


	public void setTreatment(TreatmentDAO treatment) {
		this.treatment = treatment;
	}

	

}
