package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.BuyPackageBaseActivity;
import com.huawei.android.p073ds.R$dimen;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import p015ak.C0213f;
import p514o9.C11839m;
import p514o9.C11842p;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TipCommonView {
    private static final String TAG = "TipCommonUtil";
    private BuyPackageBaseActivity activity;
    private PopupWindow leftPopupWindow;
    private TextView leftTipText;

    /* renamed from: com.huawei.android.hicloud.ui.uiextend.dialog.TipCommonView$1 */
    public class ViewOnClickListenerC42011 implements View.OnClickListener {
        public ViewOnClickListenerC42011() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TipCommonView.this.activity.m22812X4(true);
            TipCommonView.this.dismiss();
        }
    }

    public TipCommonView(Activity activity) {
        if (activity instanceof BuyPackageBaseActivity) {
            this.activity = (BuyPackageBaseActivity) activity;
        }
    }

    private PopupWindow getLeftPopupWindow() {
        View viewInflate = LayoutInflater.from(this.activity).inflate(R$layout.ph_tip_right_help, (ViewGroup) null);
        this.leftTipText = (TextView) C12809f.m76831d(viewInflate, R$id.pf_sub_tip_left);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    private int getPopWindowMaxWidth(int i10) {
        int iM83055G = (C13843a.m83055G(this.activity) * 2) / 3;
        return i10 > iM83055G ? iM83055G : i10;
    }

    public void dismiss() {
        PopupWindow popupWindow = this.leftPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.leftPopupWindow = null;
        }
    }

    public void showLeftTip(View view, String str) throws Resources.NotFoundException {
        if (this.leftPopupWindow == null) {
            this.leftPopupWindow = getLeftPopupWindow();
            this.leftTipText.setText(str);
        }
        if (this.leftPopupWindow.isShowing()) {
            return;
        }
        TextView textView = this.leftTipText;
        if (textView == null) {
            C11839m.m70687e(TAG, "showLeftTip iconView is null");
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.TipCommonView.1
            public ViewOnClickListenerC42011() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TipCommonView.this.activity.m22812X4(true);
                TipCommonView.this.dismiss();
            }
        });
        this.leftPopupWindow.getContentView().measure(0, 0);
        int popWindowMaxWidth = getPopWindowMaxWidth(this.leftPopupWindow.getContentView().getMeasuredWidth());
        this.leftPopupWindow.setWidth(popWindowMaxWidth);
        int dimensionPixelOffset = this.activity.getResources().getDimensionPixelOffset(R$dimen.margin_xl);
        int dimensionPixelOffset2 = this.activity.getResources().getDimensionPixelOffset(R$dimen.margin_m);
        int measuredWidth = view.getMeasuredWidth() / 2;
        this.leftPopupWindow.showAsDropDown(view, C11842p.m70765S0() ? (0 - measuredWidth) - dimensionPixelOffset2 : (0 - popWindowMaxWidth) + dimensionPixelOffset + measuredWidth + dimensionPixelOffset2, (int) C0213f.m1377a().getResources().getDimension(R$dimen.cloud_space_8_dp));
    }
}
