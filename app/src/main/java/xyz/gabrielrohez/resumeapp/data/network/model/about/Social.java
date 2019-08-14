package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

public class Social {
    @SerializedName("web")
    private String web;
    @SerializedName("playstore")
    private String playstore;
    @SerializedName("github")
    private String github;

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getPlaystore() {
        return playstore;
    }

    public void setPlaystore(String playstore) {
        this.playstore = playstore;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        return "Social{" +
                "web='" + web + '\'' +
                ", playstore='" + playstore + '\'' +
                ", github='" + github + '\'' +
                '}';
    }
}
