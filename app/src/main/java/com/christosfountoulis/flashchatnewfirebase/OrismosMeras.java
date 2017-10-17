package com.christosfountoulis.flashchatnewfirebase;


import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.christosfountoulis.flashchatnewfirebase.ForTheMsg.InstantMessage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.christosfountoulis.flashchatnewfirebase.R.string.day;

public class OrismosMeras extends AppCompatActivity {

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatabaseReference mDatabaseReference2;
    private Button oristikosOrismos;
    private String date;
    private String wra;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orismos_meras);
        mDisplayDate= (TextView) findViewById(R.id.tvDate);
        oristikosOrismos = (Button) findViewById(R.id.oristikos_orismos);

        mDatabaseReference2 = FirebaseDatabase.getInstance().getReference();

        SharedPreferences settings = getSharedPreferences("MyPrefs", 0);
        final String mDisplayName = settings.getString("mDisplayName", "Agnwstos Giotas");
        KanwToast(mDisplayName);


        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        OrismosMeras.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month+1;

                date = day + "/" + month + "/" + year;
                mDisplayDate.setText("Στις: "+ date);
            }
        };

        final EditText OrismosWras = (EditText) findViewById(R.id.orismos_wras);
        OrismosWras.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                wra = OrismosWras.getText().toString();
                return true;
            }
        });

        oristikosOrismos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InstantMessage imerominia_K_wra = new InstantMessage(date ,wra);
                mDatabaseReference2.child("Imerominies").push().setValue(imerominia_K_wra);

            }
        });

    }


    public void KanwToast(String mhnyma) {
        Toast.makeText(this, mhnyma, Toast.LENGTH_LONG).show ();
    }
}
