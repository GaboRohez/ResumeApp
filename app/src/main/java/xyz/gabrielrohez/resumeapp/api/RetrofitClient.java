package xyz.gabrielrohez.resumeapp.api;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.gabrielrohez.resumeapp.constants.AppConstants;

public class RetrofitClient {

    public static Retrofit instance;

    public static Retrofit getInstance() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        if (instance == null){
            instance = new Retrofit.Builder().baseUrl(AppConstants.URL_BASE)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    public static ResumeAPIService getAPI(){
        return getInstance().create(ResumeAPIService.class);
    }
    /*public static Retrofit retrofit;
    private static RetrofitClient retrofitClient;

    private RetrofitClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.URL_BASE)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static RetrofitClient getInstance() {
        if(retrofitClient == null) {
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(AppConstants.URL_BASE)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofitClient;
    }*/
}
