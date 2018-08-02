package kos.mos.beng.ui.frag;

import android.content.Intent;

import kos.mos.beng.R;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.ui.AboutActivity;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 16:47
 * @Email: KosmoSakura@foxmail.com
 * @Event:
 */
public class WatashiFragment extends BaseFragment {
    @Override
    protected int layout() {
        return R.layout.frag_watashi;
    }

    @Override
    protected void basis() {
        findView(R.id.home_info).setOnClickListener(this);
    }

    @Override
    protected void logic() {

    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.home_info:
                startActivity(new Intent(getActivity(), AboutActivity.class));
                break;
        }
    }
}
