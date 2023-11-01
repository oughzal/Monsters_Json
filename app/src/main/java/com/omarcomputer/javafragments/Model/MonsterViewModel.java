package com.omarcomputer.javafragments.Model;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.lang.reflect.Type;
import com.omarcomputer.javafragments.Utils.FileHelper;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.util.List;

public class MonsterViewModel extends ViewModel {

    private MutableLiveData<List<Monster>> monsters = new MutableLiveData<>();
    private Moshi moshi;
    private Context context;
    MonsterViewModel(){

    }
    public MonsterViewModel(Context context){
        this.context = context;
        moshi = new Moshi.Builder().build();
    }

    public void loadMonsters() throws IOException {
        String jsonContent = FileHelper.readJsonFromAssets(context,"monster_data.json");

        if (jsonContent !=null){

            parseJson(jsonContent);
        }
        else{
            Log.i("MonsterTag","Null");
        }
    }

    private void parseJson(String jsonContent) throws IOException {
            Type type = Types.newParameterizedType(List.class, Monster.class);
            List<Monster> monstersParsed = (List<Monster>) moshi.adapter(type).fromJson(jsonContent);
        monsters.setValue(monstersParsed);

    }


    public LiveData<List<Monster>>  getMonsters() throws IOException {
        loadMonsters();
        return this.monsters;
    }

}
