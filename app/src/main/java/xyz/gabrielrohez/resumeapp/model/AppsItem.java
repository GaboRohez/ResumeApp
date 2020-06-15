package xyz.gabrielrohez.resumeapp.model;

import com.google.gson.annotations.SerializedName;

public class AppsItem{

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public String getImageUrl(){
		return imageUrl;
	}

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"AppsItem{" + 
			"image_url = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}