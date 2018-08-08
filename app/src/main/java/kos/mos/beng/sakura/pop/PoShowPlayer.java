package kos.mos.beng.sakura.pop;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.sakura.list.DateSimpleAdapter;
import kos.mos.beng.tool.UToast;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月04日 20:18
 * @Email: KosmoSakura@foxmail.com
 */
public class PoShowPlayer implements PopupWindow.OnDismissListener {
    private static PoShowPlayer player;
    private PopupWindow popupWindow;
    private Activity activity;
    private DateSimpleAdapter adapter;

    public static PoShowPlayer getInstance() {
        if (player == null) {
            player = new PoShowPlayer();
        }
        return player;
    }

    public static PoShowPlayer getInstance(Activity act, List<PlayerBean> playerBeans) {
        if (player == null) {
            player = new PoShowPlayer(act, playerBeans);
        }
        return player;
    }

    private PoShowPlayer() {

    }

    private PoShowPlayer(Activity act, List<PlayerBean> playerBeans) {
        if (playerBeans == null) {
            UToast.init().CustomShort("没有更多的账户可供选择");
            return;
        }
        if (playerBeans.size() < 2) {
            UToast.init().CustomShort("没有更多的账户可供选择");
            return;
        }
        activity = act;
        LayoutInflater inflater = LayoutInflater.from(activity);
        RecyclerView xrv = (RecyclerView) inflater.inflate(R.layout.pop_show_players, null);
        popupWindow = new PopupWindow(activity);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(this);
        popupWindow.setContentView(xrv);

        adapter = new DateSimpleAdapter(playerBeans, activity);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv.setLayoutManager(layoutManager);
        xrv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public PoShowPlayer setOnItemClickListener(DateSimpleAdapter.ItemClickListener listener) {
        if (adapter != null) {
            adapter.setOnItemClickListener(bean -> {
                hide();
                listener.onItemClick(bean);
            });
        }
        return this;
    }

    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        activity.getWindow().setAttributes(lp);
    }


    public void show(View view) {
        if (popupWindow != null && !popupWindow.isShowing()) {
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
            backgroundAlpha(0.7f);
        }
    }

    public void hide() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            backgroundAlpha(1f);
        }
    }

    public void clear() {
        hide();
        player = null;
        popupWindow = null;
        adapter = null;
    }

    @Override
    public void onDismiss() {
        if (popupWindow != null && !popupWindow.isShowing()) {
            backgroundAlpha(1f);
        }
    }

}
