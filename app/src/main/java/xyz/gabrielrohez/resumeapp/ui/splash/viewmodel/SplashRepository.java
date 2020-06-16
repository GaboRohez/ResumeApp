package xyz.gabrielrohez.resumeapp.ui.splash.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.gabrielrohez.resumeapp.api.ResumeAPIService;
import xyz.gabrielrohez.resumeapp.api.RetrofitClient;
import xyz.gabrielrohez.resumeapp.model.ResumeResponse;

public class SplashRepository {

    private static final String TAG = "SplashRepository";

    private static SplashRepository instance;
    private ResumeAPIService mRestApi;

    private SplashRepository() {
        Log.d(TAG, "CONSTRUCTOR");

        mRestApi = RetrofitClient.getAPI();
    }

    public static SplashRepository getInstance() {
        Log.d(TAG, "GET_INSTANCE");

        if (instance == null) {
            instance = new SplashRepository();
        }
        return instance;
    }

    public MutableLiveData<ResumeResponse> getResumeResponse() {

        final MutableLiveData<ResumeResponse> data = new MutableLiveData<>();

        mRestApi.getResume().enqueue(new Callback<ResumeResponse>() {
            @Override
            public void onResponse(Call<ResumeResponse> call, Response<ResumeResponse> response) {
                if (response.code() == 200) {

                    data.setValue(response.body());
                    Log.d(TAG + "res", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<ResumeResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        /*mRestApi.getResume().enqueue(new Callback<List<FlightPlan>>() {
            @Override
            public void onResponse(Call<List<FlightPlan>> call, Response<List<FlightPlan>> response) {
                if (response.code() == 200) {
                    List<FlightPlan> temp = response.body();
                    for (FlightPlan flightPlan : temp) {
                        Log.d(TAG + "res", flightPlan.toString());
                    }
                    data.setValue(response.body());
                    Log.d(TAG + "res", response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<FlightPlan>> call, Throwable t) {
                List<FlightPlan> flightPlans = new ArrayList<>();
                flightPlans.add(new FlightPlan(0, "Test", 3.551, 50.52, 3.55122, 50.52625));
                data.setValue(flightPlans);
                Log.d(TAG, t.getMessage());
            }
        });*/

        return data;
    }

}
