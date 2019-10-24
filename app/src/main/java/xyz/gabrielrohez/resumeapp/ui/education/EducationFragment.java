package xyz.gabrielrohez.resumeapp.ui.education;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.adapters.EducationAdapter;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;
import xyz.gabrielrohez.resumeapp.config.AppConfig;
import xyz.gabrielrohez.resumeapp.custom.BottomSheetFragment;
import xyz.gabrielrohez.resumeapp.data.network.response.Courses;
import xyz.gabrielrohez.resumeapp.ui.documentVisor.DocumentFragment;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;
import xyz.gabrielrohez.resumeapp.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends BasicFragment implements EducationAdapter.EducationInterface, Utils.SaveImageInDevice.AsyncResponse {

    @BindView(R.id.rootSnack) LinearLayout contentSnackBar;
    @BindView(R.id.educationRecycler) RecyclerView recycler;

    private String fileNamePDF;
    private List<Courses> courses;
    private Utils.SaveImageInDevice saveImageInDevice = new Utils.SaveImageInDevice(this);

    public static EducationFragment newInstance(List<Courses> courses) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("courses", (ArrayList<? extends Parcelable>) courses);
        EducationFragment fragment = new EducationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_education, container, false);
        ButterKnife.bind(this, rootView);
        getParcelableData();
        setEducationRecyclerView();

        return rootView;
    }

    /**
     * get data from bundle
     */
    private void getParcelableData() {
        courses = getArguments().getParcelableArrayList("courses");
        Log.i("EDUCATION-courses", courses.toString());
    }

    /**
     * the information is shown in the recycler
     */
    private void setEducationRecyclerView() {
        EducationAdapter adapter = new EducationAdapter(courses, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * show pdf
     */
    @Override
    public void ItemViewClick(Courses courses) {
        basicView.addFragment(DocumentFragment.newInstance(AppConstants.PDF_FILE.getNameFromId(courses.getImage())), AppConstants.TAG_DOCUMENT_FRAGMENT, R.id.contentFragment);
    }

    /**
     * open bottom sheet
     */
    @Override
    public void MenuOnClick(Courses courses) {
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment(courses, new BottomSheetFragment.ActionsInterface() {
            @Override
            public void downloadFile(String fileName) {
                fileNamePDF = fileName;
                if (Utils.checkPermissionExternalStorange(getActivity(), AppConstants.MY_PERMISSIONS_EXTERNAL_STORANGE_DOWNLOAD))
                    saveImageInDevice.execute(fileName);
            }

            @Override
            public void sharedFile(String fileName) {
                fileNamePDF = fileName;
                if (Utils.checkPermissionExternalStorange(getActivity(), AppConstants.MY_PERMISSIONS_EXTERNAL_STORANGE_SHARED))
                    Utils.sharedPDF(fileName, getActivity());
            }
        });
        bottomSheetFragment.show(getFragmentManager(), bottomSheetFragment.getTag());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case AppConstants.MY_PERMISSIONS_EXTERNAL_STORANGE_DOWNLOAD:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    saveImageInDevice.execute(fileNamePDF);
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Snackbar.make(contentSnackBar, AppConfig.getAppContext().getResources().getString(R.string.rejected_permission), Snackbar.LENGTH_LONG).setAction(AppConfig.getAppContext().getResources().getString(R.string.accept), v -> {
                    }).show();
                }
                break;
            case AppConstants.MY_PERMISSIONS_EXTERNAL_STORANGE_SHARED:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Utils.sharedPDF(fileNamePDF, getActivity());
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Snackbar.make(contentSnackBar, AppConfig.getAppContext().getResources().getString(R.string.rejected_permission), Snackbar.LENGTH_LONG).setAction(AppConfig.getAppContext().getResources().getString(R.string.accept), v -> {
                    }).show();
                }
                break;
        }
    }

    //  process finish SAVE IMAGE IN DEVICE
    @Override
    public void processFinish(boolean bool) {
        if (bool){
            Snackbar.make(contentSnackBar, AppConfig.getAppContext().getResources().getString(R.string.file_saved), Snackbar.LENGTH_LONG).show();
            Log.i("SAVE-FILE", "onPostExecute(): "+ true);
        } else {
            Snackbar.make(contentSnackBar, AppConfig.getAppContext().getResources().getString(R.string.error_saving_file), Snackbar.LENGTH_LONG).setAction(AppConfig.getAppContext().getResources().getString(R.string.accept), null).show();
            Log.i("SAVE-FILE", "onPostExecute(): "+ false);
        }
    }
}
