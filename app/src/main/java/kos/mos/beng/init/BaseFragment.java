package kos.mos.beng.init;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liaoinstan.springview.widget.SpringView;

import kos.mos.beng.R;
import kos.mos.beng.sakura.whorl.ProgressHUD;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 15:01
 * @Email: KosmoSakura@foxmail.com
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    private ProgressHUD progressHUD;
    protected RecyclerView xrv;
    protected SpringView spv;
    private View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(layout(), container, false);
        basis();
        logic();
        return contentView;
    }

    @SuppressWarnings("unchecked")
    protected <V extends View> V findView(int resId) {
        return (V) contentView.findViewById(resId);
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
        spv = findView(res);
        spv.setType(SpringView.Type.FOLLOW);
        spv.setMovePara(1);
    }

    protected void initXrv(XAdapter adapter, int res) {
        xrv = contentView.findViewById(res);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrv.setLayoutManager(layoutManager);
        xrv.setItemAnimator(new DefaultItemAnimator());
        xrv.setAdapter(adapter);
    }

    protected void initXrvGrid(XAdapter adapter, int res, int spanCount) {
        xrv = contentView.findViewById(res);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), spanCount);
        xrv.setLayoutManager(layoutManager);
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
    public void onClick(View view) {
        action(view.getId());
    }

    protected void progressShow() {
        if (progressHUD == null) {
            progressHUD = new ProgressHUD(getActivity(), R.style.PopupWindowListDialog);
        }
        progressHUD.showDialog("加载中...");
    }

    /**
     * @param msg 显示进度条
     */
    protected void progressShow(String msg) {
        if (progressHUD == null) {
            progressHUD = new ProgressHUD(getActivity(), R.style.PopupWindowListDialog);
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
