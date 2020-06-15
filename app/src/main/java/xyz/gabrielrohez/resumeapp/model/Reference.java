package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Reference implements Parcelable {

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("job")
	private String job;

	protected Reference(Parcel in) {
		phone = in.readString();
		name = in.readString();
		job = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(phone);
		dest.writeString(name);
		dest.writeString(job);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<Reference> CREATOR = new Creator<Reference>() {
		@Override
		public Reference createFromParcel(Parcel in) {
			return new Reference(in);
		}

		@Override
		public Reference[] newArray(int size) {
			return new Reference[size];
		}
	};

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