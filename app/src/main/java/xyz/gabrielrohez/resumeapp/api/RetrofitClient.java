package xyz.gabrielrohez.resumeapp.api;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.gabrielrohez.resumeapp.constants.AppConstants;

public class RetrofitClient {

        public static Retrofit retrofit;
        private static xyz.gabrielrohez.resumeapp.api.RetrofitClient retrofitClient;

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

        public static xyz.gabrielrohez.resumeapp.api.RetrofitClient getInstance() {
            if(retrofitClient == null) {
                retrofitClient = new RetrofitClient();
            }
            return retrofitClient;
        }
}
