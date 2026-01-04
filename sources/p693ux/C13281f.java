package p693ux;

import com.huawei.android.hicloud.drive.clouddisk.expand.RequestMethod;
import com.huawei.android.hicloud.sync.protocol.SyncProtocol;

/* renamed from: ux.f */
/* loaded from: classes9.dex */
public final class C13281f {
    /* renamed from: a */
    public static boolean m79720a(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    /* renamed from: b */
    public static boolean m79721b(String str) {
        return !str.equals("PROPFIND");
    }

    /* renamed from: c */
    public static boolean m79722c(String str) {
        return str.equals("PROPFIND");
    }

    /* renamed from: d */
    public static boolean m79723d(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals(RequestMethod.PATCH) || str.equals("PROPPATCH") || str.equals(SyncProtocol.Method.REPORT);
    }
}
