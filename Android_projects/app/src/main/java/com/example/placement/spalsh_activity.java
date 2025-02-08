package com.example.placement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class spalsh_activity extends AppCompatActivity {


    private final int SPLASH_DISPLAY_LENGTH = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        // New Handler to start the MainActivity and close this SplashActivity after some seconds.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent that will start the MainActivity.
                Intent mainIntent = new Intent(spalsh_activity.this, MainActivity.class);
                spalsh_activity.this.startActivity(mainIntent);
                spalsh_activity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}