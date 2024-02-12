package com.serbus.reelerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class ReelerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reeler);

        final ViewPager2 videosViewPager = findViewById(R.id.MainViewPager);

        Intent intent = getIntent();
        List<ReelModel> reelModelList = (ArrayList<ReelModel>) intent.getSerializableExtra("reels");


        // here you can add more videos of your choice

        // adapter
        videosViewPager.setAdapter(new VideoAdapter(reelModelList));
    }
}