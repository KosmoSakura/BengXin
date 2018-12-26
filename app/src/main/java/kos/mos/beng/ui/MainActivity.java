package kos.mos.beng.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kos.mos.beng.R;
import kos.mos.beng.init.BaseActivity;
import kos.mos.beng.ui.frag.DataFragment;
import kos.mos.beng.ui.frag.PlayerFragment;
import kos.mos.beng.ui.frag.WatashiFragment;

public class MainActivity extends BaseActivity {
    private final String[] TAGS = {"HOME_FRAGMENT", "PLAY_FRAGMENT", "DATA_FRAGMENT"};
    private final int[] RES_ON = {R.drawable.v_me_on, R.drawable.v_data_on, R.drawable.v_flower_on};
    private final int[] RES = {R.drawable.v_me, R.drawable.v_data, R.drawable.v_flower};
    private Fragment fragment;
    private List<Fragment> list;
    private List<LinearLayout> views;

    @Override
    protected int layout() {
        return R.layout.activity_main;
    }

    @Override
    protected void basis() {
        views = new ArrayList<>();
        LinearLayout one = findViewById(R.id.main_lay_one);
        LinearLayout two = findViewById(R.id.main_lay_two);
        LinearLayout three = findViewById(R.id.main_lay_three);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        views.add(one);
        views.add(two);
        views.add(three);
    }

    @Override
    protected void logic() {
        list = new ArrayList<>();
        list.add(new WatashiFragment());
        list.add(new DataFragment());
        list.add(new PlayerFragment());

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < list.size(); i++) {
            ft.add(R.id.main_content, list.get(i), TAGS[i]);
            if (i == 0) {
                ft.show(list.get(i));
            } else {
                ft.hide(list.get(i));
            }
        }
        ft.commit();

        changeMenu(0);
        changeIcon(0);
//        if (Config.databaseIsEmpty(this)) {
//            new DataCreator().creatPlayer(this);
//            DbEventHelper.clear(this);
//            new DataCreator().creatEvent(this);
//        }
    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.main_lay_one:
                changeMenu(0);
                changeIcon(0);
                break;
            case R.id.main_lay_two:
                changeMenu(1);
                changeIcon(1);
                break;
            case R.id.main_lay_three:
                changeMenu(2);
                changeIcon(2);
                break;
        }
    }

    public void changeMenu(int index) {
        for (int i = 0; i < list.size(); i++) {
            Fragment fragment = list.get(i);
            if (fragment.isAdded()) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                if (index == i) {
                    fragment.setUserVisibleHint(true);
                    fragment.onResume();
                    ft.show(fragment);
                } else {
                    fragment.setUserVisibleHint(false);
                    fragment.onPause();
                    ft.hide(fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }
    }

    public void changeIcon(int index) {
        int menuSize = views.size();
        for (int i = 0; i < menuSize; i++) {
            if (i == index) {
                views.get(i).setClickable(false);
                views.get(i).setSelected(true);
                ((ImageView) views.get(i).getChildAt(0)).setImageResource(RES_ON[i]);
                ((TextView) views.get(i).getChildAt(1)).setTextColor(ContextCompat.getColor(this, R.color.default_blue_light));
            } else {
                views.get(i).setClickable(true);
                views.get(i).setSelected(false);
                ((ImageView) views.get(i).getChildAt(0)).setImageResource(RES[i]);
                ((TextView) views.get(i).getChildAt(1)).setTextColor(ContextCompat.getColor(this, R.color.default_gray));
            }
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        backToHome();
    }

    private void backToHome() {
        Intent home = new Intent(Intent.ACTION_MAIN);
        home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        home.addCategory(Intent.CATEGORY_HOME);
        startActivity(home);
    }
}
