package xyz.gabrielrohez.resumeapp.custom;

import android.Manifest;
import android.app.Dialog;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.data.network.response.Courses;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

import static android.content.ContentValues.TAG;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    private Courses data;
    @BindView(R.id.bsTitle) TextView tvTitle;

    public BottomSheetFragment(Courses courses) {
        data = courses;
    }

    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getActivity(), R.layout.bottom_sheet, null);
        ButterKnife.bind(this, contentView);

        dialog.setContentView(contentView);
        dialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(R.drawable.rounded_dialog);

        //  title of document
        tvTitle.setText(data.getInstitute());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @OnClick({R.id.bsDownload, R.id.bsShared})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bsDownload:
                if (permissionExternalStorange())
                    downloadImage(AppConstants.PDF_FILE.getNameFromId(data.getImage()));
                break;
            case R.id.bsShared:
                Log.i("BottomSheetFragment", "Shared");
                break;
        }
    }

    private boolean permissionExternalStorange() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                return false;
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                return false;
            }
        }else {
            return true;
        }
    }

    private void downloadImage(String fileName) {
        String dirtPath = "/storage/emulated/0/ResumeApp";
        File dir = new File(dirtPath);
        if (!dir.exists())
            dir.mkdirs();

        AssetManager assetManager = getActivity().getAssets();
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = assetManager.open(fileName);
            File outFile = new File(dirtPath, fileName);
            outputStream = new FileOutputStream(outFile);
            copyFile(inputStream, outputStream);
            Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
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

    private void copyFile(InputStream inputStream, OutputStream outputStream) {
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
}
