package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

public class References {
    @SerializedName("name")
    private String name;
    @SerializedName("phone")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "References{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
