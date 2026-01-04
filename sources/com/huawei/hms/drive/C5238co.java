package com.huawei.hms.drive;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;

/* renamed from: com.huawei.hms.drive.co */
/* loaded from: classes8.dex */
public final class C5238co {
    /* renamed from: a */
    public static boolean m31416a(String str) {
        return str.equals("POST") || str.equals(RequestMethod.PATCH) || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m31417b(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(RequestMethod.PATCH) || str.equals("PROPPATCH") || str.equals(SyncProtocol.Method.REPORT);
    }

    /* renamed from: c */
    public static boolean m31418c(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    /* renamed from: d */
    public static boolean m31419d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m31420e(String str) {
        return !str.equals("PROPFIND");
    }
}
