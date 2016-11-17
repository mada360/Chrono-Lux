package chrono_lux.chrono_lux.smartbulbs.hue;

import android.util.Log;

/**
 * Created by Adam on 15/11/2016.
 * This class will be used to store light objects.
 */

/*
Example light data
"1": {
        "state": {
            "on": true,
                    "bri": 254,
                    "alert": "none",
                    "reachable": true
        },
        "type": "Dimmable light",
                "name": "Hue white lamp 1",
                "modelid": "LWB006",
                "manufacturername": "Philips",
                "uniqueid": "00:17:88:01:02:30:88:9f-0b",
                "swversion": "5.38.1.15095"
    },*/


public class HueBulb {

    private static final String TAG = "debugMessage";

    private int bulbID;
    private String type;
    private Boolean status;
    private int brightness;
    private String alert;
    private Boolean reachable;
    private int hue;



    HueBulb() {
        this.setBulbID();
        this.setHue(254);
        this.setBrightness(254);
        this.setStatus(true);

    }

    // The bulb ID is used to identify a specific smartbulb. The hue documentation states it is
    // more efficient to reference individual bulbs unless a dozen are grouped.
    public void setBulbID(){
        // TODO implement JSON parser to get bulb number.
        bulbID = 1;
    }

    private int getBublbID(){
        return bulbID;
    }
    // Not sure if this will need to be public.
    public Boolean isReachable(){
        return reachable;
    }

    // The type of bulb is important as there are varying supported attributes
    // Dimmable light, Color Light, Color Temperature Light, Extended color Light.
    // I only have the dimmable and all others provide extra attributes.
    // The functionality of my app can be done with the minimum but
    // I'll include this for extension possibilites.
    public String getType(){
        return type;
    }

    // Get potential alerts from bulbs.
    public String getAlert(){
            return alert;
    }

    // Change if the light is on or off
    public void setStatus(Boolean newStatus) {
        status = newStatus;
    }

    // Get the current on/off status of the light. I won't want to send unnecessary
    // on/off requests to through the bridge as this could slow performance.
    public Boolean getStatus() {
        return status;
    }

    // Set the brightness (intensity) of the light. This is from 0-255.
    public void setBrightness(int setBrightness) {
        if (setBrightness >= 0 && setBrightness <= 255) {
            brightness = setBrightness;
        } else {
            // Should never be called as user will only be able to use slider to adjust this.
        }

    }

    // Get the current brightness, I won't want to increase the user set brightness.
    public int getBrightness() {
        return brightness;
    }

    // Not a feature of my bulbs and will not really be used by my app.
    // Could be useful as an extension as blue light is more energizing.
    public void setHue(int setHue) {
        if (setHue >= 0 && setHue <= 255) {
            brightness = setHue;
        } else {
            // Should never be called as user will only be able to use slider to adjust this.
            Log.i(TAG, "invalid hue");
        }
        hue = setHue;
    }

    // Would be good to display the current hue colour within the app.
    public int getHue() {
        return hue;
    }

}
