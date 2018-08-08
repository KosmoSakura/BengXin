package kos.mos.beng.ui.frag;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kos.mos.beng.R;
import kos.mos.beng.constants.Config;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.sakura.pop.PoShowPlayer;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.tool.UTxt;
import kos.mos.beng.tool.glide.UGlide;
import kos.mos.beng.ui.AboutActivity;

/**
 * @Description: 个人信息
 * @Author: Kosmos
 * @Date: 2018年08月02日 16:47
 * @Email: KosmoSakura@foxmail.com
 */
public class WatashiFragment extends BaseFragment {
    private ImageView iAvatar, iBanner;
    private TextView tUid, tName, tAge, tHobby, tSex, tAddress, tMdel, tSignature, tBtn;

    @Override
    protected int layout() {
        return R.layout.frag_watashi;
    }

    @Override
    protected void basis() {
        tBtn = findView(R.id.home_change);
        tAge = findView(R.id.home_age);
        tHobby = findView(R.id.home_hobby);
        iBanner = findView(R.id.home_banner);
        iAvatar = findView(R.id.home_icon);
        tUid = findView(R.id.home_uid);
        tName = findView(R.id.home_name);
        tSex = findView(R.id.home_sex);
        tAddress = findView(R.id.home_address);
        tMdel = findView(R.id.home_sort);
        tSignature = findView(R.id.home_signature);
        tBtn.setOnClickListener(this);
        findView(R.id.home_info).setOnClickListener(this);
    }

    @Override
    protected void logic() {

    }


    @Override
    public void onResume() {
        super.onResume();
        includeData(Config.getMe(getActivity()), false);
    }

    private void includeData(PlayerBean bean, boolean show) {
        if (Config.getUid(getActivity()) < 1) {
            tBtn.setText("登陆");
        } else {
            tBtn.setText("切换账号");
        }
        if (bean == null) {
            iAvatar.setImageResource(R.drawable.ic_want_cry);
            tUid.setText("K423");
            tName.setText("不知道我叫个啥");
            tSex.setText("???");
            tAge.setText("???");
            tHobby.setText("异性");
            tAddress.setText("谁知道我住哪啊");
            tMdel.setText("话说你知道我这手机型号不");
            tSignature.setText("没什么好说的");
            iBanner.setImageResource(R.color.white);
        } else {
            if (show) {
                UToast.init().CustomShort("登录账户：" + UTxt.isNull(bean.getName(), "???"));
            }
            UGlide.loadBanner(getActivity(), bean.getBanner(), iBanner);
            UGlide.loadCirle(getActivity(), bean.getAvatar(), iAvatar);
            tUid.setText(UTxt.isNull(bean.getUid(), "尚未设置Uid"));
            tName.setText(UTxt.isNull(bean.getName(), "不知道我叫个啥？"));
            tSex.setText(UTxt.isNull(bean.getSexStr(), "???"));
            tAge.setText(UTxt.isNull(bean.getAge() + "岁", "???"));
            tHobby.setText(UTxt.isNull(bean.getHobby(), "异性"));
            tAddress.setText(UTxt.isNull(bean.getAddress(), "谁知道我住哪啊?"));
            tMdel.setText(UTxt.isNull(bean.getPhoneModel(), "话说你知道我这手机型号不?"));
            tSignature.setText(UTxt.isNull(bean.getDescribe(), "这个人很懒，只留下了一句叹息"));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home_info:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
            case R.id.home_change://切换账号
                PoShowPlayer.getInstance(getActivity(), DbPlayerHelper.SearchAll(getActivity()))
                    .setOnItemClickListener(bean -> {
                        DbPlayerHelper.changeAcc(getActivity(), bean.getId());
                        includeData(bean, true);
                    }).show(view);
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        PoShowPlayer.getInstance().clear();

    }

}
