package com.javacodegeeks.drools.model;


public class QuickQuoteInputProfile {

    public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Double getFaceAmount() {
		return faceAmount;
	}
	public void setFaceAmount(Double faceAmount) {
		this.faceAmount = faceAmount;
	}
	public boolean isAdverseDiagnosis() {
		return adverseDiagnosis;
	}
	public void setAdverseDiagnosis(boolean adverseDiagnosis) {
		this.adverseDiagnosis = adverseDiagnosis;
	}
	public SmokerProfile getSmokingProf() {
		return smokingProf;
	}
	public void setSmokingProf(SmokerProfile smokingProf) {
		this.smokingProf = smokingProf;
	}
	private String state = null;
    private String gender = null;
    private int age = 0;
    private Double faceAmount = null;
    private boolean adverseDiagnosis = false;
    private SmokerProfile smokingProf = null;

}
