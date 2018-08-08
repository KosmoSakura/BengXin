package kos.mos.beng.sakura.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
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
import kos.mos.beng.init.XBinder;
import kos.mos.beng.init.XHolder;
import kos.mos.beng.tool.UTxt;
import kos.mos.beng.tool.glide.UGlide;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月06日 21:54
 * @Email: KosmoSakura@foxmail.com
 */
public class ZoneBinder extends XBinder<EventBean, ZoneBinder.ViewHolder> {
    private Context context;
    private EventListener listener;


    public interface EventListener {
        void onOverallClick(EventBean bean);//整体

        void toPoint(int position, EventBean bean);

        void toComment(String name, int position, EventBean bean);

        void onCommentsClick(int position, EventBean bean);
    }

    public ZoneBinder(Context context) {
        this.context = context;
    }

    public void setEventListener(EventListener eventListener) {
        this.listener = eventListener;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(creatView(R.layout.item_zone, inflater, parent));
    }

    @Override
    protected void logic(ViewHolder holder, EventBean bean) {
        holder.tName.setText(UTxt.isNull(bean.getName(), "???"));
        holder.tModel.setText(UTxt.isNull(bean.getPhoneModel(), "???"));
        UGlide.loadBanner(context, bean.getAvatar(), holder.iHead);

        holder.tAddress.setText(UTxt.isNull(bean.getEventAddress(), "???"));
        holder.tTime.setText(UTxt.isNull(bean.getTime(), "时间不详"));
        holder.tPoint.setText(Html.fromHtml(UTxt.isNull(bean.getPoint())));
        holder.tDescribe.setText(Html.fromHtml(UTxt.isNull(bean.getDescribe())));

        String images = bean.getImages();
        if (UTxt.isEmpty(images)) {
            holder.rImage.setVisibility(View.GONE);
        } else {
            holder.rImage.setVisibility(View.VISIBLE);
            UGlide.loadImages(context, images, holder.rImage);
        }
//        if (UTxt.isEmpty(images)) {
//            holder.rImage.setVisibility(View.GONE);
//        } else {
//            List<String> list = Arrays.asList(images.split(Code.State.MMM));
//            Log.d("Sakura", images);
//            Log.d("Sakura", list.size() + "---" + list.get(0));
//            Log.d("Sakura", "--------------------------------------------------------------");
//            if (!UTxt.isEmpty(list)) {
//                holder.rImage.setVisibility(View.VISIBLE);
//                holder.iamges.clear();
//                holder.iamges.addAll(list);
//                holder.imAdapter.notifyDataSetChanged();
//            } else {
//                holder.rImage.setVisibility(View.GONE);
//            }
//        }

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

        if (listener != null) {
            int position = getPosition(holder);
            holder.adapter.setOnItemClickListener(name -> listener.toComment(name, position, bean));
            holder.iWrite.setOnClickListener(view -> listener.onCommentsClick(position, bean));
            holder.pointLay.setOnClickListener(v -> listener.toPoint(position, bean));
            holder.rImage.setOnClickListener(view -> listener.onOverallClick(bean));
            holder.tName.setOnClickListener(view -> listener.onOverallClick(bean));
            holder.tDescribe.setOnClickListener(view -> listener.onOverallClick(bean));
        }
    }


    class ViewHolder extends XHolder {
        final TextView tName, tDescribe, tAddress, tModel, tTime, tPoint;
        final ImageView iHead, iWrite, rImage;
        final RecyclerView rList;
        //        final NoScorllRecyclerView rImage;
        final List<String> comms;
        final ZoneCommentsAdapter adapter;
        final View pointLay;
//        final ZoneImageAdapter imAdapter;

        ViewHolder(View view) {
            super(view);
            pointLay = getView(R.id.item_zone_point_lay);
            iHead = getView(R.id.item_zone_head);
            tName = getView(R.id.item_zone_name);
            tDescribe = getView(R.id.item_zone_describe);
            rImage = getView(R.id.item_zone_image);
            tAddress = getView(R.id.item_zone_address);
            tTime = getView(R.id.item_zone_time);
            tModel = getView(R.id.item_zone_model);
            iWrite = getView(R.id.item_zone_write);
            tPoint = getView(R.id.item_zone_point);

            rList = getView(R.id.item_zone_list);
            comms = new ArrayList<>();
            adapter = new ZoneCommentsAdapter(comms);
//            imAdapter = new ZoneImageAdapter(iamges, context);

            LinearLayoutManager layoutManager = new LinearLayoutManager(context);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rList.setLayoutManager(layoutManager);
            rList.setAdapter(adapter);
//            rImage.setLayoutManager(new GridLayoutManager(context, 2));
//            rImage.setAdapter(imAdapter);
        }
    }
}
