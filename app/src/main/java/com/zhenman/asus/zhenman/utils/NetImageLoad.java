package com.zhenman.asus.zhenman.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class NetImageLoad {
    private ImageView imageView;
    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
            loadImage(imageView, bitmap);
        };
    };

    public abstract void loadImage(ImageView imageView,Bitmap bitmap);

    public void downloadImage(ImageView imageView,final String imgUrl){
        this.imageView  =imageView;
        new Thread(){
            public void run() {
                try {
                    URL url = new URL(imgUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);

                    InputStream is = connection.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);

                    sleep(2000);

                    Message message = new Message();
                    message.obj = bitmap;
                    handler.sendMessage(message);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }
}