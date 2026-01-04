package p404js;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import as.C1016d;
import com.huawei.hms.location.LocationProviderCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.network.embedded.C5976k;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.nlp.network.OnlineLocationService;
import com.huawei.openalliance.p169ad.constant.JsbMapKeyNames;
import es.C9540e;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import ms.C11512e;
import p588qr.C12390b;
import p784xq.C13850f;

/* renamed from: js.b */
/* loaded from: classes8.dex */
public final class C10913b {

    /* renamed from: l */
    public static final byte[] f51776l = new byte[0];

    /* renamed from: m */
    public static volatile C10913b f51777m;

    /* renamed from: a */
    public long f51778a;

    /* renamed from: b */
    public long f51779b;

    /* renamed from: c */
    public Handler f51780c;

    /* renamed from: e */
    public LocationProviderCallback f51782e;

    /* renamed from: f */
    public PriorityBlockingQueue<RequestLocationUpdatesRequest> f51783f;

    /* renamed from: i */
    public boolean f51786i = true;

    /* renamed from: j */
    public boolean f51787j = false;

    /* renamed from: k */
    public long f51788k = -1;

    /* renamed from: d */
    public OnlineLocationService f51781d = new OnlineLocationService();

    /* renamed from: g */
    public C11512e f51784g = new C11512e(new c());

    /* renamed from: h */
    public int f51785h = C11512e.m68713c();

    /* renamed from: js.b$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            C13850f.m83120a(new StringBuilder("msg.what="), message.what, "NLPClient");
            if (message.what != 0) {
                return;
            }
            C10913b.m65958i(C10913b.this, true);
        }
    }

    /* renamed from: js.b$b */
    public class b implements Comparator<RequestLocationUpdatesRequest> {
        @Override // java.util.Comparator
        public final int compare(RequestLocationUpdatesRequest requestLocationUpdatesRequest, RequestLocationUpdatesRequest requestLocationUpdatesRequest2) {
            return Long.compare(requestLocationUpdatesRequest.getLocationRequest().getInterval(), requestLocationUpdatesRequest2.getLocationRequest().getInterval());
        }
    }

    /* renamed from: js.b$c */
    public class c implements InterfaceC10912a {
        public c() {
        }

        @Override // p404js.InterfaceC10912a
        /* renamed from: a */
        public final void mo65956a() {
            if (C10913b.this.f51787j) {
                return;
            }
            C1016d.m6186f("NLPClient", "isCacheAvailable is false, do request");
            C9540e.m59581d().m59582a(new Runnable() { // from class: js.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f51791a.m65968c();
                }
            });
        }

        /* renamed from: c */
        public final /* synthetic */ void m65968c() {
            C10913b.m65958i(C10913b.this, false);
        }
    }

    public C10913b() {
        this.f51778a = 2L;
        this.f51779b = C5976k.b.f27175m;
        m65962c();
        this.f51783f = new PriorityBlockingQueue<>(11, new b());
        String strM74462f = C12390b.m74456g().m74462f(JsbMapKeyNames.H5_LOC, "position_min_interval");
        String strM74462f2 = C12390b.m74456g().m74462f(JsbMapKeyNames.H5_LOC, "position_max_interval");
        C1016d.m6186f("NLPClient", "minInterval is " + strM74462f + ", maxInterval is " + strM74462f2);
        try {
            if (!TextUtils.isEmpty(strM74462f)) {
                this.f51778a = Long.parseLong(strM74462f);
            }
            if (TextUtils.isEmpty(strM74462f2)) {
                return;
            }
            this.f51779b = Long.parseLong(strM74462f2);
        } catch (NumberFormatException unused) {
            C1016d.m6183c("NLPClient", "parse interval fail ");
        }
    }

    /* renamed from: f */
    public static C10913b m65957f() {
        if (f51777m == null) {
            synchronized (f51776l) {
                try {
                    if (f51777m == null) {
                        f51777m = new C10913b();
                    }
                } finally {
                }
            }
        }
        return f51777m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
    
        if (r2 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009a, code lost:
    
        if (r5 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        r6.f51787j = false;
        as.C1016d.m6183c("NLPClient", "doRequest, cache is invalid");
        r6.f51782e.onLocationChanged(new com.huawei.hms.location.HwLocationResult(com.huawei.hms.support.api.location.common.exception.LocationStatusCode.ARGUMENTS_EMPTY, p433ks.C11146a.m67058a(com.huawei.hms.support.api.location.common.exception.LocationStatusCode.ARGUMENTS_EMPTY)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return;
     */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m65958i(p404js.C10913b r6, boolean r7) {
        /*
            r6.getClass()
            android.content.Context r0 = p531or.C11991a.m72145a()
            boolean r0 = es.C9546k.m59614h(r0)
            java.lang.String r1 = "NLPClient"
            if (r0 == 0) goto Lc3
            android.content.Context r0 = p531or.C11991a.m72145a()
            boolean r0 = es.C9545j.m59603d(r0)
            if (r0 != 0) goto L1b
            goto Lc3
        L1b:
            r0 = 0
            if (r7 == 0) goto L2a
            android.os.Handler r7 = r6.f51780c
            r7.removeMessages(r0)
            android.os.Handler r7 = r6.f51780c
            long r2 = r6.f51788k
            r7.sendEmptyMessageDelayed(r0, r2)
        L2a:
            com.huawei.location.nlp.network.request.OnlineLocationRequest r7 = new com.huawei.location.nlp.network.request.OnlineLocationRequest
            r7.<init>()
            int r2 = r6.f51785h
            r3 = 1
            if (r2 != r3) goto L48
            ls.a r2 = ls.C11340a.m68129g()
            java.util.List r2 = r2.m68130a()
            r7.setWifiScanResult(r2)
            ls.a r2 = ls.C11340a.m68129g()
            boolean r2 = r2.m68134e()
            goto L95
        L48:
            r4 = 2
            if (r2 != r4) goto L5f
            ls.a r2 = ls.C11340a.m68129g()
            java.util.List r2 = r2.m68131b()
            r7.setCellInfos(r2)
            ls.a r2 = ls.C11340a.m68129g()
            boolean r2 = r2.m68137i()
            goto L95
        L5f:
            ls.a r2 = ls.C11340a.m68129g()
            java.util.List r2 = r2.m68130a()
            ls.a r4 = ls.C11340a.m68129g()
            boolean r4 = r4.m68134e()
            if (r4 == 0) goto L74
            r7.setWifiScanResult(r2)
        L74:
            ls.a r2 = ls.C11340a.m68129g()
            java.util.List r2 = r2.m68131b()
            ls.a r5 = ls.C11340a.m68129g()
            boolean r5 = r5.m68137i()
            if (r5 == 0) goto L89
            r7.setCellInfos(r2)
        L89:
            boolean r2 = r6.f51786i
            if (r2 == 0) goto L98
            java.lang.String r2 = "The first online location request verifies only Wi-Fi availability."
            as.C1016d.m6186f(r1, r2)
            r6.f51786i = r0
            r2 = r4
        L95:
            if (r2 != 0) goto Lb5
            goto L9d
        L98:
            if (r4 != 0) goto Lb5
            if (r5 == 0) goto L9d
            goto Lb5
        L9d:
            r6.f51787j = r0
            java.lang.String r7 = "doRequest, cache is invalid"
            as.C1016d.m6183c(r1, r7)
            com.huawei.hms.location.LocationProviderCallback r6 = r6.f51782e
            com.huawei.hms.location.HwLocationResult r7 = new com.huawei.hms.location.HwLocationResult
            r0 = 10100(0x2774, float:1.4153E-41)
            java.lang.String r1 = p433ks.C11146a.m67058a(r0)
            r7.<init>(r0, r1)
            r6.onLocationChanged(r7)
            goto Lc8
        Lb5:
            r6.f51787j = r3
            com.huawei.hms.location.LocationProviderCallback r0 = r6.f51782e
            com.huawei.location.nlp.network.OnlineLocationService r6 = r6.f51781d
            com.huawei.hms.location.HwLocationResult r6 = r6.getLocationFromCloud(r7)
            r0.onLocationChanged(r6)
            goto Lc8
        Lc3:
            java.lang.String r6 = "doRequest fail, Network or LocationEnabled is not available"
            as.C1016d.m6183c(r1, r6)
        Lc8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p404js.C10913b.m65958i(js.b, boolean):void");
    }

    /* renamed from: a */
    public final void m65960a() {
        if (this.f51783f.isEmpty()) {
            return;
        }
        C1016d.m6186f("NLPClient", "startRequest");
        if (this.f51780c.hasMessages(0)) {
            this.f51780c.removeMessages(0);
        }
        this.f51780c.sendEmptyMessage(0);
        this.f51784g.m68715b();
    }

    /* renamed from: b */
    public final void m65961b() {
        C1016d.m6186f("NLPClient", "stopRequest");
        if (this.f51780c.hasMessages(0)) {
            this.f51780c.removeMessages(0);
        }
        this.f51784g.m68714a();
    }

    /* renamed from: c */
    public final void m65962c() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-request");
        handlerThread.start();
        this.f51780c = new a(handlerThread.getLooper());
    }

    /* renamed from: d */
    public final void m65963d(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        if (requestLocationUpdatesRequest.getLocationRequest() == null) {
            return;
        }
        this.f51783f.add(requestLocationUpdatesRequest);
        C1016d.m6186f("NLPClient", "requestLocationUpdates, nlpCache size is " + this.f51783f.size());
        long j10 = this.f51788k;
        if (j10 <= 5000 && j10 > 0) {
            m65964e();
        } else {
            m65964e();
            m65960a();
        }
    }

    /* renamed from: e */
    public final void m65964e() {
        LocationRequest locationRequest;
        RequestLocationUpdatesRequest requestLocationUpdatesRequestPeek = this.f51783f.peek();
        if (requestLocationUpdatesRequestPeek == null || (locationRequest = requestLocationUpdatesRequestPeek.getLocationRequest()) == null) {
            return;
        }
        long interval = locationRequest.getInterval();
        if (interval == this.f51788k) {
            return;
        }
        this.f51788k = Math.min(Math.max(interval, this.f51778a * 1000), this.f51779b * 1000);
        C1016d.m6186f("NLPClient", "currentInterval is " + this.f51788k);
        this.f51784g.m68716d(this.f51788k);
    }

    /* renamed from: g */
    public final void m65965g(LocationProviderCallback locationProviderCallback) {
        this.f51782e = locationProviderCallback;
    }

    /* renamed from: h */
    public final void m65966h(RequestLocationUpdatesRequest requestLocationUpdatesRequest) {
        this.f51783f.remove(requestLocationUpdatesRequest);
        C1016d.m6186f("NLPClient", "removeLocationUpdates, nlpCache size is " + this.f51783f.size());
        if (!this.f51783f.isEmpty()) {
            m65964e();
            return;
        }
        m65961b();
        this.f51788k = -1L;
        this.f51786i = true;
    }
}
