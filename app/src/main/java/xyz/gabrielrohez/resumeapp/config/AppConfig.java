package xyz.gabrielrohez.resumeapp.config;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;

public class AppConfig extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
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

        /*public String getNoPerfil() {
            return resources.getString(R.string.no_perfil);
        }*/

    }
}
