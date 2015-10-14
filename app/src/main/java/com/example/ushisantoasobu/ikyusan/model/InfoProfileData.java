package com.example.ushisantoasobu.ikyusan.model;

import java.io.Serializable;

/**
 * Created by ushisantoasobu on 15/10/12.
 */
public class InfoProfileData implements Serializable {

    public InfoProfileData() {
        //
    }

    private static final long serialVersionUID = 23456788;

    public ProfileData getProfile() {
        return profile;
    }

    public void setProfile(ProfileData profile) {
        this.profile = profile;
    }

    private ProfileData profile;
}
