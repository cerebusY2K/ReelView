package com.serbus.reelerview;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

public class Reeler {
    public static void showReeler(ArrayList<ReelModel> reelModelList, Context context){
        Intent intent = new Intent(context,ReelerActivity.class);
        intent.putExtra("reels", reelModelList);
        context.startActivity(intent);
    }
}
