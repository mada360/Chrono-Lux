package chrono_lux.chrono_lux;

/**
 * Created by Adam on 10/11/2016.
 */

public class TestLight implements SmartBulbInterface {
    @Override
    public void addLight() {

    }

    @Override
    public void turnOnLight(int LightID) {
        System.out.println("Turned on " + LightID);
    }

    @Override
    public void turnOffLight(int LightID) {
        System.out.println("Turned off " + LightID);

    }

    @Override
    public void setIntensity(int LightID, int intensity) {
        System.out.format("Set light %d to intensity %d", LightID, intensity);
    }

    @Override
    public void setHue(int LightID, int hue) {
        System.out.format("Set light %d to hue value %d", LightID, hue);

    }

    @Override
    public String getHubName() {
        return null;
    }

    @Override
    public long getDeviceTime() {
        long time= System.currentTimeMillis();
        return time;
    }
}
