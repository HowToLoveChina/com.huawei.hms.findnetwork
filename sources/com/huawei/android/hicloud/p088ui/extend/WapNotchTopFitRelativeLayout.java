package com.huawei.android.hicloud.p088ui.extend;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.WindowInsets;

/* loaded from: classes3.dex */
public class WapNotchTopFitRelativeLayout extends NotchTopFitRelativeLayout {

    /* renamed from: e */
    public Context f18016e;

    public WapNotchTopFitRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18016e = context;
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout, sk.InterfaceC12805b
    public void onRotation180(WindowInsets windowInsets) {
        if (this.f18016e instanceof Activity) {
            setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout, sk.InterfaceC12805b
    public void onRotation270(WindowInsets windowInsets) {
        if (this.f18016e instanceof Activity) {
            setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout, sk.InterfaceC12805b
    public void onRotation90(WindowInsets windowInsets) {
        if (this.f18016e instanceof Activity) {
            setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.huawei.android.hicloud.p088ui.extend.NotchTopFitRelativeLayout, sk.InterfaceC12805b
    public void onRotationPortrait(WindowInsets windowInsets) {
        if (this.f18016e instanceof Activity) {
            setPadding(0, 0, 0, 0);
        }
    }
}
