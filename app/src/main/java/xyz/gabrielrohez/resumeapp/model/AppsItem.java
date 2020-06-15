package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AppsItem implements Parcelable {

	@SerializedName("image_url")
	private String imageUrl;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	protected AppsItem(Parcel in) {
		imageUrl = in.readString();
		name = in.readString();
		url = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(imageUrl);
		dest.writeString(name);
		dest.writeString(url);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<AppsItem> CREATOR = new Creator<AppsItem>() {
		@Override
		public AppsItem createFromParcel(Parcel in) {
			return new AppsItem(in);
		}

		@Override
		public AppsItem[] newArray(int size) {
			return new AppsItem[size];
		}
	};

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