package kos.mos.beng.dao;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月03日 14:08
 * @Email: KosmoSakura@foxmail.com
 */
public class SpHelper {
    private static SpHelper helper;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SpHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("ic_sakura", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SpHelper getInstance(Context context) {
        if (helper == null) {
            helper = new SpHelper(context);
        }
        return helper;
    }

    /**
     * 存
     */
    public void put(String key, Object object) {
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }
//        boolean commit = editor.commit();
        editor.apply();
    }

    public long getLong(String key, long defaultObject) {
        return sharedPreferences.getLong(key, defaultObject);
    }

    /**
     * 取
     */
    public Object get(String key, Object defaultObject) {
        if (defaultObject instanceof String) {
            return sharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sharedPreferences.getLong(key, (Long) defaultObject);
        } else {
            return sharedPreferences.getString(key, null);
        }
    }

    /**
     * 删
     */
    public void remove(String key) {
        editor.remove(key);
        editor.commit();
    }

    /**
     * 清空
     */
    public void clear() {
        editor.clear();
        editor.commit();
    }

    /**
     * 查询某个key是否存在
     */
    public Boolean contain(String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * 返回所有的键值对
     */
    public Map<String, ?> getAll() {
        return sharedPreferences.getAll();
    }
}
