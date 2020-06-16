package xyz.gabrielrohez.resumeapp.model;

import com.google.gson.annotations.SerializedName;

public class Reference{

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("job")
	private String job;

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
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

	@Override
 	public String toString(){
		return 
			"Reference{" + 
			"phone = '" + phone + '\'' + 
			",name = '" + name + '\'' + 
			",job = '" + job + '\'' + 
			"}";
		}
}