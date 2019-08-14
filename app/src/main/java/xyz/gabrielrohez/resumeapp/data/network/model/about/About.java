package xyz.gabrielrohez.resumeapp.data.network.model.about;

import com.google.gson.annotations.SerializedName;

public class About {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;
    @SerializedName("job")
    private String job;
    @SerializedName("location")
    private String location;
    @SerializedName("resume")
    private String resume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "About{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", job='" + job + '\'' +
                ", location='" + location + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }
}
