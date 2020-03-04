package com.sww.testumeng;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;

/**
 * 友盟appkey。    工作台 --》 产品 -》 移动统计 --》android
 */
public class UmengApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /** 1
         * 注意: 即使您已经在AndroidManifest.xml中配置过appkey和channel值，也需要在App代码中调
         * 用初始化接口（如需要使用AndroidManifest.xml中配置好的appkey和channel值，
         * UMConfigure.init调用中appkey和channel参数请置为null）。
         */
        UMConfigure.init(this,"5e5e5af7167edd89ee00002b","channel_free",1,"pushSecret");
        /** 2
         * 设置组件化的Log开关:App正式上线前请关闭SDK运行调试日志。避免无关Log输出。
         * 参数: boolean 默认为false，如需查看LOG设置为true
         * 日志过来Tag:UMConfigure
         */
        UMConfigure.setLogEnabled(true);
//        UMConfigure.setEncryptEnabled(true);
    }

}
