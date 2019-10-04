package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Experience implements Parcelable {
    @SerializedName("reference")
    private Reference reference;
    @SerializedName("id")
    private int id;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("period")
    private String period;
    @SerializedName("job")
    private String job;
    @SerializedName("name")
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.reference, flags);
        dest.writeInt(this.id);
        dest.writeString(this.longitude);
        dest.writeString(this.latitude);
        dest.writeString(this.period);
        dest.writeString(this.job);
        dest.writeString(this.name);
    }

    public Experience() {
    }

    protected Experience(Parcel in) {
        this.reference = in.readParcelable(Reference.class.getClassLoader());
        this.id = in.readInt();
        this.longitude = in.readString();
        this.latitude = in.readString();
        this.period = in.readString();
        this.job = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Experience> CREATOR = new Parcelable.Creator<Experience>() {
        @Override
        public Experience createFromParcel(Parcel source) {
            return new Experience(source);
        }

        @Override
        public Experience[] newArray(int size) {
            return new Experience[size];
        }
    };

    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "reference=" + reference +
                ", id=" + id +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", period='" + period + '\'' +
                ", job='" + job + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
