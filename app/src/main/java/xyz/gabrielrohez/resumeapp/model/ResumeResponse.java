package xyz.gabrielrohez.resumeapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResumeResponse{

	@SerializedName("skills")
	private List<SkillsItem> skills;

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

	public List<SkillsItem> getSkills(){
		return skills;
	}

	public List<CoursesItem> getCourses(){
		return courses;
	}

	public InterPersonal getInterPersonal(){
		return interPersonal;
	}

	public Social getSocial(){
		return social;
	}

	public About getAbout(){
		return about;
	}

	public List<ExperienceItem> getExperience(){
		return experience;
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