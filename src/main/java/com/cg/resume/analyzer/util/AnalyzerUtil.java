package com.cg.resume.analyzer.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.json.JSONObject;

import com.cg.resume.analyzer.exception.AnalyzerException;
import com.cg.resume.analyzer.model.CandidateResumeModel;
import com.cg.resume.analyzer.model.DocxDetailsModel;
import com.cg.resume.analyzer.model.PassportDetailsModel;
import com.cg.resume.analyzer.model.PersonalDetailsModel;
import com.cg.resume.analyzer.model.ProjectDetailsModel;

/**
 * @author sphulari
 *         <h1>AnalyzerUtil Class</h1>
 *         <p>
 *         This is an utility class which provides common re-usable tools. This
 *         class provides the tools for analyzing a word document.
 *         </p>
 */

public final class AnalyzerUtil {

	public static String getFileExtension(String filePath) {
		String[] splitFilePath = filePath.split("\\.");
		int length = splitFilePath.length;
		if (length > 0 && "doc".equals(splitFilePath[length - 1])) {
			return "doc";
		} else if (length > 0 && "docx".equals(splitFilePath[length - 1])) {
			return "docx";
		} else {
			throw new AnalyzerException("Invalid file path format / file extension !!!");
		}
	}

	public static XWPFDocument readDocxDocument(String filePath) throws Exception {
		String fileExtn = getFileExtension(filePath);
		if ("doc".equals(fileExtn)) {

		}
		return new XWPFDocument(OPCPackage.open(new FileInputStream(new File(filePath))));

	}

	// read doc
	public static HWPFDocument readDocDocument(String filePath) throws Exception {
		return new HWPFDocument(new FileInputStream(new File(filePath)));
	}

	public static DocxDetailsModel extractDocxDetails(XWPFDocument document) {
		DocxDetailsModel docxDetailsModel = new DocxDetailsModel();
		docxDetailsModel.setParagraphList(document.getParagraphs());
		docxDetailsModel.setTableList(document.getTables());
		return docxDetailsModel;
	}
	// extractdocdetils
	/*
	 * public static DocDetailsModel extractDocDetails(HWPFDocument document) {
	 * DocDetailsModel docxDetailsModel = new DocxDetailsModel();
	 * //docxDetailsModel.setParagraphList(document.getParagraphs());
	 * //docxDetailsModel.setTableList(document.getListTables()); return
	 * docDetailsModel; }
	 */

	/*
	 * public static Map<String, Object> extractDocxTableDetails(XWPFTable
	 * table,Map<String, Object> profileDetailsMap) { if (profileDetailsMap == null)
	 * { profileDetailsMap = new HashMap<String, Object>(); }
	 * 
	 * for (XWPFTableRow row : table.getRows()) { // profileDetailsMap =
	 * retriveProfileDetyailsFromTable(row ,profileDetailsMap);
	 * 
	 * }
	 * 
	 * 
	 * return profileDetailsMap; }
	 */

	public static Map<String, Object> retriveProfileDetailsFromTable(DocxDetailsModel docxDetails) {
		Map<String, Object> profile = new HashMap<>();
		PersonalDetailsModel personalDetails = new PersonalDetailsModel();
		PassportDetailsModel passportDetails = new PassportDetailsModel();
		CandidateResumeModel candidateResumeDetails = new CandidateResumeModel();
		// List<XWPFParagraph> para = docxDetails.getParagraphList();
		/*
		 * for (XWPFParagraph paragrph : para) { //System.out.println("para" +
		 * paragrph.getParagraphText()); }
		 */
		for (XWPFTable table : docxDetails.getTableList()) {
			for (XWPFTableRow row : table.getRows()) {
				if (AnalyzerConsts.keyList.contains(row.getCell(0).getText().trim())) {
					profile.put(row.getCell(0).getText().trim(), row.getCell(1).getText().trim());
				}
				if (row.getCell(0).getText().trim().equalsIgnoreCase("Name")) {
					personalDetails.setName(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("designation")) {
					personalDetails.setDesignation(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("residence")) {
					personalDetails.setResidence(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("nationality")) {
					personalDetails.setNationality(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("maritalStatus")) {
					personalDetails.setMaritalStatus(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("mobile No")) {
					personalDetails.setMobileNo((row.getCell(1).getText().trim()));
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("Gender")) {
					personalDetails.setGender((row.getCell(1).getText().trim()));
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("Corporate Email")) {
					personalDetails.setCgEmailId(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("Passport Details")) {
					passportDetails.setPassportNo(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("Issue Date")) {
					passportDetails.setIssueDate(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("Expiration Date")) {
					passportDetails.setExpiryDate(row.getCell(1).getText().trim());
				} else if (row.getCell(0).getText().trim().equalsIgnoreCase("Country")) {
					passportDetails.setIssuedCountry(row.getCell(1).getText().trim());
				}
			}

		}
		personalDetails.setPassportDetails(passportDetails);
		candidateResumeDetails.setPersonalDetials(personalDetails);
		return profile;
	}

	public static Map<String, Object> retriveProfecionalDetailsFromTable(DocxDetailsModel docxDetails) {
		Map<String, Object> professional = new HashMap<>();
		// CandidateResumeModel candidateResumeDetails = new CandidateResumeModel();
		// SkillDetailsModel skillDetails = new SkillDetailsModel();
		// ProfessionalDetailsModel ProfessionalDetails = new
		// ProfessionalDetailsModel();
		for (XWPFTable table : docxDetails.getTableList()) {
			/*
			 * System.out.println("Table number of rows.." + table.getNumberOfRows());
			 * System.out.println(table.getText());
			 */
			for (XWPFTableRow row : table.getRows()) {
				if (AnalyzerConsts.skillsList.contains(row.getCell(0).getText().trim())) {
					professional.put(row.getCell(0).getText().trim(), row.getCell(1).getText().trim());
					if (row.getCell(0).getText().trim().equalsIgnoreCase("Skill set")) {
						// killDetails.setSkillSet(row.getCell(0).getText().trim());
					}

				} else if (AnalyzerConsts.professionalList.contains(row.getCell(0).getText().trim())) {
					professional.put(row.getCell(0).getText().trim(), row.getCell(1).getText().trim());
				}

			}
		}

		return professional;
	}

	public static Map<String, Object> retriveProjectdetailsFromTable(DocxDetailsModel docxDetails) {
		Map<String, Object> projectDetails = new HashMap<>();
		CandidateResumeModel candidateResumeDetails = new CandidateResumeModel();
//		ProjectDetailsModel projectdetails = new ProjectDetailsModel();
		List techList = new ArrayList();
		int i=0;
		for (XWPFTable table : docxDetails.getTableList()) {
			System.out.println(table.getNumberOfRows() + "....");
			Map<String, Object> project = new HashMap<>();
			for (XWPFTableRow row : table.getRows()) {
				
				System.out.println("row size.." + row.getTableCells().size());
				if ((row.getTableCells().size() > 1) && (AnalyzerConsts.projectList.contains(row.getCell(1).getText().trim())) ) {
					if (row.getCell(0).getText().trim() != null && !row.getCell(0).getText().trim().equals("")) {
							project.put("Project Duration", row.getCell(0).getText().trim());
						//	projectdetails.setStartDate(row.getCell(0).getText().trim());
						}
						else if(row.getTableCells().size()==4) {
							String s= row.getCell(2).getText().trim()+""+row.getCell(3).getText().trim();
							project.put(row.getCell(1).getText().trim(), s);
							techList.add(s);
						}
						else {
						project.put(row.getCell(1).getText().trim(), row.getCell(2).getText().trim());
						}
					}
				
			}
			i++;
			projectDetails.put("Project"+i, project);
		}
	
		return projectDetails;
	}

	public static void insertMapIntoJson(Map<String, Object> professionalMap, Map<String, Object> profileMap,
			Map<String, Object> projectMap) {
		JSONObject json = new JSONObject();
		json.put("Profile Details", profileMap);
		json.put("Professional Details", professionalMap);
		json.put("project details", projectMap);
		System.out.println(json);
	}
}
