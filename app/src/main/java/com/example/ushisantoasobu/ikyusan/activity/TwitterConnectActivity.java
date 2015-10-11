package com.example.ushisantoasobu.ikyusan.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.ushisantoasobu.ikyusan.R;
import com.example.ushisantoasobu.ikyusan.model.ProfileData;
import com.example.ushisantoasobu.ikyusan.model.SignupData;
import com.example.ushisantoasobu.ikyusan.util.AccountUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TwitterConnectActivity extends Activity {

    @InjectView(R.id.webView)
    WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_connect);

        ButterKnife.inject(this);

        WebViewClient client = new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                setProgressBarIndeterminateVisibility(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                setProgressBarIndeterminateVisibility(false);

                view.evaluateJavascript("document.body.innerHTML", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String s) {

//                        s = s.replaceAll("<pre style=\"word-wrap: break-word; white-space: pre-wrap;\">", "");
//                        s = s.replaceAll("</pre>", "");

                        // https://github.com/GoogleChrome/chromium-webview-samples/blob/b18afa96ab6215eed526c19156bf0fe6f5386ad1/jsinterface-example/app/src/main/java/jsinterfacesample/android/chrome/google/com/jsinterface_example/MainFragment.java
                        JsonReader reader = new JsonReader(new StringReader(s));

                        // Must set lenient to parse single values
                        reader.setLenient(true);

                        try {
                            if(reader.peek() != JsonToken.NULL) {
                                if(reader.peek() == JsonToken.STRING) {
                                    String msg = reader.nextString();
                                    if(msg != null) {

                                        msg = msg.replaceAll("\u003Cpre style=\"word-wrap: break-word; white-space: pre-wrap;\">", "");
                                        msg = msg.replaceAll(" \u003C/pre>", "");

                                        JSONObject obj = new JSONObject();
                                        try {
                                            obj = new JSONObject(msg);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                        try {
                                            // TODO: better script
                                            SignupData data = new SignupData();
                                            data.setIdentifier(obj.getInt("id"));
                                            data.setToken(obj.getString("token"));

                                            ProfileData profile = new ProfileData();
//                                            profile.setDisplayName(obj.getJSONObject("profile").getString("display_id"));
                                            profile.setDisplayName(obj.getJSONObject("profile").getString("display_name"));
                                            profile.setIconUrl(obj.getJSONObject("profile").getString("icon_url"));

                                            data.setProfile(profile);

                                            AccountUtil.getInstance(getApplicationContext()).setSignup(data);

                                            mWebView.setVisibility(View.GONE);

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        } catch (IOException e) {
                            Log.e("TAG", "MainActivity: IOException", e);
                        } finally {
                            try {
                                reader.close();
                            } catch (IOException e) {
                                // NOOP
                            }
                        }

                        Log.d("popo", s);
                    }
                });
            }
        };

        mWebView.setWebViewClient(client);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new MyJavaScriptInterface(), "HTMLOUT");

        mWebView.loadUrl("http://ikyusan.sekahama.club/auth/twitter");
    }

    class MyJavaScriptInterface
    {
        @JavascriptInterface
        @SuppressWarnings("unused")
        public void processHTML(String html)
        {
            // process the html as needed by the app
        }
    }
}
