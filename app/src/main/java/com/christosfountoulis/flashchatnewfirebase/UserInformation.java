package com.christosfountoulis.flashchatnewfirebase;

/**
 * Created by user on 20/10/2017.
 */

public class UserInformation {

    private String Onoma;
    private String email;

    public UserInformation(){
    }

    public String getOnoma() {
        return Onoma;
    }

    public void setOnoma(String onoma) {
        Onoma = onoma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
