package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Skills {
    @SerializedName("languages")
    private List<Languages> languages;

    public List<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Languages> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "languages=" + languages +
                '}';
    }
}
