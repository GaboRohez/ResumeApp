package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

public class Aptitudes {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Aptitudes{" +
                "name='" + name + '\'' +
                '}';
    }
}
