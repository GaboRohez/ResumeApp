package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class InterPersonal implements Parcelable {

	@SerializedName("aptitudes")
	private List<String> aptitudes;

	@SerializedName("interests")
	private List<String> interests;

	protected InterPersonal(Parcel in) {
		aptitudes = in.createStringArrayList();
		interests = in.createStringArrayList();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringList(aptitudes);
		dest.writeStringList(interests);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<InterPersonal> CREATOR = new Creator<InterPersonal>() {
		@Override
		public InterPersonal createFromParcel(Parcel in) {
			return new InterPersonal(in);
		}

		@Override
		public InterPersonal[] newArray(int size) {
			return new InterPersonal[size];
		}
	};

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