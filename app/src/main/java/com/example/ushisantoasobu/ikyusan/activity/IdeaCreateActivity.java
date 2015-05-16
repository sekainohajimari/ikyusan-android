package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ushisantoasobu.ikyusan.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class IdeaCreateActivity extends Activity {

    @InjectView(R.id.askButton)
    Button mAskButton;

    @InjectView(R.id.createButton)
    Button mCreateButton;

    @InjectView(R.id.editText)
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_create);

        ButterKnife.inject(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.idea_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    private boolean validate() {
        if(mEditText.getText().length() == 0 ||
                mEditText.getText().length() > 140 ) {
            return false;
        }
        return true;
    }

    @OnClick(R.id.askButton)
    void askButtonClickd() {
        mEditText.setText("お風呂で腹筋してみよう！！");
    }

    @OnClick(R.id.createButton)
    void createButtonClickd() {
        if (!validate()) {
            Toast.makeText(this, "1文字以上140文字以内です", Toast.LENGTH_SHORT).show();
            return;
        }

        finish();
    }
}
