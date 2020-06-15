package xyz.gabrielrohez.resumeapp.api;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import xyz.gabrielrohez.resumeapp.model.ResumeResponse;

public interface ResumeAPIService {

    @GET("resume.json")
    Observable<ResumeResponse> getResume();
}
