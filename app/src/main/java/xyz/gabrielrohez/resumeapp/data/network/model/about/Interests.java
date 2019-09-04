package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Interests implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("icon")
    private int icon;

    protected Interests(Parcel in) {
        name = in.readString();
        icon = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(icon);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Interests> CREATOR = new Creator<Interests>() {
        @Override
        public Interests createFromParcel(Parcel in) {
            return new Interests(in);
        }

        @Override
        public Interests[] newArray(int size) {
            return new Interests[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Interests{" +
                "name='" + name + '\'' +
                ", icon=" + icon +
                '}';
    }
}
