package com.huawei.openalliance.p169ad;

import com.huawei.openalliance.p169ad.utils.AbstractC7758be;

/* renamed from: com.huawei.openalliance.ad.mv */
/* loaded from: classes8.dex */
public abstract class AbstractC7487mv {
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static <T> T m45877a(String str, Class<T> cls) {
        if (cls == null || cls == String.class) {
            return str;
        }
        if (!cls.isPrimitive()) {
            return (T) AbstractC7758be.m47739b(str, cls, new Class[0]);
        }
        String str2 = "Response type: " + cls + " not supported!";
        AbstractC7185ho.m43823c("RemoteCallUtil", str2);
        throw new IllegalArgumentException(str2);
    }
}
