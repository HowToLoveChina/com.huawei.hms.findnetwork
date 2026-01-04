package com.huawei.android.remotecontrol.p093ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.android.hicloud.p088ui.extend.NotchFitLinearLayout;
import com.huawei.android.remotecontrol.sdk.R$dimen;
import com.huawei.android.remotecontrol.sdk.R$id;
import com.huawei.android.remotecontrol.sdk.R$layout;
import com.huawei.android.remotecontrol.sdk.R$string;
import p783xp.C13843a;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class TipLinearLayout extends NotchFitLinearLayout {
    private static final String TAG = "TipLinearLayout";
    private PopupWindow leftPopupWindow;
    private TextView leftTip;
    private Context mContext;
    private RelativeLayout mDataProtectTip;
    private RelativeLayout mLocationTip;
    private RelativeLayout mLockTip;
    private PopupWindow rightPopupWindow;
    private TextView rightTip;

    public TipLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        View.inflate(getContext(), R$layout.pf_tip_module, this);
        this.mLocationTip = (RelativeLayout) C12809f.m76831d(this, R$id.pf_location_tip);
        this.mLockTip = (RelativeLayout) C12809f.m76831d(this, R$id.pf_lock_tip);
        this.mDataProtectTip = (RelativeLayout) C12809f.m76831d(this, R$id.pf_data_protect_tip);
    }

    private PopupWindow getLeftPopupWindow() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.ph_tip_left, (ViewGroup) null);
        this.leftTip = (TextView) C12809f.m76831d(viewInflate, R$id.pf_sub_tip_left);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    private int getPopWindowMaxWidth(int i10) {
        int iM83055G = (C13843a.m83055G(getContext()) * 3) / 5;
        return i10 > iM83055G ? iM83055G : i10;
    }

    private PopupWindow getRightPopupWindow() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.ph_tip_right, (ViewGroup) null);
        this.rightTip = (TextView) C12809f.m76831d(viewInflate, R$id.pf_sub_tip_right);
        PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setOutsideTouchable(true);
        return popupWindow;
    }

    private void showLeftTip(View view) {
        View viewFindViewById;
        PopupWindow popupWindow;
        int id2 = view.getId();
        if (R$id.pf_location_tip == id2) {
            viewFindViewById = view.findViewById(R$id.iv_locate_device);
            this.leftPopupWindow = getLeftPopupWindow();
            this.leftTip.setText(R$string.ph_tip_locate_and_warning);
        } else if (R$id.pf_lock_tip == id2) {
            viewFindViewById = view.findViewById(R$id.iv_lock_device);
            this.leftPopupWindow = getLeftPopupWindow();
            this.leftTip.setText(R$string.ph_tip_lock_and_track_device);
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById == null || (popupWindow = this.leftPopupWindow) == null || this.leftTip == null) {
            C13981a.m83988e(TAG, "showLeftTip iconView is null");
            return;
        }
        popupWindow.getContentView().measure(0, 0);
        int popWindowMaxWidth = getPopWindowMaxWidth(this.leftPopupWindow.getContentView().getMeasuredWidth());
        this.leftPopupWindow.setWidth(popWindowMaxWidth);
        this.leftPopupWindow.showAsDropDown(view, C13843a.m83070V(this.mContext) ? (viewFindViewById.getRight() - popWindowMaxWidth) + this.leftTip.getPaddingStart() : viewFindViewById.getLeft() - this.leftTip.getPaddingStart(), (int) getContext().getResources().getDimension(R$dimen.cloud_space_8_dp), 3);
    }

    private void showRightTip(View view) {
        int left;
        if (this.rightPopupWindow == null) {
            this.rightPopupWindow = getRightPopupWindow();
        }
        if (this.rightPopupWindow.isShowing()) {
            return;
        }
        View viewFindViewById = view.findViewById(R$id.iv_protect_data);
        if (viewFindViewById == null) {
            C13981a.m83988e(TAG, "rightIcon is null");
            return;
        }
        this.rightPopupWindow.getContentView().measure(0, 0);
        int popWindowMaxWidth = getPopWindowMaxWidth(this.rightPopupWindow.getContentView().getMeasuredWidth());
        this.rightPopupWindow.setWidth(popWindowMaxWidth);
        if (C13843a.m83070V(this.mContext)) {
            left = viewFindViewById.getRight();
            popWindowMaxWidth = this.rightTip.getPaddingStart() * 2;
        } else {
            left = viewFindViewById.getLeft() + (this.rightTip.getPaddingStart() * 2);
        }
        this.rightPopupWindow.showAsDropDown(view, left - popWindowMaxWidth, (int) getContext().getResources().getDimension(R$dimen.cloud_space_8_dp), 3);
    }

    public void dismissAllPopWindow() {
        PopupWindow popupWindow = this.leftPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        PopupWindow popupWindow2 = this.rightPopupWindow;
        if (popupWindow2 != null) {
            popupWindow2.dismiss();
        }
    }

    public void onClick(View view) {
        dismissAllPopWindow();
        if (view == null) {
            return;
        }
        if (R$id.pf_data_protect_tip == view.getId()) {
            showRightTip(view);
        } else {
            showLeftTip(view);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mLocationTip.setOnClickListener(onClickListener);
        this.mLockTip.setOnClickListener(onClickListener);
        this.mDataProtectTip.setOnClickListener(onClickListener);
    }
}
