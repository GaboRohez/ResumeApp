package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAbout {


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
