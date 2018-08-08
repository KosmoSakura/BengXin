package kos.mos.beng.sakura;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月06日 23:04
 * @Email: KosmoSakura@foxmail.com
 */
public class NoScorllRecyclerView extends RecyclerView {
    public NoScorllRecyclerView(Context context) {
        super(context);
    }

    public NoScorllRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScorllRecyclerView(Context context, AttributeSet attrs,
                                int defStyle) {
        super(context, attrs, defStyle);
    }




    @Override
    public boolean canScrollVertically(int direction) {
        if (direction < 1) {
            boolean original = super.canScrollVertically(direction);
            return !original && getChildAt(0) != null && getChildAt(0).getTop() < 0 || original;
        }
        return super.canScrollVertically(direction);

    }


    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
            MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, expandSpec);
    }
}