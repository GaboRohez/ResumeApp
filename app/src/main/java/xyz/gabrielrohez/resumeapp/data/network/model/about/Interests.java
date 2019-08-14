package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

public class Interests {
    @SerializedName("name")
    private String name;
    @SerializedName("icon")
    private int icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Interests{" +
                "name='" + name + '\'' +
                ", icon=" + icon +
                '}';
    }
}
