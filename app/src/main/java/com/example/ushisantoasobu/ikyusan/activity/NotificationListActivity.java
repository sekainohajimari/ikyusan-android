package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.ushisantoasobu.ikyusan.IkyusanService;
import com.example.ushisantoasobu.ikyusan.R;
import com.example.ushisantoasobu.ikyusan.adapter.NotificationAdapter;
import com.example.ushisantoasobu.ikyusan.model.GroupData;
import com.example.ushisantoasobu.ikyusan.model.NotificationData;
import com.example.ushisantoasobu.ikyusan.model.NotificationsData;
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

    public GroupData group;

    NotificationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_list);

        ButterKnife.inject(this);

        //
        adapter = new NotificationAdapter(this, 0, new ArrayList<NotificationData>());
        mListView.setAdapter(adapter);

        //api
        Gson gson = new GsonBuilder().create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://ikyusan.sekahama.club")
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        IkyusanService service = restAdapter.create(IkyusanService.class);
        service.listNotification(new Callback<NotificationsData>() {
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
