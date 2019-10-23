package xyz.gabrielrohez.resumeapp.base.activity;

import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.ui.dialogs.DialogSplash;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

public class BasicActivity extends AppCompatActivity implements BasicView, BasicUIView, FragmentManager.OnBackStackChangedListener {

    //  https://github.com/material-components/material-components-android/releases
    private DialogSplash dialogSplash;
    private FragmentManager manager = getSupportFragmentManager();

    @Override
    public void showDialog(String message) {

    }

    @Override
    public void showDialogSplash(String message) {
        dialogSplash = DialogSplash.newInstance(message);
        dialogSplash.show(manager, AppConstants.TAG_SPLASH_DIALOG);
    }

    @Override
    public void showLoader(boolean visible) {

    }

    @Override
    public void addFragment(Fragment fragment, String TAG, int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        //fragmentTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up, R.anim.slide_in_bottom,R.anim.slide_out_bottom );
        fragmentManager.addOnBackStackChangedListener(this);
        fragmentTransaction.replace(id, fragment, TAG);
        fragmentTransaction.addToBackStack(TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void replaceFragment(Fragment fragment, String TAG, int id) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment, TAG);
        fragmentTransaction.commit();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false); //  disable arrow back
    }

    @Override
    public void setTitleToolbar(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackStackChanged() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            //getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //  enable arrow back

            //String tagName = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1).getName();

            //Fragment fragment = getSupportFragmentManager().findFragmentByTag(tagName);
            /*if (fragment instanceof MapFragment) {
                //titleBar.setText(getResources().getString(R.string.title_education));
            }*/
        } else {
            //getSupportActionBar().setDisplayHomeAsUpEnabled(false); //  disable arrow back
            //setTitleToolbar(getString(R.string.app_name));
            /*EducationFragment educationFragment =
                    (EducationFragment) getSupportFragmentManager().findFragmentByTag(Constants.TAG_EDUCATION);
            if (educationFragment != null && educationFragment.isVisible()) {
                titleBar.setText(getResources().getString(R.string.title_education));
            }*/
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
