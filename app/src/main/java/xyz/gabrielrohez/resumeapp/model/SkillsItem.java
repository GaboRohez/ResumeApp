package xyz.gabrielrohez.resumeapp.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SkillsItem{

	@SerializedName("platforms")
	private List<String> platforms;

	@SerializedName("version_control")
	private List<String> versionControl;

	@SerializedName("ide")
	private List<String> ide;

	@SerializedName("database")
	private List<String> database;

	@SerializedName("languages")
	private List<String> languages;

	public List<String> getPlatforms(){
		return platforms;
	}

	public List<String> getVersionControl(){
		return versionControl;
	}

	public List<String> getIde(){
		return ide;
	}

	public List<String> getDatabase(){
		return database;
	}

	public List<String> getLanguages(){
		return languages;
	}

	@Override
 	public String toString(){
		return 
			"SkillsItem{" + 
			"platforms = '" + platforms + '\'' + 
			",version_control = '" + versionControl + '\'' + 
			",ide = '" + ide + '\'' + 
			",database = '" + database + '\'' + 
			",languages = '" + languages + '\'' + 
			"}";
		}
}