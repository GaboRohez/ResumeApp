package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Apps implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private int image;

    protected Apps(Parcel in) {
        name = in.readString();
        url = in.readString();
        image = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
        dest.writeInt(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Apps> CREATOR = new Creator<Apps>() {
        @Override
        public Apps createFromParcel(Parcel in) {
            return new Apps(in);
        }

        @Override
        public Apps[] newArray(int size) {
            return new Apps[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Apps{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", image=" + image +
                '}';
    }
}
