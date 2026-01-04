package com.huawei.android.hicloud.oobe.p086ui.uiextend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.android.hicloud.oobe.R$layout;

/* loaded from: classes3.dex */
public class NormalTopView extends OOBETopView {
    public NormalTopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.android.hicloud.oobe.p086ui.uiextend.OOBETopView
    /* renamed from: a */
    public void mo17035a() {
        if (this.f12701k) {
            View.inflate(this.f12698h, R$layout.oobe_top_view_uniform, this);
        } else {
            View.inflate(this.f12698h, R$layout.oobe_top_view, this);
        }
    }
}
