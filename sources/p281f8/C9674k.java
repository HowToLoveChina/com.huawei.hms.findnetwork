package p281f8;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.hicloud.album.service.CallbackHandler;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.android.p069cg.configure.CloudAlbumSettings;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import java.util.HashMap;
import p009a8.C0074l;
import p015ak.C0209d;
import p031b7.C1120a;
import p031b7.C1136q;

/* renamed from: f8.k */
/* loaded from: classes2.dex */
public class C9674k {

    /* renamed from: g */
    public static HashMap<Integer, String> f47856g = new a();

    /* renamed from: a */
    public C9666c f47857a;

    /* renamed from: b */
    public Context f47858b;

    /* renamed from: c */
    public CallbackHandler f47859c;

    /* renamed from: d */
    public volatile int f47860d = 0;

    /* renamed from: e */
    public int f47861e = 0;

    /* renamed from: f */
    public boolean f47862f = false;

    /* renamed from: f8.k$a */
    public class a extends HashMap<Integer, String> {
        public a() {
            put(100, "no_error");
            put(101, "unknown error");
            put(102, "invalid_params");
            put(103, "sync_logoff");
            put(104, "sync_switch_off");
            put(105, "system_battery_level_too_low");
            put(106, "system_power_consumption_too_fast");
            put(107, "system_network_disabled");
            put(108, "system_network_cellular");
            put(109, "system_remote_service_disconnect");
            put(110, "system_sim_card_lock");
            put(111, "trans_download_error_limit");
            put(112, "trans_upload_error_limit");
            put(113, "cloud_storage_full");
            put(114, "st_invalid");
            put(148, "need_upgrade");
            put(1007, "no_network");
            put(Integer.valueOf(FamilyShareConstants.StatusCode.SNA_GROUP_NOT_EXIST), "mobile_switch_off");
            put(150, "N/A");
        }
    }

    /* renamed from: f8.k$b */
    public enum b {
        CAN_START_SYNC(0),
        SYNC_STOPPED(1),
        STOP_DOWNLOAD_TASK(2);


        /* renamed from: a */
        public int f47867a;

        b(int i10) {
            this.f47867a = i10;
        }

        /* renamed from: b */
        public int m60437b() {
            return this.f47867a;
        }
    }

    /* renamed from: f8.k$c */
    public enum c {
        CAN_START_SYNC(0),
        SYNC_STOPPED(1);


        /* renamed from: a */
        public int f47871a;

        c(int i10) {
            this.f47871a = i10;
        }

        /* renamed from: b */
        public int m60438b() {
            return this.f47871a;
        }
    }

    public C9674k(Context context, CallbackHandler callbackHandler) {
        this.f47858b = context;
        this.f47859c = callbackHandler;
    }

    /* renamed from: A */
    public void m60395A(int i10) {
        m60396B(i10, m60421k(false, 3).m60438b(), this.f47860d);
    }

    /* renamed from: B */
    public final void m60396B(int i10, int i11, int i12) {
        Bundle bundle = new Bundle();
        bundle.putInt("k1", i11);
        bundle.putInt("k2", i12);
        this.f47859c.invokeEvent(i10, bundle);
    }

    /* renamed from: C */
    public final void m60397C(int i10, int i11, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putInt("k1", i11);
        bundle.putBoolean("k2", z10);
        this.f47859c.invokeEvent(i10, bundle);
    }

    /* renamed from: D */
    public synchronized void m60398D(boolean z10) {
        C1120a.m6677i("SyncStrategy", "setBatteryLevelTooLow: " + z10);
        m60410P(4, z10);
    }

    /* renamed from: E */
    public synchronized void m60399E(boolean z10) {
        C1120a.m6677i("SyncStrategy", "setLogOff: " + z10);
        if (!m60431u() && !z10) {
            C1120a.m6678w("SyncStrategy", "Has login success!");
            return;
        }
        m60410P(2, true);
        m60397C(65, 1, z10);
        m60410P(1, z10);
    }

    /* renamed from: F */
    public synchronized void m60400F(boolean z10) {
        C1120a.m6677i("SyncStrategy", "setMobileSwitchOff: " + z10);
        m60410P(4096, z10);
    }

    /* renamed from: G */
    public synchronized void m60401G(boolean z10) {
        C1120a.m6677i("SyncStrategy", "setNeedUpgrade: " + z10);
        m60410P(1024, z10);
    }

    /* renamed from: H */
    public synchronized void m60402H() {
        m60396B(63, m60421k(false, 3).m60438b(), this.f47860d);
    }

    /* renamed from: I */
    public synchronized void m60403I(boolean z10) {
        C1120a.m6675d("SyncStrategy", "setNetWorkDisconnected: " + z10);
        m60410P(2048, z10);
    }

    /* renamed from: J */
    public synchronized void m60404J(boolean z10) {
        try {
            C1120a.m6677i("SyncStrategy", "setNetworkDisabled: " + z10);
            boolean zM60419i = m60419i(16);
            m60410P(16, z10);
            if (!z10 && !m60428r() && zM60419i) {
                C9665b.m60346c();
            }
            if (z10 && !zM60419i) {
                C1120a.m6677i("SyncStrategy", "network change to shouldStopDownload : " + z10 + ", from: " + zM60419i);
                m60396B(64, b.STOP_DOWNLOAD_TASK.m60437b(), 107);
            }
            m60397C(65, 16, z10);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: K */
    public synchronized void m60405K(boolean z10) {
        C1120a.m6675d("SyncStrategy", "setServiceInvalid: " + z10);
        m60410P(32, z10);
    }

    /* renamed from: L */
    public synchronized void m60406L(boolean z10) {
        C1120a.m6677i("SyncStrategy", "setStInvalid: " + z10);
        m60410P(512, z10);
    }

    /* renamed from: M */
    public synchronized void m60407M(boolean z10) {
        try {
            C1120a.m6677i("SyncStrategy", "setSwitchOff: " + z10);
            C9666c c9666c = this.f47857a;
            if (c9666c != null) {
                c9666c.m60360j();
            }
            m60397C(65, 2, z10);
            m60410P(2, z10);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: N */
    public final boolean m60408N(int i10) {
        C1120a.m6675d("SyncStrategy", "shouldStopDownload state: " + i10 + ", syncMask: 3591");
        return (i10 & 3591) == i10;
    }

    /* renamed from: O */
    public final int m60409O(int i10, int i11, boolean z10) {
        int i12 = z10 ? i11 | i10 : i11 & (~i10);
        this.f47861e = i10;
        this.f47862f = z10;
        return i12;
    }

    /* renamed from: P */
    public final void m60410P(int i10, boolean z10) {
        boolean zM60419i = m60419i(i10);
        c cVarM60421k = m60421k(false, 3);
        this.f47860d = m60409O(i10, this.f47860d, z10);
        if (z10 && m60408N(i10)) {
            C1120a.m6677i("SyncStrategy", "updateStateValue shouldStopDownload : " + i10 + ", flag: " + z10);
            m60396B(64, b.STOP_DOWNLOAD_TASK.m60437b(), m60414d());
        }
        c cVarM60421k2 = m60421k(false, 3);
        if (cVarM60421k != cVarM60421k2) {
            C1120a.m6677i("SyncStrategy", "SyncState has changed, from " + cVarM60421k + " to " + cVarM60421k2);
            m60396B(64, cVarM60421k2.m60438b(), m60414d());
        }
        if (zM60419i != z10) {
            C1120a.m6677i("SyncStrategy", "State has changed by mask: " + i10 + ", state: " + this.f47860d);
            m60396B(63, cVarM60421k2.m60438b(), this.f47860d);
        }
    }

    /* renamed from: a */
    public synchronized void m60411a() {
        C1120a.m6677i("SyncStrategy", "destroy");
        C9666c c9666c = this.f47857a;
        if (c9666c != null) {
            c9666c.m60357g();
        }
    }

    /* renamed from: b */
    public synchronized String m60412b() {
        return this.f47861e + ":" + (this.f47862f ? 1 : 0);
    }

    /* renamed from: c */
    public synchronized int m60413c() {
        return m60415e(false);
    }

    /* renamed from: d */
    public synchronized int m60414d() {
        return m60415e(true);
    }

    /* renamed from: e */
    public final int m60415e(boolean z10) {
        if (Version.isSupportMobileData()) {
            return m60436z(z10);
        }
        if (m60419i(1)) {
            return 103;
        }
        if (m60419i(2)) {
            return 104;
        }
        if (m60419i(512)) {
            return 114;
        }
        if (z10) {
            if (m60419i(4)) {
                return 105;
            }
            if (m60419i(8)) {
                return 106;
            }
        }
        if (m60419i(16)) {
            return 107;
        }
        if (m60419i(32)) {
            return 109;
        }
        return m60419i(1024) ? 148 : 100;
    }

    /* renamed from: f */
    public synchronized String m60416f(int i10) {
        if (!f47856g.containsKey(Integer.valueOf(i10))) {
            i10 = 150;
        }
        return f47856g.get(Integer.valueOf(i10));
    }

    /* renamed from: g */
    public synchronized int m60417g() {
        if (m60419i(1)) {
            return 103;
        }
        if (m60419i(2)) {
            return 104;
        }
        if (m60419i(512)) {
            return 114;
        }
        return m60419i(1024) ? 148 : 100;
    }

    /* renamed from: h */
    public synchronized int m60418h() {
        return this.f47860d;
    }

    /* renamed from: i */
    public final boolean m60419i(int i10) {
        return m60420j(i10, this.f47860d);
    }

    /* renamed from: j */
    public final boolean m60420j(int i10, int i11) {
        return (i11 & i10) == i10;
    }

    /* renamed from: k */
    public synchronized c m60421k(boolean z10, int i10) {
        try {
            C9666c c9666c = this.f47857a;
            if (c9666c != null) {
                c9666c.m60356f();
            }
            if (!m60430t() && !m60429s(z10, i10)) {
                if ((this.f47860d & 1663) == 0) {
                    return c.CAN_START_SYNC;
                }
                C1120a.m6675d("SyncStrategy", "getSyncState state: " + this.f47860d + ", syncMask: 1663");
                return c.SYNC_STOPPED;
            }
            return m60424n(z10, i10);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: l */
    public synchronized c m60422l() {
        if ((this.f47860d & 1651) == 0) {
            return c.CAN_START_SYNC;
        }
        C1120a.m6675d("SyncStrategy", "getSyncStateNoneBatteryLow state: " + this.f47860d + ", syncMask: 1651");
        return c.SYNC_STOPPED;
    }

    /* renamed from: m */
    public synchronized c m60423m() {
        if ((this.f47860d & 1635) == 0) {
            return c.CAN_START_SYNC;
        }
        C1120a.m6675d("SyncStrategy", "getSyncStateNoneNetwork state: " + this.f47860d + ", syncMask: 1635");
        return c.SYNC_STOPPED;
    }

    /* renamed from: n */
    public synchronized c m60424n(boolean z10, int i10) {
        try {
            int i11 = (m60429s(z10, i10) && m60430t()) ? 3683 : (!m60429s(z10, i10) || m60430t()) ? (m60429s(z10, i10) || !m60430t()) ? 0 : 3695 : 1651;
            if ((this.f47860d & i11) == 0) {
                return c.CAN_START_SYNC;
            }
            C1120a.m6675d("SyncStrategy", "getSyncStateOnMobile state: " + this.f47860d + ", syncMask: " + i11);
            return c.SYNC_STOPPED;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: o */
    public synchronized void m60425o() {
        C1120a.m6677i("SyncStrategy", "begin init");
        m60427q(1, C9672i.m60382b(this.f47858b));
        m60427q(2, C9672i.m60385e(this.f47858b));
        m60427q(64, false);
        m60427q(512, C9672i.m60384d());
        m60427q(1024, C9672i.m60381a());
        m60427q(2048, !C0209d.m1333z1(this.f47858b));
        m60427q(4096, C9672i.m60383c());
        this.f47857a = new C9666c(this.f47858b, this);
        C1120a.m6677i("SyncStrategy", "end init, state: " + this.f47860d);
    }

    /* renamed from: p */
    public void m60426p() {
        C9666c c9666c = this.f47857a;
        if (c9666c != null) {
            c9666c.m60361k();
        }
    }

    /* renamed from: q */
    public synchronized void m60427q(int i10, boolean z10) {
        C1120a.m6677i("SyncStrategy", "begin initState, mask: " + i10 + ", flag: " + z10);
        this.f47860d = m60409O(i10, this.f47860d, z10);
    }

    /* renamed from: r */
    public synchronized boolean m60428r() {
        return m60419i(4);
    }

    /* renamed from: s */
    public final boolean m60429s(boolean z10, int i10) {
        boolean zM15158E;
        if (i10 == 0) {
            zM15158E = C0074l.m603c().m608f();
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    return false;
                }
                if (!SyncSessionManager.m15153t().m15158E() && !C0074l.m603c().m608f()) {
                    return false;
                }
                return z10 && Version.isSupportLowBatterySync();
            }
            zM15158E = SyncSessionManager.m15153t().m15158E();
        }
        if (!zM15158E) {
            return false;
        }
        if (z10) {
            return false;
        }
    }

    /* renamed from: t */
    public final boolean m60430t() {
        if (Version.isSupportMobileData() && CloudAlbumSettings.m14363h().m14380p()) {
            return true;
        }
        if (CloudAlbumSettings.m14363h().m14385u() && 1 == C1136q.b.m7095s(this.f47858b)) {
            return C1136q.b.m7019P(this.f47858b);
        }
        return false;
    }

    public String toString() {
        return "SyncStrategy{state=" + this.f47860d + '}';
    }

    /* renamed from: u */
    public synchronized boolean m60431u() {
        return m60419i(1);
    }

    /* renamed from: v */
    public synchronized boolean m60432v() {
        return m60419i(1024);
    }

    /* renamed from: w */
    public synchronized boolean m60433w() {
        if (Version.isSupportMobileData() && CloudAlbumSettings.m14363h().m14380p()) {
            return m60419i(2048);
        }
        return m60419i(16);
    }

    /* renamed from: x */
    public synchronized boolean m60434x() {
        return m60419i(512);
    }

    /* renamed from: y */
    public synchronized boolean m60435y() {
        return m60419i(2);
    }

    /* renamed from: z */
    public final int m60436z(boolean z10) {
        if (m60419i(1)) {
            return 103;
        }
        if (m60419i(2)) {
            return 104;
        }
        if (m60419i(512)) {
            return 114;
        }
        if (m60419i(2048)) {
            return 1007;
        }
        if (z10) {
            if (m60419i(4)) {
                return 105;
            }
            if (m60419i(8)) {
                return 106;
            }
        }
        if (!CloudAlbumSettings.m14363h().m14380p() && m60419i(16)) {
            return 107;
        }
        if (m60419i(32)) {
            return 109;
        }
        return m60419i(1024) ? 148 : 100;
    }
}
