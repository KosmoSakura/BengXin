package kos.mos.beng.ui.frag;

import android.content.Intent;
import android.view.View;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.sakura.list.DateAdapter;
import kos.mos.beng.sakura.pop.PopPlayerDetail;
import kos.mos.beng.tool.UDialog;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.tool.UTxt;
import kos.mos.beng.ui.AddPlayerActivity;

/**
 * @Description: 数据页面
 * @Author: Kosmos
 * @Date: 2018年08月02日 15:08
 * @Email: KosmoSakura@foxmail.com
 */
public class DataFragment extends BaseFragment implements SpringView.OnFreshListener {
    private DateAdapter adapter;
    private ArrayList<PlayerBean> listData;
    private int page = 0;
    private final int PAGE_COUNT = 10;
    private List<PlayerBean> playerBeans;
    private View data_empty;
//    private WeixinHeader springHeader;
//    private List<Program> data = new ArrayList<Program>() {{
//        add(new Program("ofo小黄车", Normal));
//        add(new Program("哈图", Circle));
//    }};

    @Override
    protected int layout() {
        return R.layout.frag_data;
    }

    @Override
    protected void basis() {
        data_empty = findView(R.id.data_empty);
        findView(R.id.alpha_title).setOnClickListener(this);
        findView(R.id.data_add).setOnClickListener(this);


        listData = new ArrayList<>();
        adapter = new DateAdapter(listData, getActivity());
        initXrv(adapter, R.id.recyclerview);
        initSpring(R.id.springview);
        spv.setHeader(new DefaultHeader(getActivity()));
        spv.setFooter(new DefaultFooter(getActivity()));
    }

    @Override
    protected void logic() {
        spv.setListener(this);
//        springView.setHeader(springHeader = new WeixinHeader());
//        springView.setFooter(new MosHeader(getActivity()));
        //设置加载图片回调方法
//        springHeader.setOnLoadImgCallback((imageView, imgUrl, position) -> {
//            UGlide.loadCirle(getActivity(), imgUrl, imageView);
//        });
        //“更多”按钮点击事件
//        springHeader.setOnMoreClickListener(() -> springHeader.addItem(new Program("ofo小黄车", Normal)));
        //item 点击事件
//        springHeader.setOnProgramClickListener((program, holder, position) -> UToast.init().CustomShort(program.getName()));
        //item 长点击事件
//        springHeader.setOnProgramLongClickListener((program, holder, position) -> springHeader.removeItem(position));
//        springHeader.freshItem(data);
        adapter.setOnItemClickListener(new DateAdapter.ItemClickListener() {
            @Override
            public void onItemClick(PlayerBean bean, View view) {
                PopPlayerDetail.getInstance(getActivity()).show(view, bean);
            }

            @Override
            public void onLongClick(PlayerBean bean, int position) {
                UDialog.getInstance(getActivity(), true, true)
                    .showSelect("你要和他从此断绝关系吗？", "确定", "取消", (result, dia) -> {
                        dia.dismiss();
                        try {
                            DbPlayerHelper.delete(getActivity(), bean.getId());
                            listData.remove(bean);
                            adapter.notifyItemRemoved(position);
                        } catch (Exception e) {
                            UToast.init().CustomShort("因为某些原因，关系断绝失败");
                        }
                    }, null);
            }
        });
    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.data_add://添加
                addOneData();
                break;
            case R.id.alpha_title:
                xrv.scrollToPosition(0);
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        PopPlayerDetail.getInstance().clear();
    }

    private void addOneData() {
        startActivity(new Intent(getActivity(), AddPlayerActivity.class));
    }

    @Override
    public void onResume() {
        super.onResume();
        UDialog.getInstance().clear();
        addPageOne();
    }

    @Override
    public void onRefresh() {
        addPageOne();
        spv.onFinishFreshAndLoad();
    }

    private void addPageOne() {
        page = 0;
        listData.clear();
        spv.setEnableFooter(true);
        playerBeans = DbPlayerHelper.SearchAll(getActivity());
        if (UTxt.isEmpty(playerBeans)) {
            data_empty.setVisibility(View.VISIBLE);
        } else {
            data_empty.setVisibility(View.GONE);
            spv.setEnableFooter(playerBeans.size() > PAGE_COUNT);
            for (int i = 0; i < playerBeans.size() && i < PAGE_COUNT; i++) {
                listData.add(playerBeans.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadmore() {
        page++;
        for (int i = page * PAGE_COUNT; i < playerBeans.size() && i < page * PAGE_COUNT + PAGE_COUNT; i++) {
            listData.add(playerBeans.get(i));
        }
        adapter.notifyDataSetChanged();
        spv.onFinishFreshAndLoad();
        spv.setEnableFooter(playerBeans.size() > page * PAGE_COUNT);
    }
}
