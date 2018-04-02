package com.cg.resume.analyzer.model;

public class ProfessionalDetailsModel {

	private SkillDetailsModel skillDetails;

	private LanguageDetailsModel languageDetails;

	private String[] domainExperience;

	private String profile;

	private String educationalDetails;

	public SkillDetailsModel getSkillDetails() {
		return skillDetails;
	}

	public void setSkillDetails(SkillDetailsModel skillDetails) {
		this.skillDetails = skillDetails;
	}

	public LanguageDetailsModel getLanguageDetails() {
		return languageDetails;
	}

	public void setLanguageDetails(LanguageDetailsModel languageDetails) {
		this.languageDetails = languageDetails;
	}

	public String[] getDomainExperience() {
		return domainExperience;
	}

	public void setDomainExperience(String[] domainExperience) {
		this.domainExperience = domainExperience;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getEducationalDetails() {
		return educationalDetails;
	}

	public void setEducationalDetails(String educationalDetails) {
		this.educationalDetails = educationalDetails;
	}

}