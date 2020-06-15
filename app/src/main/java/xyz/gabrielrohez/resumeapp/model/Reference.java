package xyz.gabrielrohez.resumeapp.model;

import com.google.gson.annotations.SerializedName;

public class Reference{

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("job")
	private String job;

	public String getPhone(){
		return phone;
	}

	public String getName(){
		return name;
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