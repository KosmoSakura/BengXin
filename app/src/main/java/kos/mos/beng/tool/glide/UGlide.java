package kos.mos.beng.tool.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

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
        GlideApp.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.white)
            .error(R.color.white)
            .centerCrop()
            .into(tartgetIv);
    }

    public static void loadImages(Context context, String url, ImageView tartgetIv) {
        GlideApp.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .into(tartgetIv);
    }

    public static void loadImagesRes(Context context, String url, ImageView tartgetIv) {
        int res;
        try {
            res = Integer.parseInt(url);
        } catch (NumberFormatException e) {
            res = 0;
        }
        GlideApp.with(context)
            .load(res)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .into(tartgetIv);
    }

    public static void loadPop(Context context, String url, ImageView tartgetIv) {
        GlideApp.with(context)
            .load(url)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(tartgetIv);
    }

    public static void loadRound(Context context, String url, ImageView tartgetIv) {
        GlideApp.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .centerCrop()
            .transform(new TransformRound(context, FILLET_10))
            .into(tartgetIv);
//        RequestOptions options = new RequestOptions()
//            .placeholder(R.color.white)// 正在加载中的图片
//            .error(R.color.white) // 加载失败的图片
//            .centerCrop()
////            .transform(new TransformRound(context, FILLET_10))
//            .diskCacheStrategy(DiskCacheStrategy.ALL); // 磁盘缓存策略
//        Glide.with(context)
//            .load(url)
//            .apply(options)
//            .into(tartgetIv);
    }

    public static void loadCirle(Context context, String url, ImageView targetIv) {
        GlideApp.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .centerCrop()
            .transform(new TransformCircle(context))
            .into(targetIv);
    }

    public static void loadBlurPic(Context context, String string, ImageView tartgetIv) {
        GlideApp.with(context)
            .load(string)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_bg)
            .error(R.color.default_bg)
            .transform(new TransformBlur(context, 12))
            .into(tartgetIv);
    }

    public static void loadBitmap(Context context, Bitmap bmp, ImageView tartgetIv) {
        GlideApp.with(context)
            .load(bmp)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.color.default_gray)
            .error(R.color.default_gray)
            .centerCrop()
            .into(tartgetIv);
    }

}
