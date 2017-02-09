package com.example.adam.chrono_lux;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Alarm> alarms;

    private CoordinatorLayout mCoordinatorLayout;

    private final int NUM_TABS = 4;


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


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainPageAdapter());


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);




    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void SetupHub(MenuItem item) {
        Intent hubSetupIntent = new Intent(this,PHHubSetup.class);
        final int result = 1;

        startActivityForResult(hubSetupIntent,result);
    }




    class MainPageAdapter extends PagerAdapter {

        private LinearLayout page1;
        private LinearLayout page2;
        private ListView page3;
        private LinearLayout page4;
        private final int[] titles = {R.string.alarm_title, R.string.page2, R.string.page3, R.string.page4};

        @Override
        public int getCount() {
            return NUM_TABS;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            return getString(titles[position]);
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            View page;
            switch (position) {
                case 0:
                    if (page1 == null) {
                        page1 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .alarm_view, collection, false);
                    }
                    page = page1;
                    break;
                case 1:
                    if (page2 == null) {
                        page2 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .page_two, collection, false);
                    }
                    page = page2;
                    break;
                case 2:
                    if (page3 == null) {
                        page3 = (ListView) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .page_three, collection, false);
                        initListView();
                    }
                    page = page3;
                    break;
                default:
                    if (page4 == null) {
                        page4 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .page_four, collection, false);
                    }
                    page = page4;
                    break;
            }

            collection.addView(page, 0);

            return page;
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }



        private void initListView() {
            String[] items = new String[50];
            for (int i = 0; i < 50; i++) {
                items[i] = "Item " + i;
            }
            page3.setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.textview, items));
            page3.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Snackbar.make(mCoordinatorLayout, (String) parent.getItemAtPosition(position), Snackbar.LENGTH_LONG).show();
                }
            });

        }
    }






}
