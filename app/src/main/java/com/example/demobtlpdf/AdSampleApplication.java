package com.example.demobtlpdf;

import android.app.Application;
import com.huawei.hms.ads.HwAds;
public class AdSampleApplication extends Application {
    public void onCreate(){
        super.onCreate();

        HwAds.init(this);
    }
}
