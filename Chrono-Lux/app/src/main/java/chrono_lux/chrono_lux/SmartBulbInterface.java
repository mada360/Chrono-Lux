package chrono_lux.chrono_lux;

/**
 * Created by Adam on 10/11/2016.
 */

public interface SmartBulbInterface {

    void addLight();

    void turnOnLight(int LightID);

    void turnOffLight(int LightID);

    void setIntensity(int LightID, int intensity);

    void setHue(int LightID, int hue);

    //Hue bulb name will be 4 to 16 characters
    String getHubName();

    //This might be needed to ensure time sync
    long getDeviceTime();



}

