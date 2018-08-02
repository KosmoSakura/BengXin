package kos.mos.beng.ui.frag;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import kos.mos.beng.R;
import kos.mos.beng.constants.Code;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.tool.glide.UGlide;
import kos.mos.beng.ui.AboutActivity;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 16:47
 * @Email: KosmoSakura@foxmail.com
 * @Event:
 */
public class WatashiFragment extends BaseFragment {
    private ImageView iAvatar;
    private TextView tName, tSex, tAddress, tSort, tSignature;

    @Override
    protected int layout() {
        return R.layout.frag_watashi;
    }

    @Override
    protected void basis() {
        findView(R.id.home_info).setOnClickListener(this);
        findView(R.id.home_change).setOnClickListener(this);
        iAvatar = findView(R.id.home_icon);
        tName = findView(R.id.home_name);
        tSex = findView(R.id.home_sex);
        tAddress = findView(R.id.home_address);
        tSort = findView(R.id.home_sort);
        tSignature = findView(R.id.home_signature);
    }

    @Override
    protected void logic() {
        UGlide.loadRound(getActivity(), Code.Avatar.Kiana, iAvatar);

    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.home_info:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
            case R.id.home_change://切换账号
                UToast.init().CustomShort("切换账号");
                break;
        }
    }
}
