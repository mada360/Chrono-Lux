package chrono_lux.chrono_lux;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import chrono_lux.chrono_lux.R;

public class LightControl extends AppCompatActivity {

    private static final String TAG = "debugMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

    }
}
