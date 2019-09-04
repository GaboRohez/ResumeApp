package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Inter_personal implements Parcelable {
    @SerializedName("aptitudes")
    private List<Aptitudes> aptitudes;
    @SerializedName("interests")
    private List<Interests> interests;

    protected Inter_personal(Parcel in) {
        aptitudes = in.createTypedArrayList(Aptitudes.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(aptitudes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Inter_personal> CREATOR = new Creator<Inter_personal>() {
        @Override
        public Inter_personal createFromParcel(Parcel in) {
            return new Inter_personal(in);
        }

        @Override
        public Inter_personal[] newArray(int size) {
            return new Inter_personal[size];
        }
    };

    public List<Aptitudes> getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(List<Aptitudes> aptitudes) {
        this.aptitudes = aptitudes;
    }

    public List<Interests> getInterests() {
        return interests;
    }

    public void setInterests(List<Interests> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "Inter_personal{" +
                "aptitudes=" + aptitudes +
                ", interests=" + interests +
                '}';
    }
}
