package xyz.gabrielrohez.resumeapp.config;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;

import xyz.gabrielrohez.resumeapp.R;

public class AppConfig extends Application {

    private static Context mContext;
    public static AndroidResourceManager androidResourceManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        androidResourceManager = new AndroidResourceManager(getResources());
        SystemClock.sleep(2000);
    }

    public static Context getAppContext() {
        return mContext;
    }

    public class AndroidResourceManager {

        private Resources resources;

        public AndroidResourceManager(Resources resources) {
            this.resources = resources;
        }

        public String getRetrofitTimeout() {
            return resources.getString(R.string.retrofit_timeout);
        }

        public String getRetrofitFailure() {
            return resources.getString(R.string.retrofit_failure);
        }

        public String getRetrofitWrongResponse() {
            return resources.getString(R.string.retrofit_wrong_response);
        }

    }
}
