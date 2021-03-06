package kos.mos.beng.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import java.io.File;

import kos.mos.beng.R;
import kos.mos.beng.constants.Config;
import kos.mos.beng.init.BaseActivity;
import kos.mos.beng.tool.UDialog;
import kos.mos.beng.tool.UIO;
import kos.mos.beng.tool.ULog;


/**
 * Recommended
 */
public class SplashActivity extends BaseActivity {
    private static String[] ABOUT_IFLYTEK = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private int refusedCount;//拒绝权限的次数

    @Override
    protected int layout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void basis() {
        refusedCount = 0;
        getPermissions();
    }

    @Override
    protected void logic() {

    }

    private void getPermissions() {
        refusedCount++;
        boolean st = false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            for (String permission : ABOUT_IFLYTEK) {
                int status = ActivityCompat.checkSelfPermission(this, permission);
                if (status == PackageManager.PERMISSION_GRANTED) {
                    st = true;
                } else {
                    st = false;
                    break;
                }
            }
        } else {
            st = true;
        }

        if (st) {
            init();
        } else {
            ActivityCompat.requestPermissions(this, ABOUT_IFLYTEK, 10086);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 10086) {
            boolean has = false;
            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    has = true;
                } else {
                    has = false;
                    break;
                }
            }

            if (has) {
                init();//成功
            } else {
                UDialog.getInstance(this, false, false)
                    .showNoticeConfirm("警告", "这些为必要的权限", "确定",
                        (result, dia) -> {
                            if (refusedCount > 2) {
                                //引导用户到设置中去进行设置
                                Intent intent = new Intent();
                                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent.setData(Uri.fromParts("package", getPackageName(), null));
                                startActivity(intent);
                                finish();
                            } else {
                                getPermissions();
                            }
                            dia.dismiss();
                        });
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        UDialog.getInstance().clear();
    }

    private void init() {
        Config.Cache = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "sakura";
        ULog.d("Cache:" + Config.Cache);
        UIO.checkFolderExists(Config.Cache);
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
