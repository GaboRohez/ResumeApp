package xyz.gabrielrohez.resumeapp.data.network.model.about;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAbout implements Parcelable {


    @SerializedName("about")
    private About about;
    @SerializedName("social")
    private Social social;
    @SerializedName("google_play")
    private Google_play google_play;
    @SerializedName("references")
    private List<References> references;
    @SerializedName("skills")
    private Skills skills;
    @SerializedName("inter_personal")
    private Inter_personal inter_personal;

    protected ResponseAbout(Parcel in) {
        about = in.readParcelable(About.class.getClassLoader());
        google_play = in.readParcelable(Google_play.class.getClassLoader());
        references = in.createTypedArrayList(References.CREATOR);
        inter_personal = in.readParcelable(Inter_personal.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(about, flags);
        dest.writeParcelable(google_play, flags);
        dest.writeTypedList(references);
        dest.writeParcelable(inter_personal, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResponseAbout> CREATOR = new Creator<ResponseAbout>() {
        @Override
        public ResponseAbout createFromParcel(Parcel in) {
            return new ResponseAbout(in);
        }

        @Override
        public ResponseAbout[] newArray(int size) {
            return new ResponseAbout[size];
        }
    };

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    public Google_play getGoogle_play() {
        return google_play;
    }

    public void setGoogle_play(Google_play google_play) {
        this.google_play = google_play;
    }

    public List<References> getReferences() {
        return references;
    }

    public void setReferences(List<References> references) {
        this.references = references;
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    public Inter_personal getInter_personal() {
        return inter_personal;
    }

    public void setInter_personal(Inter_personal inter_personal) {
        this.inter_personal = inter_personal;
    }

    @Override
    public String toString() {
        return "ResponseAbout{" +
                "about=" + about +
                ", social=" + social +
                ", google_play=" + google_play +
                ", references=" + references +
                ", skills=" + skills +
                ", inter_personal=" + inter_personal +
                '}';
    }
}
