package com.omarcomputer.javafragments.Utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileHelper {

    public static String getJsonFromRaw(Context context,int resourceID){
        StringBuilder builder = new StringBuilder();
        try (InputStream inputStream = context.getResources().openRawResource(resourceID);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String readJsonFromAssets(Context context, String fileName) {
        StringBuilder builder = new StringBuilder();
        try (InputStream inputStream = context.getAssets().open(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static Bitmap getImageFromAssets(Context context,String fileName){
        try {
            AssetManager assetManager = context.getAssets();
            InputStream is = assetManager.open(fileName);
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            return  bitmap;
        } catch (IOException e) {
            return null;
        }
    }

    public static void loadImageIntroImageView(Context context, ImageView view,String fileNome){
        Glide.with(context)
                .load("file:///android_asset/"+ fileNome)
                .into(view);
    }
}
