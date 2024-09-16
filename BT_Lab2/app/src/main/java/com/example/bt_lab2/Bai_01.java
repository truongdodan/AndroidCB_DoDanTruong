package com.example.bt_lab2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.InterpolatorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class Bai_01 extends AppCompatActivity {
    private ArrayList<Integer> colors;
    private ArrayList<Integer> images;
    private int ranColor, ranImg;
    private ImageView image;
    private LinearLayout layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m001_act_splash);
        images = new ArrayList<>();
        images.add(R.drawable.cat);
        images.add(R.drawable.penguin);
        images.add(R.drawable.dinosaur);
        images.add(R.drawable.duck);
        images.add(R.drawable.shiba);

        colors = new ArrayList<>();
        colors.add(R.color.orange);
        colors.add(R.color.light_red);
        colors.add(R.color.purple_200);
        colors.add(R.color.teel_200);
        colors.add(R.color.white);

        ranColor = new Random().nextInt(5);
        ranImg = new Random().nextInt(5);

        image = (ImageView) findViewById(R.id.imgVw);
        layout = findViewById(R.id.liLay);

        layout.setBackgroundResource(colors.get(ranColor));
        image.setImageResource(images.get(ranImg));


    }
}
