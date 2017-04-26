package com.example.adam.chrono_lux;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.adam.chrono_lux.hue.PHHomeActivity;
import com.example.adam.chrono_lux.hue.PHLightManager;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHLight;


public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout mCoordinatorLayout;
    private String tabName;

    private final String TAG = "Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Alarm"));
        tabLayout.addTab(tabLayout.newTab().setText("Light"));
        tabLayout.addTab(tabLayout.newTab().setText("Test"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabName = (String) tabLayout.getTabAt(0).getText();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabName = (String) tab.getText();

                viewPager.setCurrentItem(tab.getPosition());
                Log.i(TAG, tabName);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void SetupHub(MenuItem item) {
        hubConfigure();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;

    }

    public void settings(MenuItem item) {

        CoordinatorLayout layout;

        Log.i(TAG, tabName);
        switch (tabName) {
            case "Light":
                layout = (CoordinatorLayout) findViewById(R.id.alarm_view);
                break;
            case "Test":
                layout = (CoordinatorLayout) findViewById(R.id.test_view);
                break;
            default:
                layout = mCoordinatorLayout;
                break;
        }

        Snackbar.make(layout, "I am just an egg", Snackbar.LENGTH_LONG).show();
    }

    private void hubConfigure(){
        Intent hubSetupIntent = new Intent(this,PHHomeActivity.class);
        final int result = 1;

        startActivityForResult(hubSetupIntent,result);
    }


}