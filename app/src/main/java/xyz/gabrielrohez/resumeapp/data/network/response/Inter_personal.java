package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Inter_personal implements Parcelable {
    @SerializedName("interests")
    private List<Interests> interests;
    @SerializedName("aptitudes")
    private List<Aptitudes> aptitudes;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.interests);
        dest.writeList(this.aptitudes);
    }

    public Inter_personal() {
    }

    protected Inter_personal(Parcel in) {
        this.interests = new ArrayList<Interests>();
        in.readList(this.interests, Interests.class.getClassLoader());
        this.aptitudes = new ArrayList<Aptitudes>();
        in.readList(this.aptitudes, Aptitudes.class.getClassLoader());
    }

    public static final Parcelable.Creator<Inter_personal> CREATOR = new Parcelable.Creator<Inter_personal>() {
        @Override
        public Inter_personal createFromParcel(Parcel source) {
            return new Inter_personal(source);
        }

        @Override
        public Inter_personal[] newArray(int size) {
            return new Inter_personal[size];
        }
    };

    public List<Interests> getInterests() {
        return interests;
    }

    public void setInterests(List<Interests> interests) {
        this.interests = interests;
    }

    public List<Aptitudes> getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(List<Aptitudes> aptitudes) {
        this.aptitudes = aptitudes;
    }

    @Override
    public String toString() {
        return "Inter_personal{" +
                "interests=" + interests +
                ", aptitudes=" + aptitudes +
                '}';
    }
}
