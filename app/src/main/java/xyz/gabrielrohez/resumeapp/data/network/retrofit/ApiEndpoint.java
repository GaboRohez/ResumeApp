package xyz.gabrielrohez.resumeapp.data.network.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import xyz.gabrielrohez.resumeapp.data.network.response.MyResumeResponse;

public interface ApiEndpoint {

    @GET("my_resume.json")
    Call<MyResumeResponse> getPersonalInfo();
}
