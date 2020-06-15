package xyz.gabrielrohez.resumeapp.model;

import com.google.gson.annotations.SerializedName;

public class Social{

	@SerializedName("github")
	private String github;

	@SerializedName("web")
	private String web;

	@SerializedName("playstore")
	private String playstore;

	public String getGithub(){
		return github;
	}

	public String getWeb(){
		return web;
	}

	public String getPlaystore(){
		return playstore;
	}

	@Override
 	public String toString(){
		return 
			"Social{" + 
			"github = '" + github + '\'' + 
			",web = '" + web + '\'' + 
			",playstore = '" + playstore + '\'' + 
			"}";
		}
}