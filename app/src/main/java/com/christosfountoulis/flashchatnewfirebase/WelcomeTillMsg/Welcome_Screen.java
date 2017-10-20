package com.christosfountoulis.flashchatnewfirebase.WelcomeTillMsg;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.christosfountoulis.flashchatnewfirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import static com.christosfountoulis.flashchatnewfirebase.R.id.btnAllaghsOnomatos;

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

    }

}
