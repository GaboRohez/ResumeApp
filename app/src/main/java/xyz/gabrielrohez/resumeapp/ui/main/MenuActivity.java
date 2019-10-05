package xyz.gabrielrohez.resumeapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.activity.BasicActivity;
import xyz.gabrielrohez.resumeapp.data.network.response.MyResumeResponse;
import xyz.gabrielrohez.resumeapp.ui.about.AboutFragment;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

public class MenuActivity extends BasicActivity {

    private MyResumeResponse response;

    @BindView(R.id.nav_view) BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
        getParcelableData();
        setUpEvents();
        navView.setSelectedItemId(R.id.navigation_profile);
    }

    /**
     * get data from intent
     */
    private void getParcelableData() {
        Intent intent = getIntent();
        response = intent.getParcelableExtra("body");
        Log.i("MENU_ACTIVITY", response.toString());
    }

    /**
     * events of buttons
     */
    private void setUpEvents() {
        navView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_profile:
                    replaceFragment(AboutFragment.newInstance(response.getSocial(), response.getAbout(), response.getSkills(), response.getInter_personal()), AppConstants.TAG_ABOUT_FRAGMENT, R.id.contentFragment);
                    return true;
                case R.id.navigation_school:

                    return true;
                case R.id.navigation_code:

                    return true;
                case R.id.navigation_work:

                    return true;
            }
            return false;
        });
    }
}
