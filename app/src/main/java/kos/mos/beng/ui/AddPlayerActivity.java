package kos.mos.beng.ui;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import org.devio.takephoto.model.TResult;

import kos.mos.beng.R;
import kos.mos.beng.constants.Config;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.tool.UDialog;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.tool.UTxt;
import kos.mos.beng.tool.glide.UGlide;
import kos.mos.beng.tool.takephoto.TakePhotoFragmentActivity;

public class AddPlayerActivity extends TakePhotoFragmentActivity
    implements OnCheckedChangeListener, UDialog.SureClick, UDialog.CancelClick {
    private EditText tUUID, tName, tAge, tHobby, tAddress, tModel, tDesc;
    private ImageView iHead, iBanner, iSave;
    private TextView tDone;
    private int sex;
    private String urlHead, urlBanner;
    private boolean isHead;
    private RadioButton rbGirl, rBoy;
    private long userId;


    @Override
    protected int layout() {
        return R.layout.activity_add_player;
    }

    @Override
    protected void basis() {
        iSave = findViewById(R.id.add_save);
        tDone = findViewById(R.id.add_done);
        iHead = findViewById(R.id.add_icon);
        iBanner = findViewById(R.id.add_banner);
        tUUID = findViewById(R.id.add_uuid);
        tName = findViewById(R.id.add_name);
        tAge = findViewById(R.id.add_age);
        tHobby = findViewById(R.id.add_hobby);
        tAddress = findViewById(R.id.add_address);
        tModel = findViewById(R.id.add_model);
        tDesc = findViewById(R.id.add_signature);
        rbGirl = findViewById(R.id.add_girl);
        rBoy = findViewById(R.id.add_boy);

        iSave.setOnClickListener(this);
        tDone.setOnClickListener(this);
        findViewById(R.id.add_icon).setOnClickListener(this);
        findViewById(R.id.add_banner).setOnClickListener(this);
        findViewById(R.id.add_back).setOnClickListener(this);
        ((RadioGroup) findViewById(R.id.add_sex_lay)).setOnCheckedChangeListener(this);
    }

    @Override
    protected void logic() {
        sex = -1;
        userId = getIntent().getLongExtra("UserId", -1);
        if (userId > 0) {
            tDone.setVisibility(View.GONE);
            iSave.setVisibility(View.VISIBLE);
            PlayerBean bean = DbPlayerHelper.Search(this, userId);
            if (bean != null) {
                urlHead = bean.getAvatar();
                urlBanner = bean.getBanner();
                UGlide.loadCirle(this, urlHead, iHead);
                UGlide.loadBanner(this, urlBanner, iBanner);
                tUUID.setText(UTxt.isNull(bean.getUid(), ""));
                tName.setText(UTxt.isNull(bean.getName(), ""));
                tAge.setText(UTxt.isNull(bean.getAge(), ""));
                tHobby.setText(UTxt.isNull(bean.getHobby(), ""));
                tAddress.setText(UTxt.isNull(bean.getAddress(), ""));
                tModel.setText(UTxt.isNull(bean.getPhoneModel(), ""));
                tDesc.setText(UTxt.isNull(bean.getDescribe(), ""));

                if (UTxt.isNull(bean.getSex(), -1) == -1) {
                    rbGirl.setChecked(true);
                    rBoy.setChecked(false);
                } else {
                    rBoy.setChecked(true);
                    rbGirl.setChecked(false);
                }
            }
        } else {
            tDone.setVisibility(View.VISIBLE);
            iSave.setVisibility(View.GONE);
        }
    }

    @Override
    protected void action(int ids) {
        switch (ids) {
            case R.id.add_back:
                finish();
                break;
            case R.id.add_save:
                toDone(true);
                break;
            case R.id.add_done:
                toDone(false);
                break;
            case R.id.add_banner:
                isHead = false;
                showSelect();
                break;
            case R.id.add_icon:
                isHead = true;
                showSelect();
                break;
        }
    }


    private void toDone(boolean toSave) {
        if (UTxt.isEmpty(tName)) {
            UToast.init().CustomShort("名字不能为空");
            return;
        }

        int age = 0;
        if (!UTxt.isEmpty(tAge.getText().toString())) {
            try {
                age = Integer.parseInt(tAge.getText().toString());
            } catch (Exception e) {
                UToast.init().CustomShort("年龄你不想输可以不输，但是不能乱输");
                return;
            }
        }

        long ids = Config.UIDCreator();
        String uid = UTxt.isNull(tUUID.getText().toString(), "K" + ids);
        String name = UTxt.isNull(tName.getText().toString(), "");
        String hobby = UTxt.isNull(tHobby.getText().toString(), "这人清新寡欲，没有任何爱好");
        String address = UTxt.isNull(tAddress.getText().toString(), "这人所在地是个谜");
        String model = UTxt.isNull(tModel.getText().toString(), "手机烂的不好意思写");
        String desc = UTxt.isNull(tDesc.getText().toString(), "这人很懒，懒的连签名都让系统帮写");

        if (toSave) {
            if (userId > 0) {
                DbPlayerHelper.update(this, new PlayerBean(userId, uid, sex, (sex == 1) ? "男" : "女",
                    name + "", urlHead + "", address + "", model + "",
                    desc + "", urlBanner + "", age, hobby + "", true));
                UToast.init().CustomShort("信息保存成功");
                finish();
            } else {
                UToast.init().CustomShort("信息数据异常");
            }
        } else {
            if (UTxt.isEmpty(urlHead)) {
                urlHead = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/deft/aa.gif";
            }
            if (UTxt.isEmpty(urlBanner)) {
                urlBanner = "https://sakura-1252716638.cos.ap-chengdu.myqcloud.com/beng/deft/xiong.png";
            }
            DbPlayerHelper.insert(this, new PlayerBean(ids, uid, sex, (sex == 1) ? "男" : "女",
                name + "", urlHead + "", address + "", model + "",
                desc + "", urlBanner + "", age, hobby + "", false));
            UToast.init().CustomShort("注册成功");
            finish();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.add_girl:
                sex = -1;
                break;
            case R.id.add_boy:
                sex = 1;
                break;
        }
    }

    @Override
    public void takeSuccess(TResult result) {
        String path = result.getImage().getCompressPath();
        if (isHead) {
            UGlide.loadCirle(this, path, iHead);
            urlHead = UTxt.isNull(path);
        } else {
            UGlide.loadBanner(this, path, iBanner);
            urlBanner = UTxt.isNull(path);
        }
    }


    private void showSelect() {
        UDialog.getInstance(this, true, true)
            .showSelect("请选择图像拾取方式", "相册", "相机", this, this);
    }

    @Override
    public void OnSureClick(String result, Dialog dia) {
        openAlbum(!isHead);
        dia.dismiss();
    }

    @Override
    protected void onResume() {
        super.onResume();
        UDialog.getInstance().clear();
    }

    @Override
    public void OnCancelClick(Dialog dia) {
        openCamrea(!isHead);
        dia.dismiss();
    }


}
