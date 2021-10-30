/*
 *  Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
 *  This subclass is created by HMS Core Toolkit 
 *  and used to receive token information or messages returned by HMS server
 *
 */
package com.example.demobtlpdf;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.InterstitialAd;

/**
 * Activity for displaying an interstitial ad.
 */
public class InterstitialActivity extends AppCompatActivity {
    private static final String TAG = InterstitialActivity.class.getSimpleName();

    private RadioGroup displayRadioGroup;
    private Button loadAdButton;

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial_ads);

        // Initialize the HUAWEI Ads SDK.
        HwAds.init(this);

        displayRadioGroup = findViewById(R.id.display_radio_group);

        loadAdButton = findViewById(R.id.load_ad);
        loadAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadInterstitialAd();
            }
        });

    }

    private AdListener adListener = new AdListener() {
        @Override
        public void onAdLoaded() {
            super.onAdLoaded();
            Toast.makeText(InterstitialActivity.this, "Ad loaded", Toast.LENGTH_SHORT).show();
            // Display an interstitial ad.
            showInterstitial();
        }

        @Override
        public void onAdFailed(int errorCode) {
            Toast.makeText(InterstitialActivity.this, "Ad load failed with error code: " + errorCode,
                    Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Ad load failed with error code: " + errorCode);
        }

        @Override
        public void onAdClosed() {
            super.onAdClosed();
            Log.d(TAG, "onAdClosed");
        }

        @Override
        public void onAdClicked() {
            Log.d(TAG, "onAdClicked");
            super.onAdClicked();
        }

        @Override
        public void onAdOpened() {
            Log.d(TAG, "onAdOpened");
            super.onAdOpened();
        }
    };

    private void loadInterstitialAd() {
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdId(getAdId());
        interstitialAd.setAdListener(adListener);

        AdParam adParam = new AdParam.Builder().build();
        interstitialAd.loadAd(adParam);
    }

    private String getAdId() {
        if (displayRadioGroup.getCheckedRadioButtonId() == R.id.display_image) {
            return "teste9ih9j0rc3";
        } else {
            return "testb4znbuh3n2";
        }
    }

    private void showInterstitial() {
        // Display an interstitial ad.
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
        }
    }
}
