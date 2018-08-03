package kos.mos.beng.ui.frag;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import kos.mos.beng.R;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.sakura.list.DateAdapter;
import x.rv.XRecyclerView;

/**
 * @Description: 数据页面
 * @Author: Kosmos
 * @Date: 2018年08月02日 15:08
 * @Email: KosmoSakura@foxmail.com
 * @Event:
 */
public class DataFragment extends BaseFragment implements XRecyclerView.LoadingListener {
    private DateAdapter mAdapter;
    private ArrayList<PlayerBean> listData;
    private int page = 0;
    private View layTitle;
    private ImageView iMiddel;

    @Override
    protected int layout() {
        return R.layout.frag_data;
    }

    @Override
    protected void basis() {
        iMiddel = findView(R.id.data_add_middle);
        iMiddel.setOnClickListener(this);
        layTitle = findView(R.id.alpha_title);
        layTitle.setOnClickListener(this);
        findView(R.id.data_add).setOnClickListener(this);

        listData = new ArrayList<>();
        mAdapter = new DateAdapter(listData, getActivity());
        initXrv(mAdapter, R.id.recyclerview);
    }

    @Override
    protected void logic() {
        xrv.setScrollAlphaChangeListener(new XRecyclerView.ScrollAlphaChangeListener() {
            @Override
            public void onAlphaChange(int alpha) {
                if (alpha < 10) {
                    layTitle.setVisibility(View.GONE);
                    iMiddel.setVisibility(View.VISIBLE);
                } else {
                    iMiddel.setVisibility(View.GONE);
                    layTitle.setVisibility(View.VISIBLE);
                    layTitle.getBackground().mutate().setAlpha(alpha);
                }
            }

            @Override
            public int setLimitHeight() {
                return 1300;
            }
        });
        xrv.setLoadingListener(this);
        xrv.refresh();
    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.data_add://添加
                addOneData();
                break;
            case R.id.data_add_middle://添加
                addOneData();
                break;
            case R.id.alpha_title:
                xrv.scrollToPosition(0);
                layTitle.setVisibility(View.GONE);
                iMiddel.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void addOneData() {
    }

    @Override
    public void onRefresh() {
        page = 0;
        new Handler().postDelayed(() -> {
            listData.clear();
            for (int i = 0; i < 15; i++) {
                listData.add(new PlayerBean());
            }
            mAdapter.notifyDataSetChanged();
            xrv.refreshComplete();
        }, 1000);            //refresh data here
    }

    @Override
    public void onLoadMore() {
        if (page < 2) {
            new Handler().postDelayed(() -> {
                for (int i = 0; i < 15; i++) {
                    listData.add(new PlayerBean());
                }
                xrv.loadMoreComplete();
                mAdapter.notifyDataSetChanged();
            }, 1000);
        } else {
            new Handler().postDelayed(() -> {
                for (int i = 0; i < 9; i++) {
                    listData.add(new PlayerBean());
                }
                xrv.setNoMore(true);
                mAdapter.notifyDataSetChanged();
            }, 1000);
        }
        page++;
    }
}
