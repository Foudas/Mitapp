package com.christosfountoulis.flashchatnewfirebase;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Toast;

public class HomePage extends AppCompatActivity{

    //////////////////////////////////////////////////////////////////////////
    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    //////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_layout);

    }

    //////////////////////////////////////////////////////////////////////////////////
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
                    //Intent ContactsIntent = new Intent (HomePage.this, ContactsPage.class);
                    //startActivity(ContactsIntent);
                }
                break;
        }
        return super.onTouchEvent(event);
    }
    //////////////////////////////////////////////////////////////////////////////////

}
