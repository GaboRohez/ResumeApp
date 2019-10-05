package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Google_play implements Parcelable {
    @SerializedName("apps")
    private List<Apps> apps;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.apps);
    }

    public Google_play() {
    }

    protected Google_play(Parcel in) {
        this.apps = new ArrayList<Apps>();
        in.readList(this.apps, Apps.class.getClassLoader());
    }

    public static final Parcelable.Creator<Google_play> CREATOR = new Parcelable.Creator<Google_play>() {
        @Override
        public Google_play createFromParcel(Parcel source) {
            return new Google_play(source);
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
