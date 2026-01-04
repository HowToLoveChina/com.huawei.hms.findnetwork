package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import okhttp3.C11918e0;

/* renamed from: com.huawei.openalliance.ad.utils.ar */
/* loaded from: classes2.dex */
public class C7744ar {
    /* renamed from: a */
    public boolean m47602a() {
        try {
            new C11918e0.a();
            return true;
        } catch (Throwable th2) {
            AbstractC7185ho.m43827d("HttpUtils", "check okhttp error:%s", th2.getClass().getSimpleName());
            return false;
        }
    }
}
