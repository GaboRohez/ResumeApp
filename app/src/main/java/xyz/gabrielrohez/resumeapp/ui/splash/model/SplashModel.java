package xyz.gabrielrohez.resumeapp.ui.splash.model;

import android.util.Log;

import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.gabrielrohez.resumeapp.base.presenter.BasicUIListener;
import xyz.gabrielrohez.resumeapp.config.AppConfig;
import xyz.gabrielrohez.resumeapp.data.network.model.about.ResponseAbout;
import xyz.gabrielrohez.resumeapp.data.network.retrofit.ApiEndpoint;
import xyz.gabrielrohez.resumeapp.data.network.retrofit.RetrofitClient;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashListener;

public class SplashModel implements SplashModelIn {

    @Override
    public void getPersonalInfo(final SplashListener listener, final BasicUIListener basicUIListener) {
        basicUIListener.showLoader(true);
        RetrofitClient.getInstance().retrofit.create(ApiEndpoint.class).getPersonalInfo().enqueue(new Callback<ResponseAbout>() {
            @Override
            public void onResponse(Call<ResponseAbout> call, Response<ResponseAbout> response) {
                Log.d("APP_LOG", "retrofit onResponse");
                basicUIListener.showLoader(false);
                if (response.isSuccessful()){
                    listener.openProfile(response.body());
                }else {
                    basicUIListener.showDialogSplash(AppConfig.androidResourceManager.getRetrofitWrongResponse());
                }
            }

            @Override
            public void onFailure(Call<ResponseAbout> call, Throwable t) {
                Log.d("APP_LOG", "retrofit onFailure");
                basicUIListener.showLoader(false);
                if(t instanceof SocketTimeoutException) {
                    basicUIListener.showDialogSplash(AppConfig.androidResourceManager.getRetrofitTimeout());
                } else {
                    basicUIListener.showDialogSplash(AppConfig.androidResourceManager.getRetrofitFailure());
                }
            }
        });
    }
}
