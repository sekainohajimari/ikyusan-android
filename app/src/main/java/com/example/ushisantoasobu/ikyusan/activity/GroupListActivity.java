package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ushisantoasobu.ikyusan.IkyusanService;
import com.example.ushisantoasobu.ikyusan.R;
import com.example.ushisantoasobu.ikyusan.model.GroupData;
import com.example.ushisantoasobu.ikyusan.model.GroupsData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class GroupListActivity extends Activity {

    @InjectView(R.id.listView)
    ListView mListView;

    // TODO: refactor
    ArrayAdapter<String> adapter;
    List<GroupData> list = new ArrayList<GroupData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        ButterKnife.inject(this);

        //
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //リスト項目クリック時の処理
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startTopicListActivity(list.get(position));
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
        service.listGroup(new Callback<GroupsData>() {
            @Override
            public void success(GroupsData groups, Response response) {
                for (GroupData group : groups.getGroups()) {
                    adapter.add(group.getName());
                    list.add(group);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.group_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_account) {
            Intent intent = new Intent(this, AccountActivity.class);
            startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい

            return true;
        }
        if (id == R.id.action_notification) {
            Intent intent = new Intent(this, NotificationListActivity.class);
            startActivityForResult(intent, 0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startTopicListActivity(GroupData group) {
        Intent intent = new Intent(this, TopicListActivity.class);
        intent.putExtra("group", group);
        startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
    }

    @OnClick(R.id.createButton)
    void createButtonClickd() {
        Intent intent = new Intent(this, GroupCreateActivity.class);
        startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
    }
}
