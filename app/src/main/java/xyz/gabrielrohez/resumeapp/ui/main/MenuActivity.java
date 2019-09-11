package xyz.gabrielrohez.resumeapp.ui.main;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.activity.BasicActivity;

public class MenuActivity extends BasicActivity {

    @BindView(R.id.nav_view) BottomNavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        setUpEvents();
    }

    private void setUpEvents() {
        navView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_profile:

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
