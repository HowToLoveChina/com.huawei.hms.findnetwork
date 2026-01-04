package com.huawei.wearengine.p2p;

import com.huawei.hmf.tasks.Task;
import com.huawei.wearengine.device.Device;
import com.huawei.wearengine.p2p.C8902a;
import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import p208cq.C8943k;
import p558pu.C12227b;
import p752wu.C13640b;
import p752wu.C13641c;
import su.C12860b;
import vu.C13489a;
import vu.InterfaceC13490b;
import vu.InterfaceC13491c;
import vu.InterfaceC13492d;
import vu.InterfaceC13493e;

/* renamed from: com.huawei.wearengine.p2p.f */
/* loaded from: classes9.dex */
public final class C8907f {

    /* renamed from: f */
    public static volatile C8907f f45354f;

    /* renamed from: b */
    public String f45356b = "";

    /* renamed from: c */
    public String f45357c = "";

    /* renamed from: d */
    public Timer f45358d = null;

    /* renamed from: e */
    public ExecutorService f45359e = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public C13489a f45355a = C13489a.m81175h();

    /* renamed from: com.huawei.wearengine.p2p.f$a */
    public class a implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ Device f45360a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC13491c f45361b;

        public a(Device device, InterfaceC13491c interfaceC13491c) {
            this.f45360a = device;
            this.f45361b = interfaceC13491c;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Throwable {
            String packageName = C13641c.m82014a().getPackageName();
            String strM82018e = C13641c.m82018e(C13641c.m82014a(), packageName);
            C12860b.m77201e(this.f45360a, "Device can not be null!");
            C12860b.m77201e(packageName, "srcPkgName can not be null!");
            C12860b.m77201e(strM82018e, "srcFingerPrint can not be null!");
            C12860b.m77201e(this.f45361b, "Receiver can not be null!");
            int iM56600b = C8907f.m56600b(C8907f.this, this.f45360a, this.f45361b, new IdentityInfo(packageName, strM82018e), new IdentityInfo(C8907f.this.f45356b, C8907f.this.f45357c));
            if (iM56600b == 0) {
                return null;
            }
            throw new C12227b(iM56600b);
        }
    }

    /* renamed from: com.huawei.wearengine.p2p.f$b */
    public class b implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC13491c f45363a;

        public b(InterfaceC13491c interfaceC13491c) {
            this.f45363a = interfaceC13491c;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            C12860b.m77201e(this.f45363a, "Receiver can not be null!");
            int iIdentityHashCode = System.identityHashCode(this.f45363a);
            C8907f c8907f = C8907f.this;
            c8907f.getClass();
            int iUnregisterReceiver = C8907f.this.f45355a.unregisterReceiver(new BinderC8904c(c8907f), iIdentityHashCode);
            if (iUnregisterReceiver == 0) {
                return null;
            }
            throw new C12227b(iUnregisterReceiver);
        }
    }

    /* renamed from: com.huawei.wearengine.p2p.f$c */
    public class c implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ Device f45365a;

        /* renamed from: b */
        public final /* synthetic */ InterfaceC13490b f45366b;

        public c(Device device, InterfaceC13490b interfaceC13490b) {
            this.f45365a = device;
            this.f45366b = interfaceC13490b;
        }

        @Override // java.util.concurrent.Callable
        public Void call() {
            C12860b.m77201e(this.f45365a, "Device can not be null!");
            C12860b.m77201e(this.f45366b, "PingCallback can not be null!");
            C8907f c8907f = C8907f.this;
            InterfaceC13490b interfaceC13490b = this.f45366b;
            c8907f.getClass();
            BinderC8905d binderC8905d = new BinderC8905d(c8907f, interfaceC13490b);
            int iPing = C8907f.this.f45355a.ping(this.f45365a, C13641c.m82014a().getPackageName(), C8907f.this.f45356b, binderC8905d);
            if (iPing == 0) {
                return null;
            }
            throw new C12227b(iPing);
        }
    }

    /* renamed from: com.huawei.wearengine.p2p.f$d */
    public class d implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ Device f45368a;

        /* renamed from: b */
        public final /* synthetic */ C8902a f45369b;

        /* renamed from: c */
        public final /* synthetic */ InterfaceC13492d f45370c;

        public d(Device device, C8902a c8902a, InterfaceC13492d interfaceC13492d) {
            this.f45368a = device;
            this.f45369b = c8902a;
            this.f45370c = interfaceC13492d;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Throwable {
            String packageName = C13641c.m82014a().getPackageName();
            String strM82018e = C13641c.m82018e(C13641c.m82014a(), packageName);
            C12860b.m77201e(packageName, "srcPkgName can not be null!");
            C12860b.m77201e(strM82018e, "srcFingerPrint can not be null!");
            C12860b.m77201e(this.f45368a, "Device can not be null!");
            C12860b.m77201e(this.f45369b, "Message can not be null!");
            C12860b.m77201e(this.f45370c, "SendCallback can not be null!");
            int iM56599a = C8907f.m56599a(C8907f.this, this.f45368a, new IdentityInfo(packageName, strM82018e), new IdentityInfo(C8907f.this.f45356b, C8907f.this.f45357c), this.f45369b, this.f45370c);
            if (iM56599a == 0) {
                return null;
            }
            throw new C12227b(iM56599a);
        }
    }

    /* renamed from: a */
    public static int m56599a(C8907f c8907f, Device device, IdentityInfo identityInfo, IdentityInfo identityInfo2, C8902a c8902a, InterfaceC13492d interfaceC13492d) throws JSONException {
        c8907f.getClass();
        if ((interfaceC13492d instanceof InterfaceC13493e) && !C13640b.m82013c("p2p_send_file_transfer_way_report")) {
            C12860b.m77197a("P2pClient", "query Health version is low");
            throw new C12227b(14);
        }
        MessageParcel messageParcelM77199c = C12860b.m77199c(c8902a);
        MessageParcelExtra messageParcelExtraM77200d = C12860b.m77200d(c8902a, messageParcelM77199c);
        BinderC8906e binderC8906e = new BinderC8906e(c8907f, interfaceC13492d);
        int iSendExtra = c8907f.f45355a.sendExtra(device, messageParcelExtraM77200d, identityInfo, identityInfo2, binderC8906e);
        return iSendExtra == 14 ? c8907f.f45355a.send(device, messageParcelM77199c, identityInfo, identityInfo2, binderC8906e) : iSendExtra;
    }

    /* renamed from: b */
    public static int m56600b(C8907f c8907f, Device device, InterfaceC13491c interfaceC13491c, IdentityInfo identityInfo, IdentityInfo identityInfo2) {
        c8907f.getClass();
        return c8907f.f45355a.registerReceiver(device, identityInfo, identityInfo2, new BinderC8903b(c8907f, interfaceC13491c), System.identityHashCode(interfaceC13491c));
    }

    /* renamed from: d */
    public static void m56602d(C8907f c8907f, InterfaceC13491c interfaceC13491c, MessageParcel messageParcel) {
        C8902a c8902aM56596c;
        c8907f.getClass();
        if (messageParcel == null) {
            C12860b.m77197a("P2pClient", "handleReceiveFile messageParcel is null");
            c8902aM56596c = new C8902a.a().m56596c();
        } else {
            C8902a.a aVar = new C8902a.a();
            if (messageParcel.m56571h() != 2) {
                C12860b.m77205i("P2pClient", "handleReceiveFile type is not file");
                return;
            } else {
                aVar.m56597e(C13641c.m82017d(messageParcel.m56568e(), messageParcel.m56570g()));
                c8902aM56596c = aVar.m56596c();
            }
        }
        interfaceC13491c.mo81179a(c8902aM56596c);
    }

    /* renamed from: g */
    public static C8907f m56605g() {
        if (f45354f == null) {
            synchronized (C8907f.class) {
                try {
                    if (f45354f == null) {
                        f45354f = new C8907f();
                    }
                } finally {
                }
            }
        }
        return f45354f;
    }

    /* renamed from: h */
    public Task<Void> m56606h(Device device, InterfaceC13490b interfaceC13490b) {
        return C8943k.m56662b(new c(device, interfaceC13490b));
    }

    /* renamed from: i */
    public Task<Void> m56607i(Device device, InterfaceC13491c interfaceC13491c) {
        return C8943k.m56662b(new a(device, interfaceC13491c));
    }

    /* renamed from: j */
    public Task<Void> m56608j(Device device, C8902a c8902a, InterfaceC13492d interfaceC13492d) {
        return C8943k.m56662b(new d(device, c8902a, interfaceC13492d));
    }

    /* renamed from: k */
    public C8907f m56609k(String str) {
        this.f45357c = str;
        return this;
    }

    /* renamed from: l */
    public C8907f m56610l(String str) {
        this.f45356b = str;
        return this;
    }

    /* renamed from: m */
    public Task<Void> m56611m(InterfaceC13491c interfaceC13491c) {
        return C8943k.m56662b(new b(interfaceC13491c));
    }
}
