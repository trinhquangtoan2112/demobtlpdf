package com.example.demobtlpdf;

import androidx.appcompat.app.AppCompatActivity;
import com.huawei.hms.ads.HwAds;

import android.os.Bundle;

import com.huawei.hms.ads.banner.BannerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HwAds.init(this);

    }

}