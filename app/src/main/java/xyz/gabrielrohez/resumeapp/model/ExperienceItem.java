package xyz.gabrielrohez.resumeapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ExperienceItem{

	@SerializedName("reference")
	private Reference reference;

	@SerializedName("period")
	private String period;

	@SerializedName("city")
	private String city;

	@SerializedName("activitys")
	private List<String> activitys;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("name")
	private String name;

	@SerializedName("job")
	private String job;

	@SerializedName("longitude")
	private String longitude;

	@SerializedName("activities")
	private List<String> activities;

	public void setReference(Reference reference){
		this.reference = reference;
	}

	public Reference getReference(){
		return reference;
	}

	public void setPeriod(String period){
		this.period = period;
	}

	public String getPeriod(){
		return period;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setActivitys(List<String> activitys){
		this.activitys = activitys;
	}

	public List<String> getActivitys(){
		return activitys;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setJob(String job){
		this.job = job;
	}

	public String getJob(){
		return job;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	public void setActivities(List<String> activities){
		this.activities = activities;
	}

	public List<String> getActivities(){
		return activities;
	}

	@Override
 	public String toString(){
		return 
			"ExperienceItem{" + 
			"reference = '" + reference + '\'' + 
			",period = '" + period + '\'' + 
			",city = '" + city + '\'' + 
			",activitys = '" + activitys + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",name = '" + name + '\'' + 
			",job = '" + job + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",activities = '" + activities + '\'' + 
			"}";
		}
}