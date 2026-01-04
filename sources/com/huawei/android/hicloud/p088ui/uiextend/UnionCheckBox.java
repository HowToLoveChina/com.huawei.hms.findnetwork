package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* loaded from: classes3.dex */
public class UnionCheckBox extends CheckBox {
    private int listIndex;

    public UnionCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getListIndex() {
        return this.listIndex;
    }

    public void setListIndex(int i10) {
        this.listIndex = i10;
    }
}
