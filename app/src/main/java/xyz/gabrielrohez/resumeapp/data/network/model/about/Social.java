package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Social implements Parcelable {
    @SerializedName("web")
    private String web;
    @SerializedName("playstore")
    private String playstore;
    @SerializedName("github")
    private String github;

    protected Social(Parcel in) {
        web = in.readString();
        playstore = in.readString();
        github = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(web);
        dest.writeString(playstore);
        dest.writeString(github);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Social> CREATOR = new Creator<Social>() {
        @Override
        public Social createFromParcel(Parcel in) {
            return new Social(in);
        }

        @Override
        public Social[] newArray(int size) {
            return new Social[size];
        }
    };

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPlaystore() {
        return playstore;
    }

    public void setPlaystore(String playstore) {
        this.playstore = playstore;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "Social{" +
                "web='" + web + '\'' +
                ", playstore='" + playstore + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}
