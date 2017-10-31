package com.christosfountoulis.flashchatnewfirebase.WelcomeTillMsg;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import android.support.v7.app.AlertDialog;

import com.christosfountoulis.flashchatnewfirebase.MainChatActivity;
import com.christosfountoulis.flashchatnewfirebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements LogInToFirebase.AsyncResponse {

    // TODO: Vasikes Metavlites:
    private FirebaseAuth mAuth;
    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mEmailView = (AutoCompleteTextView) findViewById(R.id.login_email);
        mPasswordView = (EditText) findViewById(R.id.login_password);


        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();

                    return true;
                }
                return false;
            }
        });

        // TODO: Grab an instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

    }

    // Executed when Sign in button pressed
    public void signInExistingUser(View v)   {
        // TODO: Call attemptLogin() here
        attemptLogin();

    }

    // Executed when Register button pressed
    public void registerNewUser(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        finish();
        startActivity(intent);
    }

    // TODO: Complete the attemptLogin() method
    private void attemptLogin() {

        email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if (email.equals("") || password.equals("")) return;
        Toast.makeText(this, "Login in progress...", Toast.LENGTH_SHORT).show();

        // TODO: Use FirebaseAuth to sign in with email & password
        LogInToFirebase logInToFirebase = new LogInToFirebase(email, password, mAuth, new LogInToFirebase.AsyncResponse() {
            @Override
            public void processFinish(boolean isSuccessful) {
                if(isSuccessful){
                    Intent intent = new Intent(LoginActivity.this,MainChatActivity.class);
                    finish();
                    startActivity(intent);
                }else{
                    showErrorDialog("Υπήρξε πρόβλημα δικέ μου :/");
                }
            }
        }, this);
        logInToFirebase.execute();
    }

    // TODO: Show error on screen with an alert dialog

    private void showErrorDialog (String message) {
        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public void processFinish(boolean isSuccessful) {
        //
    }
}

class LogInToFirebase extends AsyncTask<Void, Void, Void>{

    public interface AsyncResponse {
        void processFinish(boolean isSuccessful);
    }

    AsyncResponse delegate = null;

    private String email, password;
    private FirebaseAuth mAuth;
    private LoginActivity con2;


    public LogInToFirebase (String email, String password, FirebaseAuth mAuth, AsyncResponse delegate, LoginActivity con2){
        this.email = email;
        this.password = password;
        this.mAuth = mAuth;
        this.delegate = delegate;
        this.con2 = con2;
    }

    @Override
    protected Void doInBackground(Void... params) {

        Log.d("WORKING", "HEYYY");

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(con2, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d("FlashChat", "sighInWithEmail() onComplete: " +task.isSuccessful());

                if (!task.isSuccessful()) {
                    Log.d("FlashChat", "Problem signing in: " +task.getException());
                    delegate.processFinish(false);

                } else {
                    delegate.processFinish(true);
                }
            }
        });

        return null;
    }
}