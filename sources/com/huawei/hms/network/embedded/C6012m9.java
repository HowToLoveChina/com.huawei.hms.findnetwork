package com.huawei.hms.network.embedded;

import java.net.Proxy;

/* renamed from: com.huawei.hms.network.embedded.m9 */
/* loaded from: classes8.dex */
public final class C6012m9 {
    /* renamed from: a */
    public static String m34854a(C6010m7 c6010m7) {
        String strM34790c = c6010m7.m34790c();
        String strM34794e = c6010m7.m34794e();
        if (strM34794e == null) {
            return strM34790c;
        }
        return strM34790c + '?' + strM34794e;
    }

    /* renamed from: b */
    public static boolean m34856b(C6101t7 c6101t7, Proxy.Type type) {
        return !c6101t7.m35419g() && type == Proxy.Type.HTTP;
    }

    /* renamed from: a */
    public static String m34855a(C6101t7 c6101t7, Proxy.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c6101t7.m35420h());
        sb2.append(' ');
        boolean zM34856b = m34856b(c6101t7, type);
        C6010m7 c6010m7M35423k = c6101t7.m35423k();
        if (zM34856b) {
            sb2.append(c6010m7M35423k);
        } else {
            sb2.append(m34854a(c6010m7M35423k));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }
}
