package com.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.R;
import com.example.config.CommonFunctions;
import com.example.fragment.AllRequestFragment;
import com.example.fragment.ContactUsFragment;
import com.example.fragment.EditProfileFragment;
import com.example.fragment.HomeFragment;
import com.example.fragment.ManageVacancyFragment;
import com.example.fragment.NotificationFragment;
import com.example.login.LoginActivity;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Constants;

public class HomeCompanyActivity extends AppCompatActivity {

    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.rl_menu)
    RelativeLayout rlMenu;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.drawer)
    RelativeLayout drawer;
    ImageView iv_image;
    TextView tv_name;
    TextView tv_compname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_company);
        init();
    }

    private void init() {
        try {
            ButterKnife.bind(this);
            setupDrawerContent(navView);
            iv_image = navView.getHeaderView(0).findViewById(R.id.iv_image);
            tv_name = navView.getHeaderView(0).findViewById(R.id.tv_name);
            tv_compname = navView.getHeaderView(0).findViewById(R.id.tv_companyname);
           /* if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(Constants.))
                tv_name = getIntent().getExtras().getString(Constants.name);

            if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(Constants.email))
                tv_compname = getIntent().getExtras().getString(Constants.name);*/
            loadFragment(new HomeFragment());
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
        Class fragmentClass=null;
        MenuItem item=null;
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
            loadFragment(new HomeFragment());
            break;
            case R.id.nav_add_vacancy:
                Intent i=new Intent(HomeCompanyActivity.this, AddVacancyActivity.class);
                startActivity(i);
                break;
            case R.id.nav_manage_vacncy:
                fragmentClass = ManageVacancyFragment.class;
                break;
            case R.id.nav_all_request:
                fragmentClass = AllRequestFragment.class;
                break;
            case R.id.nav_notification:
               fragmentClass=NotificationFragment.class;
                break;
            case R.id.nav_edit_profile:
                fragmentClass= EditProfileFragment.class;
                break;
            case  R.id.nav_contact_us:
                fragmentClass= ContactUsFragment.class;
                break;
            case R.id.nav_about:
                Intent about=new Intent(HomeCompanyActivity.this, AboutActivity.class);
                startActivity(about);
                break;
            case R.id.nav_logout:
                CommonFunctions.changeactivity(HomeCompanyActivity.this, LoginActivity.class);
                break;
            default:
                fragmentClass = HomeFragment.class;
        }
        try {
            if(fragmentClass!=null) {
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
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}