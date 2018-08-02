package kos.mos.beng.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.dao.gen.PlayerBeanDao;
import kos.mos.beng.init.App;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 11:10
 * @Email: KosmoSakura@foxmail.com
 */
public class PlayerGenertor {
    private PlayerBeanDao dao;
    private PlayerBean bean;
    private static PlayerGenertor genertor;

    private SQLiteDatabase getDb() {
        // 通过 BaseApplication 类提供的 getDb() 获取具体 db
        return App.getInstance().getDb();
    }

    private PlayerGenertor() {
        dao = App.getInstance().getDaoSession().getPlayerBeanDao();
    }

    public static PlayerGenertor getInstance() {
        if (genertor == null) {
            genertor = new PlayerGenertor();
        }
        return genertor;
    }

    /**
     * 增
     */
    public void insert(long id, String sex, String name, String avatar, int age) {
//        bean = new PlayerBean(id, sex, name, avatar, age);
        dao.insertOrReplace(bean);
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
        bean = new PlayerBean(id);
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
}
