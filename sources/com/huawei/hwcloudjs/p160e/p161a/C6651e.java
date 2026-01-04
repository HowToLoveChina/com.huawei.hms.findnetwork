package com.huawei.hwcloudjs.p160e.p161a;

import android.content.Context;
import com.huawei.hwcloudjs.p164f.C6659d;

/* renamed from: com.huawei.hwcloudjs.e.a.e */
/* loaded from: classes8.dex */
public class C6651e {

    /* renamed from: a */
    private static final String f30872a = "CacheRequestManager";

    /* renamed from: a */
    public static void m37867a(String[] strArr, int i10, Context context) {
        C6659d.m37882c(f30872a, "enter into preload", true);
        new Thread(new RunnableC6650d(strArr, context, i10)).start();
    }
}
