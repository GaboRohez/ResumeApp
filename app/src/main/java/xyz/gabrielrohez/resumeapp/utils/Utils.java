package xyz.gabrielrohez.resumeapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import xyz.gabrielrohez.resumeapp.R;

public class Utils {

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
                        .setPositiveButton(activity.getResources().getString(R.string.accept), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, AppConstants.MY_PERMISSIONS_EXTERNAL_STORANGE);
                            }
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
}
