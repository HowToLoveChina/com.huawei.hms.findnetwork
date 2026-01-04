package p498ns;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import as.C1016d;
import es.C9545j;
import es.C9546k;
import java.util.List;
import ls.C11340a;
import ms.C11510c;
import ms.InterfaceC11513f;
import p404js.InterfaceC10912a;
import p498ns.C11746b;
import p531or.C11991a;
import p784xq.C13850f;

/* renamed from: ns.a */
/* loaded from: classes8.dex */
public final class C11745a extends C11510c implements InterfaceC11513f {

    /* renamed from: d */
    public Handler f54303d;

    /* renamed from: e */
    public C11746b f54304e;

    /* renamed from: f */
    public boolean f54305f;

    /* renamed from: g */
    public boolean f54306g;

    /* renamed from: h */
    public C11746b.a f54307h;

    /* renamed from: ns.a$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            C13850f.m83120a(new StringBuilder("msg.what="), message.what, "OnlyCell");
            if (message.what == 0 && C11745a.m70054k(C11745a.this)) {
                C11745a.m70055l(C11745a.this);
            }
        }
    }

    /* renamed from: ns.a$b */
    public class b implements C11746b.a {
        public b() {
        }

        @Override // p498ns.C11746b.a
        /* renamed from: b */
        public final void mo68704b(List<CellInfo> list) {
            if (list == null || list.isEmpty()) {
                C1016d.m6183c("OnlyCell", "scan cell success, cellInfoList is empty");
                return;
            }
            C1016d.m6186f("OnlyCell", "cell scan success, result size is " + list.size());
            C11340a.m68129g().m68136h(C11745a.this.m68712d(list));
            C11745a.this.f54306g = false;
            C11745a.this.f53429a.mo65956a();
        }
    }

    public C11745a(InterfaceC10912a interfaceC10912a) {
        super(interfaceC10912a);
        this.f54305f = false;
        this.f54306g = true;
        this.f54307h = new b();
        this.f54304e = new C11746b();
        m70053j();
    }

    /* renamed from: j */
    private void m70053j() {
        HandlerThread handlerThread = new HandlerThread("FullSDK-onlineLocation-scan");
        handlerThread.start();
        this.f54303d = new a(handlerThread.getLooper());
    }

    /* renamed from: k */
    public static boolean m70054k(C11745a c11745a) {
        c11745a.getClass();
        if (C9546k.m59614h(C11991a.m72145a()) && C9545j.m59603d(C11991a.m72145a())) {
            return c11745a.f54305f;
        }
        C1016d.m6186f("OnlyCell", "network and location enable is false");
        return false;
    }

    /* renamed from: l */
    public static void m70055l(C11745a c11745a) {
        String str;
        c11745a.f54303d.removeMessages(0);
        c11745a.f54303d.sendEmptyMessageDelayed(0, c11745a.f53430b);
        if (c11745a.f54306g && C11340a.m68129g().m68137i()) {
            str = "first scan, cached cell is valid";
        } else {
            c11745a.f54304e.m70058a(c11745a.f54307h);
            str = "requestScan cell";
        }
        C1016d.m6186f("OnlyCell", str);
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: a */
    public final void mo68700a() {
        this.f54305f = true;
        if (this.f54303d.hasMessages(0)) {
            this.f54303d.removeMessages(0);
        }
        this.f54303d.sendEmptyMessage(0);
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: b */
    public final void mo68701b(long j10) {
        this.f53430b = j10;
    }

    @Override // ms.InterfaceC11513f
    /* renamed from: c */
    public final void mo68702c() {
        if (this.f54303d.hasMessages(0)) {
            this.f54303d.removeMessages(0);
        }
        this.f54305f = false;
        this.f54306g = true;
    }
}
