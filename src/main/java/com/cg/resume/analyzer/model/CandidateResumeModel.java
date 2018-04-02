package com.cg.resume.analyzer.model;

import java.util.List;

public class CandidateResumeModel {

	private PersonalDetailsModel personalDetials;

	private ProfessionalDetailsModel professionalDetails;

	private List<ProjectDetailsModel> projectDetails;

	public PersonalDetailsModel getPersonalDetials() {
		return personalDetials;
	}

	public void setPersonalDetials(PersonalDetailsModel personalDetials) {
		this.personalDetials = personalDetials;
	}

	public ProfessionalDetailsModel getProfessionalDetails() {
		return professionalDetails;
	}

	public void setProfessionalDetails(ProfessionalDetailsModel professionalDetails) {
		this.professionalDetails = professionalDetails;
	}

	public List<ProjectDetailsModel> getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(List<ProjectDetailsModel> projectDetails) {
		this.projectDetails = projectDetails;
	}

}
