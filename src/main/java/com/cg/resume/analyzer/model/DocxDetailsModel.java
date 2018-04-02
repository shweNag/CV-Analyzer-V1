package com.cg.resume.analyzer.model;

import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

public class DocxDetailsModel {

	private List<XWPFParagraph> paragraphList;
	private List<XWPFTable> tableList;

	public List<XWPFParagraph> getParagraphList() {
		return paragraphList;
	}

	public void setParagraphList(List<XWPFParagraph> paragraphList) {
		this.paragraphList = paragraphList;
	}

	public List<XWPFTable> getTableList() {
		return tableList;
	}

	public void setTableList(List<XWPFTable> tableList) {
		this.tableList = tableList;
	}

}
