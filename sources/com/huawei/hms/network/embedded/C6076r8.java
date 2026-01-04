package com.huawei.hms.network.embedded;

import android.os.Build;
import java.net.InetSocketAddress;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.hms.network.embedded.r8 */
/* loaded from: classes8.dex */
public class C6076r8 {
    /* renamed from: a */
    public static int m35228a() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static C6089s8 m35229a(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        int iM35228a = m35228a();
        String property = System.getProperty("openConcurrent");
        boolean z10 = property == null || !property.trim().equalsIgnoreCase("false");
        if ((iM35228a < 29 || !z10) && iM35228a < 30) {
            return new C6089s8(copyOnWriteArrayList, i10, i11);
        }
        return new C6063q8(copyOnWriteArrayList, i10, i11);
    }
}
