package com.example.ushisantoasobu.ikyusan.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ushisantoasobu on 15/05/23.
 */
public class AccountUtil {

    private static final String SHARED_PREFERENCE_APP = "SHARED_PREFERENCE_APP";

    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY";

    private SharedPreferences prefs;

    static AccountUtil INSTANCE;

    public AccountUtil(Context context) {
        prefs = context.getSharedPreferences(SHARED_PREFERENCE_APP, Context.MODE_PRIVATE);
    }

    public static synchronized AccountUtil getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AccountUtil(context.getApplicationContext());
        }
        return INSTANCE;
    }

    // TODO : exceptionつける？？
    public String getAccessToken() {
        return prefs.getString(ACCESS_TOKEN_KEY, "");
    }

    public boolean setAccessToken(String token) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ACCESS_TOKEN_KEY, token);
        return editor.commit();
    }

}
