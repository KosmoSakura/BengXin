package kos.mos.beng.sakura.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.dao.bean.PlayerBean;
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
public class DateAdapter extends XAdapter<PlayerBean, DateAdapter.MainHolder> {
    private ItemClickListener listener;
    private Context context;

    public interface ItemClickListener {
        void onItemClick(PlayerBean bean, View view);

        void onLongClick(PlayerBean bean, int positon);
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public DateAdapter(List<PlayerBean> datas, Context context) {
        super(datas);
        this.context = context;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainHolder(creatView(parent, R.layout.item_data));
    }

    @Override
    protected void logic(MainHolder holder, PlayerBean bean, int position) {
        UGlide.loadBanner(context, bean.getAvatar(), holder.iHead);
        holder.tName.setText(UTxt.isNull(bean.getName(), "???"));
        holder.iSex.setImageResource(bean.getSex() == 1 ? R.drawable.v_boy : R.drawable.v_girl);
        holder.tAddress.setText(UTxt.isNull(bean.getAddress(), "???"));
        holder.tAge.setText(UTxt.isNull(bean.getAge() + "岁", "???"));
        holder.tModel.setText(UTxt.isNull(bean.getPhoneModel(), "???"));
        holder.tHobby.setText(UTxt.isNull(bean.getDescribe(), "???"));
    }

    class MainHolder extends XHolder {
        final TextView tName, tAge, tAddress, tModel, tHobby;
        final ImageView iHead, iSex;

        MainHolder(View view) {
            super(view);
            iHead = getView(R.id.item_data_icon);
            tName = getView(R.id.item_data_name);
            iSex = getView(R.id.item_data_sex);
            tAddress = getView(R.id.item_data_address);
            tAge = getView(R.id.item_data_age);
            tModel = getView(R.id.item_data_model);
            tHobby = getView(R.id.item_data_hobby);

            getView(R.id.item_data_root).setOnClickListener(view1 -> {
                if (listener != null && getLayoutPosition() > -1 && getLayoutPosition() < list.size()) {
                    listener.onItemClick(list.get(getLayoutPosition()), view);
                }
            });
            getView(R.id.item_data_root).setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (listener != null && getLayoutPosition() > -1 && getLayoutPosition() < list.size()) {
                        listener.onLongClick(list.get(getLayoutPosition()), getLayoutPosition());
                    }
                    return true;
                }
            });
        }
    }
}
