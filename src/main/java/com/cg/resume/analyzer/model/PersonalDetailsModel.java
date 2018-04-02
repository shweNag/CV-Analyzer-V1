package com.cg.resume.analyzer.model;

public class PersonalDetailsModel {

	private int employeeId;
	
	private String name;

	private String designation;

	private String residence;

	private String nationality;

	private String maritalStatus;

	private String mobileNo;

	private String gender;

	private PassportDetailsModel passportDetails;

	private String cgEmailId;
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public PassportDetailsModel getPassportDetails() {
		return passportDetails;
	}

	public void setPassportDetails(PassportDetailsModel passportDetails) {
		this.passportDetails = passportDetails;
	}

	public String getCgEmailId() {
		return cgEmailId;
	}

	public void setCgEmailId(String cgEmailId) {
		this.cgEmailId = cgEmailId;
	}

}
