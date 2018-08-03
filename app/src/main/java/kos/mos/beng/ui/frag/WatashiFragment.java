package kos.mos.beng.ui.frag;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import kos.mos.beng.R;
import kos.mos.beng.constants.Config;
import kos.mos.beng.constants.DataCreator;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseFragment;
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
    private ImageView iAvatar;
    private TextView tName, tSex, tAddress, tMdel, tSignature, tBtn;
    private long uuid;

    @Override
    protected int layout() {
        return R.layout.frag_watashi;
    }

    @Override
    protected void basis() {
        tBtn = findView(R.id.home_change);
        iAvatar = findView(R.id.home_icon);
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
        uuid = Config.getUid(getActivity());

        includeData(Config.getMe());
    }

    private void includeData(PlayerBean bean) {
        if (uuid < 1) {
            tBtn.setText("登陆");
        } else {
            tBtn.setText("切换账号");
        }
        if (bean == null) {
            iAvatar.setImageResource(R.drawable.v_girl);
            tName.setText("不知道我叫个啥");
            tSex.setText("???");
            tAddress.setText("谁知道我住哪啊");
            tMdel.setText("话说你知道我这手机型号不");
            tSignature.setText("没什么好说的");
        } else {
            UGlide.loadCirle(getActivity(), bean.getAvatar(), iAvatar);
            tName.setText(UTxt.isNull(bean.getName(), "不知道我叫个啥？"));
            tSex.setText(UTxt.isNull(bean.getSexStr(), "???"));
            tAddress.setText(UTxt.isNull(bean.getAddress(), "谁知道我住哪啊?"));
            tMdel.setText(UTxt.isNull(bean.getPhoneModel(), "话说你知道我这手机型号不?"));
            tSignature.setText(UTxt.isNull(bean.getDescribe(), "这个人很懒，只留下了一句叹息"));
        }
    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.home_info:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
            case R.id.home_change://切换账号
                if (uuid < 1) {
                    new DataCreator().creatPlayer();
                } else {
                    new DataCreator().creatPlayer();
                    UToast.init().CustomShort("切换账号");
                }
                includeData(Config.getMe());
                break;
        }
    }
}
