package kos.mos.beng.dao;

import android.content.Context;

import java.util.List;

import kos.mos.beng.dao.bean.EventBean;
import kos.mos.beng.dao.gen.EventBeanDao;
import kos.mos.beng.dao.gen.PlayerBeanDao;
import kos.mos.beng.dao.renewal.DbManager;
import kos.mos.beng.tool.UTxt;


/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:10
 * @Email: KosmoSakura@foxmail.com
 */
public class DbEventHelper {
    /**
     * 增
     */
    public static void insert(Context context, EventBean bean) {
        DbManager.getDaoSession(context).getEventBeanDao().insertOrReplace(bean);
    }

    public static void insert(Context context, List<EventBean> list) {
        DbManager.getDaoSession(context).getEventBeanDao().insertInTx(list);
    }

    public static void insert(Context context, EventBean... bean) {
        for (EventBean aBean : bean) {
            DbManager.getDaoSession(context).getEventBeanDao().insertOrReplace(aBean);
        }
    }


    /**
     * 删
     */
    public static void delete(Context context, long id) {
        DbManager.getDaoSession(context).getEventBeanDao().deleteByKey(id);
    }

    public static void delete(Context context, EventBean bean) {
        DbManager.getDaoSession(context).getEventBeanDao().delete(bean);
    }

    /**
     * 改
     */
    public static void change(Context context, EventBean bean) {
        DbManager.getDaoSession(context).getEventBeanDao().update(bean);
    }

    /**
     * 查
     */
    public static List<EventBean> SearchAll(Context context) {
        return DbManager.getDaoSession(context).getEventBeanDao().loadAll();
    }

    public static List<EventBean> SearchAllFan(Context context) {
        return DbManager.getDaoSession(context)
            .getEventBeanDao().queryBuilder()
            .orderDesc(EventBeanDao.Properties.Id).list();
    }

    public static List<EventBean> searchSync(Context context) {
        return DbManager.getDaoSession(context).getEventBeanDao().queryBuilder().listLazy();
    }

    public static EventBean Search(Context context, long id) {
        return DbManager.getDaoSession(context).getEventBeanDao().load(id);
    }

    public static List<EventBean> Search(Context context, String name) {
        return DbManager.getDaoSession(context).getEventBeanDao().queryBuilder().where(PlayerBeanDao.Properties.Name.eq(name)).list();
    }

    public static boolean checked(Context context) {
        return !UTxt.isEmpty(DbManager.getDaoSession(context).getEventBeanDao().loadAll());
    }

    /**
     * 清空数据
     */
    public static void clear(Context context) {
        DbManager.getDaoSession(context).getEventBeanDao().deleteAll();
    }
}
