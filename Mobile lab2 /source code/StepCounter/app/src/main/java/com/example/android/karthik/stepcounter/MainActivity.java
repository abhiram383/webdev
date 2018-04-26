package com.example.android.karthik.stepcounter;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener, StepListener {
    public TextView textView;
    public StepDetector simpleStepDetector;
    public SensorManager sensorManager;
    public Sensor sensor;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    public int numSteps = 0;
    public TextView TvSteps, TvLap1, TvLap2, TvLap3;
    public Button BtnStart;
    public Button BtnStop;
    public Button BtnLap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        // TODO: 1. Get an instance of the SensorManager and assign it to the variable 'sensorManager'
                    //Also get an instance of approriate sensor and assign it the variable 'sensor'
        //TODO: 2. Create an instance of StepDetector &assign it to variable 'simpleStepDetector' and register a listener on it
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);
        //TODO: 3. Get the views from the activity_main.xml and assign to variables 'TvSteps','BtnStart','BtnStop' variables suitably
        TvSteps = findViewById(R.id.tv_steps);
        TvLap1 = findViewById(R.id.tv_lapsteps1);
        TvLap2 = findViewById(R.id.tv_lapsteps2);
        TvLap3 = findViewById(R.id.tv_lapsteps3);
        BtnStart =findViewById(R.id.btn_start);
        BtnStop = findViewById(R.id.btn_stop);
        BtnLap = findViewById(R.id.btn_lap);

        BtnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numSteps = 0;
                sensorManager.registerListener(MainActivity.this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
                BtnStart.setText("Counting");
                //TvSteps.setText(event.timestamp);
            }
        });
        BtnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //sensorManager.unregisterListener(MainActivity.this);
                Toast.makeText(MainActivity.this, "Step counting stopped", Toast.LENGTH_LONG).show();
                BtnStart.setText("Start Count");
            }
        });
       BtnLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TvLap1.setText("Lap1 : "+numSteps);
                TvLap2.setText("Lap2 : "+numSteps);
                TvLap3.setText("Lap3 : "+numSteps);
            }
        });

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }
    @Override
    public void step(long timeNs) {
//        TextView TvSteps = (TextView) findViewById(R.id.tv_steps);
        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
    }

}