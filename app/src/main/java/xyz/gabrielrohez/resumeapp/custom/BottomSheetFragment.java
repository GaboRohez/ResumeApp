package xyz.gabrielrohez.resumeapp.custom;

import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.data.network.response.Courses;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;
import xyz.gabrielrohez.resumeapp.utils.Utils;

public class BottomSheetFragment extends BottomSheetDialogFragment implements Utils.SaveImageInDevice.AsyncResponse {

    private final LinearLayout contentSnackBar;

    private Courses data;
    private Utils.SaveImageInDevice saveImageInDevice = new Utils.SaveImageInDevice(this);

    @BindView(R.id.bsTitle) TextView tvTitle;

    public BottomSheetFragment(Courses courses, LinearLayout contentSnackBar) {
        this.data = courses;
        this.contentSnackBar = contentSnackBar;
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
    void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bsDownload:
                if (Utils.checkPermissionExternalStorange(getActivity()))
                    saveImageInDevice.execute(AppConstants.PDF_FILE.getNameFromId(data.getImage()));
                break;
            case R.id.bsShared:
                if (Utils.checkPermissionExternalStorange(getActivity()))
                    Utils.sharedPDF(AppConstants.PDF_FILE.getNameFromId(data.getImage()));
                break;

        }
        //  hide dialog
        getDialog().dismiss();
    }

    //  process finish SAVE IMAGE IN DEVICE
    @Override
    public void processFinish(boolean bool) {

        if (bool){
            Snackbar.make(contentSnackBar, "Saved", Snackbar.LENGTH_SHORT).show();
            Log.i("SAVE-FILE", "onPostExecute(): "+ true);
        } else {
            Snackbar.make(contentSnackBar, "Error", Snackbar.LENGTH_SHORT).show();
            Log.i("SAVE-FILE", "onPostExecute(): "+ false);
        }

    }
}
