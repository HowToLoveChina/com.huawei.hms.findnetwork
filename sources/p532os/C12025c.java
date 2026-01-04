package p532os;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import as.C1016d;
import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import es.C9545j;
import es.C9546k;
import java.util.List;
import ls.C11340a;
import ms.C11510c;
import ms.InterfaceC11513f;
import p404js.InterfaceC10912a;
import p531or.C11991a;
import p532os.C12023a;
import p784xq.C13850f;

/* renamed from: os.c */
/* loaded from: classes8.dex */
public final class C12025c extends C11510c implements InterfaceC11513f {

    /* renamed from: d */
    public Handler f55792d;

    /* renamed from: e */
    public C12023a f55793e;

    /* renamed from: f */
    public boolean f55794f;

    /* renamed from: g */
    public boolean f55795g;

    /* renamed from: h */
    public C12023a.a f55796h;

    /* renamed from: os.c$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            C13850f.m83120a(new StringBuilder("msg.what="), message.what, "OnlyWifi");
            if (message.what == 0 && C12025c.m72155m(C12025c.this)) {
                C12025c.m72153k(C12025c.this);
            }
        }
    }

    /* renamed from: os.c$b */
    public class b implements C12023a.a {
        public b() {
        }

        @Override // p532os.C12023a.a
        /* renamed from: a */
        public final void mo68705a() {
            C1016d.m6186f("OnlyWifi", "wifi scan fail, code is 10000");
        }

        @Override // p532os.C12023a.a
        /* renamed from: b */
        public final void mo68706b(List<ScanResult> list) throws NumberFormatException {
            if (list.isEmpty()) {
                C1016d.m6183c("OnlyWifi", "scan wifi success, scanResultList is empty");
            } else {
                C12025c.m72154l(C12025c.this, list);
            }
        }
    }

    public C12025c(InterfaceC10912a interfaceC10912a) {
        super(interfaceC10912a);
        this.f55794f = false;
        this.f55795g = true;
        this.f55796h = new b();
        this.f55793e = new C12023a();
        m72152j();
    }

    /* renamed from: j */
    private void m72152j() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.f55792d = new a(handlerThread.getLooper());
    }

    /* renamed from: k */
    public static void m72153k(C12025c c12025c) {
        String str;
        c12025c.f55792d.removeMessages(0);
        c12025c.f55792d.sendEmptyMessageDelayed(0, 30000L);
        if (c12025c.f55795g && C11340a.m68129g().m68134e()) {
            str = "first scan, cached wifi is valid";
        } else {
            c12025c.f55793e.m72151b(c12025c.f55796h);
            str = "requestScan wifi";
        }
        C1016d.m6186f("OnlyWifi", str);
    }

    /* renamed from: l */
    public static void m72154l(C12025c c12025c, List list) throws NumberFormatException {
        String str;
        c12025c.getClass();
        Pair<Long, List<WifiInfo>> pairM68708f = C11510c.m68708f(list);
        List list2 = (List) pairM68708f.second;
        if (list2.size() < 1) {
            str = "handlerWifiScanFail, filterResult is empty";
        } else {
            if (!C11510c.m68711i(list2, C11340a.m68129g().m68130a())) {
                C11340a.m68129g().m68133d(pairM68708f);
                c12025c.f55795g = false;
                c12025c.f53429a.mo65956a();
                return;
            }
            str = "The Wi-Fi scanning result is the same as that in the cache.";
        }
        C1016d.m6183c("OnlyWifi", str);
    }

    /* renamed from: m */
    public static boolean m72155m(C12025c c12025c) {
        c12025c.getClass();
        if (!C9546k.m59614h(C11991a.m72145a()) || !C9545j.m59603d(C11991a.m72145a())) {
            C1016d.m6186f("OnlyWifi", "gnssAndNet is false");
            return false;
        }
        C1016d.m6183c("OnlyWifi", "isNeedScan is " + c12025c.f55794f);
        return c12025c.f55794f;
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: a */
    public final void mo68700a() {
        this.f55794f = true;
        if (this.f55792d.hasMessages(0)) {
            this.f55792d.removeMessages(0);
        }
        this.f55792d.sendEmptyMessage(0);
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: b */
    public final void mo68701b(long j10) {
        this.f53430b = j10;
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: c */
    public final void mo68702c() {
        if (this.f55792d.hasMessages(0)) {
            this.f55792d.removeMessages(0);
        }
        this.f55794f = false;
        this.f55795g = true;
        this.f55793e.m72150a();
    }
}
