package kos.mos.beng.tool.takephoto;

import android.net.Uri;
import android.os.Environment;

import org.devio.takephoto.app.TakePhoto;
import org.devio.takephoto.compress.CompressConfig;
import org.devio.takephoto.model.CropOptions;
import org.devio.takephoto.model.LubanOptions;
import org.devio.takephoto.model.TakePhotoOptions;

import java.io.File;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月15日 15:31
 * @Email: KosmoSakura@foxmail.com
 */
public class UPhoto {
    private static UPhoto photo;

    private UPhoto() {
    }

    public static UPhoto of() {
        if (photo == null) {
            photo = new UPhoto();
        }
        return photo;
    }

    //裁切配置
    private boolean isCrop = true;//默认true，要裁剪
    private boolean withWonCrop = true;//默认true，使用TakePhoto自带裁剪工具
    private boolean cropStyle = true;//默认true，裁剪比率：True:宽/高,,Flase:宽x高
    private int cropHeight = 400;//默认400，裁剪高
    private int cropWidth = 400;//默认400，裁剪宽

    //压缩配置
    private boolean isCompress = true;//默认true，要压缩
    private boolean compressWithNative = false;//默认false，使用原生压缩工具（false是Luban）
    private int maxSize = 102400;//默认100k，压缩后最大不超过x单位：B
    private int compressWidth = 400;//默认400，压缩后的宽
    private int compressHeight = 400;//默认400，压缩后的高
    private boolean showProgressBar = true;//默认true，显示压缩进度条
    private boolean enableRawFile = true; //默认true，拍照压缩后要保存原图

    //选择图片配置
    private boolean pickByWon = true;//默认true，使用TakePhoto自带相册
    private boolean pickCorrect = true;//默认true，纠正拍照的照片旋转角度
    private boolean pickFromGallery = true;//默认true，True：从相册选择图片，，False：从文件选择图片
    private int limit = 1;//默认1，最多选择照片张数

    public void done(boolean openAlbum, TakePhoto takePhoto) {
        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Uri imageUri = Uri.fromFile(file);

        configCompress(takePhoto);
        configTakePhotoOption(takePhoto);
        if (openAlbum) {

            if (limit > 1) {
                if (isCrop) {
                    takePhoto.onPickMultipleWithCrop(limit, getCropOptions());
                } else {
                    takePhoto.onPickMultiple(limit);
                }
                return;
            }
            if (pickFromGallery) {
                if (isCrop) {
                    takePhoto.onPickFromGalleryWithCrop(imageUri, getCropOptions());
                } else {
                    takePhoto.onPickFromGallery();
                }
            } else {
                if (isCrop) {
                    takePhoto.onPickFromDocumentsWithCrop(imageUri, getCropOptions());
                } else {
                    takePhoto.onPickFromDocuments();
                }
            }
        } else {
            if (isCrop) {
                takePhoto.onPickFromCaptureWithCrop(imageUri, getCropOptions());
            } else {
                takePhoto.onPickFromCapture(imageUri);
            }
        }
    }

    /**
     * @param takePhoto 选择图片配置
     */
    private void configTakePhotoOption(TakePhoto takePhoto) {
        TakePhotoOptions.Builder builder = new TakePhotoOptions.Builder();
        if (pickByWon) {
            builder.setWithOwnGallery(true);
        }
        if (pickCorrect) {
            builder.setCorrectImage(true);
        }
        takePhoto.setTakePhotoOptions(builder.create());
    }

    /**
     * @param takePhoto 压缩配置
     */
    private void configCompress(TakePhoto takePhoto) {
        if (!isCompress) {
            takePhoto.onEnableCompress(null, false);
            return;
        }
        CompressConfig config;
        if (compressWithNative) {
            config = new CompressConfig.Builder().setMaxSize(maxSize)
                .setMaxPixel(compressWidth >= compressHeight ? compressWidth : compressHeight)
                .enableReserveRaw(enableRawFile)
                .create();
        } else {
            LubanOptions option = new LubanOptions.Builder()
                .setMaxHeight(compressHeight)
                .setMaxWidth(compressWidth)
                .setMaxSize(maxSize).create();
            config = CompressConfig.ofLuban(option);
            config.enableReserveRaw(enableRawFile);
        }
        takePhoto.onEnableCompress(config, showProgressBar);


    }

    /**
     * @return 裁切配置
     */
    private CropOptions getCropOptions() {
        if (!isCrop) {
            return null;
        }

        CropOptions.Builder builder = new CropOptions.Builder();

        if (cropStyle) {
            builder.setAspectX(cropWidth).setAspectY(cropHeight);
        } else {
            builder.setOutputX(cropWidth).setOutputY(cropHeight);
        }
        builder.setWithOwnCrop(withWonCrop);
        return builder.create();
    }


    //---属性配置---------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * @param crop 默认true，要裁剪
     */
    public UPhoto crop(boolean crop) {
        isCrop = crop;
        return this;
    }

    /**
     * @param compress 默认true，要压缩
     */
    public UPhoto compress(boolean compress) {
        isCompress = compress;
        return this;
    }

    /**
     * @param withWonCrop 默认true，使用TakePhoto自带裁剪工具
     */
    public UPhoto withWonCrop(boolean withWonCrop) {
        this.withWonCrop = withWonCrop;
        return this;
    }

    /**
     * @param defaultStyle 默认true，裁剪比率：True:宽/高,,Flase:宽x高
     */
    public UPhoto setCropStyle(boolean defaultStyle) {
        this.cropStyle = defaultStyle;
        return this;
    }

    /**
     * @param cropHeight 默认400，裁剪高
     */
    public UPhoto setCropHeight(int cropHeight) {
        this.cropHeight = cropHeight;
        return this;
    }

    /**
     * @param cropWidth 默认400，裁剪宽
     */
    public UPhoto setCropWidth(int cropWidth) {
        this.cropWidth = cropWidth;
        return this;
    }


    /**
     * @param compressWithNative 默认false，使用原生压缩工具（false是Luban）
     */
    public UPhoto setCompressWithNative(boolean compressWithNative) {
        this.compressWithNative = compressWithNative;
        return this;
    }

    /**
     * @param maxSize 默认100k,压缩后最大不超过x单位：B
     */
    public UPhoto setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    /**
     * @param compressWidth 默认400，压缩后的宽
     */
    public UPhoto setCompressWidth(int compressWidth) {
        this.compressWidth = compressWidth;
        return this;
    }

    /**
     * @param compressHeight 默认400，压缩后的高
     */
    public UPhoto setCompressHeight(int compressHeight) {
        this.compressHeight = compressHeight;
        return this;
    }

    /**
     * @param showProgressBar 默认true，显示压缩进度条
     */
    public UPhoto setShowProgressBar(boolean showProgressBar) {
        this.showProgressBar = showProgressBar;
        return this;
    }

    /**
     * @param enableRawFile 默认true，拍照压缩后要保存原图
     */
    public UPhoto setEnableRawFile(boolean enableRawFile) {
        this.enableRawFile = enableRawFile;
        return this;
    }

    /**
     * @param pickByWon 默认true，使用TakePhoto自带相册
     */
    public UPhoto setPickByWon(boolean pickByWon) {
        this.pickByWon = pickByWon;
        return this;
    }

    /**
     * @param pickCorrect 默认true，纠正拍照的照片旋转角度
     */
    public UPhoto setPickCorrect(boolean pickCorrect) {
        this.pickCorrect = pickCorrect;
        return this;
    }

    /**
     * @param pickFromGallery 默认true，True：从相册选择图片，，False：从文件选择图片
     */
    public UPhoto setPickFromGallery(boolean pickFromGallery) {
        this.pickFromGallery = pickFromGallery;
        return this;
    }

    /**
     * @param limit 默认1，最多选择照片张数
     */
    public UPhoto setLimit(int limit) {
        this.limit = limit;
        return this;
    }

}
