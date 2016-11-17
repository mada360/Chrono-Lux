package chrono_lux.chrono_lux.smartbulbs.hue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import android.util.Log;

import chrono_lux.chrono_lux.R;

/**
 * Created by Adam on 15/11/2016.
 */




public class PhilipsHueView extends AppCompatActivity {

    private static final String TAG = "debugMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_control);

        TextView t = (TextView)findViewById(R.id.toggleLight);

        Log.i(TAG, "onCreate");

    }

    PhilipsHueInterface hueInterface;

    //hueInterface
}
