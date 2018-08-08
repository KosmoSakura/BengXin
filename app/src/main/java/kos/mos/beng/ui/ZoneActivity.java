package kos.mos.beng.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.constants.Code;
import kos.mos.beng.constants.Config;
import kos.mos.beng.dao.DbEventHelper;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.EventBean;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseActivity;
import kos.mos.beng.sakura.list.ZoneBinder;
import kos.mos.beng.sakura.list.ZoneCommentsAdapter;
import kos.mos.beng.sakura.list.ZoneHeadBinder;
import kos.mos.beng.tool.UKeyboard;
import kos.mos.beng.tool.ULog;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.tool.UTxt;
import kos.mos.beng.tool.glide.UGlide;

public class ZoneActivity extends BaseActivity implements SpringView.OnFreshListener {
    private ArrayList<Object> listData;
    private int page = 0;
    private final int PAGE_COUNT = 10;
    private View layTitle, layDetail, layEdt;
    private EditText edt;
    private List<EventBean> playerBeans;

    private ZoneBinder zoneBinder;
    private ZoneHeadBinder headBinder;
    private String strName;
    private EventBean bean;
    private PlayerBean me;
    private int position = -1;
    private int eve;

    @Override
    protected int layout() {
        return R.layout.activity_zone;
    }

    @Override
    protected void basis() {
        tName = findViewById(R.id.item_zone_name);
        tDescribe = findViewById(R.id.item_zone_describe);
        rImage = findViewById(R.id.item_zone_image);
        tAddress = findViewById(R.id.item_zone_address);
        tTime = findViewById(R.id.item_zone_time);
        tModel = findViewById(R.id.item_zone_model);
        tPoint = findViewById(R.id.item_zone_point);
        rList = findViewById(R.id.item_zone_list);

        layTitle = findViewById(R.id.zone_title_lay);
        edt = findViewById(R.id.zone_edt);
        layEdt = findViewById(R.id.zone_edt_lay);
        layDetail = findViewById(R.id.Zone_detail_lay);
        layEdt.setOnClickListener(this);
        layDetail.setOnClickListener(this);
        findViewById(R.id.zone_send).setOnClickListener(this);
        findViewById(R.id.zone_back).setOnClickListener(this);
        findViewById(R.id.zone_back_t).setOnClickListener(this);
        findViewById(R.id.zone_write).setOnClickListener(this);


        initSpring(R.id.springview);
        spv.setHeader(new DefaultHeader(this));
        spv.setFooter(new DefaultFooter(this));
    }


    @Override
    protected void logic() {
        eve = 0;
        listData = new ArrayList<>();
        initXrv(R.id.recyclerview);
        zoneBinder = new ZoneBinder(this);
        headBinder = new ZoneHeadBinder(this);
        adapter.register(EventBean.class, zoneBinder);
        adapter.register(PlayerBean.class, headBinder);

        layTitle.setOnClickListener(this);
        spv.setListener(this);
        inflashAll();
        zoneBinder.setEventListener(new ZoneBinder.EventListener() {
            @Override
            public void toPoint(int pos, EventBean bean) {
                if (bean == null) {
                    UToast.init().CustomShort("数据异常");
                    return;
                }
                String comm = UTxt.isEmpty(bean.getPoint()) ? "" : bean.getPoint() + ",";
                bean.setPoint(comm + UTxt.isNull(me.getName()));
                DbEventHelper.change(ZoneActivity.this, bean);
                listData.set(pos, bean);
                adapter.notifyItemChanged(pos);
            }

            @Override
            public void onOverallClick(EventBean dto) {
                if (dto == null) {
                    UToast.init().CustomShort("数据异常");
                    return;
                }
                showDetail(dto);
            }

            @Override
            public void toComment(String name, int pos, EventBean dto) {
                ULog.d("回复：" + name);
                ULog.d("我的：" + me.getName());
//                if (name.equals(me.getName())) {
//                    UToast.init().CustomShort("不能回复自己");
//                    return;
//                }
                bean = dto;
                strName = name;
                position = pos;
                showEdt();
            }

            @Override
            public void onCommentsClick(int pos, EventBean dto) {
                ULog.d("评论：" + pos);
                bean = dto;
                position = pos;
                showEdt();
            }
        });
    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.zone_send:
                toComm();
                hideEdt();
                break;
            case R.id.zone_edt_lay:
                hideEdt();
                break;
            case R.id.Zone_detail_lay:
                hideDetail();
                break;
            case R.id.zone_write://添加
                addOneData();
                break;
            case R.id.zone_back:
            case R.id.zone_back_t:
                finish();
                break;
            case R.id.zone_title_lay:
//                xrv.scrollToPosition(0);
//                layTitle.setVisibility(View.GONE);
                break;
        }
    }

    private void toComm() {
        if (bean == null || position == -1) {
            UToast.init().CustomShort("数据异常");
            return;
        }
        if (UTxt.isEmpty(edt.getText().toString())) {
            UToast.init().CustomShort("请输入评论");
        } else {
            String comm = UTxt.isEmpty(bean.getComments()) ? "" : bean.getComments() + Code.State.split;
            String strNew;
            //评论
            if (UTxt.isEmpty(strName)) {
                strNew = parseComments(UTxt.isNull(me.getName()), edt.getText().toString());
            } else {
                //回复
                strNew = parseCommentsBack(UTxt.isNull(me.getName(), "???"), strName, edt.getText().toString());
            }
            bean.setComments(comm + strNew);
            DbEventHelper.change(this, bean);
            listData.set(position, bean);
            adapter.notifyItemChanged(position);
            UToast.init().CustomShort("评论成功");
            strName = "";
            position = -1;
        }
    }

    private String parseCommentsBack(String nameA, String nameB, String comments) {
        return "<font color= '#5501b5c6'>" + nameA + "</font> 回复" +
            "<font color= '#5501b5c6'>" + nameB + "</font> ：" +
            " <font color= '#21211d'>" + comments + "</font>";
    }

    private String parseComments(String name, String comments) {
        return "<font color= '#5501b5c6'>" + name + "</font> ：<font color= '#21211d'>" + comments + "</font>";
    }

    private void addOneData() {
        UToast.init().CustomShort("添加事件数据将在下个版本更新");
    }

    private void inflashAll() {
        listData.clear();
        me = Config.getMe(this);
        if (me != null) {
            listData.add(me);
        }
        if (UTxt.isEmpty(playerBeans)) {
            playerBeans = DbEventHelper.SearchAll(this);
        }
        if (playerBeans != null) {
            if (eve == 1) {
                listData.add(caidan());
            }
            listData.addAll(playerBeans);
        }
        page = 0;
        spv.setEnableFooter(false);
        adapter.setItems(listData);
        adapter.notifyDataSetChanged();
    }

    private EventBean caidan() {
        return new EventBean(Code.State.EventId, DbPlayerHelper.Search(this, Code.Uid.Dawei), 1,
            "", "刚刚", "天命空港",
            "奥托主教，德莉莎·阿波卡利斯，幽兰戴尔，可可利亚",
            parseComments("奥托主教", "天命已出动神机巴德尔部队，由幽兰戴尔指挥") + Code.State.split +
                parseComments("德莉莎·阿波卡利斯", "极东支部休伯利安号正在搜寻原舰长信号来源") + Code.State.split +
                parseComments("可可利亚", "逆熵机甲已进入隐形搜寻模式"),
            null, null,
            "<font color= '#732b90'>紧急通知！！！" +
                "<br/>已殉职休伯利安号舰长的通讯设备现已遗失。" +
                "<br/>现很可能已经落入外人手中" +
                "<br/>全体成员立即出动。" +
                "<br/>务必在机密泄露之前抓回此人。" +
                "<br/>不论生死。</font>");
    }

    private void inflashPageOne() {
        page = 0;
        spv.setEnableFooter(true);
        listData.clear();
        playerBeans = DbEventHelper.SearchAll(this);
        if (playerBeans != null) {
            spv.setEnableFooter(playerBeans.size() > PAGE_COUNT);
            for (int i = 0; i < playerBeans.size() && i < PAGE_COUNT; i++) {
                listData.add(playerBeans.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        eve++;
        inflashAll();
        spv.onFinishFreshAndLoad();
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

    @Override
    protected void onDestroy() {
        me = null;
        bean = null;
        playerBeans = null;
        super.onDestroy();
    }

    private TextView tName, tDescribe, tAddress, tModel, tTime, tPoint;
    private ImageView rImage;
    private RecyclerView rList;

    private void showDetail(EventBean dto) {
        layDetail.setVisibility(View.VISIBLE);
        tName.setText(UTxt.isNull(dto.getName(), "???"));
        tModel.setText(UTxt.isNull(dto.getPhoneModel(), "???"));

        tAddress.setText(UTxt.isNull(dto.getEventAddress(), "???"));
        tTime.setText(UTxt.isNull(dto.getTime(), "时间不详"));
        tPoint.setText(Html.fromHtml(UTxt.isNull(dto.getPoint())));
        tDescribe.setText(Html.fromHtml(UTxt.isNull(dto.getDescribe())));
        String images = dto.getImages();
        if (UTxt.isEmpty(images)) {
            rImage.setVisibility(View.GONE);
        } else {
            rImage.setVisibility(View.VISIBLE);
            UGlide.loadImages(this, images, rImage);
        }
        String comment = dto.getComments();
        if (UTxt.isEmpty(comment)) {
            rList.setVisibility(View.GONE);
        } else {
            List<String> list = Arrays.asList(comment.split(Code.State.split));

            if (!UTxt.isEmpty(list)) {
                rList.setVisibility(View.VISIBLE);
                ZoneCommentsAdapter commentsAdapter = new ZoneCommentsAdapter(list);
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rList.setLayoutManager(layoutManager);
                rList.setAdapter(commentsAdapter);
                adapter.notifyDataSetChanged();
            } else {
                rList.setVisibility(View.GONE);
            }
        }
    }

    private void hideDetail() {
        layDetail.setVisibility(View.GONE);
    }

    private void showEdt() {
        layEdt.setVisibility(View.VISIBLE);
        edt.setHint(UTxt.isNull(strName, "请输入评论内容"));
        edt.setText("");

        edt.setFocusable(true);
        edt.setFocusableInTouchMode(true);
        edt.requestFocus();
        UKeyboard.showSoftKeyborad(this, edt);
    }

    private void hideEdt() {
        layEdt.setVisibility(View.GONE);
        edt.setText("");
        edt.setHint("");
        UKeyboard.hideKeyBoard(this, edt);
    }


}
