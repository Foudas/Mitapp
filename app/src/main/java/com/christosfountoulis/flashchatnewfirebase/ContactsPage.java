package com.christosfountoulis.flashchatnewfirebase;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/*
Created by user on 30/10/2017.
 */
public class ContactsPage extends AppCompatActivity {

    private ImageButton peri, lee, fano, indo,sakis, mw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_page_layout);

        peri = (ImageButton) findViewById(R.id.peri);
        mw = (ImageButton) findViewById(R.id.mw);
        sakis = (ImageButton) findViewById(R.id.sakis);
        fano = (ImageButton) findViewById(R.id.fano);
        lee = (ImageButton) findViewById(R.id.lee);
        indo = (ImageButton) findViewById(R.id.indo);

        sakis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toProfile = new Intent(ContactsPage.this, Person.class);
                startActivity(toProfile);

                String atomo = "1";
                SharedPreferences prefs = getSharedPreferences("Plirofories Mita",0);
                prefs.edit().putString("Plirofories Mita", atomo).apply();
            }
        });
        mw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toProfile = new Intent(ContactsPage.this, Person.class);
                startActivity(toProfile);

                String atomo = "2";
                SharedPreferences prefs = getSharedPreferences("Plirofories Mita",0);
                prefs.edit().putString("Plirofories Mita", atomo).apply();
            }
        });
        peri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toProfile = new Intent(ContactsPage.this, Person.class);
                startActivity(toProfile);

                String atomo = "3";
                SharedPreferences prefs = getSharedPreferences("Plirofories Mita",0);
                prefs.edit().putString("Plirofories Mita", atomo).apply();
            }
        });
        fano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        indo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
