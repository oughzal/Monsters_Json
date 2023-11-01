package com.omarcomputer.javafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.omarcomputer.javafragments.Model.Monster;
import com.omarcomputer.javafragments.Model.MonsterViewModel;
import com.omarcomputer.javafragments.Utils.FileHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MonsterViewModel viewModel;
    public  List<Fragment> fragmentList = new ArrayList();
    private List<Monster> monstersList;
    ViewPageAdapter viewPageAdapter;
    ImageView monsterImage;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        viewModel = new MonsterViewModel(this);

        try {
            viewModel.getMonsters().observe(this, new Observer<List<Monster>>() {
                @Override
                public void onChanged(List<Monster> monsters) {
                    monstersList = monsters;
                    for(Monster monster : monsters){
                        viewPageAdapter.fragmentList.add(MonsterPage.newInstance(monster));
                        viewPager.setAdapter(viewPageAdapter);
                    }
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        viewPageAdapter= new ViewPageAdapter(this);
        ;
        //Log.i("TAGMonsters",monsters.get(0).toString());
       // Bitmap bitmap = FileHelper.getImageFromAssets(this,"monster05.webp");
        //FileHelper.loadImageIntroImageView(this, monsterImage,"monster05.webp");


    }
}