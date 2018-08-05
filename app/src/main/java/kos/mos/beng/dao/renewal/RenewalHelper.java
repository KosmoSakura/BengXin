package kos.mos.beng.dao.renewal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

import kos.mos.beng.dao.gen.DaoMaster;
import kos.mos.beng.dao.gen.EventBeanDao;
import kos.mos.beng.dao.gen.PlayerBeanDao;
import kos.mos.beng.tool.ULog;

/**
 * @Description: 数据库升级辅助类
 * @Author: Kosmos
 * @Date: 2018年08月04日 15:19
 * @Email: KosmoSakura@foxmail.com
 */
public class RenewalHelper extends DaoMaster.OpenHelper {
    /**
     * @param name    原来定义的数据库的名字   新旧数据库一致
     * @param factory 可以null
     */
    public RenewalHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * @param newVersion 更新数据库的时候自己调用
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        ULog.d("-----调用了升级检测");
        //操作数据库的更新 有几个表升级都可以传入到下面
        MigrationHelper.getInstance().migrate(db, PlayerBeanDao.class, EventBeanDao.class);
    }
}
