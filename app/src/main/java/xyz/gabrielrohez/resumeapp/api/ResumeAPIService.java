package xyz.gabrielrohez.resumeapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import xyz.gabrielrohez.resumeapp.model.ResumeResponse;

public interface ResumeAPIService {

    @GET("resume.json")
    Call<ResumeResponse> getResume();
}
