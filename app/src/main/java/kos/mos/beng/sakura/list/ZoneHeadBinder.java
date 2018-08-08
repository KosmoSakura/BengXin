package kos.mos.beng.sakura.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kos.mos.beng.R;
import kos.mos.beng.dao.bean.PlayerBean;
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
public class ZoneHeadBinder extends XBinder<PlayerBean, ZoneHeadBinder.ViewHolder> {
    private Context context;
    private EventListener eventListener;

    public interface EventListener {
        void onQrCode();
    }

    public ZoneHeadBinder(Context context) {
        this.context = context;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new ViewHolder(creatView(R.layout.item_zone_head, inflater, parent));
    }

    @Override
    protected void logic(ViewHolder holder, PlayerBean me) {
        holder.tName.setText(UTxt.isNull(me.getName()));
        holder.tDescribe.setText(UTxt.isNull(me.getDescribe()));
        UGlide.loadBanner(context, me.getBanner(), holder.iBanner);
        UGlide.loadBanner(context, me.getAvatar(), holder.iHead);
    }

    class ViewHolder extends XHolder {
        final TextView tName, tDescribe;
        final ImageView iBanner, iHead;

        ViewHolder(View view) {
            super(view);
            iBanner = getView(R.id.zone_head_banner);
            iHead = getView(R.id.zone_head_icon);
            tName = getView(R.id.zone_head_name);
            tDescribe = getView(R.id.zone_head_describe);
        }

    }
}
