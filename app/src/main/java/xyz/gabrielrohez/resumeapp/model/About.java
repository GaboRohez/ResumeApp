package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class About implements Parcelable {

	@SerializedName("resume")
	private String resume;

	@SerializedName("phone")
	private long phone;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private String location;

	@SerializedName("job")
	private String job;

	@SerializedName("email")
	private String email;

	protected About(Parcel in) {
		resume = in.readString();
		phone = in.readLong();
		name = in.readString();
		location = in.readString();
		job = in.readString();
		email = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(resume);
		dest.writeLong(phone);
		dest.writeString(name);
		dest.writeString(location);
		dest.writeString(job);
		dest.writeString(email);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<About> CREATOR = new Creator<About>() {
		@Override
		public About createFromParcel(Parcel in) {
			return new About(in);
		}

		@Override
		public About[] newArray(int size) {
			return new About[size];
		}
	};

	public String getResume(){
		return resume;
	}

	public long getPhone(){
		return phone;
	}

	public String getName(){
		return name;
	}

	public String getLocation(){
		return location;
	}

	public String getJob(){
		return job;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"About{" + 
			"resume = '" + resume + '\'' + 
			",phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			",job = '" + job + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}