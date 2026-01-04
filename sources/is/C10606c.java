package is;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import ar.C1012a;
import as.C1016d;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.location.LocationProviderCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.crowdsourcing.C6747c;
import es.C9548m;
import es.C9550o;
import is.C10612i;
import java.util.Iterator;
import java.util.Map;
import kr.C11145b;
import p404js.C10913b;
import p531or.C11991a;
import p622rr.C12619b;
import p819yq.C14035a;
import p819yq.C14036b;
import p852zq.AbstractC14365f;
import p852zq.C14360a;
import p852zq.C14363d;
import p852zq.C14366g;
import p852zq.C14368i;
import p852zq.C14370k;
import p852zq.InterfaceC14367h;
import p854zs.C14374c;
import ps.C12210a;

/* renamed from: is.c */
/* loaded from: classes8.dex */
public final class C10606c {

    /* renamed from: d */
    public static final boolean f50984d = C9550o.m59634g();

    /* renamed from: e */
    public static final byte[] f50985e = new byte[0];

    /* renamed from: f */
    public static volatile C10606c f50986f;

    /* renamed from: a */
    public C10604a f50987a;

    /* renamed from: b */
    public Handler f50988b;

    /* renamed from: c */
    public C12210a f50989c = new C12210a();

    /* renamed from: is.c$a */
    public class a implements LocationProviderCallback {
        public a() {
        }

        @Override // com.huawei.hms.location.LocationProviderCallback
        public final void onLocationChanged(HwLocationResult hwLocationResult) {
            if (C9548m.m59619b(C11991a.m72145a(), "android.permission.ACCESS_FINE_LOCATION") || C9548m.m59619b(C11991a.m72145a(), "android.permission.ACCESS_COARSE_LOCATION")) {
                C10606c.m65020f(C10606c.this, hwLocationResult);
            } else {
                C1016d.m6186f("HwLocationManager", "dispatchCallback fail, location permission is denied");
            }
        }
    }

    public C10606c() {
        C10913b.m65957f().m65965g(new a());
        C6747c.m38335e(C11991a.m72145a());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0074  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.location.Location m65018b() {
        /*
            android.content.Context r0 = p531or.C11991a.m72145a()
            boolean r0 = es.C9545j.m59603d(r0)
            java.lang.String r1 = "HwLocationManager"
            if (r0 != 0) goto L13
            java.lang.String r0 = "location unable"
            as.C1016d.m6186f(r1, r0)
            r0 = 0
            return r0
        L13:
            kr.b r0 = kr.C11145b.m67054b()
            java.lang.String r2 = "gps"
            android.location.Location r0 = r0.m67055a(r2)
            kr.b r2 = kr.C11145b.m67054b()
            java.lang.String r3 = "network"
            android.location.Location r2 = r2.m67055a(r3)
            yq.b r3 = p819yq.C14036b.m84189d()
            android.location.Location r3 = r3.m84190a()
            if (r2 != 0) goto L37
            java.lang.String r2 = "native network is null,use cache network"
            as.C1016d.m6186f(r1, r2)
            goto L6b
        L37:
            if (r3 != 0) goto L3f
            java.lang.String r3 = "cacheLocation loacation is null,use native network"
            as.C1016d.m6186f(r1, r3)
            goto L6c
        L3f:
            long r4 = r2.getElapsedRealtimeNanos()
            long r6 = r3.getElapsedRealtimeNanos()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "nativeLocTime:"
            r8.<init>(r9)
            r8.append(r4)
            java.lang.String r9 = ",cacheLocTime:"
            r8.append(r9)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            as.C1016d.m6186f(r1, r8)
            long r4 = r4 - r6
            r6 = 60000000000(0xdf8475800, double:2.96439387505E-313)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L6b
            goto L6c
        L6b:
            r2 = r3
        L6c:
            java.lang.String r3 = "return netBestLoc"
            if (r0 != 0) goto L74
            as.C1016d.m6186f(r1, r3)
            return r2
        L74:
            java.lang.String r4 = "return nativeGPSLoc"
            if (r2 != 0) goto L7c
            as.C1016d.m6186f(r1, r4)
            return r0
        L7c:
            long r5 = r0.getElapsedRealtimeNanos()
            long r7 = r2.getElapsedRealtimeNanos()
            long r9 = r5 - r7
            long r9 = java.lang.Math.abs(r9)
            r11 = 11000000000(0x28fa6ae00, double:5.4347221043E-314)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto La7
            float r5 = r0.getAccuracy()
            float r6 = r2.getAccuracy()
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto La3
            as.C1016d.m6186f(r1, r4)
            return r0
        La3:
            as.C1016d.m6186f(r1, r3)
            return r2
        La7:
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto Laf
            as.C1016d.m6186f(r1, r4)
            return r0
        Laf:
            as.C1016d.m6186f(r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: is.C10606c.m65018b():android.location.Location");
    }

    /* renamed from: d */
    public static C10606c m65019d() {
        if (f50986f == null) {
            synchronized (f50985e) {
                try {
                    if (f50986f == null) {
                        f50986f = new C10606c();
                    }
                } finally {
                }
            }
        }
        return f50986f;
    }

    /* renamed from: f */
    public static void m65020f(C10606c c10606c, HwLocationResult hwLocationResult) {
        c10606c.getClass();
        Iterator<Map.Entry<String, C14035a>> it = C14036b.m84189d().m84193e().entrySet().iterator();
        while (it.hasNext()) {
            C14035a value = it.next().getValue();
            if (value == null) {
                C1016d.m6186f("HwLocationManager", "dispatchCallback fail, wrapLocationRequest is null");
            } else if (value.m84187g() == null || TextUtils.isEmpty(value.m84185e()) || !C14374c.m85586d(value.m84186f())) {
                C1016d.m6186f("HwLocationManager", "dispatchCallback fail, request is invalid");
                it.remove();
                c10606c.m65026h(value);
            } else {
                int iM84182b = value.m84182b();
                if (iM84182b == 102 || iM84182b == 104 || iM84182b == 300 || iM84182b == 400 || iM84182b == 100) {
                    value.m84187g().mo85544b(hwLocationResult);
                }
            }
        }
    }

    /* renamed from: i */
    public static boolean m65021i(C14035a c14035a, AbstractC14365f abstractC14365f) {
        LocationRequest locationRequestM84184d = c14035a.m84184d();
        if (locationRequestM84184d == null) {
            return false;
        }
        long maxWaitTime = locationRequestM84184d.getMaxWaitTime();
        if (maxWaitTime <= 0) {
            return false;
        }
        if (SystemClock.uptimeMillis() + maxWaitTime < 0) {
            throw new C12619b(10101, C1012a.m6166a(10101));
        }
        if (maxWaitTime / 2 < locationRequestM84184d.getInterval()) {
            return false;
        }
        C1016d.m6186f("HwLocationManager", "maxWaitTime is enable , add to MaxWaitTimeQueue");
        C10612i.a.f51014a.m65054d(abstractC14365f, c14035a.m84181a(), locationRequestM84184d.getMaxWaitTime());
        return true;
    }

    /* renamed from: a */
    public final synchronized void m65022a(C14035a c14035a, InterfaceC14367h interfaceC14367h) {
        AbstractC14365f abstractC14365fM65024e;
        if (C14036b.m84189d().m84196h(c14035a.m84185e())) {
            try {
                m65025g(c14035a.m84185e());
            } catch (C12619b unused) {
                C1016d.m6183c("HwLocationManager", "requestLocationUpdatesEx throw locationServiceException");
            }
        }
        int iM84182b = c14035a.m84182b();
        RequestLocationUpdatesRequest requestLocationUpdatesRequestM84186f = c14035a.m84186f();
        C1016d.m6186f("HwLocationManager", "requestLocationUpdatesEx priority = " + iM84182b);
        if (iM84182b == 300) {
            abstractC14365fM65024e = m65024e(c14035a, interfaceC14367h);
        } else {
            if (iM84182b != 200) {
                m65023c(c14035a, interfaceC14367h);
                return;
            }
            C14360a c14360a = new C14360a(requestLocationUpdatesRequestM84186f, interfaceC14367h);
            c14360a.m85552e(m65021i(c14035a, c14360a));
            c14035a.m84188h(c14360a);
            C14036b.m84189d().m84195g(c14035a);
            C11145b.m67054b().m67056c(requestLocationUpdatesRequestM84186f, c14360a);
            abstractC14365fM65024e = c14360a;
        }
        abstractC14365fM65024e.f63719a.mo38278a();
        if (this.f50988b == null) {
            HandlerThread handlerThread = new HandlerThread("FullSDK-hwLocationManager-HwLocationManager");
            handlerThread.start();
            this.f50988b = new Handler(handlerThread.getLooper());
        }
        this.f50988b.postDelayed(new RunnableC10609f(abstractC14365fM65024e), 100L);
        int iM84182b2 = c14035a.m84182b();
        if (this.f50987a == null) {
            this.f50987a = new C10604a();
        }
        if (iM84182b2 == 300 || iM84182b2 == 102 || iM84182b2 == 104) {
            this.f50987a.m73376d();
        }
    }

    /* renamed from: c */
    public final synchronized void m65023c(C14035a c14035a, InterfaceC14367h interfaceC14367h) {
        char c10;
        AbstractC14365f c14368i;
        C10913b c10913bM65957f;
        RequestLocationUpdatesRequest requestLocationUpdatesRequestM84186f;
        if (C14036b.m84189d().m84196h(c14035a.m84185e())) {
            try {
                m65025g(c14035a.m84185e());
            } catch (C12619b unused) {
                C1016d.m6183c("HwLocationManager", "requestLocationUpdates throw locationServiceException");
            }
        }
        RequestLocationUpdatesRequest requestLocationUpdatesRequestM84186f2 = c14035a.m84186f();
        String strM84183c = c14035a.m84183c();
        switch (strM84183c.hashCode()) {
            case -792039641:
                if (!strM84183c.equals("passive")) {
                    c10 = 65535;
                    break;
                } else {
                    c10 = 0;
                    break;
                }
            case 102570:
                if (!strM84183c.equals("gps")) {
                    c10 = 65535;
                    break;
                } else {
                    c10 = 1;
                    break;
                }
            case 97798435:
                if (!strM84183c.equals("fused")) {
                    c10 = 65535;
                    break;
                } else {
                    c10 = 2;
                    break;
                }
            case 1843485230:
                if (!strM84183c.equals("network")) {
                    c10 = 65535;
                    break;
                } else {
                    c10 = 3;
                    break;
                }
            default:
                c10 = 65535;
                break;
        }
        if (c10 == 0) {
            C14370k c14370k = new C14370k(requestLocationUpdatesRequestM84186f2, interfaceC14367h);
            c14370k.m85552e(m65021i(c14035a, c14370k));
            c14035a.m84188h(c14370k);
            C14036b.m84189d().m84195g(c14035a);
            C11145b.m67054b().m67056c(requestLocationUpdatesRequestM84186f2, c14370k);
            c14368i = c14370k;
        } else if (c10 == 1) {
            c14368i = new C14368i(c14035a.m84186f(), interfaceC14367h);
            c14368i.m85552e(m65021i(c14035a, c14368i));
            c14035a.m84188h(c14368i);
            C14036b.m84189d().m84195g(c14035a);
            C11145b.m67054b().m67056c(c14035a.m84186f(), c14368i);
        } else if (c10 == 2) {
            if (c14035a.m84186f().isResendFromHMS()) {
                c14368i = new C14366g(c14035a.m84186f(), interfaceC14367h);
                c14368i.m85552e(m65021i(c14035a, c14368i));
                c14035a.m84188h(c14368i);
                C14036b.m84189d().m84195g(c14035a);
                this.f50989c.m73380a(c14035a);
            } else {
                if (f50984d) {
                    c14368i = new C14366g(c14035a.m84186f(), interfaceC14367h);
                    c14368i.m85552e(m65021i(c14035a, c14368i));
                    c14035a.m84188h(c14368i);
                    C14036b.m84189d().m84195g(c14035a);
                    this.f50989c.m73380a(c14035a);
                    c10913bM65957f = C10913b.m65957f();
                    requestLocationUpdatesRequestM84186f = c14035a.m84186f();
                } else {
                    c14368i = new C14368i(c14035a.m84186f(), interfaceC14367h);
                    c14368i.m85552e(m65021i(c14035a, c14368i));
                    c14035a.m84188h(c14368i);
                    C14036b.m84189d().m84195g(c14035a);
                    c10913bM65957f = C10913b.m65957f();
                    requestLocationUpdatesRequestM84186f = c14035a.m84186f();
                }
                c10913bM65957f.m65963d(requestLocationUpdatesRequestM84186f);
            }
            C11145b.m67054b().m67056c(c14035a.m84186f(), c14368i);
        } else {
            if (c10 != 3) {
                C1016d.m6186f("HwLocationManager", "end");
                return;
            }
            c14368i = m65024e(c14035a, interfaceC14367h);
        }
        interfaceC14367h.mo38278a();
        if (this.f50988b == null) {
            HandlerThread handlerThread = new HandlerThread("FullSDK-hwLocationManager-HwLocationManager");
            handlerThread.start();
            this.f50988b = new Handler(handlerThread.getLooper());
        }
        this.f50988b.postDelayed(new RunnableC10609f(c14368i), 100L);
        int iM84182b = c14035a.m84182b();
        if (this.f50987a == null) {
            this.f50987a = new C10604a();
        }
        if (iM84182b == 300 || iM84182b == 102 || iM84182b == 104) {
            this.f50987a.m73376d();
        }
    }

    /* renamed from: e */
    public final AbstractC14365f m65024e(C14035a c14035a, InterfaceC14367h interfaceC14367h) {
        AbstractC14365f c14370k;
        if (c14035a.m84186f().isResendFromHMS()) {
            C14363d c14363d = new C14363d(c14035a.m84186f(), interfaceC14367h);
            c14363d.m85552e(m65021i(c14035a, c14363d));
            c14035a.m84188h(c14363d);
            C14036b.m84189d().m84195g(c14035a);
            this.f50989c.m73380a(c14035a);
            return c14363d;
        }
        if (f50984d) {
            c14370k = new C14363d(c14035a.m84186f(), interfaceC14367h);
            c14370k.m85552e(m65021i(c14035a, c14370k));
            c14035a.m84188h(c14370k);
            C14036b.m84189d().m84195g(c14035a);
            this.f50989c.m73380a(c14035a);
        } else {
            c14370k = new C14370k(c14035a.m84186f(), interfaceC14367h);
            c14370k.m85552e(m65021i(c14035a, c14370k));
            c14035a.m84188h(c14370k);
            C14036b.m84189d().m84195g(c14035a);
        }
        C10913b.m65957f().m65963d(c14035a.m84186f());
        return c14370k;
    }

    /* renamed from: g */
    public final void m65025g(String str) throws C12619b {
        C14035a c14035aM84192c = C14036b.m84189d().m84192c(str);
        if (c14035aM84192c == null || TextUtils.isEmpty(c14035aM84192c.m84183c())) {
            throw new C12619b(LocationStatusCode.NO_MATCHED_CALLBACK, LocationStatusCode.getStatusCodeString(LocationStatusCode.NO_MATCHED_CALLBACK));
        }
        m65026h(c14035aM84192c);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m65026h(p819yq.C14035a r5) {
        /*
            r4 = this;
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r0 = r5.m84186f()
            is.i r1 = is.C10612i.a.m65056a()
            java.lang.String r2 = r0.getTid()
            r1.m65052b(r5, r2)
            java.lang.String r1 = r5.m84183c()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "handlerRemoveRequest, uuid is "
            r2.<init>(r3)
            java.lang.String r0 = r0.getUuid()
            r2.append(r0)
            java.lang.String r0 = ", provider is "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "HwLocationManager"
            as.C1016d.m6186f(r2, r0)
            java.lang.String r0 = "network"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L52
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r0 = r5.m84186f()
            if (r0 != 0) goto L42
            goto Lb3
        L42:
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r0 = r5.m84186f()
            boolean r0 = r0.isResendFromHMS()
            if (r0 == 0) goto L4d
            goto L76
        L4d:
            boolean r0 = is.C10606c.f50984d
            if (r0 == 0) goto L85
            goto L80
        L52:
            java.lang.String r0 = "fused"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L91
            kr.b r0 = kr.C11145b.m67054b()
            zq.f r1 = r5.m84187g()
            r0.m67057d(r1)
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r0 = r5.m84186f()
            if (r0 != 0) goto L6c
            goto Lb3
        L6c:
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r0 = r5.m84186f()
            boolean r0 = r0.isResendFromHMS()
            if (r0 == 0) goto L7c
        L76:
            ps.a r0 = r4.f50989c
            r0.m73381b(r5)
            goto Lb3
        L7c:
            boolean r0 = is.C10606c.f50984d
            if (r0 == 0) goto L85
        L80:
            ps.a r0 = r4.f50989c
            r0.m73381b(r5)
        L85:
            js.b r0 = p404js.C10913b.m65957f()
            com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r1 = r5.m84186f()
            r0.m65966h(r1)
            goto Lb3
        L91:
            java.lang.String r0 = "passive"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 != 0) goto La8
            java.lang.String r0 = "gps"
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto La2
            goto La8
        La2:
            java.lang.String r4 = "handlerRemoveRequest fail"
            as.C1016d.m6186f(r2, r4)
            return
        La8:
            kr.b r0 = kr.C11145b.m67054b()
            zq.f r1 = r5.m84187g()
            r0.m67057d(r1)
        Lb3:
            int r5 = r5.m84182b()
            is.a r0 = r4.f50987a
            if (r0 == 0) goto Lca
            r1 = 300(0x12c, float:4.2E-43)
            if (r5 == r1) goto Lc7
            r1 = 102(0x66, float:1.43E-43)
            if (r5 == r1) goto Lc7
            r1 = 104(0x68, float:1.46E-43)
            if (r5 != r1) goto Lca
        Lc7:
            r0.m73378f()
        Lca:
            yq.b r5 = p819yq.C14036b.m84189d()
            java.util.concurrent.ConcurrentHashMap r5 = r5.m84193e()
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto Le2
            is.a r5 = r4.f50987a
            if (r5 == 0) goto Le2
            r5.m73377e()
            r5 = 0
            r4.f50987a = r5
        Le2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: is.C10606c.m65026h(yq.a):void");
    }
}
