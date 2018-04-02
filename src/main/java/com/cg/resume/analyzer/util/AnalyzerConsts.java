package com.cg.resume.analyzer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class AnalyzerConsts {

	@SuppressWarnings("serial")
	public static final Map<String, String> keyList = Collections.unmodifiableMap(new ArrayList<String>() {
		{
			add("name");
			add("designation");
			add("Residence");
			add("Mobile");
			add("Mobile no");
			add("Nationality");	
			add("Marital Status");
			add("Gender");
			add("Passport Details");
			add("Issue Date");
			add("Expiration Date");
			add("Country");
			add("Languages");
			add("Education");
			add("Permanent Address");
		
			
		}
	});
public static final List<String> skillsList = Collections.unmodifiableList(new ArrayList<String>() {
	{
		add("Skills");
		add("Skill set");
		add("technology used in project");
		add("framework");
		add("Languages");
		add("Databases Worked On");
		add("Databases");
		add("Build Tool");
		add("App/Web Servers");
		add("Operating Systems");
		add("GUI Tools");
		add("Internet Technologies");
		add("Source Control Tools   \r\n" + 
				"ERP\r\n" + 
				"CMS\r\n" + 
				"");
		add("Frameworks/API's");
		add("Presentation Tier’s");
		add("Tools used");
		add("methodologies");
		add("version control tools");
		add("Web / App Servers");
		add("IDE’s & Utilities");
	}
});
public static final List<String> professionalList = Collections.unmodifiableList(new ArrayList<String>() {
	{
		
	}
	});
	
public static final List<String> projectList = Collections.unmodifiableList(new ArrayList<String>() {
	{
		add("Project Name");
		add("Client");
		add("Role");
		add("Roles performed");
		add("Technology used in project");
		add("Description");
		
	}
});


}