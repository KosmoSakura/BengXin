package kos.mos.beng.tool.glide;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月14日 22:52
 * @Email: KosmoSakura@foxmail.com
 * Glide全局配置，使用GlideModule注解执行自动代码生成，生成GlideApp，后续的Glide
 * 调用都需要替换为GlideApp.with(context).load(url).into(imageView) 的方式
 */
@GlideModule
public final class GlideConfigModule extends AppGlideModule {
}