package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ushisantoasobu.ikyusan.IkyusanService;
import com.example.ushisantoasobu.ikyusan.R;
import com.example.ushisantoasobu.ikyusan.adapter.NotificationAdapter;
import com.example.ushisantoasobu.ikyusan.model.NotificationData;
import com.example.ushisantoasobu.ikyusan.model.NotificationsData;
import com.example.ushisantoasobu.ikyusan.model.PageData;
import com.example.ushisantoasobu.ikyusan.util.EndlessScrollListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class NotificationListActivity extends Activity {

    @InjectView(R.id.listView)
    ListView mListView;

    private PageData pageData;

    NotificationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_list);

        ButterKnife.inject(this);

        //
        adapter = new NotificationAdapter(this, 0, new ArrayList<NotificationData>());
        mListView.setAdapter(adapter);

        pageData = new PageData();
        pageData.setCurrentPage(1);

        mListView.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to your AdapterView
                customLoadMoreDataFromApi(page);
                // or customLoadMoreDataFromApi(totalItemsCount);
                return (pageData.getNextPage() == null); // ONLY if more data is actually being loaded; false otherwise.
            }
        });

        //api
        Gson gson = new GsonBuilder().create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://ikyusan.sekahama.club")
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        IkyusanService service = restAdapter.create(IkyusanService.class);
        service.listNotification(pageData.getCurrentPage().toString(), new Callback<NotificationsData>() {
            @Override
            public void success(NotificationsData notifications, Response response) {
                pageData = notifications.getMeta().getPagination();
                for (NotificationData notification : notifications.getNotifications()) {
                    Map<String, String> map = new HashMap<String, String>();
                    adapter.add(notification);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //
            }
        });
    }

    public void customLoadMoreDataFromApi(int offset) {
        //api
        Gson gson = new GsonBuilder().create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://ikyusan.sekahama.club")
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        IkyusanService service = restAdapter.create(IkyusanService.class);
        service.listNotification(pageData.getCurrentPage().toString(), new Callback<NotificationsData>() {
            @Override
            public void success(NotificationsData notifications, Response response) {
                for (NotificationData notification : notifications.getNotifications()) {
                    Map<String, String> map = new HashMap<String, String>();
                    adapter.add(notification);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //
            }
        });
    }

}
