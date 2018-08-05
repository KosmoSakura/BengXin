package kos.mos.beng.ui;

import kos.mos.beng.R;
import kos.mos.beng.init.BaseActivity;

/**
 * @Description:
 * @Author: Kosmos
 * @Email: KosmoSakura@foxmail.com
 */
public class AboutActivity extends BaseActivity {
    @Override
    protected int layout() {
        return R.layout.activity_about;
    }

    @Override
    protected void basis() {
        findViewById(R.id.about_back).setOnClickListener(this);
    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.about_back:
                finish();
                break;
        }
    }

    @Override
    protected void logic() {
    }
}
