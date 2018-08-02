package kos.mos.beng.init;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.tencent.bugly.crashreport.CrashReport;

import kos.mos.beng.constants.Code;
import kos.mos.beng.dao.gen.DaoMaster;
import kos.mos.beng.dao.gen.DaoSession;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:48
 * @Email: KosmoSakura@foxmail.com
 */
public class App extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    public static App instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
        CrashReport.initCrashReport(getApplicationContext(), Code.code, false);
    }

    public static App getInstance() {
        return instances;
    }

    private void setDatabase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "beng-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}
