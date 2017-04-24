package com.example.adam.chrono_lux.light;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.adam.chrono_lux.R;
import com.example.adam.chrono_lux.hue.PHHomeActivity;
import com.example.adam.chrono_lux.hue.PHLightManager;
import com.example.adam.chrono_lux.hue.PHPushlinkActivity;
import com.example.adam.chrono_lux.hue.PHWizardAlertDialog;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;


/**
 * Created by Adam on 28/02/2017.
 */

public class LightFragment extends Fragment {

    private PHLightManager lightManager;

    private CoordinatorLayout mCoordinatorLayout;

    private ListAdapter lightAdapter;
    private ListView lightListView;

    private final String TAG = "LightFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.light_view, container, false);
        mCoordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.light_view);

        LinearLayout noHubLayout = (LinearLayout) view.findViewById(R.id.no_hub_found_view);

        if (lightManager == null) {
            Log.i(TAG, "Create light manager");
            lightManager = new PHLightManager();
        }

        // Ensure bride is connected
        if (lightManager.bridgeConnected()) {

            noHubLayout.setVisibility(View.GONE);

            Log.i(TAG, "Get lights");
            Log.i(TAG, String.valueOf(lightManager.bridgeConnected()));


            lightAdapter = new LightAdapter(getActivity().getApplicationContext(), lightManager.getLights());

            lightListView = (ListView) view.findViewById(R.id.light_list);
            lightListView.setAdapter(lightAdapter);

            lightListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Log.i(TAG, String.valueOf(position));

                    String selected = "You selected " + position;
                    Snackbar.make(mCoordinatorLayout, selected, Snackbar.LENGTH_SHORT).show();
                }
            });
        }else{

            Button setupBtn = (Button) view.findViewById(R.id.hub_setup_btn);

            ListView lightList = (ListView) view.findViewById(R.id.light_list);

            lightList.setVisibility(View.GONE);

            noHubLayout.setVisibility(View.VISIBLE);

            setupBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setupHub();
                }
            });
        }


        return view;
    }

    private void setupHub() {
        Intent hubSetupIntent = new Intent(getActivity(),PHHomeActivity.class);
        final int result = 1;

        startActivityForResult(hubSetupIntent,result);
    }


}

