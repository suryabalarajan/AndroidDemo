package com.androiddemo.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by suryabalarajan on 03/07/2019.
 */
public class CountriesActivity extends AppCompatActivity{

    private Context mContext ;
    final String TAG = CountriesActivity.this.toString();
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    private ListView mCountriesListView;
    private ArrayAdapter<String> mAdapter;
    private String[] mCountriesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countries_activity_layout);

        mContext = this;
        toolbar = (Toolbar) findViewById(R.id.countries_toolbar);
        setSupportActionBar(toolbar);
        initNavigationDrawer();

        mCountriesArray = getResources().getStringArray(R.array.countries_array);
        mCountriesListView = (ListView)findViewById(R.id.countries_listview);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mCountriesArray);
        mCountriesListView.setAdapter(mAdapter);

        // handling the click event on the list
        mCountriesListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent mIntent = new Intent(CountriesActivity.this, DetailActivity.class);
                mIntent.putExtra("Country", mCountriesArray[position]);
                startActivity(mIntent);
            }
        });
    }

    // function to handle the navigation drawer
    public void initNavigationDrawer(){

        navigationView = (NavigationView) findViewById(R.id.countries_nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();

                switch (id){

                    case R.id.profile: {

                        drawerLayout.closeDrawers();
                        finish();
                        break;
                    }
                    case R.id.countries: {

                        drawerLayout.closeDrawers();
                        break;
                    }

                }
                return false;
            }
        });

        //set up navigation drawer
        drawerLayout = (DrawerLayout) findViewById(R.id.countries_drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

}
