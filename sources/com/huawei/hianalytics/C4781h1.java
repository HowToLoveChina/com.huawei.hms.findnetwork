package com.huawei.hianalytics;

import android.content.Context;

/* renamed from: com.huawei.hianalytics.h1 */
/* loaded from: classes5.dex */
public class C4781h1 {

    /* renamed from: a */
    public static C4781h1 f21825a;

    /* renamed from: b */
    public static final byte[] f21826b = new byte[0];

    /* renamed from: a */
    public Context f21827a;

    /* renamed from: a */
    public final byte[] f21828a = new byte[0];

    public C4781h1(Context context) {
        this.f21827a = m28890a(context);
    }

    /* renamed from: a */
    public final Context m28890a(Context context) {
        return context.createDeviceProtectedStorageContext();
    }
}
