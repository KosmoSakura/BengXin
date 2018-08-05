package kos.mos.beng.ui.frag;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.sakura.list.DateAdapter;
import kos.mos.beng.tool.UToast;
import x.rv.XRecyclerView;

/**
 * @Description: 数据页面
 * @Author: Kosmos
 * @Date: 2018年08月02日 15:08
 * @Email: KosmoSakura@foxmail.com
 */
public class DataFragment extends BaseFragment implements XRecyclerView.LoadingListener {
    private DateAdapter adapter;
    private ArrayList<PlayerBean> listData;
    private int page = 0;
    private final int PAGE_COUNT = 10;
    private View layTitle;
    private ImageView iMiddel;
    private List<PlayerBean> playerBeans;

    @Override
    protected int layout() {
        return R.layout.frag_data;
    }

    @Override
    protected void basis() {
        iMiddel = findView(R.id.data_add_middle);
        layTitle = findView(R.id.alpha_title);
        xrv = findView(R.id.recyclerview);
        iMiddel.setOnClickListener(this);
        layTitle.setOnClickListener(this);
        findView(R.id.data_add).setOnClickListener(this);

        listData = new ArrayList<>();
        adapter = new DateAdapter(listData, getActivity());
        xrv.setEmptyView(findView(R.id.data_empty));
        xrv.getDefaultRefreshHeaderView().setRefreshTimeVisible(true);
        initXrv(adapter);
        layTitle.setVisibility(View.GONE);
        iMiddel.setVisibility(View.VISIBLE);
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

        adapter.setOnItemClickListener(new DateAdapter.ItemClickListener() {
            @Override
            public void onItemClick(PlayerBean bean) {
                UToast.init().CustomShort(bean.getName());
            }
        });

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
        xrv.setNoMore(true);
        listData.clear();
        playerBeans = DbPlayerHelper.SearchAll(getActivity());
        if (playerBeans != null) {
            xrv.setNoMore(playerBeans.size() <= PAGE_COUNT);
            for (int i = 0; i < playerBeans.size() && i < PAGE_COUNT; i++) {
                listData.add(playerBeans.get(i));
            }
        }
        xrv.refreshComplete();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadMore() {
        for (int i = page * PAGE_COUNT; i < playerBeans.size() && i < page * PAGE_COUNT + PAGE_COUNT; i++) {
            listData.add(playerBeans.get(i));
        }
        xrv.loadMoreComplete();
        adapter.notifyDataSetChanged();
        xrv.setNoMore(playerBeans.size() <= page * PAGE_COUNT);
        page++;
    }


}
