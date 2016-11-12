package com.example.android.challenge;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.ViewDragHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ChallengeActivity extends AppCompatActivity {
    List<Challenge> challengeList;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case(R.id.nav_profile):
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(ChallengeActivity.this, ProfileActivity.class));
                        mDrawerLayout.closeDrawers();
                        return true;
                }
                return false;
            }
        });
        Field mDragger;
        Field mEdgeSize;
        try {
            mDragger = mDrawerLayout.getClass().getDeclaredField(
                    "mLeftDragger");//mRightDragger for right obviously
            mDragger.setAccessible(true);
            ViewDragHelper draggerObj;
            try {
                draggerObj = (ViewDragHelper) mDragger
                        .get(mDrawerLayout);
                mEdgeSize = draggerObj.getClass().getDeclaredField(
                        "mEdgeSize");
                mEdgeSize.setAccessible(true);
                int edge = mEdgeSize.getInt(draggerObj);
                mEdgeSize.setInt(draggerObj, edge * 5); //optimal value as for me, you may set any constant in dp
            }
            catch (IllegalAccessException a){
            }

        }
        catch (NoSuchFieldException n){

        }

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        challengeList = new ArrayList<Challenge>();
        challengeList.add(new Challenge(3, "2.7 mi", "Madonna"));
        challengeList.add(new Challenge(4, "4 mi", "Bishops"));
        challengeList.add(new Challenge(3, "7 mi", "Reservoir Canyon"));
        challengeList.add(new Challenge(1, "3 mi", "Bob Jones Trail"));
        challengeList.add(new Challenge(2, "6 mi", "Harmony Headlands"));
        challengeList.add(new Challenge(3, "4 mi", "Valencia Peak"));
        challengeList.add(new Challenge(2, "3 mi", "Cerro Alto"));
        challengeList.add(new Challenge(2, "3.5 mi", "Mariposa"));
        challengeList.add(new Challenge(1, "3 mi", "Johnson Trail"));
        challengeList.add(new Challenge(2, "2 mi", "Black Hill"));
        challengeList.add(new Challenge(3, "2.7 mi", "Madonna"));
        challengeList.add(new Challenge(4, "4 mi", "Bishops"));
        challengeList.add(new Challenge(3, "7 mi", "Reservoir Canyon"));
        challengeList.add(new Challenge(1, "3 mi", "Bob Jones Trail"));
        challengeList.add(new Challenge(2, "6 mi", "Harmony Headlands"));
        challengeList.add(new Challenge(3, "4 mi", "Valencia Peak"));
        challengeList.add(new Challenge(2, "3 mi", "Cerro Alto"));
        challengeList.add(new Challenge(2, "3.5 mi", "Mariposa"));
        challengeList.add(new Challenge(1, "3 mi", "Johnson Trail"));
        challengeList.add(new Challenge(2, "2 mi", "Black Hill"));


        ChallengeListAdapter challengeListAdapter = new ChallengeListAdapter(this, challengeList, this);
        recyclerView.setAdapter(challengeListAdapter);
    }
}
