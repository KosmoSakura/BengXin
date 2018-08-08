package kos.mos.beng.init;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.drakeet.multitype.ItemViewBinder;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月06日 22:32
 * @Email: KosmoSakura@foxmail.com
 */
public abstract class XBinder<B, VH extends XHolder> extends ItemViewBinder<B, VH> {
    protected List<B> list;

    protected View creatView(int layout, LayoutInflater inflater, ViewGroup parent) {
        return inflater.inflate(layout, parent, false);
    }

    protected abstract void logic(VH holder, B bean);

    @Override
    public final void onBindViewHolder(@NonNull VH holder, @NonNull B item) {
        logic(holder, item);
    }
}
