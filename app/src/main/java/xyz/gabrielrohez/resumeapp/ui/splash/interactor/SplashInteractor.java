package xyz.gabrielrohez.resumeapp.ui.splash.interactor;

import android.util.Log;

import androidx.lifecycle.ViewModelProviders;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import xyz.gabrielrohez.resumeapp.api.ResumeAPIService;
import xyz.gabrielrohez.resumeapp.api.RetrofitClient;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashPresenterIn;
import xyz.gabrielrohez.resumeapp.utils.AppUtils;

public class SplashInteractor implements SplashInteractorIn {

    @Override
    public void getResumeInfo(SplashPresenterIn.Listener listener) {


        /*if (AppUtils.internetIsConnected()){
            CompositeDisposable disposable = new CompositeDisposable();
            disposable.add(RetrofitClient.getInstance().retrofit.create(ResumeAPIService.class).getResume()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(response -> {
                        listener.openResume(response);
                    }, throwable -> {
                        listener.errorInWS("An error occurred with the server, please try again later");
                    }));
        }else
            listener.errorInWS("We detected that you don't have an internet connection");*/
    }
}
