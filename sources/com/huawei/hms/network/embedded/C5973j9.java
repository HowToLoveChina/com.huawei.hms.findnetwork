package com.huawei.hms.network.embedded;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;

/* renamed from: com.huawei.hms.network.embedded.j9 */
/* loaded from: classes8.dex */
public final class C5973j9 {
    /* renamed from: a */
    public static boolean m34545a(String str) {
        return str.equals("POST") || str.equals(RequestMethod.PATCH) || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* renamed from: b */
    public static boolean m34546b(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    /* renamed from: c */
    public static boolean m34547c(String str) {
        return !str.equals("PROPFIND");
    }

    /* renamed from: d */
    public static boolean m34548d(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: e */
    public static boolean m34549e(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(RequestMethod.PATCH) || str.equals("PROPPATCH") || str.equals(SyncProtocol.Method.REPORT);
    }
}
