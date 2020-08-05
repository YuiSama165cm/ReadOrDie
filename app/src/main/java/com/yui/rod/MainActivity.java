package com.yui.rod;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yui.rod.view.SplashView;

/**
 * 山外青山楼外楼，西湖歌舞几时休
 * 暖风熏得游人醉，直把杭州变汴州
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SplashView(this));
    }
}
