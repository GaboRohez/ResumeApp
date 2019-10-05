package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Reference implements Parcelable {
    @SerializedName("job")
    private String job;
    @SerializedName("url")
    private String url;
    @SerializedName("name")
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.job);
        dest.writeString(this.url);
        dest.writeString(this.name);
    }

    public Reference() {
    }

    protected Reference(Parcel in) {
        this.job = in.readString();
        this.url = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Reference> CREATOR = new Parcelable.Creator<Reference>() {
        @Override
        public Reference createFromParcel(Parcel source) {
            return new Reference(source);
        }

        @Override
        public Reference[] newArray(int size) {
            return new Reference[size];
        }
    };

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reference{" +
                "job='" + job + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
