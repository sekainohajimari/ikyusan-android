package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ushisantoasobu.ikyusan.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class GroupCreateActivity extends Activity {

    @InjectView(R.id.button)
    Button mButton;

    @InjectView(R.id.editText)
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_create);

        ButterKnife.inject(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.group_create, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.button)
    void buttonClickd() {
        if (!validate()) {
            Toast.makeText(this, "1文字以上20文字以内です", Toast.LENGTH_SHORT).show();
            return;
        }

        finish();
    }

    private boolean validate() {
        if(mEditText.getText().length() == 0 ||
           mEditText.getText().length() > 20 ) {
            return false;
        }
        return true;
    }
}
