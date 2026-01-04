package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.ma */
/* loaded from: classes8.dex */
public class C7418ma {
    /* renamed from: a */
    public static boolean m45655a(String str) throws ClassNotFoundException {
        try {
            Class.forName(str);
            AbstractC7185ho.m43820b("OMSDKCheckUtil", str);
            return true;
        } catch (ClassNotFoundException unused) {
            AbstractC7185ho.m43820b("OMSDKCheckUtil", str + " is not avaliable");
            return false;
        }
    }
}
