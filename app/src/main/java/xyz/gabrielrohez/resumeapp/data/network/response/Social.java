package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Social implements Parcelable {

    @SerializedName("github")
    private String github;
    @SerializedName("playstore")
    private String playstore;
    @SerializedName("web")
    private String web;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.github);
        dest.writeString(this.playstore);
        dest.writeString(this.web);
    }

    public Social() {
    }

    protected Social(Parcel in) {
        this.github = in.readString();
        this.playstore = in.readString();
        this.web = in.readString();
    }

    public static final Parcelable.Creator<Social> CREATOR = new Parcelable.Creator<Social>() {
        @Override
        public Social createFromParcel(Parcel source) {
            return new Social(source);
        }

        @Override
        public Social[] newArray(int size) {
            return new Social[size];
        }
    };

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getPlaystore() {
        return playstore;
    }

    public void setPlaystore(String playstore) {
        this.playstore = playstore;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "Social{" +
                "github='" + github + '\'' +
                ", playstore='" + playstore + '\'' +
                ", web='" + web + '\'' +
                '}';
    }
}
