package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.R;
import com.example.fragment.AllRequestFragment;
import com.example.fragment.ContactUsFragment;
import com.example.fragment.EditProfileFragment;
import com.example.fragment.HomeFragment;
import com.example.fragment.NotificationFragment;
import com.example.fragment.UserAllRequestFragment;
import com.example.fragment.UserContactUsFragment;
import com.example.fragment.UserEditProfileFragment;
import com.example.fragment.UserHomeFragment;
import com.example.fragment.UserNotificationFragment;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserHomeActivity extends AppCompatActivity {

    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.drawer)
    RelativeLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        init();
    }

    private void init() {
        try {
            ButterKnife.bind(this);
            setupDrawerContent(navView);
            loadFragment(new UserHomeFragment());
            ivMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    private void setupDrawerContent(NavigationView navView) {
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                selectDrawerItem(menuItem);
                return true;
            }
        });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;
        Class fragmentClass = null;
        MenuItem item = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                loadFragment(new UserHomeFragment());
                break;
            case R.id.nav_all_request:
                fragmentClass = UserAllRequestFragment.class;
                break;
            case R.id.nav_notification:
                fragmentClass= UserNotificationFragment.class;
                break;
            case R.id.nav_edit_profile:
                fragmentClass= UserEditProfileFragment.class;
                break;
            case  R.id.nav_contact_us:
                fragmentClass= UserContactUsFragment.class;
                break;
            case R.id.nav_about:
                Intent about=new Intent(UserHomeActivity.this, UserAboutActivity.class);
                startActivity(about);
                break;
            case R.id.nav_logout:
                break;
            default:
                fragmentClass = UserHomeFragment.class;
        }
        try {
            if (fragmentClass != null) {
                fragment = (Fragment) fragmentClass.newInstance();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        menuItem.setChecked(true);

        setTitle(menuItem.getTitle());

        drawerLayout.closeDrawers();

    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}