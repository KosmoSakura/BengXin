package kos.mos.beng.init;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.liaoinstan.springview.widget.SpringView;

import kos.mos.beng.R;
import kos.mos.beng.sakura.whorl.ProgressHUD;
import me.drakeet.multitype.ItemViewBinder;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 13:17
 * @Email: KosmoSakura@foxmail.com
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressHUD progressHUD;
    protected RecyclerView xrv;
    protected SpringView spv;
    protected MultiTypeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        basis();
        logic();
    }

    /**
     * spv.setType();
     * 重叠：SpringView.Type.OVERLAP（下拉时，list动，Head或Foot停留在原地）
     * 跟随：SpringView.Type.FOLLOW（下拉时，Head或Foot跟随list移动）
     * 拖拽：SpringView.Type.DRAG（下拉时，Head或Foot动，list停留在原地）
     * spv.setEnableHeader(Boolean);//启用、禁用
     * spv.setEnableFooter(Boolean);//启用、禁用
     */
    protected void initSpring(int res) {
        spv = findViewById(res);
        spv.setType(SpringView.Type.FOLLOW);
        spv.setMovePara(1);
    }

    protected void initXrv(int res) {
        xrv = findViewById(res);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv.setLayoutManager(layoutManager);
        adapter = new MultiTypeAdapter();
        xrv.setAdapter(adapter);
    }

    protected void initXrvGrid(int res, int spanCount) {
        xrv = findViewById(res);
        GridLayoutManager layoutManager = new GridLayoutManager(this, spanCount);
        xrv.setLayoutManager(layoutManager);
        adapter = new MultiTypeAdapter();
        xrv.setAdapter(adapter);
    }

    protected <T> void registViewBinder(@NonNull Class<? extends T> clazz,
                                        @NonNull ItemViewBinder<T, ?> binder) {
        if (adapter == null) {
            return;
        }
        adapter.register(clazz, binder);
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
