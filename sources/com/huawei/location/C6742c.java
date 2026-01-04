package com.huawei.location;

import android.content.Context;
import com.huawei.riemann.gnsslocation.core.VdrLocationAlgoWrapper;

/* renamed from: com.huawei.location.c */
/* loaded from: classes8.dex */
public final class C6742c {

    /* renamed from: e */
    public static VdrLocationAlgoWrapper f31213e;

    /* renamed from: a */
    public final C6760g f31214a;

    /* renamed from: b */
    public volatile boolean f31215b = false;

    /* renamed from: c */
    public int f31216c = 0;

    /* renamed from: d */
    public int f31217d = 0;

    public C6742c(Context context, String str) {
        f31213e = VdrLocationAlgoWrapper.m53565a(context, str);
        this.f31214a = C6760g.m38369b();
    }
}
