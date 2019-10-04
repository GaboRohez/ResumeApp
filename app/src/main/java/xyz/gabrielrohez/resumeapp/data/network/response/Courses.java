package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Courses implements Parcelable {
    @SerializedName("image")
    private String image;
    @SerializedName("id")
    private String id;
    @SerializedName("period")
    private String period;
    @SerializedName("grade")
    private String grade;
    @SerializedName("institute")
    private String institute;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.image);
        dest.writeString(this.id);
        dest.writeString(this.period);
        dest.writeString(this.grade);
        dest.writeString(this.institute);
    }

    public Courses() {
    }

    protected Courses(Parcel in) {
        this.image = in.readString();
        this.id = in.readString();
        this.period = in.readString();
        this.grade = in.readString();
        this.institute = in.readString();
    }

    public static final Parcelable.Creator<Courses> CREATOR = new Parcelable.Creator<Courses>() {
        @Override
        public Courses createFromParcel(Parcel source) {
            return new Courses(source);
        }

        @Override
        public Courses[] newArray(int size) {
            return new Courses[size];
        }
    };

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "image='" + image + '\'' +
                ", id='" + id + '\'' +
                ", period='" + period + '\'' +
                ", grade='" + grade + '\'' +
                ", institute='" + institute + '\'' +
                '}';
    }
}
