package kos.mos.beng.tool;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import kos.mos.beng.R;


/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年07月06日 14:11
 * @Email: KosmoSakura@foxmail.com
 */
public class UDialog {
    private static Dialog dialog;
    private static UDialog instance;
    private EditText edt;
    private ImageView icon;
    private TextView msg, title, cancel, sure;
    private View lineTitle, lineBotton;

    public interface SureClick {
        void OnSureClick(String result, Dialog dia);
    }

    public interface CancelClick {
        void OnCancelClick(Dialog dia);
    }

    private SureClick sureClick;
    private CancelClick cancelClick;

    /**
     * @param Cancelable 是否可以通过返回键关闭
     * @param outside    是否可以点击外面关闭
     */
    public static UDialog getInstance(Context context, boolean Cancelable, boolean outside) {
        if (instance == null || dialog == null) {
            instance = new UDialog(context, Cancelable, outside);
        }
        return instance;
    }

    public static UDialog getInstance() {
        if (instance == null) {
            instance = new UDialog();
        }
        return instance;
    }

    private UDialog() {

    }

    public void clear() {
        if (instance != null) {
            instance = null;
        }
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    private UDialog(Context context, boolean Cancelable, boolean outside) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lay_dialog, null);
        dialog = new Dialog(context, R.style.SakuraDialog);
        dialog.setCancelable(Cancelable);//是否可以通过返回键关闭
        dialog.setCanceledOnTouchOutside(outside);//是否可以点击外面关闭
        dialog.show();
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawableResource(R.color.T_all);

        title = view.findViewById(R.id.dia_title);
        icon = view.findViewById(R.id.dia_icon);
        msg = view.findViewById(R.id.dia_msg);
        edt = view.findViewById(R.id.dia_edt);
        cancel = view.findViewById(R.id.dia_cancel);
        sure = view.findViewById(R.id.dia_sure);
        lineTitle = view.findViewById(R.id.dia_line_title);
        lineBotton = view.findViewById(R.id.dia_line_button);
    }

    /**
     * @param msg     通知内容
     * @param strSure 确认按钮字样
     * @apiNote 显示简单的通知对话框
     */
    public void showNotice(String msg, String strSure) {
        show(null, msg, null, strSure, null, -1);
    }

    public void showNotice(String msg, String strSure, int res) {
        show(null, msg, null, strSure, null, res);
    }

    /**
     * @param msg     通知内容
     * @param strSure 确认按钮字样
     * @apiNote 显示确认对话框
     */
    public void showNoticeConfirm(String title, String msg, String strSure, SureClick sureClick) {
        this.sureClick = sureClick;
        show(title, msg, null, strSure, null, R.mipmap.sakura);
    }

    /**
     * @param msg       通知内容
     * @param strSure   确认按钮字样
     * @param strCancel 取消按钮字样
     * @apiNote 显示选择性的对话框
     */
    public void showSelect(String msg, String strSure, String strCancel, SureClick sureClick, CancelClick cancelClick) {
        this.sureClick = sureClick;
        this.cancelClick = cancelClick;
        show(null, msg, null, strSure, strCancel, -1);
    }

    /**
     * @param strTitle 对话框标题
     * @param hint     输入框提示语
     * @apiNote 显示带有输入框的对话框
     */
    public void showInput(String strTitle, String hint, SureClick sureClick) {
        this.sureClick = sureClick;
        show(strTitle, null, hint, null, null, -1);
    }

    private void show(String strTitle, String strMsg, String strHint, String strSure, String strCancel, int res) {
        if (UTxt.isEmpty(strTitle)) {
            title.setVisibility(View.GONE);
            lineTitle.setVisibility(View.GONE);
        } else {
            title.setText(strTitle);
            title.setVisibility(View.VISIBLE);
            lineTitle.setVisibility(View.VISIBLE);
        }

        if (res > 0) {
            icon.setVisibility(View.VISIBLE);
            icon.setImageResource(res);
        } else {
            icon.setVisibility(View.GONE);
        }

        if (UTxt.isEmpty(strMsg)) {
            msg.setVisibility(View.GONE);
        } else {
            msg.setText(strMsg);
            msg.setVisibility(View.VISIBLE);
        }

        if (UTxt.isEmpty(strHint)) {
            edt.setVisibility(View.GONE);
        } else {
            edt.setHint(strHint);
            edt.setText("");
            edt.setVisibility(View.VISIBLE);
        }

        if (UTxt.isEmpty(strCancel)) {
            cancel.setVisibility(View.GONE);
            lineBotton.setVisibility(View.GONE);
            sure.setText(UTxt.isNull(strSure, "确定"));
        } else {
            cancel.setVisibility(View.VISIBLE);
            lineBotton.setVisibility(View.VISIBLE);
            cancel.setText(UTxt.isNull(strCancel, "取消"));
            sure.setText(UTxt.isNull(strSure, "确定"));
        }

        cancel.setOnClickListener(view -> {
            if (cancelClick == null) {
                dialog.dismiss();
            } else {
                cancelClick.OnCancelClick(dialog);
            }
        });
        sure.setOnClickListener(view -> {
            if (sureClick == null) {
                dialog.dismiss();
            } else {
                sureClick.OnSureClick(UTxt.isNull(edt.getText().toString()), dialog);
            }
        });
        dialog.show();
    }
}
