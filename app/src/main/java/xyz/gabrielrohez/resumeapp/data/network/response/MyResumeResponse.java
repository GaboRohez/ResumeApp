package xyz.gabrielrohez.resumeapp.data.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MyResumeResponse implements Parcelable {

    @SerializedName("experience")
    private List<Experience> experience;
    @SerializedName("courses")
    private List<Courses> courses;
    @SerializedName("inter_personal")
    private Inter_personal inter_personal;
    @SerializedName("skills")
    private Skills skills;
    @SerializedName("references")
    private List<References> references;
    @SerializedName("google_play")
    private Google_play google_play;
    @SerializedName("social")
    private Social social;
    @SerializedName("about")
    private About about;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.experience);
        dest.writeList(this.courses);
        dest.writeParcelable(this.inter_personal, flags);
        dest.writeParcelable(this.skills, flags);
        dest.writeList(this.references);
        dest.writeParcelable(this.google_play, flags);
        dest.writeParcelable(this.social, flags);
        dest.writeParcelable(this.about, flags);
    }

    private MyResumeResponse(Parcel in) {
        this.experience = new ArrayList<>();
        in.readList(this.experience, Experience.class.getClassLoader());
        this.courses = new ArrayList<>();
        in.readList(this.courses, Courses.class.getClassLoader());
        this.inter_personal = in.readParcelable(Inter_personal.class.getClassLoader());
        this.skills = in.readParcelable(Skills.class.getClassLoader());
        this.references = new ArrayList<>();
        in.readList(this.references, References.class.getClassLoader());
        this.google_play = in.readParcelable(Google_play.class.getClassLoader());
        this.social = in.readParcelable(Social.class.getClassLoader());
        this.about = in.readParcelable(About.class.getClassLoader());
    }

    public static final Parcelable.Creator<MyResumeResponse> CREATOR = new Parcelable.Creator<MyResumeResponse>() {
        @Override
        public MyResumeResponse createFromParcel(Parcel source) {
            return new MyResumeResponse(source);
        }

        @Override
        public MyResumeResponse[] newArray(int size) {
            return new MyResumeResponse[size];
        }
    };

    public List<Experience> getExperience() {
        return experience;
    }

    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public Inter_personal getInter_personal() {
        return inter_personal;
    }

    public void setInter_personal(Inter_personal inter_personal) {
        this.inter_personal = inter_personal;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public List<References> getReferences() {
        return references;
    }

    public void setReferences(List<References> references) {
        this.references = references;
    }

    public Google_play getGoogle_play() {
        return google_play;
    }

    public void setGoogle_play(Google_play google_play) {
        this.google_play = google_play;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "MyResumeResponse{" +
                "experience=" + experience +
                ", courses=" + courses +
                ", inter_personal=" + inter_personal +
                ", skills=" + skills +
                ", references=" + references +
                ", google_play=" + google_play +
                ", social=" + social +
                ", about=" + about +
                '}';
    }
}
