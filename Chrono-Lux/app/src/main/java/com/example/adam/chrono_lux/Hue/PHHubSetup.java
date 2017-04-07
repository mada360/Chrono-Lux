package com.example.adam.chrono_lux.hue;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.adam.chrono_lux.R;
import com.philips.lighting.hue.sdk.PHHueSDK;


/**
 * Created by adam on 17/01/17.
 */

public class PHHubSetup extends AppCompatActivity {

    private PHHueSDK phHueSDK;
    private static final int MAX_HUE=65535;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hub_setup_view);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Hub Set-up");
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

    }
}
