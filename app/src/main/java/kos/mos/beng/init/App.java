package kos.mos.beng.init;

import android.app.Application;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import kos.mos.beng.R;
import kos.mos.beng.constants.Code;
import kos.mos.beng.tool.ULog;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:48
 * @Email: KosmoSakura@foxmail.com
 */
public class App extends Application {
    public static App instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        initBugly();
        initLog();
    }

    private void initBugly() {
        Beta.largeIconId = R.mipmap.ic_launcher;//设置通知栏大图标，largeIconId为项目中的图片资源；
        Beta.smallIconId = R.mipmap.ic_launcher;//设置状态栏小图标，smallIconId为项目中的图片资源id;
        Beta.showInterruptedStrategy = true;//点击过确认的弹窗在APP下次启动自动检查更新时会再次显示;
        Bugly.init(this, Code.code, false);
    }

    private void initLog() {
        ULog.init(this)
            .setLogSwitch(Code.DebugState)
            .setConsoleSwitch(Code.DebugState)
            .setGlobalTag("Sakura")
            .setLogHeadSwitch(true)
            .setLog2FileSwitch(false)
            .setDir("")
            .setFilePrefix("Sakura")
            .setBorderSwitch(true)
            .setSingleTagSwitch(true)
            .setConsoleFilter(ULog.V)
            .setFileFilter(ULog.V)
            .setStackDeep(1)// log 栈深度，默认为 1
            .setStackOffset(0);
    }

    public static App getInstance() {
        return instances;
    }


}
