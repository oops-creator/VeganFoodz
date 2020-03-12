package com.tosin.VeganFoodz;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.WindowManager;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "In progress", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);



        String[] maintitle ={
                "Mushroom-Quinoa Burger",
                "Tofu Pad Thai",
                "10 Things to Know About Anxiety",
                "10 health benefits of daily yoga practice" ,
                "Zucchanoush",
                "Creamy Roasted Squash Puree",
                "9 Ways Practicing Yoga Benefits Your Health and Well-Being",
                "What Is a Mendiant? Everything You Need to Know About the Chocolate Treat" ,


        };

        String[] subtitle ={
                "2 days ago",
                "2 days ago",
                "2 days ago",
                "2 days ago",
                "2 days ago",
                "2 days ago",
                "2 days ago",
                "2 days ago"
        };

        Integer[] imgid={
                R.drawable.vegan1,R.drawable.vegan2,
                R.drawable.mentalhealth,
                R.drawable.yoga1,R.drawable.vegan3,
                R.drawable.vegan4,
                R.drawable.yoga2,
                R.drawable.vegan5
        };
        ListView mainListView  = (ListView)findViewById(R.id.mainListView);
        customListAdapter adapter = new customListAdapter(this , maintitle , subtitle , imgid);
        mainListView.setAdapter((adapter));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
