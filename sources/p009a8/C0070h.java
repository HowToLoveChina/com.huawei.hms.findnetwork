package p009a8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.album.service.logic.CloudAlbumSdkLogic;
import com.huawei.android.hicloud.album.service.logic.manager.SyncSessionManager;
import com.huawei.android.hicloud.album.service.p075vo.PowerControlStat;
import com.huawei.android.hicloud.album.service.report.CommonOpsReport;
import com.huawei.hicloud.bean.HiCloudSysParamMap;
import com.huawei.hicloud.notification.CloudSpaceNotifyUtil;
import com.huawei.hicloud.notification.constants.FamilyShareConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hwcloudjs.p164f.C6661f;
import fk.C9721b;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0209d;
import p015ak.C0213f;
import p015ak.C0241z;
import p031b7.C1120a;
import p031b7.C1122c;
import p031b7.C1136q;
import p292fn.C9733f;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p684un.C13224c;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: a8.h */
/* loaded from: classes2.dex */
public class C0070h {

    /* renamed from: v */
    public static final Object f245v = new Object();

    /* renamed from: a */
    public boolean f246a;

    /* renamed from: b */
    public long f247b;

    /* renamed from: c */
    public String f248c;

    /* renamed from: d */
    public int f249d;

    /* renamed from: e */
    public long f250e;

    /* renamed from: f */
    public double f251f;

    /* renamed from: g */
    public double f252g;

    /* renamed from: h */
    public int f253h;

    /* renamed from: i */
    public Handler f254i;

    /* renamed from: j */
    public HandlerThread f255j;

    /* renamed from: k */
    public long f256k;

    /* renamed from: l */
    public CloudAlbumSdkLogic f257l;

    /* renamed from: m */
    public int f258m;

    /* renamed from: n */
    public long f259n;

    /* renamed from: o */
    public long f260o;

    /* renamed from: p */
    public long f261p;

    /* renamed from: q */
    public Timer f262q;

    /* renamed from: r */
    public d f263r;

    /* renamed from: s */
    public int f264s;

    /* renamed from: t */
    public long f265t;

    /* renamed from: u */
    public HashMap<String, String> f266u;

    /* renamed from: a8.h$c */
    public static class c {

        /* renamed from: a */
        public static C0070h f269a = new C0070h();
    }

    /* renamed from: a8.h$d */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1120a.m6675d("PowerControlManager", "NetworkChangeReceiver.onReceive");
            if (C0070h.this.m547T(C0070h.this.m536I())) {
                C0070h.this.m565i();
            }
        }
    }

    /* renamed from: a8.h$e */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                C1120a.m6677i("PowerControlManager", "handler msg power time over,stop upload");
                C1120a.m6677i("PowerControlManager", "handleMessage stop reason:" + message.obj);
                C0070h.this.m584r0((String) message.obj);
                C0070h.this.f256k = 0L;
            }
        }
    }

    /* renamed from: a8.h$f */
    public static class f extends AbstractC12367d {

        /* renamed from: a */
        public String f272a;

        /* renamed from: b */
        public PowerControlStat f273b;

        public f(String str, PowerControlStat powerControlStat) {
            this.f272a = str;
            this.f273b = powerControlStat;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            this.f273b.setGradeCode(CloudSpaceNotifyUtil.getInstance().getSpaceProxy().getCurrentGradeCode("powerInfoReport"));
            new CommonOpsReport(C0213f.m1377a()).m15207A(C1122c.m6755Z0("04020"), this.f272a, 0, new Gson().toJson(this.f273b), false);
        }
    }

    /* renamed from: v */
    public static C0070h m527v() {
        return c.f269a;
    }

    /* renamed from: A */
    public long m528A() {
        if (m535H() != 0 || m592y() != 0) {
            return m535H() + m592y();
        }
        Context contextM1377a = C0213f.m1377a();
        long jM6997E = C1136q.b.m6997E(contextM1377a) + C1136q.b.m6991B(contextM1377a);
        this.f259n = jM6997E;
        return jM6997E;
    }

    /* renamed from: B */
    public final PowerControlStat m529B(PowerControlStat powerControlStat) {
        Context contextM1377a = C0213f.m1377a();
        int i10 = this.f249d;
        long jCurrentTimeMillis = 0;
        if (i10 == 1) {
            Long lValueOf = Long.valueOf(m531D());
            if (m531D() == 0) {
                lValueOf = Long.valueOf(C1136q.b.m7039Z(contextM1377a));
            }
            jCurrentTimeMillis = System.currentTimeMillis() - lValueOf.longValue();
        } else if (i10 == 2) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.f256k;
        }
        powerControlStat.setPower(m590w());
        powerControlStat.setPowerOverTime(jCurrentTimeMillis);
        powerControlStat.setWifiSize(m535H());
        powerControlStat.setMobileSize(m592y());
        powerControlStat.setDiscountWifi(m587t());
        powerControlStat.setDiscountMobile(m585s());
        powerControlStat.setControlType(this.f249d);
        powerControlStat.setCloudPowerControl(this.f264s);
        powerControlStat.setNeedControl(!this.f246a ? 1 : 0);
        powerControlStat.setExemptionPower(C1136q.b.m7101u(contextM1377a));
        powerControlStat.setUploadTime(m533F());
        powerControlStat.setAvailablePower(m577o());
        powerControlStat.setAvailableTime(this.f253h);
        powerControlStat.setNetType(C0209d.m1225Y(C0213f.m1377a()));
        powerControlStat.setBatteryStatus(C1136q.b.m7077m(contextM1377a));
        return powerControlStat;
    }

    /* renamed from: C */
    public CloudAlbumSdkLogic m530C() {
        return this.f257l;
    }

    /* renamed from: D */
    public synchronized long m531D() {
        return this.f250e;
    }

    /* renamed from: E */
    public long m532E() {
        return C1136q.b.m7104v(C0213f.m1377a());
    }

    /* renamed from: F */
    public int m533F() {
        Context contextM1377a = C0213f.m1377a();
        long jM531D = m531D();
        if (jM531D == 0) {
            jM531D = C1136q.b.m7039Z(contextM1377a);
        }
        int iM7042a0 = C1136q.b.m7042a0(contextM1377a);
        C1120a.m6675d("PowerControlManager", "uploadedTime:" + iM7042a0 + " startTime:" + jM531D);
        if (jM531D == 0) {
            return iM7042a0;
        }
        int iCurrentTimeMillis = ((int) ((System.currentTimeMillis() - jM531D) / 1000)) + iM7042a0;
        C1120a.m6675d("PowerControlManager", "totalTime:" + iCurrentTimeMillis);
        return iCurrentTimeMillis;
    }

    /* renamed from: G */
    public int m534G() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C1120a.m6678w("PowerControlManager", "getWeakNetworkRssiThresholdCfg, hiCloudSysParamMap is null");
            return -75;
        }
        int weakNetworkRssiThreshold = hiCloudSysParamMapM60757p.getWeakNetworkRssiThreshold();
        C1120a.m6675d("PowerControlManager", "getWeakNetworkRssiThresholdCfg, weakNetworkRssiThreshold=" + weakNetworkRssiThreshold);
        if (weakNetworkRssiThreshold <= -60) {
            return weakNetworkRssiThreshold;
        }
        C1120a.m6676e("PowerControlManager", "getWeakNetworkRssiThresholdCfg, config error");
        return -75;
    }

    /* renamed from: H */
    public long m535H() {
        return this.f260o;
    }

    /* renamed from: I */
    public int m536I() {
        WifiManager wifiManager = (WifiManager) C0213f.m1377a().getApplicationContext().getSystemService(C6661f.f30885g);
        if (wifiManager == null) {
            C1120a.m6678w("PowerControlManager", "getWifiRssi, wifiManager is null");
            return 0;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getRssi();
        }
        C1120a.m6678w("PowerControlManager", "getWifiRssi, wifiInfo is null");
        return 0;
    }

    /* renamed from: J */
    public final synchronized void m537J(int i10, String str) {
        try {
            try {
                m559f();
                if (this.f254i == null) {
                    m538K();
                }
                this.f256k = System.currentTimeMillis();
                this.f254i.removeMessages(0);
                Message messageObtain = Message.obtain();
                messageObtain.what = 0;
                messageObtain.obj = str;
                int i11 = this.f253h;
                int i12 = i11 - i10;
                if (i12 >= 0) {
                    i11 = i12;
                }
                C1120a.m6677i("PowerControlManager", "availableTime:" + this.f253h + " hasUploadedTime:" + i10);
                m558e0(i11);
                this.f254i.sendMessageDelayed(messageObtain, ((long) i11) * 1000);
            } catch (Exception e10) {
                C1120a.m6676e("PowerControlManager", "handlerPostMsg error: " + e10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: K */
    public final void m538K() {
        HandlerThread handlerThread = new HandlerThread("PowerTimeOver");
        this.f255j = handlerThread;
        handlerThread.start();
        this.f254i = new e(this.f255j.getLooper());
    }

    /* renamed from: L */
    public boolean m539L() {
        C1120a.m6677i("PowerControlManager", "isAutoSync isNeedControl:" + m527v().m542O() + " controlType:" + m527v().m583r());
        return m527v().m542O() && (m527v().m583r() == 1 || m527v().m583r() == 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0028  */
    /* renamed from: M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m540M() {
        /*
            r2 = this;
            com.huawei.hicloud.bean.HiCloudSysParamMap r0 = p031b7.C1122c.m6839v0()
            if (r0 == 0) goto L28
            int r0 = r0.isCloudPhotoPowerControl()
            r2.f264s = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "hiCloudSysParamMap isPowerControl="
            r0.append(r1)
            int r1 = r2.f264s
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PowerControlManager"
            p031b7.C1120a.m6675d(r1, r0)
            int r2 = r2.f264s
            if (r2 != 0) goto L30
        L28:
            boolean r2 = com.huawei.android.hicloud.album.service.p075vo.Version.isSupportPowerControl()
            if (r2 == 0) goto L30
            r2 = 1
            goto L31
        L30:
            r2 = 0
        L31:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p009a8.C0070h.m540M():boolean");
    }

    /* renamed from: N */
    public boolean m541N() {
        return m527v().m532E() == 0;
    }

    /* renamed from: O */
    public boolean m542O() {
        return this.f246a;
    }

    /* renamed from: P */
    public final boolean m543P() {
        return m540M() && m542O();
    }

    /* renamed from: Q */
    public boolean m544Q() {
        C1120a.m6677i("PowerControlManager", "isPowerAvailable availablePower: " + this.f247b + ", lastPower: " + m590w());
        return this.f247b > m590w();
    }

    /* renamed from: R */
    public boolean m545R() {
        int iM536I = m536I();
        boolean zM547T = m547T(iM536I);
        boolean zM7098t = C1136q.b.m7098t();
        boolean zM6791i1 = C1122c.m6791i1(C1136q.b.m7077m(C0213f.m1377a()));
        C1120a.m6675d("PowerControlManager", "isWeakNetworkControl, weakWifiNetwork=" + zM547T + ", enableWeakNetworkControl=" + zM7098t + ", isCharging=" + zM6791i1);
        if (zM6791i1 || !zM547T) {
            return false;
        }
        m555b0(SyncSessionManager.m15153t().m15201z(), "cloudalbum_upload_start_in_weak_network", iM536I);
        return zM7098t;
    }

    /* renamed from: S */
    public boolean m546S() {
        int iM536I = m536I();
        boolean zM547T = m547T(iM536I);
        boolean zM7098t = C1136q.b.m7098t();
        boolean zM7045b0 = C1136q.b.m7045b0();
        boolean zM6791i1 = C1122c.m6791i1(C1136q.b.m7077m(C0213f.m1377a()));
        C1120a.m6675d("PowerControlManager", "isWeakNetworkProgressControl, weakWifiNetwork=" + zM547T + ", enableWeakNetworkControl=" + zM7098t + ", weakNetworkProgressFlag=" + zM7045b0 + ", isCharging=" + zM6791i1);
        if (zM6791i1 || !zM547T) {
            return false;
        }
        m555b0(SyncSessionManager.m15153t().m15201z(), "cloudalbum_upload_progress_in_weak_network", iM536I);
        if (zM7098t) {
            return zM7045b0;
        }
        return false;
    }

    /* renamed from: T */
    public boolean m547T(int i10) {
        if (C0209d.m1225Y(C0213f.m1377a()) != 1) {
            C1120a.m6675d("PowerControlManager", "isWeakWifiNetWork, network type is not match");
            return false;
        }
        int iM7048c0 = C1136q.b.m7048c0();
        C1120a.m6675d("PowerControlManager", "isWeakWifiNetwork, wifiRssi=" + i10 + ", weakWifiRssiThreshold=" + iM7048c0);
        return i10 < iM7048c0;
    }

    /* renamed from: U */
    public void m548U(String str, String str2) {
        PowerControlStat powerControlStatM529B = m529B(new PowerControlStat());
        powerControlStatM529B.setReportReason(str2);
        m552Y(str, powerControlStatM529B);
    }

    /* renamed from: V */
    public void m549V() {
        Context contextM1377a = C0213f.m1377a();
        long jM7039Z = C1136q.b.m7039Z(contextM1377a);
        int iM7077m = C1136q.b.m7077m(contextM1377a);
        int iM7042a0 = C1136q.b.m7042a0(contextM1377a);
        boolean zM6791i1 = C1122c.m6791i1(iM7077m);
        if (m531D() != jM7039Z) {
            C1120a.m6677i("PowerControlManager", "getStartSavePowerTime not equal sp uplloadStartTime");
            jM7039Z = 0;
        }
        C1120a.m6675d("PowerControlManager", "recordUploadStartTime time:" + jM7039Z + " isCharging:" + zM6791i1 + " uploadedTime:" + iM7042a0);
        if (jM7039Z == 0 && this.f249d == 1 && m543P() && !zM6791i1) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (m531D() == 0) {
                m574m0(jCurrentTimeMillis);
            }
            C1136q.b.m7073k1(C0213f.m1377a(), jCurrentTimeMillis);
            if (this.f253h < 0) {
                C1120a.m6678w("PowerControlManager", "handlerPostMsg availableTime is low than 0");
            } else {
                m582q0(true, iM7042a0);
            }
        }
    }

    /* renamed from: W */
    public void m550W() {
        C1136q.b.m6994C0(m589u());
        C1136q.b.m7088p1(m534G());
        C1120a.m6675d("PowerControlManager", "refreshWeakNetworkCfg");
    }

    /* renamed from: X */
    public void m551X() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || this.f263r != null) {
            return;
        }
        synchronized (f245v) {
            try {
                if (this.f263r == null) {
                    d dVar = new d();
                    this.f263r = dVar;
                    contextM1377a.registerReceiver(dVar, new IntentFilter("android.net.wifi.RSSI_CHANGED"));
                    C1120a.m6675d("PowerControlManager", "registerNetworkChangeReceiver");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: Y */
    public final void m552Y(String str, PowerControlStat powerControlStat) {
        C1120a.m6675d("PowerControlManager", "report businessId:" + str);
        C12515a.m75110o().m75168b1(new f(str, powerControlStat));
    }

    /* renamed from: Z */
    public void m553Z(String str, int i10) {
        m555b0(str, "cloudalbum_upload_batch_count", i10);
    }

    /* renamed from: a0 */
    public final synchronized void m554a0() {
        String strM15201z = SyncSessionManager.m15153t().m15201z();
        C1120a.m6677i("PowerControlManager", "currentSessionId: " + this.f248c + ", sessionId: " + strM15201z);
        if (TextUtils.isEmpty(strM15201z)) {
            C1120a.m6678w("PowerControlManager", "reportPowerUsage sessionId is null");
            return;
        }
        if (TextUtils.isEmpty(this.f248c) || !strM15201z.equals(this.f248c)) {
            C1122c.m6756Z1();
            m530C().sendSyncFailure();
        }
        this.f248c = strM15201z;
    }

    /* renamed from: b0 */
    public void m555b0(String str, String str2, int i10) {
        C1120a.m6675d("PowerControlManager", "reportWeakNetworkEvent, businessId=" + str2);
        if (TextUtils.isEmpty(str)) {
            str = C1122c.m6755Z0("04005");
        }
        C1122c.m6747W1(C0213f.m1377a(), String.valueOf(107), String.valueOf(i10), "04005", str2, str);
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("wifiRssiOrFileSize", String.valueOf(i10));
        C13224c.m79487f1().m79567R(str2, linkedHashMapM79497A);
        UBAAnalyze.m29947H("CKC", str2, linkedHashMapM79497A);
    }

    /* renamed from: c0 */
    public synchronized void m556c0(long j10, String str) {
        try {
            Context contextM1377a = C0213f.m1377a();
            boolean zM6791i1 = C1122c.m6791i1(C1136q.b.m7077m(contextM1377a));
            C1120a.m6675d("PowerControlManager", "isNeedPowerControl:" + m543P() + " controlType:" + this.f249d + " isCharging:" + zM6791i1);
            long jM1688f = C0241z.m1688f(this.f266u.get(str));
            HashMap<String, String> map = this.f266u;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j10);
            sb2.append("");
            map.put(str, sb2.toString());
            C1120a.m6675d("PowerControlManager", "bytes:" + j10 + " lastUploadedSize" + jM1688f);
            if (m543P() && this.f249d == 1 && !zM6791i1) {
                if (m528A() == 0 && m531D() == 0) {
                    m549V();
                }
                int iM1225Y = C0209d.m1225Y(C0213f.m1377a());
                if (iM1225Y == 1) {
                    if (jM1688f == 0) {
                        m578o0(this.f260o + j10);
                    } else {
                        long j11 = j10 - jM1688f;
                        if (j11 < 0) {
                            C1120a.m6677i("PowerControlManager", " wifi increaseBytes small 0,return");
                            return;
                        }
                        m578o0(this.f260o + j11);
                    }
                } else if (jM1688f == 0) {
                    m566i0(this.f261p + j10);
                } else {
                    long j12 = j10 - jM1688f;
                    if (j12 < 0) {
                        C1120a.m6677i("PowerControlManager", "increaseBytes small 0,return");
                        return;
                    }
                    m566i0(this.f261p + j12);
                }
                C1120a.m6675d("PowerControlManager", "savePower mobileBytes:" + this.f261p + " wifiByte:" + this.f260o);
                C1136q.b.m7091q1(contextM1377a, m592y());
                C1136q.b.m7014M0(contextM1377a, m535H());
                C1136q.b.m7094r1(contextM1377a, iM1225Y);
                C1136q.b.m7012L0(contextM1377a, System.currentTimeMillis());
            } else {
                if (zM6791i1 || !m543P()) {
                    C1120a.m6675d("PowerControlManager", "isCharging cancel timer and record uploaded time");
                    C1136q.b.m7076l1(contextM1377a, m533F());
                    m571l();
                    m559f();
                }
                if (jM1688f == 0) {
                    this.f265t += j10;
                } else {
                    this.f265t += j10 - jM1688f;
                }
                C1136q.b.m6996D0(contextM1377a, this.f265t);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: d0 */
    public void m557d0(long j10) {
        this.f247b = j10;
    }

    /* renamed from: e0 */
    public void m558e0(int i10) {
        this.f253h = i10;
    }

    /* renamed from: f */
    public synchronized void m559f() {
        try {
            try {
                Handler handler = this.f254i;
                if (handler != null) {
                    handler.removeMessages(0);
                }
                HandlerThread handlerThread = this.f255j;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                this.f254i = null;
                this.f255j = null;
            } catch (Exception e10) {
                C1120a.m6676e("PowerControlManager", "cancel error: " + e10);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: f0 */
    public void m560f0(int i10) {
        this.f249d = i10;
    }

    /* renamed from: g */
    public final void m561g() {
        if (this.f262q == null) {
            return;
        }
        synchronized (f245v) {
            try {
                if (this.f262q != null) {
                    C1120a.m6675d("PowerControlManager", "cancelCheckWeakNetworkTimer");
                    this.f262q.cancel();
                    this.f262q = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: g0 */
    public void m562g0(double d10) {
        this.f252g = d10;
    }

    /* renamed from: h */
    public boolean m563h() {
        Context contextM1377a = C0213f.m1377a();
        if (!m543P() || this.f249d != 1) {
            if (!m543P() || this.f249d != 2 || System.currentTimeMillis() - this.f256k <= this.f253h * 1000) {
                return false;
            }
            C1120a.m6677i("PowerControlManager", "checkPowerOver power time over,stop upload");
            m584r0("control type=2 time over stop");
            return true;
        }
        long jM531D = m531D();
        if (jM531D == 0) {
            jM531D = C1136q.b.m7039Z(contextM1377a);
        }
        if (jM531D != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - jM531D;
            C1120a.m6675d("PowerControlManager", "checkPowerOver startUploadTime:" + jM531D + " duration:" + jCurrentTimeMillis + " availableTime:" + this.f253h);
            int i10 = this.f253h;
            if (i10 >= 0 && jCurrentTimeMillis > i10 * 1000) {
                C1120a.m6677i("PowerControlManager", "checkPowerOver rate power time over,stop upload");
                m584r0("power control time over stop");
                return true;
            }
        } else {
            C1120a.m6677i("PowerControlManager", "checkPowerOver startUploadTime is 0 record startTime");
            m549V();
        }
        C1120a.m6677i("PowerControlManager", "checkPowerOver getLastPower:" + m590w() + " availablePower:" + this.f247b);
        if (m590w() <= this.f247b) {
            return false;
        }
        C1120a.m6677i("PowerControlManager", "checkPowerOver power over,stop upload");
        m584r0("power control over stop");
        return true;
    }

    /* renamed from: h0 */
    public void m564h0(double d10) {
        this.f251f = d10;
    }

    /* renamed from: i */
    public final void m565i() {
        synchronized (f245v) {
            try {
                boolean zM7083o = C1136q.b.m7083o();
                C1120a.m6675d("PowerControlManager", "checkWeakNetworkProgress, checkingWeakNetworkFlag=" + zM7083o);
                if (!zM7083o) {
                    m580p0();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: i0 */
    public void m566i0(long j10) {
        this.f261p = j10;
    }

    /* renamed from: j */
    public synchronized void m567j(String str) {
        try {
            if (str.startsWith("04001")) {
                m548U("power_sync_end", "other_no_stop_report");
                Handler handler = this.f254i;
                if (handler != null) {
                    handler.removeMessages(0);
                }
                this.f256k = 0L;
                this.f249d = 0;
                this.f260o = 0L;
                this.f261p = 0L;
                m571l();
                m573m();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: j0 */
    public void m568j0(boolean z10) {
        this.f246a = z10;
    }

    /* renamed from: k */
    public void m569k(Context context) {
        C1120a.m6677i("PowerControlManager", "clearPowerCache");
        if (!m541N()) {
            m548U("power_control_clear", "other_no_stop_report");
        }
        m566i0(0L);
        m571l();
        m573m();
        m574m0(0L);
        m578o0(0L);
        this.f247b = 0L;
        C1136q.b.m7091q1(context, 0L);
        C1136q.b.m7014M0(context, 0L);
        C1136q.b.m7094r1(context, 0);
        C1136q.b.m7012L0(context, 0L);
        C1136q.b.m6998E0(context, 0L);
    }

    /* renamed from: k0 */
    public void m570k0(int i10) {
        this.f258m = i10;
    }

    /* renamed from: l */
    public void m571l() {
        m574m0(0L);
        C1136q.b.m7073k1(C0213f.m1377a(), 0L);
    }

    /* renamed from: l0 */
    public void m572l0(CloudAlbumSdkLogic cloudAlbumSdkLogic) {
        this.f257l = cloudAlbumSdkLogic;
    }

    /* renamed from: m */
    public void m573m() {
        C1136q.b.m7076l1(C0213f.m1377a(), 0);
    }

    /* renamed from: m0 */
    public synchronized void m574m0(long j10) {
        this.f250e = j10;
    }

    /* renamed from: n */
    public void m575n() {
        if (C1136q.b.m7045b0() || C1136q.b.m7083o()) {
            synchronized (f245v) {
                try {
                    if (C1136q.b.m7045b0()) {
                        C1136q.b.m7085o1(false);
                    }
                    if (C1136q.b.m7083o()) {
                        C1136q.b.m7105v0(false);
                    }
                    C1120a.m6675d("PowerControlManager", "clearWeakNetworkProgressData");
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* renamed from: n0 */
    public void m576n0(long j10) {
        C1136q.b.m6998E0(C0213f.m1377a(), j10);
    }

    /* renamed from: o */
    public long m577o() {
        return this.f247b;
    }

    /* renamed from: o0 */
    public void m578o0(long j10) {
        this.f260o = j10;
    }

    /* renamed from: p */
    public final double m579p(long j10) {
        return this.f252g * j10;
    }

    /* renamed from: p0 */
    public final void m580p0() {
        try {
            m561g();
            Timer timer = new Timer();
            this.f262q = timer;
            timer.schedule(new b(), 5000L);
            C1136q.b.m7105v0(true);
            C1120a.m6675d("PowerControlManager", "startCheckWeakNetworkTimer");
        } catch (Exception e10) {
            C1120a.m6676e("PowerControlManager", "startCheckWeakNetworkTimer, exception=" + e10.toString());
        }
    }

    /* renamed from: q */
    public final double m581q(long j10) {
        return this.f251f * j10;
    }

    /* renamed from: q0 */
    public void m582q0(boolean z10, int i10) {
        if (m543P()) {
            if ((this.f249d != 2 || z10) && !z10) {
                return;
            }
            C1120a.m6677i("PowerControlManager", "startTimer isPowerWithTimeControl:" + z10);
            if (z10) {
                m537J(i10, "power control time over stop");
            } else {
                m537J(i10, "control type=2 time over stop");
            }
        }
    }

    /* renamed from: r */
    public int m583r() {
        return this.f249d;
    }

    /* renamed from: r0 */
    public final void m584r0(String str) {
        C1120a.m6677i("PowerControlManager", "stopReason:" + str);
        if (m530C() != null) {
            m530C().stopUpload(FamilyShareConstants.StatusCode.USER_HAS_JOINED_SHARE_SPACE, true);
        } else {
            C1120a.m6678w("PowerControlManager", "sdkLogic is null ");
        }
        m548U("power_over_control", str);
        m554a0();
    }

    /* renamed from: s */
    public double m585s() {
        return this.f252g;
    }

    /* renamed from: s0 */
    public void m586s0() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || this.f263r == null) {
            return;
        }
        synchronized (f245v) {
            try {
                d dVar = this.f263r;
                if (dVar != null) {
                    contextM1377a.unregisterReceiver(dVar);
                    this.f263r = null;
                    C1120a.m6675d("PowerControlManager", "unregisterNetworkChangeReceiver");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: t */
    public double m587t() {
        return this.f251f;
    }

    /* renamed from: t0 */
    public void m588t0() {
        m586s0();
        m561g();
        m575n();
    }

    /* renamed from: u */
    public boolean m589u() {
        HiCloudSysParamMap hiCloudSysParamMapM60757p = C9733f.m60705z().m60757p();
        if (hiCloudSysParamMapM60757p == null) {
            C1120a.m6678w("PowerControlManager", "getEnableWeakNetworkControlCfg, hiCloudSysParamMap is null");
            return false;
        }
        int enableWeakNetworkControl = hiCloudSysParamMapM60757p.getEnableWeakNetworkControl();
        C1120a.m6675d("PowerControlManager", "getEnableWeakNetworkControlCfg, enableWeakNetworkControl=" + enableWeakNetworkControl);
        return enableWeakNetworkControl == 1;
    }

    /* renamed from: w */
    public long m590w() {
        double dM581q;
        double dM579p;
        if (m535H() == 0 && m592y() == 0) {
            Context contextM1377a = C0213f.m1377a();
            long jM6997E = C1136q.b.m6997E(contextM1377a);
            long jM6991B = C1136q.b.m6991B(contextM1377a);
            C1120a.m6675d("PowerControlManager", "getLastPower wifiPower:" + jM6997E + " mobilePower:" + jM6991B + " discountWifi:" + this.f251f + " mobilePower:" + this.f252g);
            dM581q = m581q(jM6997E);
            dM579p = m579p(jM6991B);
        } else {
            C1120a.m6675d("PowerControlManager", "getLastPower wifiPower:" + m535H() + " mobilePower:" + m592y() + " discountWifi:" + this.f251f + " mobilePower:" + this.f252g);
            dM581q = m581q(m535H());
            dM579p = m579p(m592y());
        }
        return (long) (dM581q + dM579p);
    }

    /* renamed from: x */
    public long m591x() {
        return C1136q.b.m6995D(C0213f.m1377a());
    }

    /* renamed from: y */
    public long m592y() {
        return this.f261p;
    }

    /* renamed from: z */
    public int m593z() {
        return C1136q.b.m6993C(C0213f.m1377a());
    }

    public C0070h() {
        this.f246a = false;
        this.f247b = 524288000L;
        this.f251f = 0.4d;
        this.f252g = 1.0d;
        this.f253h = -1;
        this.f256k = 0L;
        this.f258m = 0;
        this.f259n = 0L;
        this.f260o = 0L;
        this.f261p = 0L;
        this.f266u = new HashMap<>();
    }

    /* renamed from: a8.h$b */
    public class b extends TimerTask {

        /* renamed from: a */
        public int f267a;

        public b() {
            this.f267a = 1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                C1120a.m6675d("PowerControlManager", "CheckWeakNetworkTimeTask.run, taskId=" + this.f267a);
                if (!C0070h.this.m547T(C0070h.this.m536I())) {
                    C0070h.this.m575n();
                    return;
                }
                if (this.f267a == 1) {
                    synchronized (C0070h.f245v) {
                        try {
                            if (C0070h.this.f262q != null) {
                                C0070h.this.f262q.schedule(C0070h.this.new b(2), 5000L);
                            }
                        } finally {
                        }
                    }
                }
                if (this.f267a == 2) {
                    C1136q.b.m7085o1(true);
                    C0070h.this.m586s0();
                }
            } catch (Exception e10) {
                C1120a.m6676e("PowerControlManager", "CheckWeakNetworkTimeTask.run, taskId=" + this.f267a + ", exception=" + e10.toString());
                C0070h.this.m575n();
            }
        }

        public b(int i10) {
            this.f267a = i10;
        }
    }
}
