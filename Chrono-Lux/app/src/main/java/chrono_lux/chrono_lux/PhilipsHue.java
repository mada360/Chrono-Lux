package chrono_lux.chrono_lux;

/**
 * Created by Adam on 10/11/2016.
 */

public class PhilipsHue implements SmartBulbInterface {
    @Override
    public void addLight() {

    }

    @Override
    public void turnOnLight(int LightID) {

    }

    @Override
    public void turnOffLight(int LightID) {

    }

    @Override
    public void setIntensity(int LightID, int intensity) {

    }

    @Override
    public void setHue(int LightID, int hue) {

    }

    @Override
    public String getHubName() {
        // TODO code parser for hue config/device data
        return null;
    }

    @Override
    public long getDeviceTime() {
        long time= 0;

        try{
              time = 0; //some kind of api call
        }catch (Exception e){
            System.out.println(e);
        }

        return time;
    }
}
