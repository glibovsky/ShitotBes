package com.shitot.interfaces;

import java.util.*;

import com.shitot.dao.*;
import com.shitot.json.*;

public interface IShitotRepository {

   // From office
	User loginUser(User user);
    boolean createUser(User user);
    boolean createDoctor(Doctor doctor);
    boolean createPatient(Patient patient);
    boolean createProblems(Problems problem);
    boolean createTreatment(Treatment treatment, int patientId, int intervalId);
    boolean addSymptom(Symptoms symptom);
   
    
    // From Doctor
    Doctor loginDoctor(Doctor doctor);
    boolean updateClinic(Clinic clinic);
    boolean updatePatientByDoctor(Treatment treatment);
    boolean createClinic(Clinic clinic);
    List<SlotDAO> createSlot(List<Slot> slots);
    List<Patient> getPatientByPeriod(int doctorId, Date startDate, Date endDate);
    
    
    //Requests
    List<Patient> getAllPatient();
    List<Doctor> getAllDoctor();
    List<Clinic> getAllClinic();
    List<Symptoms> getAllSymptoms();
    List<Clinic> getAllClinicByDocotr(int doctorId);
    List<Clinic> getAllClinicByCity(String city);
    List<Doctor> getDoctorByClinicCity(String city);
	List<Doctor> getDoctorBySpecialty(String specialty);
	
    Patient getPatient(int patientId);
    Doctor getDoctor(int doctorId);
    Patient getPatientIdByName(String patientName);
    Doctor getDoctorByName(String doctorName);
    
    List<Patient> getPatientByDoctor(int doctorId);
    List<Patient> getPatientByDoctorNotPayment(int doctorId);
	List<Patient> getPatientNotPayment();
	int getSumPatientByPeriod(Date startDate, Date endDate);
	int getStatisticBySymptom(String symptom);
	List<Patient> getPatientNotMeeting();
	int getPatientByDay(Date date);
	int getCalledPatientByDay(Date date);
	int getTherapyPatientByDay(Date date);
	int getPaymentPatientByDay(Date date);
	Map<String, Integer> getStatisticBySymptoms(List<Symptoms> symptoms);

   
    
    

}
