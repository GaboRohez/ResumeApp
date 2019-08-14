package xyz.gabrielrohez.resumeapp.data.network.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

public class RetrofitClient {

    private static RetrofitClient retrofitClient;
    public Retrofit retrofit;

    private RetrofitClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        //loggin (just for testing)
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        //http client
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(false)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

    }

    public static RetrofitClient getInstance() {
        if(retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }
}
