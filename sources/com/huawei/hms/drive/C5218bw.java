package com.huawei.hms.drive;

import android.os.Build;
import java.net.InetSocketAddress;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.hms.drive.bw */
/* loaded from: classes8.dex */
public class C5218bw {
    /* renamed from: a */
    public static C5219bx m31263a(CopyOnWriteArrayList<InetSocketAddress> copyOnWriteArrayList, int i10, int i11) {
        int iM31262a = m31262a();
        String property = System.getProperty("openConcurrent");
        return (iM31262a < 29 || !(property == null || !property.trim().equalsIgnoreCase("false"))) ? iM31262a >= 30 ? new C5217bv(copyOnWriteArrayList, i10, i11) : new C5219bx(copyOnWriteArrayList, i10, i11) : new C5217bv(copyOnWriteArrayList, i10, i11);
    }

    /* renamed from: a */
    public static int m31262a() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (NoClassDefFoundError unused) {
            return 0;
        }
    }
}
