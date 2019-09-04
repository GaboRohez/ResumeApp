package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Skills implements Parcelable {
    @SerializedName("languages")
    private List<Languages> languages;

    protected Skills(Parcel in) {
        languages = in.createTypedArrayList(Languages.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(languages);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Skills> CREATOR = new Creator<Skills>() {
        @Override
        public Skills createFromParcel(Parcel in) {
            return new Skills(in);
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
