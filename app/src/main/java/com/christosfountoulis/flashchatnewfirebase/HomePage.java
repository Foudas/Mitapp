package com.christosfountoulis.flashchatnewfirebase;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.christosfountoulis.flashchatnewfirebase.WelcomeTillMsg.LoginActivity;
import com.christosfountoulis.flashchatnewfirebase.WelcomeTillMsg.Welcome_Screen;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.spark.submitbutton.SubmitButton;

import static com.christosfountoulis.flashchatnewfirebase.WelcomeTillMsg.RegisterActivity.CHAT_PREFS;
import static com.christosfountoulis.flashchatnewfirebase.WelcomeTillMsg.RegisterActivity.DISPLAY_NAME_KEY;

public class HomePage extends AppCompatActivity{

    //////////////////////////////////////////////////////////////////////////
    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    //////////////////////////////////////////////////////////////////////////

    private ImageButton btnAllaghsOnomatos;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReference2;
    private SubmitButton toHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);

        btnAllaghsOnomatos = (ImageButton) findViewById(R.id.btnAllaghsOnomatos);
        mAuth = FirebaseAuth.getInstance();
        mDatabaseReference2 = FirebaseDatabase.getInstance().getReference();
        toHomePage = (SubmitButton) findViewById(R.id.toHomePage);

        //////////////////Pop up parathiro////////////////////////////
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Αλλαγή ονόματος");
        alert.setMessage("Βάλε ένα καινούργιο όνομα για το οποίο πιστεύεις πως θα φας λιγότερο μπούλινκ.");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Κομπλέ", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Xrisimopoioume katallila tin eisodo tou xristi.
                String kainourgio_onoma = input.getText().toString();

                if(!kainourgio_onoma.equals("")) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    String userID = user.getUid();
                    mDatabaseReference2.child("Stoixeia").child(userID).child("Onoma").setValue(kainourgio_onoma);

                    KanwToast(kainourgio_onoma);
                }
            }
        });

        alert.setNegativeButton("Άκυρο", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });
        //////////////////////////////////////////////////////////////

        toHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHomePage = new Intent(HomePage.this, MainChatActivity.class);
                startActivity(toHomePage);
            }
        });

        // TODO: Button gia ruthisi onomatos
        btnAllaghsOnomatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                if ( -(deltaX) > MIN_DISTANCE) {
                    Toast.makeText(this, "apo dejia pros ta aristera", Toast.LENGTH_SHORT).show ();
                    Intent CalendarIntent = new Intent (HomePage.this, CalendarCode.class);
                    startActivity(CalendarIntent);

                } else if (deltaX > MIN_DISTANCE){
                    Toast.makeText(this, "aristera -> dejia", Toast.LENGTH_SHORT).show ();

                    // TODO: Na oloklhroso to layout me tis epafes
                    Intent ContactsIntent = new Intent (HomePage.this, ContactsPage.class);
                    startActivity(ContactsIntent);
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void KanwToast(String mhnyma) {
        Toast.makeText(this, mhnyma, Toast.LENGTH_LONG).show ();
    }

}
