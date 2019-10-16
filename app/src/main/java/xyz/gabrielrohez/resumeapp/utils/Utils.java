package xyz.gabrielrohez.resumeapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.config.AppConfig;

public class Utils {

    /**
     *  check permission
     * @return  bool: true or false
     */
    public static boolean checkPermissionExternalStorange(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new MaterialAlertDialogBuilder(activity, R.style.AlertDialogTheme)
                        .setCancelable(false)
                        .setTitle(activity.getResources().getString(R.string.permission))
                        .setMessage(activity.getResources().getString(R.string.permission_description))
                        .setPositiveButton(activity.getResources().getString(R.string.accept), (dialogInterface, i) -> {
                            //Prompt the user once explanation has been shown
                            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, AppConstants.MY_PERMISSIONS_EXTERNAL_STORANGE);
                        }).create().show();
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, AppConstants.MY_PERMISSIONS_EXTERNAL_STORANGE);
            }
            return false;
        } else {
            return true;
        }
    }

    /**
     * Download pdf
     */
    public static class SaveImageInDevice extends AsyncTask<String, Integer, Boolean> {

        private AsyncResponse listener;

        public interface AsyncResponse {
            void processFinish(boolean bool);
        }

        public SaveImageInDevice(AsyncResponse listener) {
            this.listener = listener;
        }

        @Override
        protected Boolean doInBackground(String... fileName) {
            String dirtPath = AppConstants.PATH_APP;
            File dir = new File(dirtPath);
            if (!dir.exists())
                dir.mkdirs();

            AssetManager assetManager = AppConfig.getAppContext().getAssets();
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                inputStream = assetManager.open(fileName[0]);
                File outFile = new File(dirtPath, fileName[0]);
                outputStream = new FileOutputStream(outFile);
                copyFile(inputStream, outputStream);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            } finally {
                if (inputStream != null){
                    try {
                        inputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                if (outputStream != null){
                    try {
                        outputStream.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.i("SAVE-FILE", "onProgressUpdate(): " + values[0]);

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            listener.processFinish(aBoolean);
            Log.i("SAVE-FILE", "onPostExecute(): "+aBoolean);
        }
    }

    /**
     *
     */
    private static void copyFile(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, read);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * shared file
     * @param fileName String: name of file
     */
    public static void sharedPDF(String fileName) {
        SaveImageInDevice saveImageInDevice = new SaveImageInDevice(bool -> {
            //  process finish
            if (bool){
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                Uri phototUri = Uri.parse(AppConstants.PATH_APP+fileName);
                shareIntent.setData(phototUri);
                shareIntent.setType("pdf/*");
                shareIntent.putExtra(Intent.EXTRA_STREAM, phototUri);
                AppConfig.getAppContext().startActivity(Intent.createChooser(shareIntent, AppConfig.getAppContext().getResources().getString(R.string.shared_via)));

            } else {
                Log.i("SHARED-FILE", "onPostExecute(): "+ false);
            }
        });
        saveImageInDevice.execute(fileName);

    }


}
