package com.shitot.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import com.shitot.dao.*;
import com.shitot.interfaces.IShitotRepository;
import com.shitot.json.*;
import com.shitot.mediator.*;

public class ServicesHibernate implements IShitotRepository {

    @PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
    public EntityManager em;

    //*
    @Override
    public User loginUser(User user) {
	Query q = em.createQuery("SELECT u FROM UserDAO u where u.name = ?1");
	q.setParameter(1, user.getName());
	UserDAO response;
	try {
	    response = (UserDAO) q.getSingleResult();
	} catch (NoResultException exception) {
	    return null;
	}
	if (user.getPassword().equals(response.getPassword())) {
	    user.setName(response.getName());
	    user.setUserId(response.getId());
	}
	return user;
    }
    
    //*
    @SuppressWarnings("unchecked")
	@Override
    @Transactional
	public boolean createUser(User user) {
    	Query q = em.createQuery("SELECT u FROM UserDAO u where u.name = ?1");
    	q.setParameter(1, user.getName());
    	List<UserDAO> users = q.getResultList();
    	if(users.size()==0){
    		UserDAO us = new UserDAO();
    		us.setName(user.getName());
    		us.setPassword(user.getPassword());
    		em.persist(us);
    		return true;
    	}
    		
		return false;
	}


  //*
    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public boolean createPatient(Patient patient) {
	Query q = em.createQuery("SELECT patient FROM PatientDAO patient WHERE patient.telNumber=?1");
	q.setParameter(1, patient.getTelNumber());
	List<PatientDAO> response = q.getResultList();
	if (response.size() == 0) {
	    PatientDAO patientDao = ConvertorJsonToDao.convertPatient(patient);
	    em.persist(patientDao);
	    return true;
	}
	return false;
    }

  //*
    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public boolean createDoctor(Doctor doctor) {
	Query q = em.createQuery("SELECT doctor FROM DoctorDAO doctor WHERE doctor.nameLogin=?1");
	q.setParameter(1, doctor.getNameLogin());
	List<DoctorDAO> response = q.getResultList();
	if (response.size() == 0) {
	    DoctorDAO doctorDao = new DoctorDAO();
	    doctorDao = ConvertorJsonToDao.convertDoctor(doctor);
	    em.persist(doctorDao);
	    return true;
	}
	return false;
    }

  //*
    @Override
    public Patient getPatient(int patientId) {
	PatientDAO patientDao = em.find(PatientDAO.class, patientId);
	return ConvertorDaoToJson.convertPatient(patientDao);
    }

  //*
    @Override
    @SuppressWarnings("unchecked")
    public List<Doctor> getAllDoctor() {
	Query q = em.createQuery("SELECT doctor FROM DoctorDAO doctor");
	List<DoctorDAO> doctors = q.getResultList();
	return ConvertorDaoToJson.convertDoctors(doctors);
    }

  //*
    @Override
    @SuppressWarnings("unchecked")
    public List<Patient> getAllPatient() {
	Query q = em.createQuery("SELECT patient FROM PatientDAO patient");
	List<PatientDAO> patients = q.getResultList();
	return ConvertorDaoToJson.convertPatients(patients);
    }


    //*
    @Override
    public Patient getPatientIdByName(String name) {
	Query q = em.createQuery("SELECT p FROM PatientDAO p WHERE p.name=?1");
	q.setParameter(1, name);
	PatientDAO response;
	try {
	    response = (PatientDAO) q.getSingleResult();
	} catch (NoResultException exception) {
	    return null;
	}
	return ConvertorDaoToJson.convertPatient(response);
    }

    //*
    @Override
    public Doctor getDoctorByName(String name) {
	Query q = em.createQuery("SELECT d FROM DoctorDAO d WHERE d.nameLogin=?1");
	q.setParameter(1, name);
	DoctorDAO response;
	try {
	    response = (DoctorDAO) q.getResultList().get(0);
	} catch (NoResultException exception) {
	    return null;
	}
	return ConvertorDaoToJson.convertDoctor(response);
    }

    //*
    @Override
    public Doctor getDoctor(int doctorId) {
	DoctorDAO doctorDao = em.find(DoctorDAO.class, doctorId);
	return ConvertorDaoToJson.convertDoctor(doctorDao);
    }

	//*
    @Override
	public boolean createProblems(Problems problem) {
		Query q=em.createQuery("Select p from ProblemsDAO p from p.nameProblem=?1");
		q.setParameter(1, problem.getNameProblem());
		if(q.getResultList().size()==0){
			ProblemsDAO prob= ConvertorJsonToDao.convertProblem(problem);
			em.persist(prob);
			List<SymptomsDAO> symptomsDao = new LinkedList<SymptomsDAO>();
			for(Symptoms s:problem.getSymptoms()){
				SymptomsDAO symptom = em.find(SymptomsDAO.class, s.getId());
				if(symptom!=null)
					symptomsDao.add(symptom);
			}
			prob.setSymptoms(symptomsDao);
			return true;
		}
		return false;
	}

	//*
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean createClinic(Clinic clinic) {
		int docId = clinic.getDoctor().getId();
		System.out.println(docId);
		Query q=em.createQuery("Select c from ClinicDAO c join c.doctor d where c.city=?1 and c.addressClinic=?2 and d.id=?3");
		q.setParameter(1, clinic.getCity()).setParameter(2, clinic.getAddressClinic()).setParameter(3, docId);
		List<ClinicDAO> cls = q.getResultList();
		System.out.println(cls.toString());
		if(cls.size() == 0){
			ClinicDAO cl= ConvertorJsonToDao.convertClinic(clinic);
			System.out.println(cl.toString());
			em.persist(cl);
			System.out.println("res "+cl);
			DoctorDAO doctor = em.find(DoctorDAO.class, docId);
			cl.setDoctor(doctor);
			List<SlotDAO> slotsDAO=createSlot(clinic.getSlots());
			cl.setSlots(slotsDAO);
			List<ClinicDAO> c = doctor.getClinics();
			c.add(cl);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public 	List<SlotDAO> createSlot(List<Slot> slots) {
		List<SlotDAO> slotsDAO=new LinkedList<SlotDAO>();
		for(Slot slot:slots){
			SlotDAO sl= ConvertorJsonToDao.convertSlot(slot);
			em.persist(sl);
			List<IntervalDAO> intervalDao = new LinkedList<IntervalDAO>();
			List<IntervalDAO> intervals = ConvertorJsonToDao.convertIntervals(slot.getIntervals());
			for(IntervalDAO interval:intervals){
				if(interval!=null){
					em.persist(interval);
					intervalDao.add(interval);
					
				}
			}
			sl.setIntervals(intervalDao);
			slotsDAO.add(sl);
		}
		return slotsDAO;
	}

	//*
	@Override
	@Transactional
	public boolean updateClinic(Clinic clinic) {
		/*Query q=em.createQuery("Select c from ClinicDAO c join c.doctor d from c.city=?1 and c.addressClinic=?2 and d.id=?3");
		q.setParameter(1, clinic.getCity()).setParameter(2, clinic.getAddressClinic()).setParameter(3, clinic.getDoctor().getId());*/
		ClinicDAO cl =  em.find(ClinicDAO.class, clinic.getId());
		if(cl!=null){
			List<SlotDAO> slots= createSlot(clinic.getSlots());
			/*for(Slot sl:clinic.getSlots()){
				SlotDAO slot = ConvertorJsonToDao.convertSlot(sl);
				em.persist(slot);
				List<IntervalDAO> intervalDao = new LinkedList<IntervalDAO>();
				List<IntervalDAO> intervals = ConvertorJsonToDao.convertIntervals(sl.getIntervals());
				for(IntervalDAO interval:intervals){
					if(interval!=null){
						em.persist(interval);
						intervalDao.add(interval);
						
					}
				}
				slot.setIntervals(intervalDao);
				slots.add(slot);
			}*/
			List<SlotDAO> sl = cl.getSlots();
			if(slots.size()>0){
				for(SlotDAO s:slots){
					sl.add(s);
				}
			}
				
			cl.setSlots(sl);
			return true;
		}
		return false;
	}

	/*private void removeSlots(int clinicId) {
		
		ClinicDAO clinic = em.find(ClinicDAO.class, clinicId);
		List<SlotDAO> slots = clinic.getSlots();
		if(slots.size()!=0){
			for(SlotDAO sl:slots){
				em.remove(sl);
			}
			clinic.setSlots(null);
		}
		
	}*/


	//*
	@Override
	@Transactional
	public boolean updatePatientByDoctor(Treatment treatment) {
		TreatmentDAO tret = em.find(TreatmentDAO.class, treatment.getId());
		if(tret == null)
			return false;
	
		tret.setDatePayment(treatment.getDatePayment());
		tret.setPayment(treatment.getPayment());
		tret.setCheckNumber(treatment.getCheckNumber());
		return true;
	}

	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Clinic> getAllClinic() {
		Query q = em.createQuery("Select c From ClinicDAO c");
		List<ClinicDAO> cl = q.getResultList();
		List<Clinic> resCl = ConvertorDaoToJson.convertClinics(cl);
		return resCl;
	}

	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Clinic> getAllClinicByDocotr(int doctorId) {
		Query q = em.createQuery("Select c From ClinicDAO c join c.doctor d Where d.id=?1");
		q.setParameter(1, doctorId);
		List<ClinicDAO> cl = q.getResultList();
		List<Clinic> resCl = ConvertorDaoToJson.convertClinics(cl);
		return resCl;
	}

	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Clinic> getAllClinicByCity(String city) {
		Query q = em.createQuery("Select c From ClinicDAO c Where c.city=?1");
		q.setParameter(1, city);
		List<ClinicDAO> cl = q.getResultList();
		List<Clinic> resCl = ConvertorDaoToJson.convertClinics(cl);
		return resCl;
	}


	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatientByPeriod(int doctorId, Date startDate, Date endDate) {
		Query q = em.createQuery("Select p From PatientDAO p join p.treatments t Where t.id=?1 and p.dateMeeting between ?2 and ?3");
		q.setParameter(1, doctorId).setParameter(2, startDate, TemporalType.DATE).setParameter(3, endDate, TemporalType.DATE);
		List<PatientDAO> pat = q.getResultList();
		System.out.println("res DAO "+pat);
		return ConvertorDaoToJson.convertPatients(pat);
	}


	//*
	@Override
	public Doctor loginDoctor(Doctor doctor) {
		Query q = em.createQuery("SELECT d FROM DoctorDAO d where d.nameLogin = ?1");
		q.setParameter(1, doctor.getNameLogin());
		DoctorDAO response;
		try {
		    response = (DoctorDAO) q.getSingleResult();
		} catch (NoResultException exception) {
		    return null;
		}
		if (doctor.getPassword().equals(response.getPassword())) {
		   /* doctor.setName(response.getName());
		    doctor.setId(response.getId());*/
			doctor = ConvertorDaoToJson.convertDoctor(response);
		}
		return doctor;
	}
	
	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorByClinicCity(String city){
		Query q = em.createQuery("Select d From DoctorDAO d join d.clinics c Where c.city=?1");
		q.setParameter(1, city);
		List<DoctorDAO> doctors = q.getResultList();
		return ConvertorDaoToJson.convertDoctors(doctors);
	}
	
	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorBySpecialty(String specialty){
		Query q = em.createQuery("Select doctor From DoctorDAO doctor Where doctor.specialization=?1");
		q.setParameter(1, specialty);
		List<DoctorDAO> doctors = q.getResultList();
		return ConvertorDaoToJson.convertDoctors(doctors);
	}


	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatientNotPayment() {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		Date cDate = null;
		try {
			cDate = format.parse("20/04/2016");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(cDate.toString());
		Query q = em.createQuery("Select p From PatientDAO p Where p.dateMeeting<?1 and p.payment=0");
		q.setParameter(1, cDate, TemporalType.DATE);
		List<PatientDAO> res = q.getResultList();
		return ConvertorDaoToJson.convertPatients(res);
	}

	//*
	@Override
	@Transactional
	public boolean createTreatment(Treatment treatment, int patientId, int IntervalId) {
		if(treatment==null)
			return false;
		TreatmentDAO treatmentDao = ConvertorJsonToDao.convertTreatment(treatment);
		em.persist(treatmentDao);
		List<ProblemsDAO> problemsDao = new LinkedList<ProblemsDAO>();
		for(Problems probl:treatment.getProblems()){
			ProblemsDAO p = ConvertorJsonToDao.convertProblem(probl);
			em.persist(p);
			List<SymptomsDAO> symptomsDao = new LinkedList<SymptomsDAO>();
			for(Symptoms s:probl.getSymptoms()){
				SymptomsDAO symDao =new SymptomsDAO();
				if(s.getId()!=0)
				symDao=em.find(SymptomsDAO.class, s.getId());
				symptomsDao.add(symDao);
			}
			p.setSymptoms(symptomsDao);
			problemsDao.add(p);
		}
		treatmentDao.setProblems(problemsDao);
		
		DoctorDAO doctorDao = new DoctorDAO();
		if(treatment.isAlternativeDoctor()==false){
		if(treatment.getDoctor().getId()!=0)
			doctorDao = em.find(DoctorDAO.class, treatment.getDoctor().getId());
		}
		else {
			if(treatment.getAlternativeDoctor().getId()!=0)
				doctorDao = em.find(DoctorDAO.class, treatment.getDoctor().getId());
			}
		if(doctorDao==null)
			return false;
		treatmentDao.setDoctor(doctorDao);
		
		IntervalDAO interval= em.find(IntervalDAO.class, IntervalId);
		if(interval==null)
			return false;
		interval.setTreatment(treatmentDao);
		
		PatientDAO patient = new PatientDAO();
		patient=em.find(PatientDAO.class, patientId);
		if(patient==null)
			return false;
		List<TreatmentDAO> trTmp = patient.getTreatments();
		trTmp.add(treatmentDao);
		return true;
	}

	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Symptoms> getAllSymptoms() {
		Query q = em.createQuery("Select s From SymptomsDAO s");
		return ConvertorDaoToJson.convertSymptoms(q.getResultList());
	}

	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatientByDoctor(int doctorId) {
		Query q = em.createQuery("Select p from PatientDAO p join p.treatment t join t.doctor d Where d.id=?1");
		q.setParameter(1, doctorId);
		return ConvertorDaoToJson.convertPatients(q.getResultList());
	}

	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatientByDoctorNotPayment(int doctorId) {
		Date curDate = new Date();
		Query q = em.createQuery("Select p from PatientDAO p join p.treatment t join t.doctor d Where d.id=?1 and t.dateMeeting<?2 and t.payment=0");
		q.setParameter(1, doctorId).setParameter(2, curDate);
		return ConvertorDaoToJson.convertPatients(q.getResultList());
	}

	//*
	@Override
	public int getSumPatientByPeriod(Date startDate, Date endDate) {
		Query q = em.createQuery("Select count(t.payment) From TreatmentDAO t Where t.dateMeeting between ?1 and ?2");
		q.setParameter(1, startDate, TemporalType.DATE).setParameter(2, endDate, TemporalType.DATE);
		int res = q.getFirstResult();
		return res;
	}

	//*
	@Override
	public int getStatisticBySymptom(String nameSymptom) {
		Query q = em.createQuery("Select count(p) From PatientDAO p join p.problems pr join pr.symptoms s Where s.nameSymptom=?1");
		q.setParameter(1, nameSymptom);
		int res = q.getFirstResult();
		return res;
	}
	
	//*
	@Override
	public Map<String, Integer> getStatisticBySymptoms(List<Symptoms> symptoms){
		Map<String, Integer> resultMap = new HashMap<String, Integer>();
		for(Symptoms s:symptoms){
			int res = getStatisticBySymptom(s.getNameSymptom());
			resultMap.put(s.getNameSymptom(), res);
		}
		return resultMap;
	}

	//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatientNotMeeting() {
		Date curDate = new Date();
		Query q = em.createQuery("Select p From PatientDAO p join p.treatmant t Where t.dateMeeting<?1 and t.payment=0");
		q.setParameter(1, curDate,TemporalType.DATE);
		return ConvertorDaoToJson.convertPatients(q.getResultList());
	}

	//*
	@Override
	public boolean addSymptom(Symptoms symptom) {
		if(symptom==null)
		return false;
		Query q = em.createQuery("From SymptomsDAO s Where s.NameSymptom=?1");
		q.setParameter(1, symptom.getNameSymptom());
		if(q.getResultList().size()!=0)
			return false;
		SymptomsDAO symptomDao = new SymptomsDAO();
		symptomDao = ConvertorJsonToDao.convertSymptom(symptom);
		em.persist(symptomDao);
		return true;
	}

	//*
	@Override
	public int getPatientByDay(Date date) {
		Query q = em.createQuery("Select count(p) From PatientDAO p join p.treatment t Where t.dateApplication=?1 or t.dateMeeting=?1 or t.datePayment=?1");
		q.setParameter(1, date, TemporalType.DATE);
		int res = q.getFirstResult();
		return res;
	}

	//*
	@Override
	public int getCalledPatientByDay(Date date) {
		Query q = em.createQuery("Select count(p) From PatientDAO p join p.treatment t Where t.dateApplication=?1");
		q.setParameter(1, date, TemporalType.DATE);
		int res = q.getFirstResult();
		return res;
	}

	//*
	@Override
	public int getTherapyPatientByDay(Date date) {
		Query q = em.createQuery("Select count(p) From PatientDAO p join p.treatment t Where t.dateMeeting=?1");
		q.setParameter(1, date, TemporalType.DATE);
		int res = q.getFirstResult();
		return res;
	}

	//*
	@Override
	public int getPaymentPatientByDay(Date date) {
		Query q = em.createQuery("Select count(p) From PatientDAO p join p.treatment t Where t.datePayment=?1");
		q.setParameter(1, date, TemporalType.DATE);
		int res = q.getFirstResult();
		return res;
	}




	
	
	
	
	


}