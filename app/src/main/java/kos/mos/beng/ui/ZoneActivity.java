package kos.mos.beng.ui;

import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import kos.mos.beng.R;
import kos.mos.beng.init.BaseActivity;
import kos.mos.beng.sakura.list.AlphaAdapter;
import kos.mos.beng.sakura.list.bean.AlphaBean;
import x.rv.XRecyclerView;

public class ZoneActivity extends BaseActivity implements XRecyclerView.LoadingListener {
    private AlphaAdapter mAdapter;
    private ArrayList<AlphaBean> listData;
    private int refreshTime = 0;
    private int page = 0;

    @Override
    protected int layout() {
        return R.layout.activity_zone;
    }

    @Override
    protected void basis() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listData = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            listData.add(new AlphaBean("item" + i));
        }
        mAdapter = new AlphaAdapter(listData);
        boolean stytle = getIntent().getBooleanExtra("list_style", true);
        if (stytle) {
            initXrv(mAdapter, R.id.recyclerview);
        } else {
            initXrvGrid(mAdapter, R.id.recyclerview, 3);
        }
    }

    @Override
    protected void logic() {
        xrv.setLoadingListener(this);
        xrv.refresh();
    }

    @Override
    public void onRefresh() {
        refreshTime++;
        page = 0;
        new Handler().postDelayed(() -> {
            listData.clear();
            for (int i = 0; i < 15; i++) {
                listData.add(new AlphaBean("item" + i + "after " + refreshTime + " times of refresh"));
            }
            mAdapter.notifyDataSetChanged();
            xrv.refreshComplete();
        }, 1000);            //refresh data here
    }

    @Override
    public void onLoadMore() {
        if (page < 2) {
            new Handler().postDelayed(() -> {
                xrv.loadMoreComplete();
                for (int i = 0; i < 15; i++) {
                    listData.add(new AlphaBean("item" + (i + listData.size())));
                }
                xrv.loadMoreComplete();
                mAdapter.notifyDataSetChanged();
            }, 1000);
        } else {
            new Handler().postDelayed(() -> {
                for (int i = 0; i < 9; i++) {
                    listData.add(new AlphaBean("item" + (1 + listData.size())));
                }
                xrv.setNoMore(true);
                mAdapter.notifyDataSetChanged();
            }, 1000);
        }
        page++;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
