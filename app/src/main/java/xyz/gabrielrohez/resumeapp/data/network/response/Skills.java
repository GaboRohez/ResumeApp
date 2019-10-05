package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Skills implements Parcelable {

    @SerializedName("languages")
    private List<Languages> languages;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.languages);
    }

    public Skills() {
    }

    protected Skills(Parcel in) {
        this.languages = new ArrayList<Languages>();
        in.readList(this.languages, Languages.class.getClassLoader());
    }

    public static final Parcelable.Creator<Skills> CREATOR = new Parcelable.Creator<Skills>() {
        @Override
        public Skills createFromParcel(Parcel source) {
            return new Skills(source);
        }

        @Override
        public Skills[] newArray(int size) {
            return new Skills[size];
        }
    };

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "languages=" + languages +
                '}';
    }
}
