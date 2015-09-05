package com.example.ushisantoasobu.ikyusan;

import com.example.ushisantoasobu.ikyusan.model.GroupsData;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;

/**
 * Created by ushisantoasobu on 15/04/26.
 */
public interface IkyusanService {

    @Headers("Authorization: Token token=7e38c396497b3ab19d57a1dc1df360170cd54a4df1d18c51ba74da0e4f488e1e64088c5bde350d65")
    @GET("/api/v1/g")
    void listGroup(Callback<GroupsData> callback);

}
