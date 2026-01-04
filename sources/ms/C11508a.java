package ms;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.util.Pair;
import as.C1016d;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import es.C9545j;
import es.C9546k;
import java.util.List;
import ls.C11340a;
import p404js.InterfaceC10912a;
import p498ns.C11746b;
import p531or.C11991a;
import p532os.C12023a;
import p784xq.C13850f;

/* renamed from: ms.a */
/* loaded from: classes8.dex */
public final class C11508a extends C11510c implements InterfaceC11513f {

    /* renamed from: d */
    public Handler f53418d;

    /* renamed from: e */
    public C12023a f53419e;

    /* renamed from: f */
    public C11746b f53420f;

    /* renamed from: g */
    public boolean f53421g;

    /* renamed from: h */
    public boolean f53422h;

    /* renamed from: i */
    public boolean f53423i;

    /* renamed from: j */
    public C12023a.a f53424j;

    /* renamed from: k */
    public C11746b.a f53425k;

    /* renamed from: ms.a$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            C13850f.m83120a(new StringBuilder("msg.what="), message.what, "WifiAndCell");
            int i10 = message.what;
            if (i10 == -1) {
                C11508a.m68693j(C11508a.this);
                return;
            }
            if (i10 == 0) {
                if (C11508a.m68694l(C11508a.this)) {
                    C11508a.m68695m(C11508a.this);
                }
            } else if (i10 == 1 && C11508a.m68694l(C11508a.this)) {
                C11508a.m68697o(C11508a.this);
            }
        }
    }

    /* renamed from: ms.a$b */
    public class b implements C11746b.a {
        public b() {
        }

        @Override // p498ns.C11746b.a
        /* renamed from: b */
        public final void mo68704b(List<CellInfo> list) {
            if (list == null || list.isEmpty()) {
                C1016d.m6183c("WifiAndCell", "cellInfoList is empty");
                return;
            }
            C1016d.m6186f("WifiAndCell", "cell scan success, result size is " + list.size());
            C11340a.m68129g().m68136h(C11508a.this.m68712d(list));
            C11508a.this.f53423i = false;
        }
    }

    /* renamed from: ms.a$c */
    public class c implements C12023a.a {
        public c() {
        }

        @Override // p532os.C12023a.a
        /* renamed from: a */
        public final void mo68705a() {
            C1016d.m6186f("WifiAndCell", "wifi scan fail, code is 10000");
            if (C11508a.this.f53418d.hasMessages(-1)) {
                C11508a.this.f53418d.removeMessages(-1);
                C11508a.this.f53418d.sendEmptyMessage(-1);
            }
        }

        @Override // p532os.C12023a.a
        /* renamed from: b */
        public final void mo68706b(List<ScanResult> list) throws NumberFormatException {
            if (list.isEmpty()) {
                C1016d.m6183c("WifiAndCell", "wifi scan success, scanResultList is empty");
                return;
            }
            C1016d.m6186f("WifiAndCell", "wifi scan success, scanResultList size is " + list.size());
            C11508a.m68699q(C11508a.this, list);
        }
    }

    public C11508a(InterfaceC10912a interfaceC10912a) {
        super(interfaceC10912a);
        this.f53421g = true;
        this.f53422h = true;
        this.f53423i = true;
        this.f53424j = new c();
        this.f53425k = new b();
        this.f53419e = new C12023a();
        this.f53420f = new C11746b();
        m68703k();
    }

    /* renamed from: j */
    public static void m68693j(C11508a c11508a) {
        c11508a.f53422h = false;
        if (C11340a.m68129g().m68137i() || C11340a.m68129g().m68134e()) {
            C1016d.m6186f("WifiAndCell", "handlerTimeout onScanResult");
            c11508a.f53429a.mo65956a();
        }
    }

    /* renamed from: l */
    public static boolean m68694l(C11508a c11508a) {
        c11508a.getClass();
        if (!C9546k.m59614h(C11991a.m72145a()) || !C9545j.m59603d(C11991a.m72145a())) {
            C1016d.m6186f("WifiAndCell", "checkLocationAvailability false");
            return false;
        }
        C1016d.m6186f("WifiAndCell", "isNeed:" + c11508a.f53421g);
        return c11508a.f53421g;
    }

    /* renamed from: m */
    public static void m68695m(C11508a c11508a) {
        c11508a.f53418d.removeMessages(0);
        c11508a.f53418d.sendEmptyMessageDelayed(0, 30000L);
        boolean zM68134e = C11340a.m68129g().m68134e();
        C1016d.m6186f("WifiAndCell", "isFirstScanWifi = " + c11508a.f53422h + ",isWifiCacheValid = " + zM68134e);
        if (c11508a.f53422h && zM68134e) {
            c11508a.f53422h = false;
        } else {
            c11508a.f53419e.m72151b(c11508a.f53424j);
        }
    }

    /* renamed from: o */
    public static void m68697o(C11508a c11508a) {
        c11508a.f53418d.removeMessages(1);
        c11508a.f53418d.sendEmptyMessageDelayed(1, c11508a.f53430b);
        boolean zM68137i = C11340a.m68129g().m68137i();
        C1016d.m6186f("WifiAndCell", "isFirstScanCell = " + c11508a.f53423i + ", isCellCacheValid = " + zM68137i);
        if (c11508a.f53423i && zM68137i) {
            c11508a.f53423i = false;
        } else {
            c11508a.f53420f.m70058a(c11508a.f53425k);
        }
    }

    /* renamed from: q */
    public static void m68699q(C11508a c11508a, List list) throws NumberFormatException {
        String str;
        c11508a.getClass();
        Pair<Long, List<WifiInfo>> pairM68708f = C11510c.m68708f(list);
        List list2 = (List) pairM68708f.second;
        if (list2.size() < 1) {
            str = "handlerWifiScanResult, filterResult is empty";
        } else {
            if (!C11510c.m68711i(list2, C11340a.m68129g().m68130a())) {
                C11340a.m68129g().m68133d(pairM68708f);
                if (c11508a.f53418d.hasMessages(-1)) {
                    c11508a.f53418d.removeMessages(-1);
                    c11508a.f53422h = false;
                    c11508a.f53429a.mo65956a();
                    return;
                }
                return;
            }
            str = "The Wi-Fi scanning result is the same as that in the cache.";
        }
        C1016d.m6183c("WifiAndCell", str);
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: a */
    public final void mo68700a() {
        this.f53421g = true;
        if (this.f53418d.hasMessages(0)) {
            this.f53418d.removeMessages(0);
        }
        if (this.f53418d.hasMessages(1)) {
            this.f53418d.removeMessages(1);
        }
        if (this.f53418d.hasMessages(-1)) {
            this.f53418d.removeMessages(-1);
        }
        this.f53418d.sendEmptyMessage(0);
        this.f53418d.sendEmptyMessage(1);
        this.f53418d.sendEmptyMessageDelayed(-1, 3000L);
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: b */
    public final void mo68701b(long j10) {
        C1016d.m6186f("WifiAndCell", "setScanInterval:" + j10);
        this.f53430b = j10;
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: c */
    public final void mo68702c() {
        C1016d.m6186f("WifiAndCell", "stopScan");
        if (this.f53418d.hasMessages(0)) {
            this.f53418d.removeMessages(0);
        }
        if (this.f53418d.hasMessages(1)) {
            this.f53418d.removeMessages(1);
        }
        if (this.f53418d.hasMessages(-1)) {
            this.f53418d.removeMessages(-1);
        }
        this.f53419e.m72150a();
        this.f53421g = false;
        this.f53423i = true;
        this.f53422h = true;
    }

    /* renamed from: k */
    public final void m68703k() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.f53418d = new a(handlerThread.getLooper());
    }
}
