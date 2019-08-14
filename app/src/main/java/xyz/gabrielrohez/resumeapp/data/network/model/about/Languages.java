package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

public class Languages {
    @SerializedName("name")
    private String name;
    @SerializedName("yoe")
    private String yoe;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYoe() {
        return yoe;
    }

    public void setYoe(String yoe) {
        this.yoe = yoe;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "name='" + name + '\'' +
                ", yoe='" + yoe + '\'' +
                '}';
    }
}
