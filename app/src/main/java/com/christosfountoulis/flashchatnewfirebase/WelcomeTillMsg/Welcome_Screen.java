package com.christosfountoulis.flashchatnewfirebase.WelcomeTillMsg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.christosfountoulis.flashchatnewfirebase.R;

public class Welcome_Screen extends AppCompatActivity {

    private static int TIME = 2000;

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.welcome_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LogInIntent = new Intent(Welcome_Screen.this, LoginActivity.class);
                startActivity(LogInIntent);
                finish();
            }
        },TIME);

    }

}
