package kos.mos.beng.tool;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import kos.mos.beng.R;
import kos.mos.beng.init.App;


/**
 * @Description: 避免Toast消息提示按照队列来重复提示
 * @Author: Kosmos
 * @Date: 2017年2月14日 16:24
 * @Email: KosmoSakura@foxmail.com
 * @Events: ToastUtil
 * ------>1.新增showCustomToast():自定义居中Toast
 */
public class UToast {
    private static UToast tu;

    public static UToast init() {
        if (tu == null) {
            tu = new UToast();
        }
        return tu;
    }

    private UToast() {
    }

    private Handler handler = new Handler(Looper.getMainLooper());

    private Toast defaulToast, customToast;

    private final Object synObj = new Object();

    private final int HIDE_ICON = -1;
    private final int SHOW_DEFAULT_ICON = -2;

    public void CustomLong(String msg) {
        showCustomToastBase(msg, true);
    }

    public void CustomShort(String msg) {
        showCustomToastBase(msg, false);
    }

    public void ShortMessage(String msg) {
        ShortMessage(null, msg);
    }

    public void LongMessage(String msg) {
        LongMessage(null, msg);
    }

    private void showCustomToastBase(final String msg, final boolean isLong) {
        View toastRoot = LayoutInflater.from(App.getInstance()).inflate(R.layout.lay_toast, null);
        TextView mTextView = toastRoot.findViewById(R.id.toast_base_msg);
        mTextView.setText(msg);
        if (customToast == null) {
            customToast = new Toast(App.getInstance());
        }
        //获取屏幕高度
        WindowManager wm = (WindowManager) App.getInstance().getSystemService(Context.WINDOW_SERVICE);
        int height = wm.getDefaultDisplay().getHeight();
        //Toast的Y坐标是屏幕高度的1/3，不会出现不适配的问题
        customToast.setGravity(Gravity.BOTTOM, 0, height / 8);
        if (isLong) {
            customToast.setDuration(Toast.LENGTH_LONG);
        } else {
            customToast.setDuration(Toast.LENGTH_SHORT);
        }
        customToast.setView(toastRoot);
        customToast.show();
    }


    /**
     * @param ctx 使用时的上下文
     * @param msg 提示文字
     */
    private void ShortMessage(final Context ctx, final String msg) {
        new Thread(() -> handler.post(() -> {
            synchronized (synObj) {
                if (defaulToast != null) {
                    defaulToast.setText(msg);
                    defaulToast.setDuration(Toast.LENGTH_SHORT);
                } else {
                    if (ctx == null)
                        defaulToast = Toast.makeText(App.getInstance(), msg, Toast.LENGTH_SHORT);
                    else
                        defaulToast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT);
                }
                defaulToast.show();
            }
        })).start();
    }

    /**
     * @param ctx 使用时的上下文
     * @param msg 提示文字
     */
    private void LongMessage(final Context ctx, final String msg) {
        new Thread(() -> handler.post(() -> {
            synchronized (synObj) {
                if (defaulToast != null) {
                    defaulToast.setText(msg);
                    defaulToast.setDuration(Toast.LENGTH_LONG);
                } else {
                    if (ctx == null)
                        defaulToast = Toast.makeText(App.getInstance(), msg, Toast.LENGTH_LONG);
                    else
                        defaulToast = Toast.makeText(ctx, msg, Toast.LENGTH_LONG);
                }
                defaulToast.show();
            }
        })).start();
    }
}
