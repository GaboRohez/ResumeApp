package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Languages implements Parcelable {
    @SerializedName("yoe")
    private String yoe;
    @SerializedName("name")
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.yoe);
        dest.writeString(this.name);
    }

    public Languages() {
    }

    protected Languages(Parcel in) {
        this.yoe = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Languages> CREATOR = new Parcelable.Creator<Languages>() {
        @Override
        public Languages createFromParcel(Parcel source) {
            return new Languages(source);
        }

        @Override
        public Languages[] newArray(int size) {
            return new Languages[size];
        }
    };

    public String getYoe() {
        return yoe;
    }

    public void setYoe(String yoe) {
        this.yoe = yoe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "yoe='" + yoe + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
