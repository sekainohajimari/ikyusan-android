package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ushisantoasobu.ikyusan.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.RestAdapter;

public class GroupListActivity extends Activity {

    @InjectView(R.id.listView)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        ButterKnife.inject(this);

        //
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        adapter.add("sakai no hajimari");
        adapter.add("POC");

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            //リスト項目クリック時の処理
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                startTopicListActivity();
            }

        });

        //api
//        RestAdapter restAdapter = new RestAdapter.Builder().build();
//        IkyusanService service = restAdapter.create(IkyusanService.class);
//        List<GroupData> groupDatas = service.listGroup();
//        Toast.makeText(this, "test", Toast.LENGTH_LONG).show();
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
        if (id == R.id.action_create) {
            Intent intent = new Intent(this, GroupCreateActivity.class);
            startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
            return true;
        }
        if (id == R.id.action_notification) {
            Log.d("Test", "お知らせ押された");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startTopicListActivity() {
        Intent intent = new Intent(this, TopicListActivity.class);
        startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
    }
}
