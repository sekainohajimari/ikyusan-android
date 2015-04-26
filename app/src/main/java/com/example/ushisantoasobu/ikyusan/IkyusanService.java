package com.example.ushisantoasobu.ikyusan;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ushisantoasobu on 15/04/26.
 */
public interface IkyusanService {

    @GET("https://note.mu/api/v1/notes?note_intro_only=true&urlname=ushisantoasobu")
    List<GroupData> listGroup();

}
