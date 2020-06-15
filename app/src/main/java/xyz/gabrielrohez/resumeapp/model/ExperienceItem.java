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

	public Reference getReference(){
		return reference;
	}

	public String getPeriod(){
		return period;
	}

	public String getCity(){
		return city;
	}

	public List<String> getActivitys(){
		return activitys;
	}

	public String getLatitude(){
		return latitude;
	}

	public String getName(){
		return name;
	}

	public String getJob(){
		return job;
	}

	public String getLongitude(){
		return longitude;
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