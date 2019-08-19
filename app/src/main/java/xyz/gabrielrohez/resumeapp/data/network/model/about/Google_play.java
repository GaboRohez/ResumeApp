package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Google_play implements Parcelable {
    @SerializedName("apps")
    private List<Apps> apps;

    protected Google_play(Parcel in) {
        apps = in.createTypedArrayList(Apps.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(apps);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Google_play> CREATOR = new Creator<Google_play>() {
        @Override
        public Google_play createFromParcel(Parcel in) {
            return new Google_play(in);
        }

        @Override
        public Google_play[] newArray(int size) {
            return new Google_play[size];
        }
    };

    public List<Apps> getApps() {
        return apps;
    }

    public void setApps(List<Apps> apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return "Google_play{" +
                "apps=" + apps +
                '}';
    }
}
