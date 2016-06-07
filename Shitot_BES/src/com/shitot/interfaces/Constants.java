package com.shitot.interfaces;

public interface Constants {

    String ERROR_LOGIN = "Username or password is wrong";
    String ERROR_EXISTED_ADDRESS = "Address already exists";
    String ERROR_EXISTED_DOCTOR = "Doctor already exists";
    String ERROR_EXISTED_PATIENT = "Patient already exists";
    String ERROR_NO_EXISTED_PATIENT_OR_DOCTOR = "No patient or doctor";
    String ERROR_EDIT_CALENDAR = "Error edit calendar";
    String ERROR_EXISTED_CLINIC = "Clinic already exist";
    String ERROR_EXISTED_PROBLEM = "Problem already exist";
    String ERROR_EXISTED_TREATMENT = "Treatment not create";
    String ERROR_EXISTED_SYMPTOM = "Symtom not create";

   

    String REQUEST_LOGIN = "/login";
    String REQUEST_LOGIN_DOCTOR = "/loginDoctor";
    String REQUEST_CREATE_ADDRESS = "/requestCreateAddress";
    String REQUEST_GET_ALL_DOCTOR = "/requestGetAllDoctor";
    String REQUEST_GET_CALENDAR_BY_DOCTOR_ID = "/requestGetCalendarByDoctorId";
    String REQUEST_GET_ALL_ADDRESSES = "/requestGetAllAddresses";
    String REQUEST_CREATE_DOCTOR = "/requestCreateDoctor";
    String REQUEST_CREATE_PATIENT = "/requestCreatePatient";
    String REQUEST_GET_ALL_PATIENT = "/requestGetAllPatient";
    String REQUEST_GET_PATIENT_BY_ID = "/requestPatientById";
    String REQUEST_GET_ADD_PATIENT_TO_DOCTOR = "/requestGetAddPatientToDoctor";
    String REQUEST_EDIT_CALENDAR = "/editCalendar";
    String REQUEST_CREATE_CLINIC = "/createClinic";
    String REQUEST_UPDATE_PATIENT = "/updatePatient";
    String REQUEST_GET_PATIENT_BY_PERIOD = "/requestGetPatientByPeriod";
	String REQUEST_GET_DOCTOR_BY_CITY = "/getDoctorByCity";
	String REQUEST_GET_DOCTOR_BY_SPECIALIZATION = "/getDoctorBySpecialty";
	String REQUEST_UPDATE_CLINIC = "/updateClinic";
	String REQUEST_GET_PATIENT_NOT_PAYMENT = "/getPatientNotPayment";
	String REQUEST_CREATE_USER = "/createUser";
	String REQUEST_GET_PATIENT_BY_NAME = "/getPatientByName";
	String REQUEST_GET_DOCTOR_BY_NAME = "/getDoctorByName";
	String REQUEST_GET_DOCTOR_BY_ID = "/getDoctorById";
	String REQUEST_CREATE_PROBLEM = "/createProblem";
	String REQUEST_GET_ALL_CLINIC = "/getAllClinic";
	String REQUEST_GET_ALL_CLINIC_BY_DOCTOR = "/getAllClinicByDoctor";
	String REQUEST_GET_ALL_CLINIC_BY_CITY = "/getAllClinicByCity";
	String REQUEST_CREATE_TREATMENT = "/createTreatment";
	String REQUEST_GET_ALL_SYMPTOMS = "/getAllSymptoms";
	String REQUEST_GET_PATIENT_BY_DOCTOR = "/getPatientByDoctor";
	String REQUEST_GET_PATIENT_BY_DOCTOR_NOT_PAYMENT = "/getPatientByDoctorNotPayment";
	String REQUEST_GET_SUM_PATIENT_BY_PERIOD = "/getSumPatientByPeriod";
	String REQUEST_GET_STATISTIC_BY_SYMPTOM = "/getStatisticBySymptom";
	String REQUEST_GET_STATISTIC_BY_SYMPTOMS = "/getStatisticBySymptoms";
	String REQUEST_GET_PATIENT_NOT_MEETING = "/getPatientNotMeeting";
	String REQUEST_CREATE_SYMPTOM = "/createSymptom";
	String REQUEST_GET_PATIENT_BY_DAY = "/getPatientByDay";
	String REQUEST_GET_CALLED_PATIENT_BY_DAY = "/getCalledPatientByDay";
	String REQUEST_GET_THERAPY_PATIENT_BY_DAY = "/getTherapyPatientByDay";
	String REQUEST_GET_PAYMENT_PATIENT_BY_DAY = "/getPaymentPatientByDay";
	
	
	
}