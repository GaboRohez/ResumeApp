package xyz.gabrielrohez.resumeapp.model;

import com.google.gson.annotations.SerializedName;

public class CoursesItem{

	@SerializedName("period")
	private String period;

	@SerializedName("grade")
	private String grade;

	@SerializedName("institute")
	private String institute;

	@SerializedName("title")
	private String title;

	public String getPeriod(){
		return period;
	}

	public String getGrade(){
		return grade;
	}

	public String getInstitute(){
		return institute;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"CoursesItem{" + 
			"period = '" + period + '\'' + 
			",grade = '" + grade + '\'' + 
			",institute = '" + institute + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}