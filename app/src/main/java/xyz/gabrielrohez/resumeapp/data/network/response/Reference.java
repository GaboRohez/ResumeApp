package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Reference implements Parcelable {
    @SerializedName("job")
    private String job;
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
        dest.writeString(this.job);
        dest.writeString(this.phone);
        dest.writeString(this.name);
    }

    public Reference() {
    }

    protected Reference(Parcel in) {
        this.job = in.readString();
        this.phone = in.readString();
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

    public String getphone() {
        return phone;
    }

    public void setphone(String phone) {
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
        return "Reference{" +
                "job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
