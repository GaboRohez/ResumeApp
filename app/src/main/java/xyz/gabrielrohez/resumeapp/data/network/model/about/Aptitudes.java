package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Aptitudes implements Parcelable {
    @SerializedName("name")
    private String name;

    protected Aptitudes(Parcel in) {
        name = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Aptitudes> CREATOR = new Creator<Aptitudes>() {
        @Override
        public Aptitudes createFromParcel(Parcel in) {
            return new Aptitudes(in);
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
