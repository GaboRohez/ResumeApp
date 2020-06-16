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

	public void setPeriod(String period){
		this.period = period;
	}

	public String getPeriod(){
		return period;
	}

	public void setGrade(String grade){
		this.grade = grade;
	}

	public String getGrade(){
		return grade;
	}

	public void setInstitute(String institute){
		this.institute = institute;
	}

	public String getInstitute(){
		return institute;
	}

	public void setTitle(String title){
		this.title = title;
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