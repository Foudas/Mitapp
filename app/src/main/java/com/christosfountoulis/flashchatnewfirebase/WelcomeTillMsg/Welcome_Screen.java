package com.christosfountoulis.flashchatnewfirebase.WelcomeTillMsg;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.christosfountoulis.flashchatnewfirebase.R;

public class Welcome_Screen extends AppCompatActivity {

    private ImageButton prosLogIn;

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.welcome_screen);

        prosLogIn = (ImageButton) findViewById(R.id.prosLogIn);

        prosLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LogInIntent = new Intent(Welcome_Screen.this, LoginActivity.class);
                startActivity(LogInIntent);
                finish();
            }
        });

        // TODO: Button gia ruthisi onomatos

    }

}
