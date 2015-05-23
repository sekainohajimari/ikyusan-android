package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.ushisantoasobu.ikyusan.adapter.IdeaAdapter;
import com.example.ushisantoasobu.ikyusan.model.IdeaData;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.RestAdapter;

public class IdeaListActivity extends Activity {

    @InjectView(R.id.listView)
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_list);

        ButterKnife.inject(this);

        List<IdeaData> ideas = new ArrayList<IdeaData>();

        IdeaData item1 = new IdeaData();
        item1.name = "aaa";

        IdeaData item2 = new IdeaData();
        item2.name = "bbb";

        IdeaData item3 = new IdeaData();
        item3.name = "ccc";

        ideas.add(item1);
        ideas.add(item2);
        ideas.add(item3);

        IdeaAdapter ideaAdapter = new IdeaAdapter(this, 0, ideas);


        mListView.setAdapter(ideaAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            //リスト項目クリック時の処理
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                Toast.makeText(getApplicationContext(), "clicked!!", Toast.LENGTH_SHORT).show();
            }

        });

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                showAlertDialog();
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.idea_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_create) {
            Intent intent = new Intent(this, IdeaCreateActivity.class);
            startActivityForResult(intent, 0); //2つめの引数はactivityを識別するためのものらしい
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("このネタを...?");
//        builder.setMessage("message");
        builder.setNeutralButton("編集する", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
            }
        });
        builder.setNegativeButton("削除する", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //
            }
        });
//        builder.setNeutralButton("キャンセル", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                //
//            }
//        });
        builder.setCancelable(true);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
