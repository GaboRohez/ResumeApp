package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Social implements Parcelable {

	@SerializedName("github")
	private String github;

	@SerializedName("web")
	private String web;

	@SerializedName("playstore")
	private String playstore;

	protected Social(Parcel in) {
		github = in.readString();
		web = in.readString();
		playstore = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(github);
		dest.writeString(web);
		dest.writeString(playstore);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Social> CREATOR = new Creator<Social>() {
		@Override
		public Social createFromParcel(Parcel in) {
			return new Social(in);
		}

		@Override
		public Social[] newArray(int size) {
			return new Social[size];
		}
	};

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