package xyz.gabrielrohez.resumeapp.ui.splash.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import xyz.gabrielrohez.resumeapp.model.ResumeResponse;

public class SplashViewModel  extends AndroidViewModel {

    public static final String TAG = "SplashViewModel";

    private LiveData<ResumeResponse> mResume;
    private SplashRepository mSplashRepository;

    public SplashViewModel(@NonNull Application application) {
        super(application);
        Log.d(TAG, "CONSTRUCTOR");
        this.mSplashRepository = SplashRepository.getInstance();
        this.mResume = mSplashRepository.getResumeResponse();
    }

    public LiveData<ResumeResponse> getResume(){
        Log.d(TAG, "GET_FLIGHT_PLANS");
        return mResume;
    }

}

