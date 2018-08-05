package kos.mos.beng.init;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import kos.mos.beng.R;
import kos.mos.beng.sakura.whorl.ProgressHUD;
import x.rv.XRecyclerView;
import x.rv.logic.ProgressStyle;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 13:17
 * @Email: KosmoSakura@foxmail.com
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressHUD progressHUD;
    protected XRecyclerView xrv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        basis();
        logic();
    }

    protected void initXrv(XAdapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv.setLayoutManager(layoutManager);

        xrv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrv.setLoadingMoreProgressStyle(ProgressStyle.SquareSpin);//方形旋转
//        xrv.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);//球旋转
        xrv.setArrowImageView(R.drawable.v_down);
        xrv.setAdapter(adapter);
    }

    protected void initXrvGrid(XAdapter adapter, int res, int spanCount) {
        xrv = findViewById(res);
        GridLayoutManager layoutManager = new GridLayoutManager(this, spanCount);
        xrv.setLayoutManager(layoutManager);

        xrv.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrv.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        xrv.setArrowImageView(R.drawable.v_down);
        xrv.setAdapter(adapter);
    }

    /**
     * @return 返回布局
     */
    protected abstract int layout();

    /**
     * 初始化基础信息
     */
    protected abstract void basis();

    /**
     * 填充逻辑部分 include
     */
    protected abstract void logic();

    protected void action(int ids) {
    }

    @Override
    public final void onClick(View view) {
        action(view.getId());
    }

    protected void progressShow() {
        if (progressHUD == null) {
            progressHUD = new ProgressHUD(this, R.style.PopupWindowListDialog);
        }
        progressHUD.showDialog("加载中...");
    }

    /**
     * @param msg 显示进度条
     */
    protected void progressShow(String msg) {
        if (progressHUD == null) {
            progressHUD = new ProgressHUD(this, R.style.PopupWindowListDialog);
        }
        progressHUD.showDialog(msg);
    }

    protected void progressText(String msg) {
        if (progressHUD != null && progressHUD.isShowing()) {
            progressHUD.setMessage(msg);
        }
    }

    protected void progressHide() {
        if (progressHUD != null && progressHUD.isShowing()) {
            progressHUD.hideDialog();
        }
    }
}
