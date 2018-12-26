package kos.mos.beng.tool.takephoto;

import android.content.Intent;
import android.os.Bundle;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.app.TakePhotoImpl;
import org.devio.takephoto.model.InvokeParam;
import org.devio.takephoto.model.TContextWrap;
import org.devio.takephoto.model.TResult;
import org.devio.takephoto.permission.InvokeListener;
import org.devio.takephoto.permission.PermissionManager;
import org.devio.takephoto.permission.TakePhotoInvocationHandler;

import kos.mos.beng.init.BaseActivity;
import kos.mos.beng.tool.ULog;

/**
 * 继承这个类来让Activity获取拍照的能力<br>
 * Author: crazycodeboy
 * Date: 2016/9/21 0007 20:10
 * Version:3.0.0
 * 技术博文：http://www.devio.org
 * GitHub:https://github.com/crazycodeboy
 * Email:crazycodeboy@gmail.com
 */
public abstract class TakePhotoFragmentActivity extends BaseActivity implements TakePhoto.TakeResultListener, InvokeListener {
    private TakePhoto takePhoto;
    private InvokeParam invokeParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }

    protected void openCamrea(boolean banner) {
        toGetPhoto(banner, false);
    }

    protected void openAlbum(boolean banner) {
        toGetPhoto(banner, true);
    }

    private void toGetPhoto(boolean banner, boolean ways) {
        int w;
        int h;
        int cw;
        int ch;
        if (banner) {
            w = 1000;
            h = 600;
            cw = 600;
            ch = 200;
        } else {
            w = 400;
            h = 400;
            cw = 100;
            ch = 100;
        }

        UPhoto.of()
            //裁剪
            .crop(true)//默认true，要裁剪
            .withWonCrop(true)//默认true，使用TakePhoto自带裁剪工具
            .setCropStyle(true)//默认true，裁剪比率：True:宽/高,,Flase:宽x高
            .setCropWidth(w)//默认400，裁剪宽
            .setCropHeight(h)//默认400，裁剪高
            //压缩
            .compress(true)//默认true，要压缩
            .setCompressWithNative(true)//默认false，使用原生压缩工具（false是Luban）
            .setMaxSize(204800)//默认100k,压缩后最大不超过x单位：B
            .setCompressWidth(cw)//默认400，压缩后的宽
            .setCompressHeight(ch)//默认400，压缩后的高
            .setShowProgressBar(true)//默认true，显示压缩进度条
            .setEnableRawFile(false)//默认true，拍照压缩后要保存原图
            //图片配置
            .setPickByWon(false)//默认true，使用TakePhoto自带相册
            .setPickCorrect(false)//默认true，纠正拍照的照片旋转角度
            .setPickFromGallery(true)//默认true，True：从相册选择图片，，False：从文件选择图片
            .setLimit(1)//默认1，最多选择照片张数
            .done(ways, getTakePhoto());
    }

    /**
     * 获取TakePhoto实例
     */
    private TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

//    @Override
//    public void takeSuccess(TResult result) {
//        ULog.i("拍照成功：" + result.getImage().getCompressPath());
//    }

    @Override
    public void takeFail(TResult result, String msg) {
        ULog.i("拍照失败：" + msg);
    }

    @Override
    public void takeCancel() {
        ULog.i("操作被取消：");
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }
}
