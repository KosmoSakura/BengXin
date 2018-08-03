package kos.mos.beng.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.dao.gen.PlayerBeanDao;
import kos.mos.beng.init.App;
import kos.mos.beng.tool.UTxt;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:10
 * @Email: KosmoSakura@foxmail.com
 */
public class PlayerHelper {
    private PlayerBeanDao dao;
    private static PlayerHelper genertor;

    private SQLiteDatabase getDb() {
        // 通过 BaseApplication 类提供的 getDb() 获取具体 db
        return App.getInstance().getDb();
    }

    private PlayerHelper() {
        dao = App.getInstance().getDaoSession().getPlayerBeanDao();
    }

    public static PlayerHelper getInstance() {
        if (genertor == null) {
            genertor = new PlayerHelper();
        }
        return genertor;
    }

    /**
     * 增
     */
    public void insert(PlayerBean bean) {
        dao.insertOrReplace(bean);
    }

    public void insert(List<PlayerBean> list) {
        dao.insertInTx(list);
    }

    public void insert(PlayerBean... bean) {
        for (PlayerBean aBean : bean) {
            dao.insertOrReplace(aBean);
        }
    }


    /**
     * 删
     */
    public void delete(long id) {
        dao.deleteByKey(id);
    }

    /**
     * 改
     */
    public void change(long id, String name) {
        PlayerBean bean = new PlayerBean();
        dao.update(bean);
    }

    /**
     * 查
     */
    public List<PlayerBean> SearchAll() {
        return dao.loadAll();
    }

    public List<PlayerBean> searchSync() {
        return dao.queryBuilder().listLazy();
    }

    public PlayerBean Search(long id) {
        return dao.load(id);
    }

    public List<PlayerBean> Search(String name) {
        List<PlayerBean> list = dao.queryBuilder().where(PlayerBeanDao.Properties.Name.eq(name)).list();
        return list;
    }

    public PlayerBean checkMe() {
        List<PlayerBean> list = dao.loadAll();
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
