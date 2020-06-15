package xyz.gabrielrohez.resumeapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class InterPersonal{

	@SerializedName("aptitudes")
	private List<String> aptitudes;

	@SerializedName("interests")
	private List<String> interests;

	public List<String> getAptitudes(){
		return aptitudes;
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