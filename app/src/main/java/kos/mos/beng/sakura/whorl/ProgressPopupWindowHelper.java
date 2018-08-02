package kos.mos.beng.sakura.whorl;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import kos.mos.beng.R;


/**
 * @Description: Loading工具
 * @Author: Kosmos
 * @Date: 2018年03月20日 14:57
 * @Email: KosmoSakura@foxmail.com
 * @Event:
 */
public class ProgressPopupWindowHelper {
    private static ProgressPopupWindowHelper helper;
    private PopupWindow pop;
    private WhorlView wv_p;
    private Context con;
    private View layRoot;

    private ProgressPopupWindowHelper(Context context) {
        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
        // pop = new PopupWindow(contentView, 100, 100, true);
        con = context;
        layRoot = LayoutInflater.from(con).inflate(R.layout.lay_progress_pop, null);
        pop = new PopupWindow(layRoot);
        pop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setBackgroundDrawable(new ColorDrawable(0));//背景
        pop.setFocusable(true);//是否能响应点击事件
        pop.setOutsideTouchable(true);//是否能响应外部点击事件
        wv_p = layRoot.findViewById(R.id.progress_wv_p);
    }

    public static ProgressPopupWindowHelper getInstance(Context context) {
        if (helper == null) {
            helper = new ProgressPopupWindowHelper(context);
        }
        return helper;
    }

    /**
     * Android的对话框有两种：PopupWindow和AlertDialog。它们的不同点在于：
     * •AlertDialog的位置固定，而PopupWindow的位置可以随意
     * •AlertDialog是非阻塞线程的，而PopupWindow是阻塞线程的
     * •PopupWindow的位置按照有无偏移分，可以分为偏移和无偏移两种；按照参照物的不同，
     * 可以分为相对于某个控件（Anchor锚）和相对于父控件。具体如下
     * •showAsDropDown(View anchor)：相对某个控件的位置（正左下方），无偏移
     * •showAsDropDown(View anchor,int xoff,int yoff)：相对某个控件的位置，有偏移
     * •showAtLocation(View parent,int gravity,int x,int y)：相对于父控件的位置
     * （例如正中央Gravity.CENTER，下方Gravity.BOTTOM等），可以设置偏移或无偏移
     */
    public void show(View anchor) {
        if (pop != null && !pop.isShowing()) {
//            pop.showAtLocation(layRoot, Gravity.CENTER, 0, 0);
            pop.showAsDropDown(layRoot);
            wv_p.start();
//            layRoot.startAnimation(AnimationUtils.loadAnimation(con, R.anim.fade_in));
        }
    }

    public void hide() {
        if (pop != null && pop.isShowing()) {
//            layRoot.startAnimation(AnimationUtils.loadAnimation(con, R.anim.fade_out));
            pop.dismiss();
            wv_p.stop();
        }
    }
}
