package com.shitot.json;

import java.util.*;


public class Clinic {
	
	private int id;
	
	private String city;
	private String addressClinic;
	
	List<Slot> slots;
	Doctor doctor;
	
	public Clinic() {}
	
	

	public Clinic(String city, String addressClinic, List<Slot> slots, Doctor doctor) {
		this.city = city;
		this.addressClinic = addressClinic;
		this.slots = slots;
		this.doctor = doctor;
	}



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

	public List<Slot> getSlots() {
		return slots;
	}

	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Clinic [id=" + id + ", city=" + city + ", addressClinic=" + addressClinic + ", slots=" + slots
				+ ", doctor=" + doctor + "]";
	}




	
	

}
