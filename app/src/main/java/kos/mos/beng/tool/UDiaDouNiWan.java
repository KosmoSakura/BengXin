package kos.mos.beng.tool;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import kos.mos.beng.R;

/**
 * @Description: <p>
 * @Author: Kosmos
 * @Date: 2018年08月15日 17:15
 * @Email: KosmoSakura@foxmail.com
 * @Event:
 */
public class UDiaDouNiWan {


    public UDiaDouNiWan(Context c) {
        inits(c);
    }

    private void inits(Context c) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.lay_dialog_douniwan, null);
        Dialog upDialog = new Dialog(c, R.style.SakuraDialog);
        upDialog.setCancelable(true);
        upDialog.setCanceledOnTouchOutside(true);
        upDialog.show();
        upDialog.setContentView(view);
        upDialog.getWindow().setBackgroundDrawableResource(R.color.T_all);
        Button cancel = view.findViewById(R.id.dia_simple_cancel);
        Button sure = view.findViewById(R.id.dia_simple_sure);
        final LinearLayout relTxt = view.findViewById(R.id.dia_simple_rel_txt);
        final RelativeLayout relPic = view.findViewById(R.id.dia_simple_rel_pic);

        sure.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                relTxt.setVisibility(View.GONE);
                relPic.setVisibility(View.VISIBLE);
                return true;
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                relTxt.setVisibility(View.VISIBLE);
                relPic.setVisibility(View.GONE);
                return true;
            } else
                return false;
        });
        cancel.setOnClickListener(view1 -> upDialog.dismiss());
        upDialog.show();
    }

}
