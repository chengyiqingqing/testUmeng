package com.sww.testumeng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    public final static String  key = "resume_arrive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTestDeviceInfo(MainActivity.this);
//        {"device_id":"dc:f0:90:86:bb:56","mac":"dc:f0:90:86:bb:56"}
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] deviceInfo = new String[2];
        try {
            if (context != null) {
                deviceInfo[0] = DeviceConfig.getDeviceIdForGeneral(context);
                deviceInfo[1] = DeviceConfig.getMac(context);
                Log.e(TAG, "getTestDeviceInfo: " + deviceInfo[0]);
                Log.e(TAG, "getTestDeviceInfo: " + deviceInfo[1]);
            }
        } catch (Exception e) {
        }
        return deviceInfo;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        Map<String,Object> map = new HashMap<>();
        map.put("111","haha1");
        map.put("222","haha2");
        map.put("333","haha3");
        MobclickAgent.onEventObject(MainActivity.this, key, map);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }



}
