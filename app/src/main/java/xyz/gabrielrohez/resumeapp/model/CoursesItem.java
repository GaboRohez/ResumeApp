package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CoursesItem implements Parcelable {

	@SerializedName("period")
	private String period;

	@SerializedName("grade")
	private String grade;

	@SerializedName("institute")
	private String institute;

	@SerializedName("title")
	private String title;

	protected CoursesItem(Parcel in) {
		period = in.readString();
		grade = in.readString();
		institute = in.readString();
		title = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(period);
		dest.writeString(grade);
		dest.writeString(institute);
		dest.writeString(title);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<CoursesItem> CREATOR = new Creator<CoursesItem>() {
		@Override
		public CoursesItem createFromParcel(Parcel in) {
			return new CoursesItem(in);
		}

		@Override
		public CoursesItem[] newArray(int size) {
			return new CoursesItem[size];
		}
	};

	public String getPeriod(){
		return period;
	}

	public String getGrade(){
		return grade;
	}

	public String getInstitute(){
		return institute;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"CoursesItem{" + 
			"period = '" + period + '\'' + 
			",grade = '" + grade + '\'' + 
			",institute = '" + institute + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}