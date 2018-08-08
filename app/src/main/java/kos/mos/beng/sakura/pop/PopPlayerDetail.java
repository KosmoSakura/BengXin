package kos.mos.beng.sakura.pop;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import kos.mos.beng.R;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.tool.UTxt;
import kos.mos.beng.tool.glide.UGlide;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月04日 20:18
 * @Email: KosmoSakura@foxmail.com
 */
public class PopPlayerDetail implements PopupWindow.OnDismissListener {
    private static PopPlayerDetail player;
    private PopupWindow popupWindow;
    private Activity activity;
    private ImageView iAvatar, iBanner;
    private TextView tUid, tName, tAge, tHobby, tSex, tAddress, tMdel, tSignature;

    public static PopPlayerDetail getInstance() {
        if (player == null) {
            player = new PopPlayerDetail();
        }
        return player;
    }

    public static PopPlayerDetail getInstance(Activity act) {
        if (player == null) {
            player = new PopPlayerDetail(act);
        }
        return player;
    }

    private PopPlayerDetail() {

    }

    private PopPlayerDetail(Activity act) {
        activity = act;
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.pop_show_player_detail, null);
        tAge = view.findViewById(R.id.home_age);
        tHobby = view.findViewById(R.id.home_hobby);
        iBanner = view.findViewById(R.id.home_banner);
        iAvatar = view.findViewById(R.id.home_icon);
        tUid = view.findViewById(R.id.home_uid);
        tName = view.findViewById(R.id.home_name);
        tSex = view.findViewById(R.id.home_sex);
        tAddress = view.findViewById(R.id.home_address);
        tMdel = view.findViewById(R.id.home_sort);
        tSignature = view.findViewById(R.id.home_signature);

        view.findViewById(R.id.palyer_detail_lay).setOnClickListener(view1 -> hide());

        popupWindow = new PopupWindow(activity);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setOnDismissListener(this);
        popupWindow.setContentView(view);
    }

    private void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        activity.getWindow().setAttributes(lp);
    }


    public void show(View view, PlayerBean bean) {
        if (bean == null) {
            UToast.init().CustomShort("数据异常");
            return;
        }
        if (popupWindow != null && !popupWindow.isShowing()) {
            UGlide.loadBanner(activity, bean.getBanner(), iBanner);
            UGlide.loadCirle(activity, bean.getAvatar(), iAvatar);
            tUid.setText(UTxt.isNull(bean.getUid(), "尚未设置Uid"));
            tName.setText(UTxt.isNull(bean.getName(), "不知道我叫个啥？"));
            tSex.setText(UTxt.isNull(bean.getSexStr(), "???"));
            tAge.setText(UTxt.isNull(bean.getAge() + "岁", "???"));
            tHobby.setText(UTxt.isNull(bean.getHobby(), "异性"));
            tAddress.setText(UTxt.isNull(bean.getAddress(), "谁知道我住哪啊?"));
            tMdel.setText(UTxt.isNull(bean.getPhoneModel(), "话说你知道我这手机型号不?"));
            tSignature.setText(UTxt.isNull(bean.getDescribe(), "这个人很懒，只留下了一句叹息"));
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
            backgroundAlpha(0.7f);
        }
    }

    public PopPlayerDetail hide() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
            backgroundAlpha(1f);
        }
        return this;
    }

    public void clear() {
        hide();
        player = null;
        popupWindow = null;
    }

    @Override
    public void onDismiss() {
        if (popupWindow != null && !popupWindow.isShowing()) {
            backgroundAlpha(1f);
        }
    }
}
