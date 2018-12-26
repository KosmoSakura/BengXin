package kos.mos.beng.ui;

import android.app.Dialog;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.devio.takephoto.model.TResult;

import kos.mos.beng.R;
import kos.mos.beng.constants.Code;
import kos.mos.beng.constants.UStr;
import kos.mos.beng.dao.DbEventHelper;
import kos.mos.beng.dao.DbPlayerHelper;
import kos.mos.beng.dao.bean.EventBean;
import kos.mos.beng.dao.bean.PlayerBean;
import kos.mos.beng.sakura.pop.PoShowPlayer;
import kos.mos.beng.tool.UDialog;
import kos.mos.beng.tool.UToast;
import kos.mos.beng.tool.UTxt;
import kos.mos.beng.tool.glide.UGlide;
import kos.mos.beng.tool.takephoto.TakePhotoFragmentActivity;

public class AddEventActivity extends TakePhotoFragmentActivity implements UDialog.SureClick, UDialog.CancelClick {
    private EditText edtDesc, edtAddress, edtModel, edTime, edtName, edtNameBack, edtComTxt;
    private ImageView iBanner, iDel, iDelPoint, iDelComment, iDelImages;
    private TextView tAt, tPoint, tComment, tImages;
    private String strAt, strPoint, strComment;
    private String url;
    private View comLay;

    @Override
    protected int layout() {
        return R.layout.activity_add_event;
    }

    @Override
    protected void basis() {
        tAt = findViewById(R.id.add_at);
        edtName = findViewById(R.id.com_name);
        edtNameBack = findViewById(R.id.com_back_name);
        edtComTxt = findViewById(R.id.com_text);
        comLay = findViewById(R.id.com_lay);
        edtDesc = findViewById(R.id.add_desc);
        edtAddress = findViewById(R.id.add_address);
        edtModel = findViewById(R.id.add_model);
        iDelImages = findViewById(R.id.add_images_txt_del);
        tImages = findViewById(R.id.add_images_txt);
        iDelPoint = findViewById(R.id.add_point_del);
        tPoint = findViewById(R.id.add_point);
        edTime = findViewById(R.id.add_time);
        iBanner = findViewById(R.id.add_image);
        iDel = findViewById(R.id.add_at_del);
        tComment = findViewById(R.id.add_comment);
        iDelComment = findViewById(R.id.add_comment_del);

        findViewById(R.id.com_done).setOnClickListener(this);
        findViewById(R.id.add_save).setOnClickListener(this);
        findViewById(R.id.add_back).setOnClickListener(this);
        iDelImages.setOnClickListener(this);
        tPoint.setOnClickListener(this);
        iDelPoint.setOnClickListener(this);
        iBanner.setOnClickListener(this);
        comLay.setOnClickListener(this);
        tComment.setOnClickListener(this);
        iDelComment.setOnClickListener(this);
        tAt.setOnClickListener(this);
        iDel.setOnClickListener(this);
        strPoint = "";
        strAt = "";
        strComment = "";
        iDelPoint.setVisibility(View.GONE);
        iDelComment.setVisibility(View.GONE);
        iDelImages.setVisibility(View.GONE);
        iDel.setVisibility(View.GONE);
        comLay.setVisibility(View.GONE);
    }

    @Override
    protected void logic() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_at:
                PoShowPlayer.getInstance(this, DbPlayerHelper.SearchAll(this))
                    .setOnItemClickListener(bean -> {
                        if (bean == null) {
                            UToast.init().CustomShort("数据异常");
                            return;
                        }
                        if (UTxt.isEmpty(strAt)) {
                            strAt = "@" + UTxt.isNull(bean.getName(), "???");
                        } else {
                            strAt = strAt + " , " + UTxt.isNull(bean.getName(), "???");
                        }
                        tAt.setText(strAt);
                        iDel.setVisibility(View.VISIBLE);
                    }).show(view);
                break;
            case R.id.add_point:
                PoShowPlayer.getInstance(this, DbPlayerHelper.SearchAll(this))
                    .setOnItemClickListener(bean -> {
                        if (bean == null) {
                            UToast.init().CustomShort("数据异常");
                            return;
                        }
                        String name = UTxt.isNull(bean.getName());
                        if (UTxt.isEmpty(strPoint)) {
                            strPoint = name;
                        } else {
                            if (strPoint.contains(name)) {
                                UToast.init().CustomShort("一个人点赞一次就够了");
                                return;
                            } else {
                                strPoint = strPoint + "," + name;
                            }
                        }
                        tPoint.setText(strPoint);
                        iDelPoint.setVisibility(View.VISIBLE);
                    }).show(view);
                break;
            case R.id.com_lay:
                comLay.setVisibility(View.GONE);
                break;
            case R.id.add_comment:
                comLay.setVisibility(View.VISIBLE);
                break;
            case R.id.com_done:
                if (UTxt.isEmpty(edtName)) {
                    UToast.init().CustomShort("不能匿名");
                    return;
                }
                if (UTxt.isEmpty(edtComTxt)) {
                    UToast.init().CustomShort("不能说空话");
                    return;
                }
                String com = "";
                if (UTxt.isEmpty(edtNameBack)) {
                    com = UStr.parseComments(edtName.getText().toString(), edtComTxt.getText().toString());
                } else {
                    com = UStr.parseComments(edtName.getText().toString(), edtNameBack.getText().toString(), edtComTxt.getText().toString());
                }
                if (UTxt.isEmpty(strComment)) {
                    strComment = com;
                } else {
                    strComment = strComment + Code.State.split + com;
                }
                tComment.setText(Html.fromHtml(strComment));
                edtName.setText(null);
                edtNameBack.setText(null);
                edtComTxt.setText(null);
                comLay.setVisibility(View.GONE);
                break;
            case R.id.add_comment_del:
                tComment.setText(null);
                strComment = "";
                iDelComment.setVisibility(View.GONE);
                break;
            case R.id.add_at_del:
                tAt.setText(null);
                strAt = "";
                iDel.setVisibility(View.GONE);
                break;
            case R.id.add_point_del:
                tPoint.setText(null);
                strPoint = "";
                iDelPoint.setVisibility(View.GONE);
                break;
            case R.id.add_images_txt_del:
                tImages.setText(null);
                url = "";
                iBanner.setImageResource(R.drawable.ic_add_image);
                iDelImages.setVisibility(View.GONE);
                break;
            case R.id.add_image:
                UDialog.getInstance(this, true, true)
                    .showSelect("请选择图像拾取方式", "相册", "相机", this, this);
                break;
            case R.id.add_save:
                toSave();
                break;
            case R.id.add_back:
                finish();
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        PoShowPlayer.getInstance().clear();
    }


    private void toSave() {
        if (UTxt.isEmpty(edtDesc)) {
            UToast.init().CustomShort("必须的说点什么");
            return;
        }

        PlayerBean me = DbPlayerHelper.getMe(this);
        if (me == null) {
            UToast.init().CustomShort("个人信息获取失败");
            return;
        }
        if (!UTxt.isEmpty(edtModel)) {
            me.setPhoneModel(edtModel.getText().toString());
        }
        String time = UTxt.isNull(edTime.getText().toString(), "刚刚");
        String address = UTxt.isNull(edtAddress.getText().toString(), UTxt.isNull(me.getAddress(), "???"));

        DbEventHelper.insert(this, new EventBean(System.currentTimeMillis(), me, 1,
            UTxt.isNull(url), time, address, strPoint + "", strComment + "", null, null,
            edtDesc.getText().toString() + "" + UStr.parseAtNoAt(strAt)));
        UToast.init().CustomShort("发布成功");
        finish();
    }

    @Override
    public void takeSuccess(TResult result) {
        String compressPath = result.getImage().getCompressPath();
        if (UTxt.isEmpty(url)) {
            url = compressPath;
        } else {
            url = url + Code.State.MMM + compressPath;
        }
        tImages.setText(UTxt.isNull(url));
        UGlide.loadBanner(this, compressPath, iBanner);
        iDelImages.setVisibility(View.VISIBLE);
    }

    @Override
    public void OnSureClick(String result, Dialog dia) {
        openAlbum(true);
        dia.dismiss();
    }

    @Override
    public void OnCancelClick(Dialog dia) {
        openCamrea(true);
        dia.dismiss();
    }
}
