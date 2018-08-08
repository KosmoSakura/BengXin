package kos.mos.beng.ui.frag;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseFragment;
import kos.mos.beng.sakura.pop.PopPlayerDetail;
import kos.mos.beng.sakura.list.DateAdapter;
import kos.mos.beng.tool.UToast;

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
        adapter.setOnItemClickListener((bean, view) -> PopPlayerDetail.getInstance(getActivity()).show(view, bean));
        addPageOne();
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
        UToast.init().CustomShort("添加用户数据将在下个版本更新");
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
        if (playerBeans != null) {
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
