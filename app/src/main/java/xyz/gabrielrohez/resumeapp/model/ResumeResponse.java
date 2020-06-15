package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResumeResponse implements Parcelable {

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

	protected ResumeResponse(Parcel in) {
		courses = in.createTypedArrayList(CoursesItem.CREATOR);
		interPersonal = in.readParcelable(InterPersonal.class.getClassLoader());
		about = in.readParcelable(About.class.getClassLoader());
		experience = in.createTypedArrayList(ExperienceItem.CREATOR);
		apps = in.createTypedArrayList(AppsItem.CREATOR);
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(courses);
		dest.writeParcelable(interPersonal, flags);
		dest.writeParcelable(about, flags);
		dest.writeTypedList(experience);
		dest.writeTypedList(apps);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<ResumeResponse> CREATOR = new Creator<ResumeResponse>() {
		@Override
		public ResumeResponse createFromParcel(Parcel in) {
			return new ResumeResponse(in);
		}

		@Override
		public ResumeResponse[] newArray(int size) {
			return new ResumeResponse[size];
		}
	};

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