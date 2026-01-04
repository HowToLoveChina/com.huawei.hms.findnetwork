package com.huawei.openalliance.p169ad;

/* renamed from: com.huawei.openalliance.ad.ov */
/* loaded from: classes8.dex */
public class C7561ov {
    /* renamed from: a */
    public static boolean m46639a() {
        try {
            Class.forName("com.huawei.hms.pps.HwPPS");
            return true;
        } catch (Throwable unused) {
            AbstractC7185ho.m43823c("HMSConnectProcessor", "check hms sdk available error");
            return false;
        }
    }
}
