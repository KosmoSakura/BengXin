package kos.mos.beng.ui;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.constants.Config;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseActivity;
import kos.mos.beng.sakura.list.DateAdapter;
import kos.mos.beng.tool.UToast;
import x.rv.XRecyclerView;

public class ZoneActivity extends BaseActivity implements XRecyclerView.LoadingListener {
    private DateAdapter adapter;
    private ArrayList<PlayerBean> listData;
    private int page = 0;
    private final int PAGE_COUNT = 10;
    private View layTitle;
    private ImageView iMiddel;
    private List<PlayerBean> playerBeans;

    @Override
    protected int layout() {
        return R.layout.activity_zone;
    }

    @Override
    protected void basis() {
        xrv = findViewById(R.id.recyclerview);
        iMiddel = findViewById(R.id.data_add_middle);
        layTitle = findViewById(R.id.zone_title_lay);
        layTitle.setOnClickListener(this);
        iMiddel.setOnClickListener(this);
        findViewById(R.id.zone_back).setOnClickListener(this);
        findViewById(R.id.zone_back_t).setOnClickListener(this);
        findViewById(R.id.zone_write).setOnClickListener(this);

        layTitle.setVisibility(View.GONE);
        iMiddel.setVisibility(View.VISIBLE);

        PlayerBean me = Config.getMe(this);
        if (me == null) {
            UToast.init().ShortMessage("请先补充数据");
            finish();
            return;
        }
        listData = new ArrayList<>();
        adapter = new DateAdapter(listData, this);
        xrv.getDefaultRefreshHeaderView().setRefreshTimeVisible(true);
//        View header = LayoutInflater.from(this).inflate(R.layout.item_zone_head, null);
//        ImageView iBanner = header.findViewById(R.id.zone_head_banner);
//        ImageView iHead = header.findViewById(R.id.zone_head_icon);
//        TextView tName = header.findViewById(R.id.zone_head_name);
//        TextView tDescribe = header.findViewById(R.id.zone_head_describe);
//        tName.setText(UTxt.isNull(me.getName()));
//        tDescribe.setText(UTxt.isNull(me.getDescribe()));
//        UGlide.loadBanner(this, me.getBanner(), iBanner);
//        UGlide.loadBanner(this, me.getAvatar(), iHead);
//        xrv.addHeaderView(header);
        initXrv(adapter);
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
            case R.id.zone_write://添加
                addOneData();
                break;
            case R.id.data_add_middle://添加
                addOneData();
                break;
            case R.id.zone_back:
            case R.id.zone_back_t:
                onBackPressed();
            case R.id.zone_title_lay:
                xrv.scrollToPosition(0);
                layTitle.setVisibility(View.GONE);
                iMiddel.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void addOneData() {
        UToast.init().CustomShort("添加");
    }

    @Override
    public void onRefresh() {
        page = 0;
        xrv.setNoMore(true);
        listData.clear();
        playerBeans = DbPlayerHelper.SearchAll(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.zone, menu);
        MenuItem itemEdit = menu.findItem(R.id.item_write);
        UToast.init().CustomShort("发布");
        return true;
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
