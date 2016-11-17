package chrono_lux.chrono_lux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import chrono_lux.chrono_lux.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "debugMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

    }
}
