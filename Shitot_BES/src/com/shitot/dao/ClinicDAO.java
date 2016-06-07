package com.shitot.dao;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="clinic")
public class ClinicDAO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="clinic_id")
	private int id;
	
	private String city;
	private String addressClinic;
	
	@ManyToOne
	DoctorDAO doctor;
	
	@OneToMany
	List<SlotDAO> slots;
	
	public ClinicDAO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressClinic() {
		return addressClinic;
	}

	public void setAddressClinic(String addressClinic) {
		this.addressClinic = addressClinic;
	}

	public List<SlotDAO> getSlots() {
		return slots;
	}

	public void setSlots(List<SlotDAO> slots) {
		this.slots = slots;
	}
	

	public DoctorDAO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDAO doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "ClinicDAO [id=" + id + ", city=" + city + ", addressClinic=" + addressClinic + ", doctor=" + doctor
				+ ", slots=" + slots + "]";
	}

	
	
	

}
