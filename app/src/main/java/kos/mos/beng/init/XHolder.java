package kos.mos.beng.init;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年07月05日 18:32
 * @Email: KosmoSakura@foxmail.com
 */
public class XHolder extends RecyclerView.ViewHolder {
    private View contentView;

    public XHolder(View itemView) {
        super(itemView);
        contentView = itemView;
    }

    @SuppressWarnings("unchecked")
    protected  <V extends View> V getView(int resId) {
        return (V) contentView.findViewById(resId);
    }
}
