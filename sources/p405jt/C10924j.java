package p405jt;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p434kt.ThreadFactoryC11147a;

/* renamed from: jt.j */
/* loaded from: classes2.dex */
public class C10924j extends AbstractC10918d {

    /* renamed from: b */
    public final InterfaceC10925k f51816b;

    /* renamed from: c */
    public final Executor f51817c = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC11147a("FileLog"));

    /* renamed from: jt.j$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f51818a;

        /* renamed from: b */
        public final /* synthetic */ String f51819b;

        public a(String str, String str2) {
            this.f51818a = str;
            this.f51819b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C10924j.this.f51816b.mo66001a(this.f51818a, this.f51819b);
        }
    }

    /* renamed from: jt.j$b */
    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C10927m f51821a;

        /* renamed from: b */
        public final /* synthetic */ int f51822b;

        /* renamed from: c */
        public final /* synthetic */ String f51823c;

        public b(C10927m c10927m, int i10, String str) {
            this.f51821a = c10927m;
            this.f51822b = i10;
            this.f51823c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C10924j.this.f51816b.mo66002a(this.f51821a, this.f51822b, this.f51823c);
        }
    }

    public C10924j(InterfaceC10925k interfaceC10925k) {
        this.f51816b = interfaceC10925k;
    }

    @Override // p405jt.InterfaceC10925k
    /* renamed from: a */
    public InterfaceC10925k mo66001a(String str, String str2) {
        this.f51817c.execute(new a(str, str2));
        InterfaceC10925k interfaceC10925k = this.f51802a;
        if (interfaceC10925k != null) {
            interfaceC10925k.mo66001a(str, str2);
        }
        return this;
    }

    @Override // p405jt.InterfaceC10925k
    /* renamed from: a */
    public void mo66002a(C10927m c10927m, int i10, String str) {
        this.f51817c.execute(new b(c10927m, i10, str));
        InterfaceC10925k interfaceC10925k = this.f51802a;
        if (interfaceC10925k != null) {
            interfaceC10925k.mo66002a(c10927m, i10, str);
        }
    }
}
