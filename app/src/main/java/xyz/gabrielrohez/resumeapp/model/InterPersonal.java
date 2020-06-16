package xyz.gabrielrohez.resumeapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class InterPersonal{

	@SerializedName("aptitudes")
	private List<String> aptitudes;

	@SerializedName("interests")
	private List<String> interests;

	public void setAptitudes(List<String> aptitudes){
		this.aptitudes = aptitudes;
	}

	public List<String> getAptitudes(){
		return aptitudes;
	}

	public void setInterests(List<String> interests){
		this.interests = interests;
	}

	public List<String> getInterests(){
		return interests;
	}

	@Override
 	public String toString(){
		return 
			"InterPersonal{" + 
			"aptitudes = '" + aptitudes + '\'' + 
			",interests = '" + interests + '\'' + 
			"}";
		}
}