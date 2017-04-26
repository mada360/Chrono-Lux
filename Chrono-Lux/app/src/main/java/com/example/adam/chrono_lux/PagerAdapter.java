package com.example.adam.chrono_lux;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.adam.chrono_lux.alarm.AlarmFragment;
import com.example.adam.chrono_lux.light.LightFragment;
import com.example.adam.chrono_lux.test.TestFragment;

/**
 * Created by Adam on 28/02/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter { int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                AlarmFragment alarmTab = new AlarmFragment();
                return alarmTab;
            case 1:
                LightFragment lightTab = new LightFragment();
                return lightTab;
            case 2:
                TestFragment tab3 = new TestFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}