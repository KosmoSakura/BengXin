package kos.mos.beng.constants;

import android.content.Context;

import kos.mos.beng.dao.PlayerHelper;
import kos.mos.beng.dao.SpHelper;
import kos.mos.beng.dao.bean.PlayerBean;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月03日 13:58
 * @Email: KosmoSakura@foxmail.com
 * @Event:
 */
public class Config {
    public static String Cache = "";
    private static long me = -1;

    public static PlayerBean getMe() {
        return PlayerHelper.getInstance().checkMe();
    }

    public static long getUid(Context context) {
        if (me < 1) {
            me = SpHelper.getInstance(context).getLong(Code.State.UUID, -1);
            if (me < 1 && getMe() != null) {
                me = getMe().getId();
            }
        }
        return me;
    }
}
