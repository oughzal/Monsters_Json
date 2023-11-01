package com.omarcomputer.javafragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.omarcomputer.javafragments.Model.Monster;
import com.omarcomputer.javafragments.Utils.FileHelper;

import java.io.Serializable;

public class MonsterPage extends Fragment {

    private Monster monster;
    private ImageView monsterImage;
    private TextView monsterName;
    public MonsterPage() {
        // Required empty public constructor
    }

    public static MonsterPage newInstance(Monster monster) {
        MonsterPage fragment = new MonsterPage();
        Bundle args = new Bundle();
        args.putSerializable("monster", (Serializable) monster);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            monster = (Monster) getArguments().getSerializable("monster");

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monster_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        monsterImage = view.findViewById(R.id.monsterImage);
        monsterName = view.findViewById(R.id.monsterName);
        monsterName.setText(monster.getMonsterName());
        FileHelper.loadImageIntroImageView(getContext(), monsterImage, monster.getImageFile() + ".webp");
    }
}