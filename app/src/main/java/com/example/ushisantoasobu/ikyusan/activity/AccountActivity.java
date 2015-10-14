package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ushisantoasobu.ikyusan.IkyusanService;
import com.example.ushisantoasobu.ikyusan.R;
import com.example.ushisantoasobu.ikyusan.model.InfoProfileData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

public class AccountActivity extends Activity {

    @InjectView(R.id.idTextView)
    TextView mTextView;

    @InjectView(R.id.nicknameEditText)
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ButterKnife.inject(this);

        //api
        Gson gson = new GsonBuilder().create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://ikyusan.sekahama.club")
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        IkyusanService service = restAdapter.create(IkyusanService.class);
        service.infoProfile(new Callback<InfoProfileData>() {
            @Override
            public void success(InfoProfileData data, Response response) {
                mTextView.setText(data.getProfile().getDisplayId());
                mEditText.setText(data.getProfile().getDisplayName());
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
        getMenuInflater().inflate(R.menu.menu_account, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.button)
    void buttonClickd() {
        //api
        Gson gson = new GsonBuilder().create();
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://ikyusan.sekahama.club")
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        IkyusanService service = restAdapter.create(IkyusanService.class);
        service.updateProfile("たこまん", "0", new Callback<InfoProfileData>() {
            @Override
            public void success(InfoProfileData profile, Response response) {
                mTextView.setText(profile.getProfile().getDisplayId());
                mEditText.setText(profile.getProfile().getDisplayName());
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //
            }
        });
    }
}
