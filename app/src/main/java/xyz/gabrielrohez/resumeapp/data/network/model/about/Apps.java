package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

public class Apps {
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private int image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Apps{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", image=" + image +
                '}';
    }
}
