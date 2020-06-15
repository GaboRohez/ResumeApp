package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ExperienceItem implements Parcelable {

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

	protected ExperienceItem(Parcel in) {
		period = in.readString();
		city = in.readString();
		activitys = in.createStringArrayList();
		latitude = in.readString();
		name = in.readString();
		job = in.readString();
		longitude = in.readString();
		activities = in.createStringArrayList();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(period);
		dest.writeString(city);
		dest.writeStringList(activitys);
		dest.writeString(latitude);
		dest.writeString(name);
		dest.writeString(job);
		dest.writeString(longitude);
		dest.writeStringList(activities);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<ExperienceItem> CREATOR = new Creator<ExperienceItem>() {
		@Override
		public ExperienceItem createFromParcel(Parcel in) {
			return new ExperienceItem(in);
		}

		@Override
		public ExperienceItem[] newArray(int size) {
			return new ExperienceItem[size];
		}
	};

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