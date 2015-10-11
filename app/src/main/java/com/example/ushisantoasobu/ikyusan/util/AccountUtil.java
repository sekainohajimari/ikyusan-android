package com.example.ushisantoasobu.ikyusan.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ushisantoasobu.ikyusan.model.ProfileData;
import com.example.ushisantoasobu.ikyusan.model.SignupData;

/**
 * Created by ushisantoasobu on 15/05/23.
 */
public class AccountUtil {

    private static final String SHARED_PREFERENCE_APP = "SHARED_PREFERENCE_APP";

//    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY";
//    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY";
//    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY";
//    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY";
//    private static final String ACCESS_TOKEN_KEY = "ACCESS_TOKEN_KEY";

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
//    public String getAccessToken() {
//        return prefs.getString(ACCESS_TOKEN_KEY, "");
//    }

//    public boolean setAccessToken(String token) {
//        SharedPreferences.Editor editor = prefs.edit();
//        editor.putString(ACCESS_TOKEN_KEY, token);
//        return editor.commit();
//    }

    public boolean setSignup(SignupData signup) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("identifier", signup.getIdentifier());
        editor.putString("token", signup.getToken());
        editor.putString("display_id", signup.getProfile().getDisplayId());
        editor.putString("display_name", signup.getProfile().getDisplayName());
        editor.putString("icon_url", signup.getProfile().getIconUrl());
        return editor.commit();
    }

    public boolean setProfile(ProfileData profile) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("display_id", profile.getDisplayId());
        editor.putString("display_name",profile.getDisplayName());
        if (profile.getInUseDefaultIcon()) {
            editor.putString("icon_url", profile.getDefaultIconUrl());
        } else {
            editor.putString("icon_url", profile.getIconUrl());
        }
        return editor.commit();
    }

    public boolean deleteAll() {
        SharedPreferences.Editor editor = prefs.edit();
        return editor.clear().commit();
    }

}
