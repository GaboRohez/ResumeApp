package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Inter_personal {
    @SerializedName("aptitudes")
    private List<Aptitudes> aptitudes;
    @SerializedName("interests")
    private List<Interests> interests;

    public List<Aptitudes> getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(List<Aptitudes> aptitudes) {
        this.aptitudes = aptitudes;
    }

    public List<Interests> getInterests() {
        return interests;
    }

    public void setInterests(List<Interests> interests) {
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "Inter_personal{" +
                "aptitudes=" + aptitudes +
                ", interests=" + interests +
                '}';
    }
}
