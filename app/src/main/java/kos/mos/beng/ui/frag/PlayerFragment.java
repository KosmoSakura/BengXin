package kos.mos.beng.ui.frag;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;

import kos.mos.beng.R;
import kos.mos.beng.constants.Config;
import kos.mos.beng.constants.DataCreator;
import kos.mos.beng.dao.DbEventHelper;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.tool.UDiaDouNiWan;
import kos.mos.beng.tool.UDialog;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.ui.ZoneActivity;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 15:09
 * @Email: KosmoSakura@foxmail.com
 */
public class PlayerFragment extends BaseFragment {
    private View layMore;

    @Override
    protected int layout() {
        return R.layout.frag_player;
    }

    @Override
    protected void basis() {
        layMore = findView(R.id.home_function);

        findView(R.id.player_J).setOnClickListener(this);
        findView(R.id.player_Z).setOnClickListener(this);
        findView(R.id.player_zone).setOnClickListener(this);
        findView(R.id.home_setting).setOnClickListener(this);

        findView(R.id.home_function_back).setOnClickListener(this);
        findView(R.id.home_event_clear).setOnClickListener(this);
        findView(R.id.home_player_clear).setOnClickListener(this);
        findView(R.id.home_all_clear).setOnClickListener(this);

        findView(R.id.home_player_reset).setOnClickListener(this);
        findView(R.id.home_event_reset).setOnClickListener(this);
        findView(R.id.home_all_reset).setOnClickListener(this);
        findView(R.id.home_function_about).setOnClickListener(this);
    }

    @Override
    protected void logic() {

    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.home_function_back:
                layMore.setVisibility(View.GONE);
                break;
            case R.id.home_setting:
                layMore.setVisibility(View.VISIBLE);
                break;
            case R.id.home_player_clear://清除用户
                DbPlayerHelper.clear(getActivity());
                showDia(1000, "用户擦除中");
                break;
            case R.id.home_event_clear://清除朋友圈
                DbEventHelper.clear(getActivity());
                showDia(1000, "朋友圈擦除中");
                break;
            case R.id.home_all_clear://清除所有
                DbPlayerHelper.clear(getActivity());
                DbEventHelper.clear(getActivity());
                showDia(1500, "天命数据库擦除中");
                break;
            case R.id.home_player_reset://重置用户数据库:
                DbPlayerHelper.clear(getActivity());
                new DataCreator().creatPlayer(getActivity());
                showDia(2000, "数据重置中");
                break;

            case R.id.home_event_reset://重置朋友圈数据:
                DbPlayerHelper.clear(getActivity());
                DbEventHelper.clear(getActivity());
                new DataCreator().creatPlayer(getActivity());
                new DataCreator().creatEvent(getActivity());
                showDia(4000, "数据重置中");
                break;

            case R.id.home_all_reset://重置所有
                UToast.init().CustomShort("真的只是个占位\n不然有个缺口看着难受");
                break;
            case R.id.home_function_about://关于
                String version = getString(R.string.Version);
                UDialog.getInstance(getActivity(), true, true)
                    .showNotice("弱小、可怜、又无助，但是好吃\n\n当前版本：" + version +
                            "\n\nApp的使用无需授权",
                        "哦", R.drawable.firefox);
                break;
            case R.id.player_J:
                new UDiaDouNiWan(getActivity());
                break;
            case R.id.player_Z:
                UToast.init().CustomShort("BiliBili平台尚未开放");
                break;
            case R.id.player_zone:
                if (Config.getUid(getActivity()) < 1) {
                    UToast.init().ShortMessage("请先登录");
                } else {
                    startActivity(new Intent(getActivity(), ZoneActivity.class));
                }
//                if (Config.getUid(getActivity()) < 1) {
//                    UToast.init().ShortMessage("请先登录");
//                } else if (DbEventHelper.checked(getActivity())) {
//                    startActivity(new Intent(getActivity(), ZoneActivity.class));
//                } else {
//                    UDialog.getInstance(getActivity(), true, true)
//                        .showNotice("数据库未检测到朋友圈数据\n你可以选择下面那个所谓的设置\n随便弄点数据瞧瞧",
//                            "好滴", -1);
//                }
                break;
        }
    }

    private void showDia(long time, String str) {
        progressShow(str);
        new Handler().postDelayed(() -> {
            progressHide();
            layMore.setVisibility(View.GONE);
        }, time);
    }

    private void clearReset() {
        progressShow("数据清除中...");
        DbPlayerHelper.clear(getActivity());
        DbEventHelper.clear(getActivity());
        new CountDownTimer(6000, 2000) {
            @Override
            public void onTick(long l) {
                if (l < 4500) {
                    progressText("数据清除完成！");
                } else {
                    progressText("数据库已清空...");
                }
            }

            @Override
            public void onFinish() {
                progressHide();
            }
        }.start();
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
            }
        }.start();
    }
}
