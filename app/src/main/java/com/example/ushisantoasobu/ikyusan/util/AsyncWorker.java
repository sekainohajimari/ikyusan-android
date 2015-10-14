//package com.example.ushisantoasobu.ikyusan.util;
//
//import android.content.AsyncTaskLoader;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//
//public class AsyncWorker extends AsyncTaskLoader {
//
//    private Bitmap bitmap;
//    private String url;
//
//    public AsyncWorker(Context context, String url) {
//        super(context);
//        this.url = url;
//    }
////
//    @Override
//    public void loadInBackground() {
//        Bitmap bmp = null;
////
////        try {
////            //画像のURLを直うち
////            URL url = new URL(this.url);
////            //インプットストリームで画像を読み込む
////            InputStream istream = url.openStream();
////            //読み込んだファイルをビットマップに変換
////            bmp = BitmapFactory.decodeStream(istream);
////            //ビットマップをImageViewに設定
////            imageview.setImageBitmap(bmp);
////            //インプットストリームを閉じる
////            istream.close();
////        } catch (IOException e) {
////            // TODO 自動生成された catch ブロック
////            e.printStackTrace();
////        }
////    }
//}