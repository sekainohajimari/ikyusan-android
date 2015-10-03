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
import com.example.ushisantoasobu.ikyusan.model.TopicData;
import com.example.ushisantoasobu.ikyusan.model.TopicsData;
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

public class TopicListActivity extends Activity {

    @InjectView(R.id.listView)
    ListView mListView;

    public GroupData group;

    ArrayAdapter<String> adapter;
    List<TopicData> list = new ArrayList<TopicData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        ButterKnife.inject(this);

        group = (GroupData)getIntent().getSerializableExtra("group");

        //
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            //リスト項目クリック時の処理
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                startIdeaListActivity();
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
        service.listTopic(group.getId().toString(), new Callback<TopicsData>() {
            @Override
            public void success(TopicsData topics, Response response) {
                for (TopicData topic : topics.getTopics()) {
                    adapter.add(topic.getName());
                    list.add(topic);
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
        getMenuInflater().inflate(R.menu.topic_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_create) {
            Intent intent = new Intent(this, GroupEditActivity.class);
            startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startIdeaListActivity() {
        Intent intent = new Intent(this, IdeaListActivity.class);
        startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
    }

    @OnClick(R.id.createButton)
    void createButtonClickd() {
        Intent intent = new Intent(this, TopicCreateActivity.class);
        intent.putExtra("groupId", group.getId());
        startActivityForResult(intent, 0);
    }
}
