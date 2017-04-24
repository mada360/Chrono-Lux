package com.example.adam.chrono_lux;

import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.adam.chrono_lux.hue.PHLightManager;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

/**
 * HueApplicationActivity - The starting point for creating your own Hue App.
 * Currently contains a simple view with a button to change your lights to random colours.  Remove this and add your own app implementation here! Have fun!
 *
 * @author SteveyO
 *
 */
public class HueApplicationActivity extends Activity {

    PHLightManager lightManager = new PHLightManager();
    private Button randomButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        setContentView(R.layout.ph_main);


        randomButton = (Button) findViewById(R.id.buttonRand);
        randomButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                lightManager.randomLights();
            }

        });



    }

    @Override
    public void onBackPressed() {
        Intent home = new Intent(this,MainActivity.class);
        final int result = 1;

        startActivityForResult(home,result);
    }
}