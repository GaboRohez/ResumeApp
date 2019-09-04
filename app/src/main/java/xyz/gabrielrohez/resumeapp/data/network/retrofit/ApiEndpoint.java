package xyz.gabrielrohez.resumeapp.data.network.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import xyz.gabrielrohez.resumeapp.data.network.model.about.ResponseAbout;

public interface ApiEndpoint {

    @GET("about.json")
    Call<ResponseAbout> getPersonalInfo();
}
