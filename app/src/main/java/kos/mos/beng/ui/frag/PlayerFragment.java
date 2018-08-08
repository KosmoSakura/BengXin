package kos.mos.beng.ui.frag;

import android.content.Intent;
import android.os.CountDownTimer;

import kos.mos.beng.R;
import kos.mos.beng.constants.Config;
import kos.mos.beng.constants.DataCreator;
import kos.mos.beng.dao.DbEventHelper;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.ui.ZoneActivity;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 15:09
 * @Email: KosmoSakura@foxmail.com
 */
public class PlayerFragment extends BaseFragment {
    private int count;

    @Override
    protected int layout() {
        return R.layout.frag_player;
    }

    @Override
    protected void basis() {
        count = 0;
        findView(R.id.player_J).setOnClickListener(this);
        findView(R.id.player_Z).setOnClickListener(this);
        findView(R.id.player_zone).setOnClickListener(this);
        findView(R.id.home_reset).setOnClickListener(this);
    }

    @Override
    protected void logic() {

    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.home_reset:
                if (count < 1) {
                    UToast.init().CustomShort("警告\n此操作将删除所有自定义数据\n再点击5次将执行命令");
                }
                if (count > 5) {
                    dataReset();
                }
                count++;
                break;
            case R.id.player_J:
                UToast.init().CustomShort("系统检测您弯的不够彻底");
                break;
            case R.id.player_Z:
                UToast.init().CustomShort("BiliBili平台尚未开放");
                break;
            case R.id.player_zone:
                if (Config.getUid(getActivity()) < 1) {
                    UToast.init().ShortMessage("请先登录");
                } else if (DbEventHelper.checked(getActivity())) {
                    startActivity(new Intent(getActivity(), ZoneActivity.class));
                } else {
                    UToast.init().ShortMessage("请先补充数据");
                }
                break;
        }
    }

    private void dataRebuild() {
        progressShow("数据构建中...");
        new CountDownTimer(4000, 2000) {
            @Override
            public void onTick(long l) {
                if (l < 3000) {
                    progressText("数据构建成功！");
                }
            }

            @Override
            public void onFinish() {
                progressHide();
            }
        }.start();
    }

    private void dataReset() {
        progressShow("数据清除中...");
        DbPlayerHelper.clear(getActivity());
        new DataCreator().creatPlayer(getActivity());
        DbEventHelper.clear(getActivity());
        new DataCreator().creatEvent(getActivity());
        new CountDownTimer(6000, 2000) {
            @Override
            public void onTick(long l) {
                if (l < 4500) {
                    progressText("重置成功！");
                } else {
                    progressText("数据重构中...");
                }
            }

            @Override
            public void onFinish() {
                progressHide();
                count = 0;
            }
        }.start();
    }
}
