package com.huawei.android.remotecontrol.p093ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.huawei.android.remotecontrol.sdk.R$id;
import p809yg.C13981a;
import sk.C12809f;

/* loaded from: classes4.dex */
public class ExplandItem extends LinearLayout implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "ExplandItem";
    private View mDetail;
    private CheckBox mIcon;

    public ExplandItem(Context context) {
        super(context);
    }

    private void initCheckState() {
        if (this.mIcon.isChecked()) {
            this.mDetail.setVisibility(0);
        } else {
            this.mDetail.setVisibility(8);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        initCheckState();
    }

    public void onExplandExchange() {
        if (this.mIcon.isChecked()) {
            this.mIcon.setChecked(false);
        } else {
            this.mIcon.setChecked(true);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mIcon = (CheckBox) C12809f.m76831d(this, R$id.list_arrow_expland);
        View viewM76831d = C12809f.m76831d(this, R$id.item_detail);
        this.mDetail = viewM76831d;
        if (viewM76831d != null && this.mIcon != null) {
            initCheckState();
            this.mIcon.setOnCheckedChangeListener(this);
            return;
        }
        C13981a.m83988e(TAG, "intiView error--mIcon=" + this.mIcon + "--mDetail=" + this.mDetail);
    }

    public ExplandItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
