package kos.mos.beng.ui;

import android.app.Dialog;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
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
import kos.mos.beng.dao.DbEventHelper;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.EventBean;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.init.BaseActivity;
import kos.mos.beng.sakura.list.ZoneBinder;
import kos.mos.beng.sakura.list.ZoneCommentsAdapter;
import kos.mos.beng.sakura.list.ZoneHeadBinder;
import kos.mos.beng.tool.UDialog;
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
    private TextView tTitle;

    @Override
    protected int layout() {
        return R.layout.activity_zone;
    }

    @Override
    protected void basis() {
        tTitle = findViewById(R.id.zone_back_t);
        tName = findViewById(R.id.item_zone_name);
        tDescribe = findViewById(R.id.item_zone_describe);
        vPager = findViewById(R.id.item_zone_images);
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
        tTitle.setOnClickListener(this);
        findViewById(R.id.zone_write).setOnClickListener(this);


        initSpring(R.id.springview);
        spv.setHeader(new DefaultHeader(this));
        spv.setFooter(new DefaultFooter(this));
    }


    @Override
    protected void logic() {
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
                String myName = UTxt.isNull(me.getName());
                String olds = UTxt.isNull(bean.getPoint());
                String news = "";
                if (olds.contains("," + myName)) {
                    news = olds.replace("," + myName, "");
                } else if (olds.contains(myName)) {
                    news = olds.replace(myName, "");
                } else {
                    news = olds + "," + myName;
                }
                bean.setPoint(news);
                DbEventHelper.change(ZoneActivity.this, bean);
                listData.set(pos, bean);
                adapter.notifyItemChanged(pos);
            }

            @Override
            public void onOverallLongClick(int pos, EventBean bean) {
                UDialog.getInstance(ZoneActivity.this, true, true)
                    .showSelect("要删除这条朋友圈吗？", "删", "不删", new UDialog.SureClick() {
                        @Override
                        public void OnSureClick(String result, Dialog dia) {
                            dia.dismiss();
                            DbEventHelper.delete(ZoneActivity.this, bean);
                            listData.remove(pos);
                            adapter.notifyItemRemoved(pos);
                        }
                    }, null);
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
                if (name.contains(me.getName())) {
                    UToast.init().CustomShort("不能回复自己");
                    return;
                }
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
        startActivity(new Intent(this, AddEventActivity.class));
    }

    private void inflashAll() {
        listData.clear();
        me = DbPlayerHelper.getMe(this);
        if (me != null) {
            tTitle.setText(UTxt.isNull(me.getName(), "???"));
            listData.add(me);
        }
        playerBeans = DbEventHelper.SearchAllFan(this);
        if (!UTxt.isEmpty(playerBeans)) {
            listData.addAll(playerBeans);
        }
        page = 0;
        spv.setEnableFooter(false);
        adapter.setItems(listData);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
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
    private ViewPager vPager;
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
        Log.d("Sakura", "--------------------------------------------------------------");
        String images = dto.getImages();
        if (UTxt.isEmpty(images)) {
            vPager.setVisibility(View.GONE);
            rImage.setVisibility(View.GONE);
        } else {
            String[] split = images.split(Code.State.MMM);
//            List<String> list = Arrays.asList(images.split(Code.State.MMM));
            if (!UTxt.isEmpty(split) && !UTxt.isEmpty(split[0])) {
                if (split.length > 1) {
                    rImage.setVisibility(View.GONE);
                    vPager.setVisibility(View.VISIBLE);
                    ImageView[] arr = new ImageView[split.length];
                    for (int i = 0; i < split.length; i++) {
                        ImageView imageView = new ImageView(ZoneActivity.this);
//                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        if (dto.getType() == 3) {
                            UGlide.loadImagesRes(this, split[i], imageView);
                        } else {
                            UGlide.loadImages(this, split[i], imageView);
                        }
                        arr[i] = imageView;
                    }
                    vPager.setAdapter(new GuideViewPagerAdapter(arr));
                } else {
                    rImage.setVisibility(View.VISIBLE);
                    vPager.setVisibility(View.GONE);
                    if (dto.getType() == 3) {
                        UGlide.loadImagesRes(this, split[0], rImage);
                    } else {
                        UGlide.loadImages(this, split[0], rImage);
                    }
                }
            } else {
                vPager.setVisibility(View.GONE);
                rImage.setVisibility(View.GONE);
            }
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

    private class GuideViewPagerAdapter extends PagerAdapter {
        private ImageView[] views;

        GuideViewPagerAdapter(ImageView[] split) {
            super();
            this.views = split;
        }

        @Override
        public int getCount() {
            if (views != null) {
                return views.length;
            }
            return 0;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(views[position]);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views[position], 0);
            return views[position];
        }
    }
}
