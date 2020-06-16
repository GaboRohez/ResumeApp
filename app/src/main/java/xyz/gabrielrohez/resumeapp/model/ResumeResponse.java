package xyz.gabrielrohez.resumeapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResumeResponse{

	@SerializedName("skills")
	private Skills skills;

	@SerializedName("courses")
	private List<CoursesItem> courses;

	@SerializedName("inter_personal")
	private InterPersonal interPersonal;

	@SerializedName("social")
	private Social social;

	@SerializedName("about")
	private About about;

	@SerializedName("experience")
	private List<ExperienceItem> experience;

	@SerializedName("apps")
	private List<AppsItem> apps;

	public void setSkills(Skills skills){
		this.skills = skills;
	}

	public Skills getSkills(){
		return skills;
	}

	public void setCourses(List<CoursesItem> courses){
		this.courses = courses;
	}

	public List<CoursesItem> getCourses(){
		return courses;
	}

	public void setInterPersonal(InterPersonal interPersonal){
		this.interPersonal = interPersonal;
	}

	public InterPersonal getInterPersonal(){
		return interPersonal;
	}

	public void setSocial(Social social){
		this.social = social;
	}

	public Social getSocial(){
		return social;
	}

	public void setAbout(About about){
		this.about = about;
	}

	public About getAbout(){
		return about;
	}

	public void setExperience(List<ExperienceItem> experience){
		this.experience = experience;
	}

	public List<ExperienceItem> getExperience(){
		return experience;
	}

	public void setApps(List<AppsItem> apps){
		this.apps = apps;
	}

	public List<AppsItem> getApps(){
		return apps;
	}

	@Override
 	public String toString(){
		return 
			"ResumeResponse{" + 
			"skills = '" + skills + '\'' + 
			",courses = '" + courses + '\'' + 
			",inter_personal = '" + interPersonal + '\'' + 
			",social = '" + social + '\'' + 
			",about = '" + about + '\'' + 
			",experience = '" + experience + '\'' + 
			",apps = '" + apps + '\'' + 
			"}";
		}
}