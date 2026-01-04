package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.net.Uri;

/* renamed from: com.huawei.openalliance.ad.mr */
/* loaded from: classes8.dex */
public class C7483mr {

    /* renamed from: a */
    private static C7483mr f34691a;

    /* renamed from: b */
    private static final byte[] f34692b = new byte[0];

    /* renamed from: c */
    private static final Uri f34693c = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/pps/api/call").build();

    /* renamed from: d */
    private Context f34694d;

    private C7483mr(Context context) {
        this.f34694d = context.getApplicationContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> com.huawei.openalliance.p169ad.ipc.CallResult<T> m45853a(java.lang.String r18, java.lang.String r19, java.lang.Class<T> r20) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.p169ad.C7483mr.m45853a(java.lang.String, java.lang.String, java.lang.Class):com.huawei.openalliance.ad.ipc.CallResult");
    }

    /* renamed from: a */
    public static C7483mr m45852a(Context context) {
        C7483mr c7483mr;
        synchronized (f34692b) {
            try {
                if (f34691a == null) {
                    f34691a = new C7483mr(context);
                }
                c7483mr = f34691a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7483mr;
    }
}
