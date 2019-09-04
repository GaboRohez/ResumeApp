package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Languages implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("yoe")
    private String yoe;

    protected Languages(Parcel in) {
        name = in.readString();
        yoe = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(yoe);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Languages> CREATOR = new Creator<Languages>() {
        @Override
        public Languages createFromParcel(Parcel in) {
            return new Languages(in);
        }

        @Override
        public Languages[] newArray(int size) {
            return new Languages[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYoe() {
        return yoe;
    }

    public void setYoe(String yoe) {
        this.yoe = yoe;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "name='" + name + '\'' +
                ", yoe='" + yoe + '\'' +
                '}';
    }
}
