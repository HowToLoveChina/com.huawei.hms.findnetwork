package com.huawei.android.hicloud.p088ui.extend;

import android.content.Context;
import p015ak.C0219i;

/* renamed from: com.huawei.android.hicloud.ui.extend.b */
/* loaded from: classes3.dex */
public class C3944b {
    /* renamed from: a */
    public static AbstractC3943a m24060a(Context context) {
        int iM1463a = C0219i.m1463a();
        return (iM1463a >= 21 || iM1463a == 0) ? new GradientActionBarStyleEMUI10(context) : iM1463a >= 17 ? new GradientActionBarStyleEMUI9(context) : new GradientActionBarStyleEMUI5(context);
    }
}
