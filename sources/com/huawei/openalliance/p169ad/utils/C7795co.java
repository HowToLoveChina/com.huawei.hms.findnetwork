package com.huawei.openalliance.p169ad.utils;

import com.huawei.openalliance.p169ad.AbstractC7185ho;
import javax.net.ssl.SSLContext;

/* renamed from: com.huawei.openalliance.ad.utils.co */
/* loaded from: classes2.dex */
public class C7795co {
    /* renamed from: a */
    public static SSLContext m48076a() {
        AbstractC7185ho.m43817a("SSLContextUtil", "use tls 1.3");
        return SSLContext.getInstance("TLSv1.3");
    }
}
