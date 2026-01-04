package com.huawei.android.p069cg.p071ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.huawei.uikit.phone.hwswitch.widget.HwSwitch;
import p031b7.C1140u;

/* loaded from: classes2.dex */
public class UnionSwitchNetCheck extends HwSwitch {

    /* renamed from: M */
    public int f11331M;

    /* renamed from: N */
    public Activity f11332N;

    /* renamed from: O */
    public CompoundButton.OnCheckedChangeListener f11333O;

    public UnionSwitchNetCheck(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Activity getActivity() {
        return this.f11332N;
    }

    public int getListIndex() {
        return this.f11331M;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        Activity activity = this.f11332N;
        if (activity == null || !C1140u.m7195g(activity)) {
            return super.performClick();
        }
        return true;
    }

    public void setActivity(Activity activity) {
        this.f11332N = activity;
    }

    public void setCheckedProgrammatically(boolean z10) {
        super.setOnCheckedChangeListener(null);
        super.setChecked(z10);
        super.setOnCheckedChangeListener(this.f11333O);
    }

    public void setListIndex(int i10) {
        this.f11331M = i10;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f11333O = onCheckedChangeListener;
        super.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
