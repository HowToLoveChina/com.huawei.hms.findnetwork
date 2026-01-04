package com.huawei.hms.drive;

import java.net.Proxy;

/* renamed from: com.huawei.hms.drive.cr */
/* loaded from: classes8.dex */
public final class C5241cr {
    /* renamed from: a */
    public static String m31425a(C5201bf c5201bf, Proxy.Type type) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c5201bf.m31109b());
        sb2.append(' ');
        if (m31426b(c5201bf, type)) {
            sb2.append(c5201bf.m31107a());
        } else {
            sb2.append(m31424a(c5201bf.m31107a()));
        }
        sb2.append(" HTTP/1.1");
        return sb2.toString();
    }

    /* renamed from: b */
    private static boolean m31426b(C5201bf c5201bf, Proxy.Type type) {
        return !c5201bf.m31116i() && type == Proxy.Type.HTTP;
    }

    /* renamed from: a */
    public static String m31424a(C5193az c5193az) {
        String strM30972h = c5193az.m30972h();
        String strM30974j = c5193az.m30974j();
        if (strM30974j == null) {
            return strM30972h;
        }
        return strM30972h + '?' + strM30974j;
    }
}
