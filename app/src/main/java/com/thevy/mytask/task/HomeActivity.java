package com.thevy.mytask.task;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.thevy.mytask.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRcvAdapter;
    List<Task> data = new ArrayList<>();
    Button btnOKTask;
    TextView tvReward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Home Activity", "Start Home Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //getListTask(); //TODO

        data.add(new Task(0, "Day luc 6h", 1, 1));
        data.add(new Task(1, "doc 30 trang sach", 1, 1));
        data.add(new Task(2, "tap thu duc 30p", 1, 1));
        mRcvAdapter = new RecyclerViewAdapter(getApplicationContext(), data);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mRcvAdapter);

        mRcvAdapter.setOnItemClickedListener(new RecyclerViewAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(int position, boolean isChecked) {
                //tu khong check -> check: isChecked = true
                //cap nhat data  //TODO
                //Toast.makeText(HomeActivity.this, String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
            }
        });

        btnOKTask = (Button) findViewById(R.id.btnOKTask);
        btnOKTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateListTask();
            }
        });

        tvReward = (TextView) findViewById(R.id.tvReward);
        tvReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RewardActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getListTask() {
        //TODO
    }

    private void updateListTask() {
        //TODO
    }

    //danh cho left navigation
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
