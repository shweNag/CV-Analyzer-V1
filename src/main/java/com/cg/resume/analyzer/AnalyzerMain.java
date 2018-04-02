package com.cg.resume.analyzer;

import java.util.Map;

//import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.cg.resume.analyzer.model.DocxDetailsModel;
import com.cg.resume.analyzer.util.AnalyzerUtil;

public class AnalyzerMain {

	public static void main(String[] args) { 
	String  filePath = "C:\\Users\\sphulari\\Downloads\\Vijoy_CG__ profile_Angular2.docx";
		System.out.println("Enter File Path : ");
		/*
		 * try (Scanner scanner = new Scanner(System.in)) { filePath =
		 * scanner.nextLine(); }
		 */
		try {
			String fileExtn = AnalyzerUtil.getFileExtension(filePath);
			if ("doc".equals(fileExtn)) {
				
			}
			else if("docx".equals(fileExtn)) {
		new AnalyzerMain().processDocument(filePath);}
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}

	private void processDocument(String filePath) {

		try {

			XWPFDocument document = AnalyzerUtil.readDocxDocument(filePath);
			// reading word document
			DocxDetailsModel docxDetails = AnalyzerUtil.extractDocxDetails(document);

			Map<String, Object> professionalMap = AnalyzerUtil.retriveProfecionalDetailsFromTable(docxDetails);
			Map<String, Object> profileMap = AnalyzerUtil.retriveProfileDetailsFromTable(docxDetails);
			Map<String, Object> projectMap = AnalyzerUtil.retriveProjectdetailsFromTable(docxDetails);
			AnalyzerUtil.insertMapIntoJson(professionalMap, profileMap, projectMap);

		} catch (Exception ex) {
			ex.printStackTrace();

			System.out.println(ex.getMessage() + "\nExiting Analyzer!!!");
		}
	}
	
	

	

	/*
	 * private void processDocDocument(String filePath) { Map<String, String>
	 * tableExtractMap = null; try { HWPFDocument document =
	 * AnalyzerUtil.readDocDocument(filePath); // reading word document
	 * DocxDetailsModel docxDetails = AnalyzerUtil.extractDocDetails(document);
	 * for(XWPFTable table : docxDetails.getTableList()) { tableExtractMap =
	 * AnalyzerUtil.extractDocxTableDetails(table, tableExtractMap); }
	 * 
	 * System.out.println(tableExtractMap.toString());
	 * 
	 * } catch (Exception ex) { ex.printStackTrace();
	 * System.out.println(ex.getMessage() + "\nExiting Analyzer!!!"); } }
	 */

}
