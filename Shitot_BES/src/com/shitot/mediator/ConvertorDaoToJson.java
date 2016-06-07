package com.shitot.mediator;

import java.util.*;
import com.shitot.dao.*;
import com.shitot.json.*;

public class ConvertorDaoToJson {

	public static List<Patient> convertPatients(List<PatientDAO> patientsDao) {
		if (patientsDao == null)
		    return null;
		List<Patient> patientsJson = new LinkedList<Patient>();
		for (PatientDAO patientDao : patientsDao) {
		    Patient p = convertPatient(patientDao);
		    patientsJson.add(p);
		}
		return patientsJson;
	    }
	
	public static Patient convertPatient(PatientDAO patientDao) {
	if (patientDao == null)
	    return null;
	Patient patientJson = new Patient();
	patientJson.setId(patientDao.getId());
	patientJson.setAge(patientDao.getAge());
	patientJson.setName(patientDao.getName());
	patientJson.setTelNumber(patientDao.getTelNumber());
	patientJson.setDescription(patientDao.getDescription());
	patientJson.setTreatments(convetTreatmens(patientDao.getTreatments()));
	return patientJson;
    }

    public static List<Treatment> convetTreatmens(List<TreatmentDAO> treatments) {
		if(treatments==null)
			return null;
		List<Treatment> treatmensJson = new LinkedList<Treatment>();
		for(TreatmentDAO tr:treatments){
			Treatment t = convertTreatment(tr);
			treatmensJson.add(t);
		}
		return treatmensJson;
	}

	public static Treatment convertTreatment(TreatmentDAO tr) {
		if(tr==null)
			return null;
		Treatment treatmentJson = new Treatment();
		treatmentJson.setId(tr.getId());
		treatmentJson.setDateMeeting(tr.getDateMeeting());
		treatmentJson.setDatePayment(tr.getDatePayment());
		treatmentJson.setPayment(tr.getPayment());
		treatmentJson.setCheckNumber(tr.getCheckNumber());
		treatmentJson.setDoctor(convertDoctor(tr.getDoctor()));
		treatmentJson.setProblems(convertProblems(tr.getProblems()));
		treatmentJson.setAlternativeDoctor(tr.isAlternativeDoctor());
		treatmentJson.setAlternativeDoctor(convertDoctor(tr.getAlternativeDoctor()));
		treatmentJson.setInfSourse(tr.getInfSourse());
		treatmentJson.setNameUser(tr.getNameUser());
		treatmentJson.setDateApplication(tr.getDateApplication());
		return treatmentJson;
	}

	public static List<Problems> convertProblems(List<ProblemsDAO> problemsDao) {
    	if (problemsDao == null)
    	    return null;
    	List<Problems> problemsJson = new LinkedList<Problems>();
    	for (ProblemsDAO problemDao : problemsDao) {
    	    Problems p = convertProblem(problemDao);
    	    problemsJson.add(p);
    	}
    	return problemsJson;
	}

    public static Problems convertProblem(ProblemsDAO problemDao) {
    	if (problemDao == null)
    	    return null;
    	Problems problemsJson = new Problems();
    	problemsJson.setId(problemDao.getId());
    	problemsJson.setNameProblem(problemDao.getNameProblem());
    	problemsJson.setDescription(problemDao.getDescription());
    	problemsJson.setSymptoms(convertSymptoms(problemDao.getSymptoms()));
    	return problemsJson;
        }

    public static List<Doctor> convertDoctors(List<DoctorDAO> doctorsDao) {
	if (doctorsDao == null)
	    return null;
	List<Doctor> doctorsJson = new LinkedList<Doctor>();
	for (DoctorDAO doctorDao : doctorsDao) {
	    Doctor d = convertDoctor(doctorDao);
	    doctorsJson.add(d);
	}
	return doctorsJson;
    }

    

    public static Doctor convertDoctor(DoctorDAO doctorDao) {
	if (doctorDao == null)
	    return null;
	Doctor doctorJson = new Doctor();
	doctorJson.setId(doctorDao.getId());
	doctorJson.setNameLogin(doctorDao.getNameLogin());;
	doctorJson.setPassword(doctorDao.getPassword());
	doctorJson.setEmail(doctorDao.getEmail());
	doctorJson.setAddress(doctorDao.getAddress());
	doctorJson.setTelNumber(doctorDao.getTelNumber());
	doctorJson.setTelHouse(doctorDao.getTelHouse());
	doctorJson.setSpecialty(doctorDao.getSpecialty());
	doctorJson.setOtherSpecialty(doctorDao.getOtherSpecialty());
	doctorJson.setCertification(doctorDao.getCertification());
	doctorJson.setExpert(doctorDao.getExpert());
	doctorJson.setLectors(doctorDao.getLectors());
	doctorJson.setPreferential(doctorDao.getPreferential());
	doctorJson.setTargetAudience(doctorDao.getTargetAudience());
	doctorJson.setComments(doctorDao.getComments());
	doctorJson.setClinics(convertClinics(doctorDao.getClinics()));
	return doctorJson;
    }



    public static List<Clinic> convertClinics(List<ClinicDAO> clinicsDao) {
    	if (clinicsDao == null)
    	    return null;
    	List<Clinic> clinicsJson = new LinkedList<Clinic>();
    	for (ClinicDAO clinicDao : clinicsDao) {
    	    Clinic cl = convertClinic(clinicDao);
    	    clinicsJson.add(cl);
    	}
    	return clinicsJson;
	}

	public static Clinic convertClinic(ClinicDAO clinicDao) {
		if(clinicDao==null)
			return null;
		Clinic clinicJson=new Clinic();
		clinicJson.setId(clinicDao.getId());
		clinicJson.setCity(clinicDao.getCity());
		clinicJson.setAddressClinic(clinicDao.getAddressClinic());
		//clinicJson.setDoctors(convertDoctor(clinicDao.getDoctors()));
		clinicJson.setSlots(convertSlots(clinicDao.getSlots()));
		return clinicJson;
	}

	public static List<Slot> convertSlots(List<SlotDAO> slotsDao) {
		if (slotsDao == null)
    	    return null;
    	List<Slot> slotsJson = new LinkedList<Slot>();
    	for (SlotDAO slotDao : slotsDao) {
    	    Slot s = convertSlot(slotDao);
    	    slotsJson.add(s);
    	}
    	return slotsJson;
	}

	public static Slot convertSlot(SlotDAO slotDao) {
		if(slotDao==null)
			return null;
		Slot slotJson=new Slot();
		slotJson.setId(slotDao.getId());
		slotJson.setDate(slotDao.getDate());;
		slotJson.setIntervals(convertIntervals(slotDao.getIntervals()));;
		
		return slotJson;
	}
	
	public static List<Interval> convertIntervals(List<IntervalDAO> intervalsDao){
		if (intervalsDao == null)
    	    return null;
    	List<Interval> intervalsJson = new LinkedList<Interval>();
    	for (IntervalDAO intervalDao : intervalsDao) {
    	    Interval i = convertInterval(intervalDao);
    	    intervalsJson.add(i);
    	}
    	return intervalsJson;
	}

	public static Interval convertInterval(IntervalDAO intervalDao) {
		if(intervalDao==null)
			return null;
		Interval intervalJson = new Interval();
		intervalJson.setId(intervalDao.getId());
		intervalJson.setHours(intervalDao.getHours());
		intervalJson.setTreatment(convertTreatment(intervalDao.getTreatment()));
		return intervalJson;
	}

	public static List<Symptoms> convertSymptoms(List<SymptomsDAO> symptomsDao){
		if (symptomsDao == null)
    	    return null;
    	List<Symptoms> symptomsJson = new LinkedList<Symptoms>();
    	for (SymptomsDAO symptomDao : symptomsDao) {
    	    Symptoms s = convertSymptom(symptomDao);
    	    symptomsJson.add(s);
    	}
    	return symptomsJson;
	}

	public static Symptoms convertSymptom(SymptomsDAO symptomDao) {
		if(symptomDao==null)
			return null;
		Symptoms symptomJson = new Symptoms();
		symptomJson.setId(symptomDao.getId());
		symptomJson.setNameSymptom(symptomDao.getNameSymptom());;
		return symptomJson;
	}

}
