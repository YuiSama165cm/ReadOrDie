package com.yui.rod.density;

import android.os.Bundle;

import com.yui.rod.R;

public class DensityActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //设置density
        DensityUtils.setDensity(getApplication(), this);
        setContentView(R.layout.activity_density);
    }

}
