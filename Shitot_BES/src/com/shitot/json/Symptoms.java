package com.shitot.json;


public class Symptoms {

	int id;
	
	private String nameSymptom;
	/*private Boolean bBehavior; // ב. התנהגות
	 private Boolean attention; // קשב
	 private Boolean anxiety; // חרדה
	 private Boolean depression; // דיכאון
	 private Boolean selfWorth; // ערך עצמי
	 private Boolean socialSkills; // מיומנויות חברתיות
	 private Boolean treatmentPaired; // טיפול זוגי
	 private Boolean eating; // אכילה
	 private Boolean personality; // ה.אישיות
	 private Boolean trauma; // טראומה
	 private Boolean ParentalGuidance; // הדרכת הורים
	 private Boolean pressure; // מ.לחץ
	 private Boolean pdd; // PDD
	 private Boolean work; // עבודה
	*/
	 public Symptoms() {	}
	 
	 

	public Symptoms(String nameSymptom) {
		this.nameSymptom = nameSymptom;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameSymptom() {
		return nameSymptom;
	}

	public void setNameSymptom(String nameSymptom) {
		this.nameSymptom = nameSymptom;
	}



	@Override
	public String toString() {
		return "Symptoms [id=" + id + ", nameSymptom=" + nameSymptom + "]";
	}
	
	

	/*public Boolean getbBehavior() {
		return bBehavior;
	}

	public void setbBehavior(Boolean bBehavior) {
		this.bBehavior = bBehavior;
	}

	public Boolean getAttention() {
		return attention;
	}

	public void setAttention(Boolean attention) {
		this.attention = attention;
	}

	public Boolean getAnxiety() {
		return anxiety;
	}

	public void setAnxiety(Boolean anxiety) {
		this.anxiety = anxiety;
	}

	public Boolean getDepression() {
		return depression;
	}

	public void setDepression(Boolean depression) {
		this.depression = depression;
	}

	public Boolean getSelfWorth() {
		return selfWorth;
	}

	public void setSelfWorth(Boolean selfWorth) {
		this.selfWorth = selfWorth;
	}

	public Boolean getSocialSkills() {
		return socialSkills;
	}

	public void setSocialSkills(Boolean socialSkills) {
		this.socialSkills = socialSkills;
	}

	public Boolean getTreatmentPaired() {
		return treatmentPaired;
	}

	public void setTreatmentPaired(Boolean treatmentPaired) {
		this.treatmentPaired = treatmentPaired;
	}

	public Boolean getEating() {
		return eating;
	}

	public void setEating(Boolean eating) {
		this.eating = eating;
	}

	public Boolean getPersonality() {
		return personality;
	}

	public void setPersonality(Boolean personality) {
		this.personality = personality;
	}

	public Boolean getTrauma() {
		return trauma;
	}

	public void setTrauma(Boolean trauma) {
		this.trauma = trauma;
	}

	public Boolean getParentalGuidance() {
		return ParentalGuidance;
	}

	public void setParentalGuidance(Boolean parentalGuidance) {
		ParentalGuidance = parentalGuidance;
	}

	public Boolean getPressure() {
		return pressure;
	}

	public void setPressure(Boolean pressure) {
		this.pressure = pressure;
	}

	public Boolean getPdd() {
		return pdd;
	}

	public void setPdd(Boolean pdd) {
		this.pdd = pdd;
	}

	public Boolean getWork() {
		return work;
	}

	public void setWork(Boolean work) {
		this.work = work;
	}*/

	 

}
