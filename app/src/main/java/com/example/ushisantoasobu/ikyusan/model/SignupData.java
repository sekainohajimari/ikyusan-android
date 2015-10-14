package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/10/11.
 */
public class SignupData implements Serializable {

    Integer     identifier;
    String      token;
    ProfileData profile;

    public boolean isValidate() {
        if (identifier != null && token != null) {
            return true;
        }

        return false;
    }

    private static final long serialVersionUID = 1L;

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ProfileData getProfile() {
        return profile;
    }

    public void setProfile(ProfileData profile) {
        this.profile = profile;
    }
}
