package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class References implements Parcelable {

    @SerializedName("phone")
    private String phone;
    @SerializedName("name")
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.phone);
        dest.writeString(this.name);
    }

    public References() {
    }

    protected References(Parcel in) {
        this.phone = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<References> CREATOR = new Parcelable.Creator<References>() {
        @Override
        public References createFromParcel(Parcel source) {
            return new References(source);
        }

        @Override
        public References[] newArray(int size) {
            return new References[size];
        }
    };

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "References{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
