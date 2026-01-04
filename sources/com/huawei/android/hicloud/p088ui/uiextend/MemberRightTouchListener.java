package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.huawei.cloud.pay.R$drawable;

/* loaded from: classes3.dex */
public class MemberRightTouchListener implements View.OnTouchListener {
    private Context context;
    private LinearLayout rightTagLayout;

    public MemberRightTouchListener(Context context, LinearLayout linearLayout) {
        this.context = context;
        this.rightTagLayout = linearLayout;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null || this.rightTagLayout == null || this.context == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.rightTagLayout.setBackground(this.context.getDrawable(R$drawable.payment_tab_press));
        } else if (action == 1 || action == 3) {
            this.rightTagLayout.setBackground(null);
            view.performClick();
        }
        return true;
    }
}
