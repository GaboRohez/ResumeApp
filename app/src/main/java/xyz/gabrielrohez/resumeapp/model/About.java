package xyz.gabrielrohez.resumeapp.model;

import com.google.gson.annotations.SerializedName;

public class About{

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