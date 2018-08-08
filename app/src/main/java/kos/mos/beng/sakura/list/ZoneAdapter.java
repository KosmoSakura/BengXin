package kos.mos.beng.sakura.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.constants.Code;
import kos.mos.beng.dao.bean.EventBean;
import kos.mos.beng.init.XAdapter;
import kos.mos.beng.init.XHolder;
import kos.mos.beng.tool.UTxt;
import kos.mos.beng.tool.glide.UGlide;


/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年07月05日 18:12
 * @Email: KosmoSakura@foxmail.com
 */
public class ZoneAdapter extends XAdapter<EventBean, ZoneAdapter.MainHolder> {
    private ItemClickListener listener;
    private Context context;

    public interface ItemClickListener {
        void onItemClick(EventBean bean);
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public ZoneAdapter(List<EventBean> dates, Context context) {
        super(dates);
        this.context = context;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainHolder(creatView(parent, R.layout.item_zone));
    }

    @Override
    protected void logic(MainHolder holder, EventBean bean, int position) {
        holder.tName.setText(UTxt.isNull(bean.getName(), "???"));
        holder.tModel.setText(UTxt.isNull(bean.getPhoneModel(), "???"));
        UGlide.loadBanner(context, bean.getAvatar(), holder.iHead);
        String images = bean.getImages();
        if (UTxt.isEmpty(images)) {
            holder.iMage.setVisibility(View.GONE);
        } else {
            UGlide.loadImages(context, images, holder.iMage);
            holder.iMage.setVisibility(View.VISIBLE);
        }
        holder.tAddress.setText(UTxt.isNull(bean.getEventAddress(), "???"));
        holder.tTime.setText(UTxt.isNull(bean.getTime(), "时间不详"));
        holder.tPoint.setText(Html.fromHtml(UTxt.isNull(bean.getPoint())));
        holder.tDescribe.setText(Html.fromHtml(UTxt.isNull(bean.getDescribe())));

        String comment = bean.getComments();
        if (UTxt.isEmpty(comment)) {
            holder.rList.setVisibility(View.GONE);
        } else {
            List<String> list = Arrays.asList(comment.split(Code.State.split));
            if (!UTxt.isEmpty(list)) {
                holder.rList.setVisibility(View.VISIBLE);
                holder.comms.clear();
                holder.comms.addAll(list);
                holder.adapter.notifyDataSetChanged();
            } else {
                holder.rList.setVisibility(View.GONE);
            }
        }
    }

    class MainHolder extends XHolder {
        final TextView tName, tDescribe, tAddress, tModel, tTime, tPoint;
        final ImageView iHead, iMage, iWrite;
        final RecyclerView rList;
        final List<String> comms;
        final ZoneCommentsAdapter adapter;


        MainHolder(View view) {
            super(view);
            iHead = getView(R.id.item_zone_head);
            tName = getView(R.id.item_zone_name);
            tDescribe = getView(R.id.item_zone_describe);
            iMage = getView(R.id.item_zone_image);
            tAddress = getView(R.id.item_zone_address);
            tTime = getView(R.id.item_zone_time);
            tModel = getView(R.id.item_zone_model);
            iWrite = getView(R.id.item_zone_write);
            tPoint = getView(R.id.item_zone_point);

            rList = getView(R.id.item_zone_list);
            comms = new ArrayList<>();
            adapter = new ZoneCommentsAdapter(comms);
            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rList.setLayoutManager(layoutManager);
            rList.setAdapter(adapter);

//            getView(R.id.item_data_root).setOnClickListener(view1 -> {
//                int position = getLayoutPosition() - 1;
//                if (listener != null && position > -1 && position < list.size()) {
//                    listener.onItemClick(list.get(position));
//                }
//            });
        }
    }
}
