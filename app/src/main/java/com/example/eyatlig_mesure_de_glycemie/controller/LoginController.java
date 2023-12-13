package com.example.eyatlig_mesure_de_glycemie.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.eyatlig_mesure_de_glycemie.model.User;

public class LoginController {

    private static final String SHARED_PREFS="sharedPrefs";
    private static LoginController instance=null ;
    private static User user;
    private LoginController() {

        super()  ;
    }
    public static final LoginController getInstance(Context context) {
        if (instance == null) {
            instance = new LoginController();
        }
        recapUser(context);
        return LoginController.instance;
    }

    private static void recapUser(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        String username = preferences.getString("username", "");
        String password = preferences.getString("password", "");
        user = new User(username, password);
    }

    public void createUser(String username, String password, Context context) {
        this.user = new User(username, password);

        SharedPreferences preferences = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();//objet de type editer
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();


    }

    public String getUsername() {
        return user.getUsername();
    }

    public String getPassword() {
        return user.getPassword();
    }


}
