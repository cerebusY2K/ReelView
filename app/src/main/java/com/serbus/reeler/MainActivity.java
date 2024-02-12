package com.serbus.reeler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;

import com.serbus.reelerview.ReelModel;
import com.serbus.reelerview.Reeler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ReelModel> reelModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ReelModel videoItems1 = new ReelModel();
        videoItems1.videoURL = "https://cdn.discordapp.com/attachments/1011618287328698508/1094297434907230328/The_BEST_Advice_For_Learning_Data_Structures_and_Algorithms_Ft._Sandeep_Jain_Founder_of_GFG.mp4";
        videoItems1.videoTitle = "GFG KARLO HO JAAYEGA";
        videoItems1.VideoDescription = "Test1";
        reelModelList.add(videoItems1);

        ReelModel videoItems2 = new ReelModel();
        videoItems2.videoURL = "https://assets.mixkit.co/videos/preview/mixkit-waves-in-the-water-1164-large.mp4";
        videoItems2.videoTitle = "Playing 2nd video";
        videoItems2.VideoDescription = "Test2";
        reelModelList.add(videoItems2);

        ReelModel videoItems3 = new ReelModel();
        videoItems3.videoURL = "https://assets.mixkit.co/videos/preview/mixkit-pink-and-blue-ink-1192-large.mp4";
        videoItems3.videoTitle = "Playing 3rd video";
        videoItems3.VideoDescription = "Test3";
        reelModelList.add(videoItems3);

        ReelModel videoItems5 = new ReelModel();
        videoItems5.videoURL = "https://assets.mixkit.co/videos/preview/mixkit-tree-with-yellow-flowers-1173-large.mp4";
        videoItems5.videoTitle = "Playing 4th video";
        videoItems5.VideoDescription = "Test4";
        reelModelList.add(videoItems5);

        ReelModel videoItems4 = new ReelModel();
        videoItems4.videoURL = "https://cdn.discordapp.com/attachments/1011618287328698508/1094292482734432436/GFG_Karlo_Ho_Jayega___GeeksforGeeks_Shorts.mp4";
        videoItems4.videoTitle = "Playing 5th video";
        videoItems4.VideoDescription = "Test5";
        reelModelList.add(videoItems4);



        final AppCompatButton button = findViewById(R.id.reelButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reeler.showReeler(reelModelList,MainActivity.this);
            }
        });


    }
}