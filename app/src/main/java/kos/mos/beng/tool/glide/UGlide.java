package kos.mos.beng.tool.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import kos.mos.beng.R;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月02日 23:59
 * @Email: KosmoSakura@foxmail.com
 */
public class UGlide {
    public final static int FILLET_10 = 10;//圆角角度 10度

    public static void loadBanner(Context context, String url, ImageView tartgetIv) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.white)
            .error(R.color.white)
            .centerCrop()
            .crossFade()
            .into(tartgetIv);
    }

    public static void loadImages(Context context, String url, ImageView tartgetIv) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .into(tartgetIv);
//        Glide.with(context).load(url)
//            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//            .placeholder(R.color.default_gray)
//            .error(R.color.default_gray)
//            .centerCrop()
//            .thumbnail(0.2f)
//            .into(new SimpleTarget<GlideDrawable>() {
//                @Override
//                public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//                    tartgetIv.setImageDrawable(resource);
//                }
//            });
    }

    public static void loadPop(Context context, String url, ImageView tartgetIv) {
        Glide.with(context)
            .load(url)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(tartgetIv);
    }

    public static void loadRound(Context context, String url, ImageView tartgetIv) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .centerCrop()
            .crossFade()
            .transform(new TransformRound(context, FILLET_10))
            .into(tartgetIv);
    }

    public static void loadCirle(Context context, String url, ImageView targetIv) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .centerCrop()
            .crossFade()
            .transform(new TransformCircle(context))
            .into(targetIv);
    }

    public static void loadBlurPic(Context context, String string, ImageView tartgetIv) {
        Glide.with(context)
            .load(string)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_bg)
            .error(R.color.default_bg)
            .crossFade()
            .bitmapTransform(new TransformBlur(context, 12))
            .into(tartgetIv);
    }

    public static void loadBitmap(Context context, Bitmap bmp, ImageView tartgetIv) {
        Glide.with(context)
            .load(bmp)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .centerCrop()
            .crossFade()
            .into(tartgetIv);
    }
}
