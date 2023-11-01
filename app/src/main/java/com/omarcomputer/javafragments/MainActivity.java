package com.omarcomputer.javafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.omarcomputer.javafragments.Model.Monster;
import com.omarcomputer.javafragments.Model.MonsterViewModel;
import com.omarcomputer.javafragments.Utils.FileHelper;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MonsterViewModel viewModel;
    private List<Monster> monsters;
    ImageView monsterImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monsterImage = findViewById(R.id.monsterImage);
        viewModel = new MonsterViewModel(this);
        try {
            viewModel.getMonsters().observe(this, new Observer<List<Monster>>() {
                @Override
                public void onChanged(List<Monster> monsters) {
                    FileHelper.loadImageIntroImageView(getApplicationContext(), monsterImage,monsters.get(0).getImageFile()+".webp");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Log.i("TAGMonsters",monsters.get(0).toString());
       // Bitmap bitmap = FileHelper.getImageFromAssets(this,"monster05.webp");
        //FileHelper.loadImageIntroImageView(this, monsterImage,"monster05.webp");


    }
}