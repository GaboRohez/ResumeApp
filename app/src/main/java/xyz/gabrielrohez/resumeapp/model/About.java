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

	public void setResume(String resume){
		this.resume = resume;
	}

	public String getResume(){
		return resume;
	}

	public void setPhone(long phone){
		this.phone = phone;
	}

	public long getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(String location){
		this.location = location;
	}

	public String getLocation(){
		return location;
	}

	public void setJob(String job){
		this.job = job;
	}

	public String getJob(){
		return job;
	}

	public void setEmail(String email){
		this.email = email;
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