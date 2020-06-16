package xyz.gabrielrohez.resumeapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Skills{

	@SerializedName("database")
	private List<String> database;

	@SerializedName("languages")
	private List<String> languages;

	@SerializedName("ide")
	private List<String> ide;

	@SerializedName("version_control")
	private List<String> versionControl;

	@SerializedName("platforms")
	private List<String> platforms;

	public void setDatabase(List<String> database){
		this.database = database;
	}

	public List<String> getDatabase(){
		return database;
	}

	public void setLanguages(List<String> languages){
		this.languages = languages;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public void setIde(List<String> ide){
		this.ide = ide;
	}

	public List<String> getIde(){
		return ide;
	}

	public void setVersionControl(List<String> versionControl){
		this.versionControl = versionControl;
	}

	public List<String> getVersionControl(){
		return versionControl;
	}

	public void setPlatforms(List<String> platforms){
		this.platforms = platforms;
	}

	public List<String> getPlatforms(){
		return platforms;
	}

	@Override
 	public String toString(){
		return 
			"Skills{" + 
			"database = '" + database + '\'' + 
			",languages = '" + languages + '\'' + 
			",ide = '" + ide + '\'' + 
			",version_control = '" + versionControl + '\'' + 
			",platforms = '" + platforms + '\'' + 
			"}";
		}
}