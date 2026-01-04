package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.huawei.uikit.phone.hwswitch.widget.HwSwitch;

/* loaded from: classes3.dex */
public class UnionSwitch extends HwSwitch {

    /* renamed from: M */
    public int f12708M;

    /* renamed from: N */
    public CompoundButton.OnCheckedChangeListener f12709N;

    public UnionSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getListIndex() {
        return this.f12708M;
    }

    public void setCheckedProgrammatically(boolean z10) {
        super.setOnCheckedChangeListener(null);
        super.setChecked(z10);
        super.setOnCheckedChangeListener(this.f12709N);
    }

    public void setListIndex(int i10) {
        this.f12708M = i10;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f12709N = onCheckedChangeListener;
        super.setOnCheckedChangeListener(onCheckedChangeListener);
    }
}
