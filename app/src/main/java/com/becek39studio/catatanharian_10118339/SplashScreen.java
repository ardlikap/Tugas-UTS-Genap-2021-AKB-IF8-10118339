package com.becek39studio.catatanharian_10118339;

//Tanggal Pengerjaan 3 Juni 2021, 10118339, MUHAMMAD AL ARDLIKA PRIHASISWANA, IF8

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mainMenu();
            }
        }, 2000);
    }

    private void mainMenu(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}