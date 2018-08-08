package kos.mos.beng.sakura.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.init.XAdapter;
import kos.mos.beng.init.XHolder;
import kos.mos.beng.tool.glide.UGlide;


/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年07月05日 18:12
 * @Email: KosmoSakura@foxmail.com
 */
public class ZoneImageAdapter extends XAdapter<String, ZoneImageAdapter.MainHolder> {
    private Context context;

    public ZoneImageAdapter(List<String> datas, Context context) {
        super(datas);
        this.context = context;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainHolder(creatView(parent, R.layout.item_iamge));
    }

    @Override
    protected void logic(MainHolder holder, String bean, int position) {
        UGlide.loadImages(context, bean, holder.image);
    }

    class MainHolder extends XHolder {
        final ImageView image;

        MainHolder(View view) {
            super(view);
            image = getView(R.id.item_image);

//            getView(R.id.item_data_root).setOnClickListener(view1 -> {
//                int position = getLayoutPosition() - 1;
//                if (listener != null && position > -1 && position < list.size()) {
//                    listener.onItemClick(list.get(position));
//                }
//            });
        }
    }
}
