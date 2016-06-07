package com.shitot.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shitot.exception.RestException;
import com.shitot.interfaces.Constants;
import com.shitot.interfaces.IShitotRepository;
import com.shitot.json.*;
import com.shitot.response.Response;

@Controller
@RequestMapping("/")
public class ShitotBesController extends ExceptionHandlerController {

	@Autowired
	IShitotRepository persistenceServices;

	@RequestMapping({ "/", "index" })
	String index() {
		return "index";
	}

	// Doctors Page

	@RequestMapping(value = Constants.REQUEST_LOGIN_DOCTOR, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginDoctor(@RequestBody Doctor doctor) throws RestException {
		try {
			Doctor res = null;
			if ((res = persistenceServices.loginDoctor(doctor)) != null) {
				return Response.successResponse(res);
			}
			return Response.errorResponse(Constants.ERROR_LOGIN);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}

	@RequestMapping(value = Constants.REQUEST_CREATE_CLINIC, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createClinic(@RequestBody Clinic clinic) throws RestException {
		try {
			System.out.println(clinic.toString());
			if (persistenceServices.createClinic(clinic))
				return Response.emptyResponse();
			else
				return Response.errorResponse(Constants.ERROR_EXISTED_CLINIC);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_UPDATE_CLINIC, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateClinic(@RequestBody Clinic clinic) throws RestException {
		try {
			if (persistenceServices.updateClinic(clinic))
				return Response.emptyResponse();
			else
				return Response.errorResponse(Constants.ERROR_EXISTED_CLINIC);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}

	@RequestMapping(value = Constants.REQUEST_UPDATE_PATIENT, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updatePatient(@RequestBody Treatment treatment) throws RestException {
		try {
			if (persistenceServices.updatePatientByDoctor(treatment))
				return Response.emptyResponse();
			else
				return Response.errorResponse(Constants.ERROR_EXISTED_PATIENT);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}

	@RequestMapping(value = Constants.REQUEST_GET_PATIENT_BY_PERIOD + "/{doctorId}" + "/{startDateStr}"
			+ "/{endDateStr}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientByPeriod(@PathVariable int doctorId,@PathVariable String startDateStr,@PathVariable
			String endDateStr) throws RestException {
		Date startDate, endDate;
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    	    startDate = format.parse(startDateStr);
    	    endDate = format.parse(endDateStr);
			System.out.println(startDate+" "+endDate);
			List<Patient> pl = persistenceServices.getPatientByPeriod(doctorId, startDate, endDate);
			System.out.println(pl.toString());
			return Response.successResponse(pl);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_ALL_CLINIC, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllCinic() throws RestException {
		try {
			return Response.successResponse(persistenceServices.getAllClinic());
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_ALL_CLINIC_BY_DOCTOR+"/{doctorId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllCinicByDoctor(@PathVariable int doctorId) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getAllClinicByDocotr(doctorId));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_ALL_CLINIC_BY_CITY+"/{city}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllCinicByDoctor(@PathVariable String city) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getAllClinicByCity(city));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	

	// Customer Page

	//*
	@RequestMapping(value = Constants.REQUEST_LOGIN, method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loginUser(@RequestBody User user) throws RestException {
		try {
			User res = persistenceServices.loginUser(user);
			if (res != null) {
				return Response.successResponse(res);
			}
			return Response.errorResponse(Constants.ERROR_LOGIN);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}

	//*
	@RequestMapping(value = Constants.REQUEST_CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createUser(@RequestBody User user) throws RestException {
		try {
			if (persistenceServices.createUser(user)) {
				return Response.emptyResponse();
			}
			return Response.errorResponse(Constants.ERROR_EXISTED_DOCTOR);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value = Constants.REQUEST_CREATE_DOCTOR, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createDoctor(@RequestBody Doctor doctor) throws RestException {
		try {
			if (persistenceServices.createDoctor(doctor)) {
				return Response.emptyResponse();
			}
			return Response.errorResponse(Constants.ERROR_EXISTED_DOCTOR);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}

	//*
	@RequestMapping(value = Constants.REQUEST_CREATE_PATIENT, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createPatient(@RequestBody Patient patient) throws RestException {
		try {
			if (persistenceServices.createPatient(patient)) {
				return Response.emptyResponse();
			}
			return Response.errorResponse(Constants.ERROR_EXISTED_PATIENT);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value = Constants.REQUEST_CREATE_PROBLEM, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createProblem(@RequestBody Problems problem) throws RestException {
		try {
			if (persistenceServices.createProblems(problem)) {
				return Response.emptyResponse();
			}
			return Response.errorResponse(Constants.ERROR_EXISTED_PROBLEM);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value = Constants.REQUEST_CREATE_TREATMENT+"/{patientId}"+"/{intervalId}", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> createTreatment(@RequestBody Treatment treatment,@PathVariable int patientId,@PathVariable int intervalId) throws RestException {
		try {
			if (persistenceServices.createTreatment(treatment, patientId, intervalId)) {
				return Response.emptyResponse();
			}
			return Response.errorResponse(Constants.ERROR_EXISTED_TREATMENT);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}


	//*
	@RequestMapping(value = Constants.REQUEST_GET_PATIENT_BY_ID + "/{patientId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientById(@PathVariable int patientId) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getPatient(patientId));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	
	//*
	@RequestMapping(value = Constants.REQUEST_GET_PATIENT_BY_NAME + "/{patientName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientByName(@PathVariable String patientName) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getPatientIdByName(patientName));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}

	//*
	@RequestMapping(value = Constants.REQUEST_GET_ALL_PATIENT, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllPatient() throws RestException {
		try {
			return Response.successResponse(persistenceServices.getAllPatient());
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}

	//*
	@RequestMapping(value = Constants.REQUEST_GET_ALL_DOCTOR, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllDoctor() throws RestException {
		try {
			return Response.successResponse(persistenceServices.getAllDoctor());
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value =  Constants.REQUEST_GET_DOCTOR_BY_CITY+"/{city}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDoctorByCity(@PathVariable String city) throws RestException {
		try {
			System.out.println(city);
			return Response.successResponse(persistenceServices.getDoctorByClinicCity(city));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value =  Constants.REQUEST_GET_DOCTOR_BY_SPECIALIZATION+"/{specialty}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDoctorBySpecialization(@PathVariable String specialty) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getDoctorBySpecialty(specialty));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value =  Constants.REQUEST_GET_PATIENT_NOT_PAYMENT, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientNotPayment() throws RestException {
		try {
			return Response.successResponse(persistenceServices.getPatientNotPayment());
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value = Constants.REQUEST_GET_DOCTOR_BY_NAME + "/{doctorName}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDoctorByName(@PathVariable String doctorName) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getDoctorByName(doctorName));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	
	//*
	@RequestMapping(value = Constants.REQUEST_GET_DOCTOR_BY_ID + "/{doctorId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDoctorById(@PathVariable int doctorId) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getDoctor(doctorId));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value = Constants.REQUEST_GET_ALL_SYMPTOMS, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getAllSymptoms() throws RestException {
		try {
			return Response.successResponse(persistenceServices.getAllSymptoms());
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value = Constants.REQUEST_GET_PATIENT_BY_DOCTOR + "/{doctorId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientByDoctorId(@PathVariable int doctorId) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getPatientByDoctor(doctorId));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	//*
	@RequestMapping(value = Constants.REQUEST_GET_PATIENT_BY_DOCTOR_NOT_PAYMENT + "/{doctorId}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientByDoctorNotPayment(@PathVariable int doctorId) throws RestException {
		try {
			return Response.successResponse(persistenceServices.getPatientByDoctorNotPayment(doctorId));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_SUM_PATIENT_BY_PERIOD + "/{stDateStr}"+"/{endDateStr}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getSumPatientByPeriod(@PathVariable String stDateStr, @PathVariable String endDateStr) throws RestException {
		Date startDate, endDate;
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    	    startDate = format.parse(stDateStr);
    	    endDate = format.parse(endDateStr);
			return Response.successResponse(persistenceServices.getSumPatientByPeriod(startDate, endDate));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_STATISTIC_BY_SYMPTOM + "/{nameSymptom}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getStatisticBySymptom(@PathVariable String nameSymptom) throws RestException {
		try {
			
			return Response.successResponse(persistenceServices.getStatisticBySymptom(nameSymptom));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_STATISTIC_BY_SYMPTOMS, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getStatisticBySymptom(@RequestBody List<Symptoms> symptoms) throws RestException {
		try {
			
			return Response.successResponse(persistenceServices.getStatisticBySymptoms(symptoms));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_PATIENT_NOT_MEETING, method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientNotMeeting() throws RestException {
		try {
			return Response.successResponse(persistenceServices.getPatientNotMeeting());
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_CREATE_SYMPTOM, method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> addSymptom(@RequestBody Symptoms symptom) throws RestException {
		try {
			if (persistenceServices.addSymptom(symptom))
			{
				return Response.emptyResponse();
			}
			return Response.errorResponse(Constants.ERROR_EXISTED_SYMPTOM);
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_PATIENT_BY_DAY + "/{dateStr}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPatientByDay(@PathVariable String dateStr) throws RestException {
		Date date;
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    	    date = format.parse(dateStr);
			return Response.successResponse(persistenceServices.getPatientByDay(date));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_CALLED_PATIENT_BY_DAY + "/{dateStr}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getCalledPatientByDay(@PathVariable String dateStr) throws RestException {
		Date date;
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    	    date = format.parse(dateStr);
			return Response.successResponse(persistenceServices.getCalledPatientByDay(date));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_THERAPY_PATIENT_BY_DAY + "/{dateStr}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getTherapyPatientByDay(@PathVariable String dateStr) throws RestException {
		Date date;
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    	    date = format.parse(dateStr);
			return Response.successResponse(persistenceServices.getTherapyPatientByDay(date));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	
	@RequestMapping(value = Constants.REQUEST_GET_PAYMENT_PATIENT_BY_DAY + "/{dateStr}", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> getPaymentPatientByDay(@PathVariable String dateStr) throws RestException {
		Date date;
		try {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    	    date = format.parse(dateStr);
			return Response.successResponse(persistenceServices.getTherapyPatientByDay(date));
		} catch (Throwable e) {
			throw new RestException(e);
		}
	}
	

}
