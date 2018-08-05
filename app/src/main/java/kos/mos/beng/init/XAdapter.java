package kos.mos.beng.init;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @Description: 所有的适配器他爹
 * @Author: Kosmos
 * @Date: 2018年07月05日 18:06
 * @Email: KosmoSakura@foxmail.com
 */
public abstract class XAdapter<B, VH extends XHolder> extends RecyclerView.Adapter<VH> {
    protected List<B> list;


    public XAdapter(List<B> datas) {
        list = datas;
    }


    protected abstract void logic(VH holder, B bean, int position);

    protected View creatView(ViewGroup parent, int layout) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, null);
//        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        if (list != null && list.get(position) != null) {
            logic(holder, list.get(position), position);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        if (list != null && list.get(position) != null) {
            logic(holder, list.get(position), position);
        }
    }

    @NonNull
    @Override
    public abstract VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return list.size();
    }
}
