package kos.mos.beng.sakura.list;

import android.support.annotation.NonNull;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.init.XAdapter;
import kos.mos.beng.init.XHolder;
import kos.mos.beng.tool.UTxt;


/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年07月05日 18:12
 * @Email: KosmoSakura@foxmail.com
 */
public class ZoneCommentsAdapter extends XAdapter<String, ZoneCommentsAdapter.MainHolder> {
    private ItemClickListener listener;

    public interface ItemClickListener {
        void onItemClick(String name);
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public ZoneCommentsAdapter(List<String> datas) {
        super(datas);
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainHolder(creatView(parent, R.layout.item_zone_comment));
    }

    @Override
    protected void logic(MainHolder holder, String bean, int position) {
        holder.tDescribe.setText(Html.fromHtml(UTxt.isNull(bean)));
        if (listener != null) {
            holder.tDescribe.setOnLongClickListener(view -> {
                String txt = holder.tDescribe.getText().toString();
                int name;
                if (txt.contains("回复")) {
                    name = txt.indexOf("回复");
                } else {
                    name = txt.indexOf("：");
                }
                listener.onItemClick(UTxt.isNull(txt.substring(0, name)));
                return true;
            });
        }
    }

    class MainHolder extends XHolder {
        final TextView tDescribe;

        MainHolder(View view) {
            super(view);
            tDescribe = getView(R.id.item_zone_comment_t);

//            getView(R.id.item_data_root).setOnClickListener(view1 -> {
//                int position = getLayoutPosition() - 1;
//                if (listener != null && position > -1 && position < list.size()) {
//                    listener.onItemClick(list.get(position));
//                }
//            });
        }
    }
}
