package com.christosfountoulis.flashchatnewfirebase;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 31/10/2017.
 */

public class Person extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_layout);

        SharedPreferences settings = getSharedPreferences("Plirofories Mita", 0);
        final String mNumber = settings.getString("Plirofories Mita", "Agnwstos Giotas");

        if (mNumber.equals("1")){
            ImageView eikona = (ImageView) findViewById(R.id.eikonaAtomou);
            eikona.setBackgroundResource(R.drawable.mita_first);

            TextView text = (TextView) findViewById(R.id.text);
            text.setText("aka Φανασης ο Δευτερος #ακ");

            TextView sex_TextView = (TextView) findViewById(R.id.sex_TextView);
            sex_TextView.setText("Φύλο: Γυναικοτός");

            TextView fb_prof = (TextView) findViewById(R.id.fb);
            fb_prof.setText("Facebook: Sakis Ioannidis");

            TextView arithmos_prwin = (TextView) findViewById(R.id.arithmos_prwin);
            arithmos_prwin.setText("Αριθμός Πρώην: Uncountable nmz");

            TextView til = (TextView) findViewById(R.id.til);
            til.setText("6987240873, αλλά είναι λιγο μακριά");

            TextView stathero = (TextView) findViewById(R.id.stathero);
            stathero.setText("Σταθερό τηλ: Νο φράγκα για αυτό το αγαθό");
        } else if (mNumber.equals("2")){
            ImageView eikona = (ImageView) findViewById(R.id.eikonaAtomou);
            eikona.setBackgroundResource(R.drawable.second);

            TextView text = (TextView) findViewById(R.id.text);
            text.setText("aka Μω.");

            TextView sex_TextView = (TextView) findViewById(R.id.sex_TextView);
            sex_TextView.setText("Γιατί σκατά να ενδιαφερθείς για τον Μω;");

        } else if (mNumber.equals("3")){
            ImageView eikona = (ImageView) findViewById(R.id.eikonaAtomou);
            eikona.setBackgroundResource(R.drawable.third);

            TextView text = (TextView) findViewById(R.id.text);
            text.setText("aka Γερος Γκεις Περιτομης");

            TextView sex_TextView = (TextView) findViewById(R.id.sex_TextView);
            sex_TextView.setText("Φυλο: SuperGay");

            TextView fb_prof = (TextView) findViewById(R.id.fb);
            fb_prof.setText("Facebook: Χάρης Πεχλιβανίδης");

            TextView arithmos_prwin = (TextView) findViewById(R.id.arithmos_prwin);
            arithmos_prwin.setText("Αριθμός Πρώην: Οσες οι πριγκίπισσες σε ασπρα αλογα");

            TextView til = (TextView) findViewById(R.id.til);
            til.setText("6943816306");

            TextView stathero = (TextView) findViewById(R.id.stathero);
            stathero.setText("2310438690");
        } else if (mNumber.equals("4")){
            ImageView eikona = (ImageView) findViewById(R.id.eikonaAtomou);
            eikona.setBackgroundResource(R.drawable.third);

            TextView text = (TextView) findViewById(R.id.text);
            text.setText("aka Φάνο");

            TextView sex_TextView = (TextView) findViewById(R.id.sex_TextView);
            sex_TextView.setText("Φυλο: Γκόλουμ");

            TextView fb_prof = (TextView) findViewById(R.id.fb);
            fb_prof.setText("Facebook: Thanos Ploumistos");

            TextView arithmos_prwin = (TextView) findViewById(R.id.arithmos_prwin);
            arithmos_prwin.setText("Αριθμός Πρώην: Ίδιος με τον αριθμό ατόμων που τον κυνηγάνε");

            TextView til = (TextView) findViewById(R.id.til);
            til.setText("69********");

            TextView stathero = (TextView) findViewById(R.id.stathero);
            stathero.setText("2310419351");

        } else if (mNumber.equals("5")) {
            ImageView eikona = (ImageView) findViewById(R.id.eikonaAtomou);
            eikona.setBackgroundResource(R.drawable.third);

            TextView text = (TextView) findViewById(R.id.text);
            text.setText("aka Τζονις Γκει Ινδος Αρθουρος");

            TextView sex_TextView = (TextView) findViewById(R.id.sex_TextView);
            sex_TextView.setText("Φυλο: Παραλίας");

            TextView fb_prof = (TextView) findViewById(R.id.fb);
            fb_prof.setText("Facebook: Γιαννης Σαρηκωστας");

            TextView arithmos_prwin = (TextView) findViewById(R.id.arithmos_prwin);
            arithmos_prwin.setText("Αριθμός Πρώην: Οσες λέει μείον 10");

            TextView til = (TextView) findViewById(R.id.til);
            til.setText("69********");

            TextView stathero = (TextView) findViewById(R.id.stathero);
            stathero.setText("2310******(Τζαμπα θα παρεις ειναι αλλου)");
        }else if (mNumber.equals("6")) {
            ImageView eikona = (ImageView) findViewById(R.id.eikonaAtomou);
            eikona.setBackgroundResource(R.drawable.third);

            TextView text = (TextView) findViewById(R.id.text);
            text.setText("aka Σαβουρογαμης κολλητός λη");

            TextView sex_TextView = (TextView) findViewById(R.id.sex_TextView);
            //sex_TextView.setText("Φυλο: Παραλίας");

            TextView fb_prof = (TextView) findViewById(R.id.fb);
            //fb_prof.setText("Facebook: Γιαννης Σαρηκωστας");

            TextView arithmos_prwin = (TextView) findViewById(R.id.arithmos_prwin);
            //arithmos_prwin.setText("Αριθμός Πρώην: Οσες λέει μείον 10");

            TextView til = (TextView) findViewById(R.id.til);
            //til.setText("69********");

            TextView stathero = (TextView) findViewById(R.id.stathero);
            //stathero.setText("2310******(Τζαμπα θα παρεις ειναι αλλου)");
        }
    }
}
