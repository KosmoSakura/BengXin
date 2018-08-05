package kos.mos.beng.dao;

import android.content.Context;

import java.util.List;

import kos.mos.beng.constants.Config;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.dao.gen.PlayerBeanDao;
import kos.mos.beng.dao.renewal.DbManager;
import kos.mos.beng.tool.UTxt;


/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:10
 * @Email: KosmoSakura@foxmail.com
 */
public class DbPlayerHelper {
    /**
     * 增
     */
    public static void insert(Context context, PlayerBean bean) {
        DbManager.getDaoSession(context).getPlayerBeanDao().insertOrReplace(bean);
    }

    public static void insert(Context context, List<PlayerBean> list) {
        DbManager.getDaoSession(context).getPlayerBeanDao().insertInTx(list);
    }

    public static void insert(Context context, PlayerBean... bean) {
        for (PlayerBean aBean : bean) {
            DbManager.getDaoSession(context).getPlayerBeanDao().insertOrReplace(aBean);
        }
    }


    /**
     * 删
     */
    public static void delete(Context context, long id) {
        DbManager.getDaoSession(context).getPlayerBeanDao().deleteByKey(id);
    }

    /**
     * 改
     */
    public static void change(Context context, long id, String name) {
        PlayerBean bean = new PlayerBean();
        DbManager.getDaoSession(context).getPlayerBeanDao().update(bean);
    }

    /**
     * 查
     */
    public static List<PlayerBean> SearchAll(Context context) {
        return DbManager.getDaoSession(context).getPlayerBeanDao().loadAll();
    }

    public static List<PlayerBean> searchSync(Context context) {
        return DbManager.getDaoSession(context).getPlayerBeanDao().queryBuilder().listLazy();
    }

    public static PlayerBean Search(Context context, long id) {
        return DbManager.getDaoSession(context).getPlayerBeanDao().load(id);
    }

    public static List<PlayerBean> Search(Context context, String name) {
        return DbManager.getDaoSession(context).getPlayerBeanDao().queryBuilder().where(PlayerBeanDao.Properties.Name.eq(name)).list();
    }

    /**
     * 清空数据
     */
    public static void clear(Context context) {
        DbManager.getDaoSession(context).getPlayerBeanDao().deleteAll();
        Config.setUid(context, -1);
    }

    /**
     * 切换账号
     */
    public static PlayerBean changeAcc(Context context, long key) {
        if (Config.getUid(context) > 0) {
            PlayerBean oldBean = DbManager.getDaoSession(context).getPlayerBeanDao().load(Config.getUid(context));
            oldBean.setMe(false);
            DbManager.getDaoSession(context).getPlayerBeanDao().update(oldBean);
        }
        PlayerBean newBean = DbManager.getDaoSession(context).getPlayerBeanDao().load(key);
        newBean.setMe(true);
        DbManager.getDaoSession(context).getPlayerBeanDao().update(newBean);
        Config.setUid(context, key);
        return newBean;
    }

    public static PlayerBean checkMe(Context context) {
        List<PlayerBean> list = DbManager.getDaoSession(context).getPlayerBeanDao().loadAll();
        if (!UTxt.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getMe()) {
                    return list.get(i);
                }
            }
        }
        return null;
    }
}
