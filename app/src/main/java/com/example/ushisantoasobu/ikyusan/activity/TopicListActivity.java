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
import android.widget.Toast;
import com.example.ushisantoasobu.ikyusan.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.RestAdapter;

public class TopicListActivity extends Activity {

    @InjectView(R.id.listView)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_list);

        ButterKnife.inject(this);

        //
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        adapter.add("トーク内容");
        adapter.add("呼びたいゲスト");
        adapter.add("食べ歩きもやりたいYo!");

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            //リスト項目クリック時の処理
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                startIdeaListActivity();
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
            Intent intent = new Intent(this, TopicCreateActivity.class);
            startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startIdeaListActivity() {
        Intent intent = new Intent(this, IdeaListActivity.class);
        startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
    }
}
