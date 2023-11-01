package com.omarcomputer.javafragments;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.omarcomputer.javafragments.Model.Monster;
import com.omarcomputer.javafragments.Model.MonsterViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentStateAdapter {
    private MonsterViewModel viewModel;
    public List<Monster> monstersList;
    public  List<Fragment> fragmentList = new ArrayList();

    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
