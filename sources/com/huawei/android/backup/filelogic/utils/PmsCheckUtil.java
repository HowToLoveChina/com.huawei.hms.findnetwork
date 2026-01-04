package com.huawei.android.backup.filelogic.utils;

import android.os.RemoteException;
import android.p018os.IBackupSessionCallback;
import p229di.C9137b;
import p229di.C9142g;

/* loaded from: classes.dex */
public final class PmsCheckUtil {

    /* renamed from: a */
    public static boolean f9526a;

    /* renamed from: b */
    public static boolean f9527b;

    /* renamed from: c */
    public static int f9528c;

    /* renamed from: a */
    public static int m12607a() {
        int iM57449a = C9137b.m57449a(-1, "getVersionCode");
        C2111d.m12654j("PMSCheckUtil", "pms version is ", Integer.valueOf(iM57449a));
        return iM57449a;
    }

    /* renamed from: b */
    public static void m12608b() {
        C2111d.m12653i("PMSCheckUtil", "Judge issupport tar.");
        f9527b = true;
        if (!m12611e()) {
            f9526a = false;
            return;
        }
        int iM57453e = C9137b.m57453e(new IBackupSessionCallback.Stub() { // from class: com.huawei.android.backup.filelogic.utils.PmsCheckUtil.1
            @Override // android.p018os.IBackupSessionCallback
            public void onTaskStatusChanged(int i10, int i11, int i12, String str) throws RemoteException {
            }
        });
        if (iM57453e == -1 || iM57453e == -2) {
            C2111d.m12654j("PMSCheckUtil", "check support tar fail sessionID = ", Integer.valueOf(iM57453e));
            f9526a = false;
        } else {
            int iM57449a = C9137b.m57449a(iM57453e, "backup tar /data/data/com.huawei.hidisk/files/testsrc  /data/data/com.huawei.hidisk/files/testdest");
            f9526a = iM57449a != -3;
            C2111d.m12653i("PMSCheckUtil", "executeBackupTask taskId= " + iM57449a);
        }
        C2111d.m12654j("PMSCheckUtil", "PMSCheckUtil finishBackupSession, pes:", C9137b.m57450b(iM57453e) + ", conversationId: " + iM57453e + ", isSupportTar: " + f9526a);
    }

    /* renamed from: c */
    public static boolean m12609c() {
        boolean z10 = m12607a() > 0;
        C2111d.m12654j("PMSCheckUtil", "isPMSSupportTwinApp : ", Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: d */
    public static boolean m12610d() {
        if (!C9142g.m57464c()) {
            return false;
        }
        int i10 = f9528c;
        if (i10 > 0) {
            return i10 >= 5;
        }
        try {
            f9528c = m12607a();
            C2111d.m12653i("PMSCheckUtil", "isSupportNewRYFeature pmsVer: " + f9528c);
            return f9528c >= 5;
        } catch (Exception e10) {
            C2111d.m12648d("PMSCheckUtil", "isSupportNewRYFeature getPmsVer Exception " + e10.getMessage());
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m12611e() {
        return C9137b.m57452d();
    }

    /* renamed from: f */
    public static boolean m12612f() {
        return m12607a() >= 3;
    }

    /* renamed from: g */
    public static boolean m12613g() {
        int iM12607a = m12607a();
        C2111d.m12654j("PMSCheckUtil", "pms version is ", Integer.valueOf(iM12607a));
        return iM12607a > 1;
    }

    /* renamed from: h */
    public static boolean m12614h() {
        C2111d.m12653i("PMSCheckUtil", "is support tar, isInit: " + f9527b + ", isSupportTar: " + f9526a);
        if (f9527b) {
            return f9526a;
        }
        m12608b();
        return f9526a;
    }
}
