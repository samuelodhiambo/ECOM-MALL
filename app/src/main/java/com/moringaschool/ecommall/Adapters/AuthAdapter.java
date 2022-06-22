package com.moringaschool.ecommall.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.moringaschool.ecommall.ui.AuthFragments.LoginFragment;
import com.moringaschool.ecommall.ui.AuthFragments.SignUpFragment;

public class AuthAdapter extends FragmentPagerAdapter {
    int totalTabs;

    public AuthAdapter(FragmentManager fm, int totalTabs){
        super(fm);
        this.totalTabs = totalTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new SignUpFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
