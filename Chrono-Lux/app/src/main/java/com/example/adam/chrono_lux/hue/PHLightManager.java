package com.example.adam.chrono_lux.hue;

import android.util.Log;

import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Adam on 11/04/2017.
 */

public class PHLightManager {

    private PHHueSDK phHueSDK = PHHueSDK.create();
    private static final int MAX_BRIGHTNESS = 254;
    private PHBridge bridge = phHueSDK.getSelectedBridge();


    public boolean bridgeConnected(){
        return bridge != null;
    }

    // Toggle lights On/Off
    public void randomLights() {


        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        for (PHLight light : allLights) {

            PHLightState lightState = new PHLightState();

            if(light.getLastKnownLightState().isOn()){
                lightState.setOn(false);
            }else{
                lightState.setOn(true);
            }

            //lightState.setBrightness(rand.nextInt(MAX_BRIGHTNESS));
            // To validate your lightstate is valid (before sending to the bridge) you can use:
            // String validState = lightState.validateState();
            bridge.updateLightState(light, lightState, listener);
            //  bridge.updateLightState(light, lightState);   // If no bridge response is required then use this simpler form.
        }
    }


    public void changeBulb(){

    }

    public List<PHLight> getLights(){
        return bridge.getResourceCache().getAllLights();
    }

    public int lightCount(){
        List<PHLight> allLights = bridge.getResourceCache().getAllLights();
        return allLights.size();
    }

    // If you want to handle the response from the bridge, create a PHLightListener object.
    private PHLightListener listener = new PHLightListener() {

        @Override
        public void onSuccess() {
        }

        @Override
        public void onStateUpdate(Map<String, String> arg0, List<PHHueError> arg1) {
            Log.w("LightManager", "Light has updated");
        }

        @Override
        public void onError(int arg0, String arg1) {}

        @Override
        public void onReceivingLightDetails(PHLight arg0) {}

        @Override
        public void onReceivingLights(List<PHBridgeResource> arg0) {}

        @Override
        public void onSearchComplete() {}
    };

    // TODO Disconnect from bridge when app exits. Currently acts when view would be destroyed needs to work on app close. Broadcast receiver?
    public void disconnectHub() {

        PHBridge bridge = phHueSDK.getSelectedBridge();
        if (bridge != null) {
            Log.i("disconnectHUB", "There is a bride");
            if (phHueSDK.isHeartbeatEnabled(bridge)) {
                phHueSDK.disableHeartbeat(bridge);
            }

            phHueSDK.disconnect(bridge);
        }
    }

}
