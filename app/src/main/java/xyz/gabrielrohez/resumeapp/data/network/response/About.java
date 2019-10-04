package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class About implements Parcelable {
    @SerializedName("resume")
    private String resume;
    @SerializedName("location")
    private String location;
    @SerializedName("job")
    private String job;
    @SerializedName("phone")
    private String phone;
    @SerializedName("email")
    private String email;
    @SerializedName("name")
    private String name;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.resume);
        dest.writeString(this.location);
        dest.writeString(this.job);
        dest.writeString(this.phone);
        dest.writeString(this.email);
        dest.writeString(this.name);
    }

    public About() {
    }

    protected About(Parcel in) {
        this.resume = in.readString();
        this.location = in.readString();
        this.job = in.readString();
        this.phone = in.readString();
        this.email = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<About> CREATOR = new Parcelable.Creator<About>() {
        @Override
        public About createFromParcel(Parcel source) {
            return new About(source);
        }

        @Override
        public About[] newArray(int size) {
            return new About[size];
        }
    };

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "About{" +
                "resume='" + resume + '\'' +
                ", location='" + location + '\'' +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
