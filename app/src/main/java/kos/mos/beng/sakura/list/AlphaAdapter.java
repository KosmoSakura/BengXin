package kos.mos.beng.sakura.list;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kos.mos.beng.R;
import kos.mos.beng.init.XAdapter;
import kos.mos.beng.init.XHolder;
import kos.mos.beng.sakura.list.bean.AlphaBean;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年07月05日 18:12
 * @Email: KosmoSakura@foxmail.com
 */
public class AlphaAdapter extends XAdapter<AlphaBean, AlphaAdapter.AlphaHolder> {
    private ItemClickListener listener;

    public interface ItemClickListener {
        void onItemClick(AlphaBean bean, int position);
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public AlphaAdapter(ArrayList<AlphaBean> datas) {
        super(datas);
    }

    @NonNull
    @Override
    public AlphaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlphaHolder(creatView(parent, R.layout.item_alpha));
    }

    @Override
    protected void logic(AlphaHolder holder, AlphaBean bean, int position) {
        holder.mTextView.setText(bean.getName());
    }

    class AlphaHolder extends XHolder {
        TextView mTextView;

        AlphaHolder(View view) {
            super(view);
            mTextView = getView(R.id.text);
            getView(R.id.item_main_root).setOnClickListener(view1 -> {
                int position = getLayoutPosition() - 1;
                if (listener != null && position < list.size()) {
                    listener.onItemClick(list.get(position), position);
                }
            });
        }
    }
}
