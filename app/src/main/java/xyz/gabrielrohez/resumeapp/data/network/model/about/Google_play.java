package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Google_play {
    @SerializedName("apps")
    private List<Apps> apps;

    public List<Apps> getApps() {
        return apps;
    }

    public void setApps(List<Apps> apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return "Google_play{" +
                "apps=" + apps +
                '}';
    }
}
