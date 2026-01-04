package p832z4;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import p699v4.C13346o;

/* renamed from: z4.c */
/* loaded from: classes.dex */
public class C14129c implements InterfaceC14130d {

    /* renamed from: d */
    public static final Object f63179d = new Object();

    /* renamed from: e */
    public static final Object f63180e = new Object();

    /* renamed from: f */
    public static final C14129c f63181f = new C14129c();

    /* renamed from: a */
    public volatile boolean f63182a = false;

    /* renamed from: b */
    public volatile boolean f63183b = false;

    /* renamed from: c */
    public C13346o f63184c = new C13346o(2, 2, 2);

    /* renamed from: z4.c$a */
    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC14130d f63185a;

        public a(InterfaceC14130d interfaceC14130d) {
            this.f63185a = interfaceC14130d;
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            for (int i10 = 0; i10 < 10 && !C14129c.this.m84799c(); i10++) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused) {
                    C2111d.m12653i("ReadUncoupleModuleManager", "sleep error.");
                }
            }
            this.f63185a.mo12700a();
        }
    }

    /* renamed from: b */
    public static C14129c m84798b() {
        return f63181f;
    }

    @Override // p832z4.InterfaceC14130d
    /* renamed from: a */
    public void mo12700a() {
        synchronized (f63180e) {
            this.f63183b = true;
        }
        C2111d.m12653i("ReadUncoupleModuleManager", "finish call back get!");
    }

    /* renamed from: c */
    public boolean m84799c() {
        boolean z10;
        synchronized (f63180e) {
            z10 = this.f63183b;
        }
        return z10;
    }

    /* renamed from: d */
    public void m84800d(Context context) {
        if (context == null || this.f63182a) {
            return;
        }
        synchronized (f63179d) {
            try {
                if (!this.f63182a) {
                    this.f63184c.m80077c(new Thread(new RunnableC14128b(context, this), "loadsystemmodule"));
                    this.f63182a = true;
                }
            } finally {
            }
        }
    }

    /* renamed from: e */
    public void m84801e(InterfaceC14130d interfaceC14130d) {
        if (interfaceC14130d == null) {
            return;
        }
        C2111d.m12653i("ReadUncoupleModuleManager", "wait to load info.");
        this.f63184c.m80077c(new a(interfaceC14130d));
    }

    /* renamed from: f */
    public void m84802f() {
        this.f63184c.m80076b();
    }
}
