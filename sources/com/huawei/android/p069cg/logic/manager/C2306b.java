package com.huawei.android.p069cg.logic.manager;

import android.os.SystemClock;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import p031b7.C1120a;
import p031b7.C1136q;
import p336he.C10155f;
import p546p6.C12106s;

/* renamed from: com.huawei.android.cg.logic.manager.b */
/* loaded from: classes2.dex */
public class C2306b {

    /* renamed from: com.huawei.android.cg.logic.manager.b$b */
    public static class b {

        /* renamed from: a */
        public static C2306b f11008a = new C2306b();
    }

    /* renamed from: a */
    public static C2306b m14512a() {
        return b.f11008a;
    }

    /* renamed from: b */
    public synchronized int m14513b(String str) {
        if (!C10155f.m63257J()) {
            C1120a.m6677i("OBSFlowControlManager", "obs flow control close");
            return 50320;
        }
        if (SyncSessionManager.m15153t().m15163J()) {
            C1120a.m6677i("OBSFlowControlManager", "getOBSFlowCode vfc is executed");
            return 0;
        }
        long jM6966g = C1136q.m6966g();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C1120a.m6677i("OBSFlowControlManager", "getOBSFlowCode elapsedRealtime: " + jElapsedRealtime);
        if (SyncSessionManager.m15153t().m15154A() != 6) {
            long jM6974o = C1136q.m6974o() * 1000;
            C1120a.m6677i("OBSFlowControlManager", "getOBSFlowCode latestOBSFlowControlTime: " + jM6966g + ", obsFlowControlIntervalTime: " + jM6974o);
            if (jElapsedRealtime > jM6966g && jElapsedRealtime < jM6974o + jM6966g) {
                C1120a.m6677i("OBSFlowControlManager", "isInControlInterval");
                return 50321;
            }
        }
        int iM6973n = C1136q.m6973n();
        C1120a.m6677i("OBSFlowControlManager", "getOBSFlowCode obsFlowControlCount: " + iM6973n);
        long j10 = jElapsedRealtime - jM6966g;
        C12106s c12106sM72509c = C12106s.m72509c();
        String strValueOf = String.valueOf(iM6973n);
        if (j10 <= 0 || jM6966g == 0) {
            j10 = 0;
        }
        return c12106sM72509c.m72514f(strValueOf, String.valueOf(j10 / 1000), str);
    }

    public C2306b() {
    }
}
