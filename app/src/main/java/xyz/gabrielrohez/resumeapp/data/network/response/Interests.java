package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Interests implements Parcelable {
    @SerializedName("icon")
    private int icon;
    @SerializedName("name")
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.icon);
        dest.writeString(this.name);
    }

    public Interests() {
    }

    protected Interests(Parcel in) {
        this.icon = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Interests> CREATOR = new Parcelable.Creator<Interests>() {
        @Override
        public Interests createFromParcel(Parcel source) {
            return new Interests(source);
        }

        @Override
        public Interests[] newArray(int size) {
            return new Interests[size];
        }
    };

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Interests{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                '}';
    }
}
