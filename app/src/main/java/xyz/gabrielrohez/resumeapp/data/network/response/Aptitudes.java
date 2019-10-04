package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Aptitudes implements Parcelable {
    @SerializedName("name")
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public Aptitudes() {
    }

    protected Aptitudes(Parcel in) {
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Aptitudes> CREATOR = new Parcelable.Creator<Aptitudes>() {
        @Override
        public Aptitudes createFromParcel(Parcel source) {
            return new Aptitudes(source);
        }

        @Override
        public Aptitudes[] newArray(int size) {
            return new Aptitudes[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Aptitudes{" +
                "name='" + name + '\'' +
                '}';
    }
}
