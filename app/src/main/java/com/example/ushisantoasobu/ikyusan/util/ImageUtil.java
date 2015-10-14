package com.example.ushisantoasobu.ikyusan.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by ushisantoasobu on 15/10/12.
 */
public class ImageUtil {

    // ref: http://androidgamepark.blogspot.jp/2013/10/imageview-url.html
    static public void set(ImageView imageview, String urlString) {
        try {
            //画像のURLを直うち
            URL url = new URL(urlString);
            //インプットストリームで画像を読み込む
            InputStream istream = url.openStream();
            //読み込んだファイルをビットマップに変換
            Bitmap oBmp = BitmapFactory.decodeStream(istream);
            //ビットマップをImageViewに設定
            imageview.setImageBitmap(oBmp);
            //インプットストリームを閉じる
            istream.close();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
    }

}
