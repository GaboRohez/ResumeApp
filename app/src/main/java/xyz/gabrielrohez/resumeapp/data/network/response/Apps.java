package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Apps implements Parcelable {
    @SerializedName("image")
    private int image;
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
        dest.writeInt(this.image);
        dest.writeString(this.url);
        dest.writeString(this.name);
    }

    public Apps() {
    }

    protected Apps(Parcel in) {
        this.image = in.readInt();
        this.url = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Apps> CREATOR = new Parcelable.Creator<Apps>() {
        @Override
        public Apps createFromParcel(Parcel source) {
            return new Apps(source);
        }

        @Override
        public Apps[] newArray(int size) {
            return new Apps[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
        return "Apps{" +
                "image=" + image +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
