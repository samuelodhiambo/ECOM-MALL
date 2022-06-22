package com.moringaschool.ecommall.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.moringaschool.ecommall.Adapters.AuthAdapter;
import com.moringaschool.ecommall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AuthenticationActivity extends AppCompatActivity {
    @BindView(R.id.authTabLayout)
    TabLayout authTabLayout;
    @BindView(R.id.authViewPager)
    ViewPager authViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        ButterKnife.bind(this);

        TabLayout.Tab loginTab = authTabLayout.newTab();
        loginTab.setText("Log In");
        authTabLayout.addTab(loginTab);

        TabLayout.Tab signupTab = authTabLayout.newTab();
        signupTab.setText("Sign Up");
        authTabLayout.addTab(signupTab);

        authTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        AuthAdapter adapter = new AuthAdapter(getSupportFragmentManager(), authTabLayout.getTabCount());
        authViewPager.setAdapter(adapter);
        authViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(authTabLayout));

        authTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                authViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}