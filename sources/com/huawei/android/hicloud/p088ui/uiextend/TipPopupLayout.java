package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.uikit.phone.hwbubblelayout.widget.HwBubbleLayout;
import p783xp.C13843a;
import sk.C12809f;

/* loaded from: classes3.dex */
public class TipPopupLayout extends NotchFitLinearLayout {
    private static final double HALF = 0.5d;
    private static final int REVERSES = 2;
    private static final String TAG = "TipPopupLayout";
    private HwBubbleLayout bubbleLayout;
    private int famliyShareMaxNum;
    private ImageView helpIcon;
    private boolean isFamliyShareNumNotEnough;
    private PopupWindow rightPopupWindow;
    private RelativeLayout textLayout;
    private TextView tipText;
    String tipTxtStr;

    public TipPopupLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isFamliyShareNumNotEnough = false;
        this.famliyShareMaxNum = 0;
        View.inflate(getContext(), R$layout.tip_popup_item, this);
        this.helpIcon = (ImageView) C12809f.m76831d(this, R$id.features_help);
    }

    private int getPopWindowMaxWidth(int i10) {
        int iM83055G = (C13843a.m83055G(getContext()) * 2) / 3;
        return i10 > iM83055G ? iM83055G : i10;
    }

    private PopupWindow getRightPopupWindow() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.pop_main_tip_right, (ViewGroup) null);
        this.bubbleLayout = (HwBubbleLayout) C12809f.m76831d(viewInflate, R$id.bubble_layout_popup);
        this.tipText = (TextView) C12809f.m76831d(viewInflate, R$id.pf_sub_tip_right);
        this.textLayout = (RelativeLayout) C12809f.m76831d(viewInflate, R$id.pf_sub_tip_right_layout);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void showRightTip(android.view.View r15) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.p088ui.uiextend.TipPopupLayout.showRightTip(android.view.View):void");
    }

    public void dismiss() {
        PopupWindow popupWindow = this.rightPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.rightPopupWindow = null;
        }
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (R$id.features_help == id2 || R$id.family_share_num_not_enough == id2 || R$id.basic_detail_iv == id2 || R$id.detail_iv == id2) {
            showRightTip(view);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        PopupWindow popupWindow = this.rightPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.rightPopupWindow.dismiss();
        this.rightPopupWindow = null;
        showRightTip(this.helpIcon);
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.helpIcon.setOnClickListener(onClickListener);
    }

    public void setFamliyShareMaxNum(int i10) {
        this.famliyShareMaxNum = i10;
    }

    public void setFamliyShareNumNotEnough(boolean z10) {
        this.isFamliyShareNumNotEnough = z10;
    }

    public void setImageViewPic(int i10) {
        ImageView imageView = this.helpIcon;
        if (imageView != null) {
            imageView.setImageResource(i10);
        }
    }

    public void setTipTxtStr(String str) {
        this.tipTxtStr = str;
    }
}
