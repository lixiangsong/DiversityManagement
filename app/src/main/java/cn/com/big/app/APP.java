package cn.com.big.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;

import java.util.HashMap;

/**
 * 程序入口.
 *
 * @author luyh
 * @version 1.0
 * @date 2019/04/09
 */
public class APP extends Application {

    protected static APP instance;

    /**
     * 获取APP实例
     */
    public static APP getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initX5WebView();
    }

    /**
     * 初始化X5的设置
     */
    private void initX5WebView() {
        // 在调用TBS初始化、创建WebView之前进行如下配置, 以开启优化方案(仅Android 5.1+生效)
        HashMap<String, Object> map = new HashMap<>();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        QbSdk.initTbsSettings(map);
        // x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), null);
        // 非wifi网络条件下是否允许下载内核，默认为false(针对用户没有安装微信/手Q/QQ空间[无内核]的情况下)
        QbSdk.setDownloadWithoutWifi(true);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(getApplicationContext());
    }
}
