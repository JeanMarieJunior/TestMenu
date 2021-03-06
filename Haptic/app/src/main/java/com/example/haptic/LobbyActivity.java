package com.example.haptic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.bhaptics.bhapticsmanger.SdkRequestHandler;
import com.bhaptics.service.SimpleBhapticsDevice;

public class LobbyActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = LobbyActivity.class.getSimpleName();

    private ListViewAdapter adapter;

    private Button drawingButton, tactFileButton, tactotExampleButton, pingallButton;


    private SdkRequestHandler sdkRequestHandler;

    private android.os.Handler handler = new android.os.Handler();
    private java.lang.Runnable run = new java.lang.Runnable() {

        @Override
        public void run() {
            handler.postDelayed(this, 500);

            if (adapter != null) {
                adapter.onChangeListUpdate(sdkRequestHandler.getDeviceList());
                adapter.notifyDataSetChanged();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        handler.postDelayed(run, 100);


        sdkRequestHandler = App.getHandler(getApplicationContext());


        adapter = new ListViewAdapter(this, sdkRequestHandler.getDeviceList());
        ListView listview = (ListView) findViewById(R.id.deviceListView) ;
        listview.setAdapter(adapter) ;

        drawingButton = findViewById(R.id.drawing_button);
        drawingButton.setOnClickListener(this);

        tactFileButton = findViewById(R.id.tact_file_button);
        tactFileButton.setOnClickListener(this);

        tactotExampleButton = findViewById(R.id.tactot_file_button);
        tactotExampleButton.setOnClickListener(this);

        pingallButton = findViewById(R.id.ping_button);
        pingallButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sdkRequestHandler.quit();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ping_button) {
            for (SimpleBhapticsDevice simpleBhapticsDevice : sdkRequestHandler.getDeviceList()) {
                if (simpleBhapticsDevice.isConnected()) {
                    sdkRequestHandler.ping(simpleBhapticsDevice.getAddress());
                }
            }
        } else if (v.getId() == R.id.drawing_button) {
            startActivityForResult(new Intent(this, DrawingActivity.class), 1);
        } else if (v.getId() == R.id.tact_file_button) {
            startActivityForResult(new Intent(this, TactFileActivity.class), 1);
        } else {
            startActivityForResult(new Intent(this, VestDemoActivity.class), 1);
        }
    }
}