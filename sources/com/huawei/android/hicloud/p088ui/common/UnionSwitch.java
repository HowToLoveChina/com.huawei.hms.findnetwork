package com.huawei.android.hicloud.p088ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.huawei.uikit.phone.hwswitch.widget.HwSwitch;

/* loaded from: classes3.dex */
public class UnionSwitch extends HwSwitch {

    /* renamed from: M */
    public int f17855M;

    /* renamed from: N */
    public CompoundButton.OnCheckedChangeListener f17856N;

    /* renamed from: O */
    public boolean f17857O;

    public UnionSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17857O = true;
    }

    public int getListIndex() {
        return this.f17855M;
    }

    public void setCheckedProgrammatically(boolean z10) {
        super.setOnCheckedChangeListener(null);
        super.setChecked(z10);
        super.setOnCheckedChangeListener(this.f17856N);
    }

    public void setListIndex(int i10) {
        this.f17855M = i10;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f17856N = onCheckedChangeListener;
        super.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    public void setRestoreCheckStatus(boolean z10) {
        this.f17857O = z10;
    }
}
