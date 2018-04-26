package com.example.abhiram.facedetection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button BtnSmile, BtnFeature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnSmile = findViewById(R.id.btn_smile);
        BtnFeature = findViewById(R.id.btn_feature);

        BtnSmile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FaceTrackerActivity.class);
            }
        });

        BtnFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PhotoViewerActivity.class);
            }
        });
    }
}
