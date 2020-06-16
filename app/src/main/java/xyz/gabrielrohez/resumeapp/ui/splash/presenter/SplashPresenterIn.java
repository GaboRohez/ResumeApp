package xyz.gabrielrohez.resumeapp.ui.splash.presenter;

import xyz.gabrielrohez.resumeapp.model.ResumeResponse;

public interface SplashPresenterIn {

    interface Listener{
        void errorInWS(String message);
        void openResume(ResumeResponse response);
    }

    interface Presenter{
        void getResumeInfo();
    }
}
