package kos.mos.beng.init;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.tencent.bugly.Bugly;

import kos.mos.beng.constants.Code;
import kos.mos.beng.dao.gen.DaoMaster;
import kos.mos.beng.dao.gen.DaoSession;
import kos.mos.beng.tool.ULog;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:48
 * @Email: KosmoSakura@foxmail.com
 */
public class App extends Application {
    private SQLiteDatabase db;
    private DaoSession mDaoSession;
    public static App instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
        initBugly();
        initLog();
    }
//https://bugly.qq.com/docs/user-guide/instruction-manual-android-upgrade/?v=20180709165613
    //https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=monline_dg&wd=bugly%20%E6%94%B6%E4%B8%8D%E5%88%B0%20%E6%9B%B4%E6%96%B0%E6%8E%A8%E9%80%81&oq=bugly%2520%25E6%2594%25B6%25E4%25B8%258D%25E5%2588%25B0%25E6%259B%25B4%25E6%2596%25B0&rsv_pq=ea4def7400073a73&rsv_t=7521nbthuqAOwbJND5wA0zsTqZ12gf1x1q9QCytiZL0WbTsdSBY2FAoU0OHNtxvlgQ&rqlang=cn&rsv_enter=1&rsv_sug3=8&rsv_sug2=0&inputT=16699&rsv_sug4=19281
    private void initBugly() {
//        Beta.autoInit = true;//true表示app启动自动初始化升级模块；
//        Beta.autoCheckUpgrade = true;//true表示初始化时自动检查升级
//        Beta.initDelay = 1 * 1000;//设置升级周期为60s（默认检查周期为0s），60s内SDK不重复向后天请求策略
//        Beta.largeIconId = R.mipmap.ic_launcher;//设置通知栏大图标，largeIconId为项目中的图片资源；
//        Beta.smallIconId = R.mipmap.ic_launcher;//设置状态栏小图标，smallIconId为项目中的图片资源id;
//        Beta.storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        Beta.showInterruptedStrategy = true;//点击过确认的弹窗在APP下次启动自动检查更新时会再次显示;
//        Beta.enableNotification = true;//设置是否显示消息通知
//        Beta.canShowApkInfo = true;//使用默认弹窗
//        Beta.enableHotfix = false;//关闭或开启热更新能力,默认开启
        /**
         * 只允许在MainActivity上显示更新弹窗，其他activity上不显示弹窗;
         * 不设置会默认所有activity都可以显示弹窗;
         */
//          Beta.canShowUpgradeActs.add(MainActivity.class);
//        // 不在登录activity上显示弹窗
//        Beta.canNotShowUpgradeActs.add(MainActivity.class);

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

    private void setDatabase() {
        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(this, "beng-db", null);
        db = mHelper.getWritableDatabase();
        DaoMaster mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
