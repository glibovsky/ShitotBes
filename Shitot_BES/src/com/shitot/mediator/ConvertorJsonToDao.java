package com.shitot.mediator;

import java.util.*;
import com.shitot.dao.*;
import com.shitot.json.*;

public class ConvertorJsonToDao {

    public static List<PatientDAO> convertPatients(List<Patient> patients){
    	if(patients==null)
    		return null;
    	List<PatientDAO> patientsDao = new LinkedList<PatientDAO>();
    	for(Patient patient:patients){
    		patientsDao.add(convertPatient(patient));
    	}
    	return patientsDao;
    }
    
	public static PatientDAO convertPatient(Patient patient) {
	if (patient != null) {
	    PatientDAO patientDao = new PatientDAO();
	    patientDao.setName(patient.getName());
	    patientDao.setTelNumber(patient.getTelNumber());
	    patientDao.setAge(patient.getAge());
	    patientDao.setDescription(patient.getDescription());
	   // patientDao.setTreatments(convertTreatments(patient.getTreatments()));
	    return patientDao;
	}
	return null;
    }

    public static List<TreatmentDAO> convertTreatments(List<Treatment> treatments) {
		if(treatments==null)
			return null;
		List<TreatmentDAO> treatmentsDao = new LinkedList<TreatmentDAO>();
		for(Treatment tr:treatments){
			TreatmentDAO t = convertTreatment(tr);
			if(t!=null)
				treatmentsDao.add(t);
		}
		return treatmentsDao;
	}

	public static TreatmentDAO convertTreatment(Treatment tr) {
		if(tr==null)
			return null;
		TreatmentDAO treatmentDao = new TreatmentDAO();
		treatmentDao.setDateMeeting(tr.getDateMeeting());
		treatmentDao.setDatePayment(tr.getDatePayment());
		treatmentDao.setCheckNumber(tr.getCheckNumber());
		treatmentDao.setPayment(tr.getPayment());
		treatmentDao.setAlternativeDoctor(tr.isAlternativeDoctor());
		treatmentDao.setInfSourse(tr.getInfSourse());
		treatmentDao.setNameUser(tr.getNameUser());
		treatmentDao.setDateApplication(tr.getDateApplication());
		//treatmentDao.setDoctors(convertDoctors(tr.getDoctors()));
		//treatmentDao.setProblems(convertProblems(tr.getProblems()));
		return treatmentDao;
	}

	public static List<ProblemsDAO> convertProblems(List<Problems> problems) {
		if(problems==null)
			return null;
		List<ProblemsDAO> problemsDao = new LinkedList<ProblemsDAO>();
	    for (Problems problem : problems) {
		problemsDao.add(convertProblem(problem));
	    }
	    return problemsDao;
	}

	public static ProblemsDAO convertProblem(Problems problem) {
	if (problem != null) {
	    ProblemsDAO problemDao = new ProblemsDAO();
	    problemDao.setNameProblem(problem.getNameProblem());
	    problemDao.setDescription(problem.getDescription());
	   // problemDao.setSymptoms(convertSymptoms(problem.getSymptoms()));
	    return problemDao;
	}
	return null;
    }

	public static List<DoctorDAO> convertDoctors(List<Doctor> doctors) {
	if (doctors != null) {
	    List<DoctorDAO> doctorsDao = new LinkedList<DoctorDAO>();
	    for (Doctor doctor : doctors) {
		doctorsDao.add(convertDoctor(doctor));
	    }
	    return doctorsDao;
	}
	return null;
    }


    public static DoctorDAO convertDoctor(Doctor doctor) {
	if (doctor != null) {
	    DoctorDAO doctorDao = new DoctorDAO();
	    doctorDao.setNameLogin(doctor.getNameLogin());;
	    doctorDao.setPassword(doctor.getPassword());
	    doctorDao.setEmail(doctor.getEmail());
	    doctorDao.setTelNumber(doctor.getTelNumber());
	    doctorDao.setTelHouse(doctor.getTelHouse());
	    doctorDao.setAddress(doctor.getAddress());
	    doctorDao.setCertification(doctor.getCertification());
	    doctorDao.setComments(doctor.getComments());
	    doctorDao.setComments(doctor.getComments());
	    doctorDao.setExpert(doctor.getExpert());
	    doctorDao.setLectors(doctor.getLectors());
	    doctorDao.setOtherSpecialty(doctor.getOtherSpecialty());
	    doctorDao.setPreferential(doctor.getPreferential());
	    doctorDao.setSpecialty(doctor.getSpecialty());
	    doctorDao.setTargetAudience(doctor.getTargetAudience());
	    //doctorDao.setClinics(convetClinics(doctor.getClinics()));
	    return doctorDao;
	}
	return null;
    }

	public static List<ClinicDAO> convetClinics(List<Clinic> clinics) {
		if(clinics==null)
			return null;
		List<ClinicDAO> clinicsDao = new LinkedList<ClinicDAO>();
	    for (Clinic clinic : clinics) {
		clinicsDao.add(convertClinic(clinic));
	    }
	    return clinicsDao;
	}

	public static ClinicDAO convertClinic(Clinic clinic) {
		if(clinic==null)
			return null;
		ClinicDAO clinicDao = new ClinicDAO();
		clinicDao.setAddressClinic(clinic.getAddressClinic());
		clinicDao.setCity(clinic.getCity());
		//clinicDao.setDoctor(convertDoctor(clinic.getDoctor()));
		return clinicDao;
	}

	public static List<SlotDAO> convertSlots(List<Slot> slots) {
		if(slots==null)
			return null;
		List<SlotDAO> slotsDao = new LinkedList<SlotDAO>();
	    for (Slot slot : slots) {
		slotsDao.add(convertSlot(slot));
	    }
	    return slotsDao;
	}

	public static SlotDAO convertSlot(Slot slot) {
		if(slot==null)
			return null;
		SlotDAO slotDao = new SlotDAO();
		slotDao.setDate(slot.getDate());
		//slotDao.setIntervals(convertIntervals(slot.getIntervals()));
		return slotDao;
	}
	
	

	public static List<SymptomsDAO> convertSymptoms(List<Symptoms> symptoms) {
			if(symptoms==null)
			return null;
			List<SymptomsDAO> symptomsDao = new LinkedList<SymptomsDAO>();
			for(Symptoms symptom:symptoms){
				symptomsDao.add(convertSymptom(symptom));
			}
			return symptomsDao;
		}

	public static SymptomsDAO convertSymptom(Symptoms symptom) {
		if(symptom==null)
		return null;
		
		SymptomsDAO symptomDao = new SymptomsDAO();
		//symptomDao.setId(symptom.getId());
		symptomDao.setNameSymptom(symptom.getNameSymptom());
		return symptomDao;
	}
	
	 public static List<IntervalDAO> convertIntervals(List<Interval> intervals) {
			if(intervals==null)
			return null;
			List<IntervalDAO> intervalsDao = new LinkedList<IntervalDAO>();
			for(Interval interval:intervals){
				intervalsDao.add(convertInterval(interval));
			}
			return intervalsDao;
		}

	public static IntervalDAO convertInterval(Interval interval) {
		if(interval==null)
			return null;
		IntervalDAO intervalDao = new IntervalDAO();
		intervalDao.setHours(interval.getHours());
		//intervalDao.setTreatment(convertTreatment(interval.getTreatment()));
		return intervalDao;
	}
}