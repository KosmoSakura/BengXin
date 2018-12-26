package kos.mos.beng.constants;

import android.content.Context;

import java.util.List;

import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.SpHelper;
import kos.mos.beng.dao.bean.PlayerBean;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月03日 13:58
 * @Email: KosmoSakura@foxmail.com
 */
public class Config {
    public static String Cache = "";
    private static long me = -1;

    public static boolean databaseIsEmpty(Context context) {
        List<PlayerBean> playerBeans = DbPlayerHelper.SearchAll(context);
        return playerBeans == null || playerBeans.size() < 1;
    }

    public static void setUid(Context context, long uid) {
        SpHelper.getInstance(context).put(Code.State.UUID, uid);
        me = uid;
    }

    public static long getUid(Context context) {
        if (me < 1) {
            me = SpHelper.getInstance(context).getLong(Code.State.UUID, -1);
            PlayerBean bean = DbPlayerHelper.getMe(context);
            if (Config.me < 1 && bean != null) {
                Config.me = bean.getId();
            }
        }
        return me;
    }

    public static long UIDCreator() {
        return System.currentTimeMillis();
    }
}
