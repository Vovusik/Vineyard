package com.vineyard.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.vineyard.fragments.BugTabFragment;
import com.vineyard.fragments.LibraryFragment;
import com.vineyard.fragments.PreparationFragment;
import com.vineyard.R;
import com.vineyard.fragments.ReproductionFragment;
import com.vineyard.fragments.SettingsFragment;
import com.vineyard.fragments.StructureFragment;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationStartActivity();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        final LinearLayout holder = findViewById(R.id.holder);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // этот код - реальный игрок, стоящий за этим красивым пользовательским интерфейсом,
                // в основном это математический расчет, который обрабатывает сжатие
                // нашего представления содержимого

                float scaleFactor = 7f;
                float slideX = drawerView.getWidth() * slideOffset;

                holder.setTranslationX(slideX);
                holder.setScaleX(1 - (slideOffset / scaleFactor));
                holder.setScaleY(1 - (slideOffset / scaleFactor));

                super.onDrawerSlide(drawerView, slideOffset);
            }
        };

        drawer.addDrawerListener(toggle);

        //drawer.setScrimColor(Color.TRANSPARENT); // Затемнення прозоре
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navigationView, navController);
        navigationView.setNavigationItemSelectedListener(this);

        //loadFragment(new StructureFragment());
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        // Встановлюю анімацію екрана при переході на інші актівіті
//        // при нажатии нижних элементов навигации экрана
//        animationStartActivity();
//    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
           drawer.closeDrawer(Gravity.LEFT, true);
            // drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.nav_structure:
                setTitle(R.string.menu_structure);
                fragment = new StructureFragment();
                break;
            case R.id.nav_reproduction:
                setTitle(R.string.menu_reproduction);
                fragment = new ReproductionFragment();
                break;
            case R.id.nav_bug:
                setTitle(R.string.menu_bug);
                fragment = new BugTabFragment();
                break;
            case R.id.nav_preparation:
                setTitle(R.string.menu_preparation);
                fragment = new PreparationFragment();
                break;
            case R.id.nav_library:
                setTitle(R.string.menu_library);
                fragment = new LibraryFragment();
                break;
            case R.id.nav_settings:
                setTitle(R.string.menu_settings);
                fragment = new SettingsFragment();
                break;
//            default: {
//                fragment = new StructureFragment();
//                break;
//            }
        }

       // onBackPressed();
//        drawer.closeDrawers();
//        return true;


        drawer.closeDrawer(Gravity.LEFT, true);
        //drawer.closeDrawer(GravityCompat.START);
        // return true;
        return loadFragment(fragment);
    }

    private void animationStartActivity() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
                    .replace(R.id.flContent, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}