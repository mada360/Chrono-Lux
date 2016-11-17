package chrono_lux.chrono_lux.smartbulbs.hue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import chrono_lux.chrono_lux.smartbulbs.SmartBulbInterface;

/**
 * Created by Adam on 10/11/2016.
 */

public class PhilipsHueInterface  implements SmartBulbInterface {
    private String devID = null;
    private String bridgeIP = null;

    private List<HueBulb> bulbList;

    private void addBulb(){
        HueBulb bulb = new HueBulb();
        bulb.setBulbID();
        bulb.setStatus(true);
        bulb.setBrightness(254);
        bulb.setHue(254);
        bulbList.add(bulb);

    }

    private String getDeveloperID(){
        // TODO implement a method to send a json request to bridge to receive developer ID.

        /**
         * URL = request http://<bridge ip address>/api
         * Body = {"devicetype":"Chrono-Lux#android"}
         */
        // Change to the parsed devID/username

        String parsedDevID = "vp79mQkFtCHD4cXdx7GmgXiW0u6SjpGFCQLWLaOD";
        return parsedDevID;
    }

    private void setDevID(){
        devID = getDeveloperID();
    }

    private void setBridgeAddress(){
        // TODO Set brideIP to the provided ip address.
        // TODO Find a way to scan for bridge on LAN
        bridgeIP = "192.168.1.115";
    }

    @Override
    public void addLight() {
        HueBulb light1 = new HueBulb();
    }

    @Override
    public void turnOnLight(int LightID) {
        // PUT {"on":true}
    }

    @Override
    public void turnOffLight(int LightID) {
        // PUT {"on":false}

    }

    @Override
    public void setIntensity(int LightID, int intensity) {
        // PUT {"bri":intensity}
    }

    @Override
    public void setHue(int LightID, int hue) {
        // PUT {"hue":hue}
    }

    @Override
    public String getHubName() {
        // TODO code parser for hue config/device data
        return null;
    }

    @Override
    public long getDeviceTime() {
        //"UTC": "2016-11-15T14:31:24",
        //"localtime": "2016-11-15T14:31:24",
        //"timezone": "Europe/London",

        long milliseconds = 0;

       String string_date = "2016-11-15T14:32:24";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.UK );
        try {
            Date d = sdf.parse(string_date);
             milliseconds = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return milliseconds;

    }

}
