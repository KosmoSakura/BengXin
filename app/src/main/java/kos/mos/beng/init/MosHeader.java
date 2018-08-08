package kos.mos.beng.init;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liaoinstan.springview.container.BaseHeader;

import kos.mos.beng.R;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月06日 19:54
 * @Email: KosmoSakura@foxmail.com
 */
public class MosHeader extends BaseHeader {
    private Context context;
    private int rotationSrc;
    private int arrowSrc;

    private long freshTime;

    private final int ROTATE_ANIM_DURATION = 180;
    private RotateAnimation mRotateUpAnim;
    private RotateAnimation mRotateDownAnim;

    private TextView headerTitle;
    private TextView headerTime;
    private ImageView headerArrow;
    private ProgressBar headerProgressbar;

    public MosHeader(Context context) {
        this(context, R.drawable.progress_small, R.drawable.arrow);
    }

    public MosHeader(Context context, int rotationSrc, int arrowSrc) {
        this.context = context;
        this.rotationSrc = rotationSrc;
        this.arrowSrc = arrowSrc;

        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);
        mRotateDownAnim = new RotateAnimation(-180.0f, 0.0f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
            0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
    }

    @Override
    public View getView(LayoutInflater inflater, ViewGroup viewGroup) {
        View view = inflater.inflate(com.liaoinstan.springview.R.layout.default_header, viewGroup, true);
        headerTitle = view.findViewById(com.liaoinstan.springview.R.id.default_header_title);
        headerTime = view.findViewById(com.liaoinstan.springview.R.id.default_header_time);
        headerArrow = view.findViewById(com.liaoinstan.springview.R.id.default_header_arrow);
        headerProgressbar = view.findViewById(com.liaoinstan.springview.R.id.default_header_progressbar);
        headerProgressbar.setIndeterminateDrawable(ContextCompat.getDrawable(context, rotationSrc));
        headerArrow.setImageResource(arrowSrc);
        return view;
    }

    @Override
    public void onPreDrag(View rootView) {
        if (freshTime == 0) {
            freshTime = System.currentTimeMillis();
        } else {
            int m = (int) ((System.currentTimeMillis() - freshTime) / 1000 / 60);
            if (m >= 1 && m < 60) {
                headerTime.setText(m + "分钟前");
            } else if (m >= 60) {
                int h = m / 60;
                headerTime.setText(h + "小时前");
            } else if (m > 60 * 24) {
                int d = m / (60 * 24);
                headerTime.setText(d + "天前");
            } else if (m == 0) {
                headerTime.setText("刚刚");
            }
        }
    }

    @Override
    public void onDropAnim(View rootView, int dy) {

    }

    @Override
    public void onLimitDes(View rootView, boolean upORdown) {
        headerTitle.setText("松开刷新");
        if (headerArrow.getVisibility() == View.VISIBLE)
            headerArrow.startAnimation(mRotateUpAnim);
        if (!upORdown) {
            headerTitle.setText("松开刷新");
            if (headerArrow.getVisibility() == View.VISIBLE)
                headerArrow.startAnimation(mRotateUpAnim);
        } else {
            headerTitle.setText("下拉刷新");
            if (headerArrow.getVisibility() == View.VISIBLE)
                headerArrow.startAnimation(mRotateDownAnim);
        }
    }

    @Override
    public void onStartAnim() {
        freshTime = System.currentTimeMillis();
        headerTitle.setText("正在刷新");
        headerArrow.setVisibility(View.INVISIBLE);
        headerArrow.clearAnimation();
        headerProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onFinishAnim() {
        headerArrow.setVisibility(View.VISIBLE);
        headerProgressbar.setVisibility(View.INVISIBLE);
    }
}
