package xyz.gabrielrohez.resumeapp.model;

import com.google.gson.annotations.SerializedName;

public class Social{

	@SerializedName("github")
	private String github;

	@SerializedName("web")
	private String web;

	@SerializedName("playstore")
	private String playstore;

	public void setGithub(String github){
		this.github = github;
	}

	public String getGithub(){
		return github;
	}

	public void setWeb(String web){
		this.web = web;
	}

	public String getWeb(){
		return web;
	}

	public void setPlaystore(String playstore){
		this.playstore = playstore;
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