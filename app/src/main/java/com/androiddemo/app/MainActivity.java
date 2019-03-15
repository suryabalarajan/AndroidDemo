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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

/**
 * Created by suryabalarajan on 03/06/2019.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext ;
    final String TAG = MainActivity.this.toString();
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    private RelativeLayout educationTextLayout, skillsTextLayout, workExpTextLayout, projTextLayout,
        aProjTextLayout, ecTextLayout;
    private LinearLayout educationLayout, workExpLayout;
    private TableLayout skillsLayout, projLayout, aProjLayout, ecLayout;
    private ImageView arrow1, arrow2, arrow3, arrow4, arrow5, arrow6;
    private Boolean educationFlag, skillsFlag, workExpFlag, projFlag, aProjFlag, ecFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        mToolbar = (Toolbar) findViewById(R.id.countries_toolbar);
        setSupportActionBar(mToolbar);
        initNavigationDrawer();

        init();
    }

    // Initializing the UI elements
    public void init() {

        educationTextLayout = (RelativeLayout) findViewById(R.id.educationtext_layout);
        skillsTextLayout = (RelativeLayout) findViewById(R.id.skillstext_layout);
        workExpTextLayout  = (RelativeLayout) findViewById(R.id.workexptext_layout);
        projTextLayout = (RelativeLayout) findViewById(R.id.projectstext_layout);
        aProjTextLayout = (RelativeLayout) findViewById(R.id.aprojectstext_layout);
        ecTextLayout = (RelativeLayout) findViewById(R.id.ectext_layout);
        educationLayout = (LinearLayout) findViewById(R.id.education_layout);
        workExpLayout = (LinearLayout) findViewById(R.id.workexp_layout);
        skillsLayout = (TableLayout) findViewById(R.id.skills_layout);
        projLayout = (TableLayout) findViewById(R.id.projects_layout);
        aProjLayout = (TableLayout) findViewById(R.id.academic_projects_layout);
        ecLayout = (TableLayout) findViewById(R.id.ec_activities_layout);
        arrow1 = (ImageView) findViewById(R.id.arrow1);
        arrow2 = (ImageView) findViewById(R.id.arrow2);
        arrow3 = (ImageView) findViewById(R.id.arrow3);
        arrow4 = (ImageView) findViewById(R.id.arrow4);
        arrow5 = (ImageView) findViewById(R.id.arrow5);
        arrow6 = (ImageView) findViewById(R.id.arrow6);
        educationFlag = true;
        skillsFlag = true;
        workExpFlag = true;
        projFlag = true;
        aProjFlag = true;
        ecFlag = true;

        educationTextLayout.setOnClickListener(this);
        skillsTextLayout.setOnClickListener(this);
        workExpTextLayout.setOnClickListener(this);
        projTextLayout.setOnClickListener(this);
        aProjTextLayout.setOnClickListener(this);
        ecTextLayout.setOnClickListener(this);

    }

    // function to handle the UI elements
    @Override
    public void onClick(View view) {

        int mID = view.getId();

        switch (mID) {
            case R.id.educationtext_layout: {
                if(educationFlag == false) {
                    educationLayout.setVisibility(View.GONE);
                    arrow1.setImageResource(R.drawable.menu_arrow_end);
                    educationFlag = true;
                } else {
                    educationLayout.setVisibility(View.VISIBLE);
                    arrow1.setImageResource(R.drawable.menu_arrow_bottom);
                    educationFlag = false;
                }
                break;
            }
            case R.id.skillstext_layout: {
                if(skillsFlag == false){
                    skillsLayout.setVisibility(View.GONE);
                    arrow2.setImageResource(R.drawable.menu_arrow_end);
                    skillsFlag = true;
                } else {
                    skillsLayout.setVisibility(View.VISIBLE);
                    arrow2.setImageResource(R.drawable.menu_arrow_bottom);
                    skillsFlag = false;
                }


                break;
            }
            case R.id.workexptext_layout: {
                if(workExpFlag == false) {
                    workExpLayout.setVisibility(View.GONE);
                    arrow3.setImageResource(R.drawable.menu_arrow_end);
                    workExpFlag = true;
                }else {
                    workExpLayout.setVisibility(View.VISIBLE);
                    arrow3.setImageResource(R.drawable.menu_arrow_bottom);
                    workExpFlag = false;
                }
                break;
            }
            case R.id.projectstext_layout: {
                if(projFlag == false) {
                    projLayout.setVisibility(View.GONE);
                    arrow4.setImageResource(R.drawable.menu_arrow_end);
                    projFlag = true;
                } else {
                    projLayout.setVisibility(View.VISIBLE);
                    arrow4.setImageResource(R.drawable.menu_arrow_bottom);
                    projFlag = false;
                }
                break;
            }
            case R.id.aprojectstext_layout: {
                if(aProjFlag == false) {
                    aProjLayout.setVisibility(View.GONE);
                    arrow5.setImageResource(R.drawable.menu_arrow_end);
                    aProjFlag = true;
                } else {
                    aProjLayout.setVisibility(View.VISIBLE);
                    arrow5.setImageResource(R.drawable.menu_arrow_bottom);
                    aProjFlag = false;
                }

                break;
            }
            case R.id.ectext_layout: {
                if(ecFlag == false) {
                    ecLayout.setVisibility(View.GONE);
                    arrow6.setImageResource(R.drawable.menu_arrow_end);
                    ecFlag = true;
                } else {
                    ecLayout.setVisibility(View.VISIBLE);
                    arrow6.setImageResource(R.drawable.menu_arrow_bottom);
                    ecFlag = false;
                }
                break;
            }
        }

    }

    // function to handle the navigation drawer
    public void initNavigationDrawer(){

        mNavigationView = (NavigationView) findViewById(R.id.countries_nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                int id = item.getItemId();

                switch (id){

                    case R.id.profile: {

                        mDrawerLayout.closeDrawers();
                        break;
                    }
                    case R.id.countries: {

                        mDrawerLayout.closeDrawers();
                        Intent intent = new Intent(MainActivity.this, CountriesActivity.class);
                        startActivity(intent);
                        break;
                    }

                }
                return false;
            }
        });

        //set up navigation drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

}
