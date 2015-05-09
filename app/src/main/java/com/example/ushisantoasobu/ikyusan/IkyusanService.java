package com.example.ushisantoasobu.ikyusan;

import com.example.ushisantoasobu.ikyusan.model.GroupData;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by ushisantoasobu on 15/04/26.
 */
public interface IkyusanService {

    @GET("https://note.mu/api/v1/notes?note_intro_only=true&urlname=ushisantoasobu")
    List<GroupData> listGroup();

}
