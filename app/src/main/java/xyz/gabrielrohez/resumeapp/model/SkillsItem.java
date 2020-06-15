package xyz.gabrielrohez.resumeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SkillsItem implements Parcelable {

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

	protected SkillsItem(Parcel in) {
		platforms = in.createStringArrayList();
		versionControl = in.createStringArrayList();
		ide = in.createStringArrayList();
		database = in.createStringArrayList();
		languages = in.createStringArrayList();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeStringList(platforms);
		dest.writeStringList(versionControl);
		dest.writeStringList(ide);
		dest.writeStringList(database);
		dest.writeStringList(languages);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<SkillsItem> CREATOR = new Creator<SkillsItem>() {
		@Override
		public SkillsItem createFromParcel(Parcel in) {
			return new SkillsItem(in);
		}

		@Override
		public SkillsItem[] newArray(int size) {
			return new SkillsItem[size];
		}
	};

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