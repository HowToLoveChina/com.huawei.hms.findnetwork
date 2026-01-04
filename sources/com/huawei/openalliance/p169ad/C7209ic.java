package com.huawei.openalliance.p169ad;

import android.content.Context;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.openalliance.ad.ic */
/* loaded from: classes8.dex */
public class C7209ic {

    /* renamed from: a */
    private final InterfaceC7207ia f33171a;

    /* renamed from: b */
    private final InterfaceC7320iu f33172b;

    /* renamed from: d */
    private int f33174d;

    /* renamed from: e */
    private ServerSocket f33175e;

    /* renamed from: f */
    private b f33176f;

    /* renamed from: g */
    private boolean f33177g;

    /* renamed from: h */
    private InterfaceC7316iq f33178h;

    /* renamed from: j */
    private Context f33180j;

    /* renamed from: c */
    private final Map<String, Long> f33173c = new ConcurrentHashMap();

    /* renamed from: i */
    private boolean f33179i = false;

    /* renamed from: com.huawei.openalliance.ad.ic$a */
    public static class a implements InterfaceC7214ih {

        /* renamed from: a */
        WeakReference<C7209ic> f33184a;

        public a(C7209ic c7209ic) {
            this.f33184a = new WeakReference<>(c7209ic);
        }

        @Override // com.huawei.openalliance.p169ad.InterfaceC7214ih
        /* renamed from: a */
        public void mo43916a() {
            C7209ic c7209ic = this.f33184a.get();
            if (c7209ic != null) {
                c7209ic.m43914a(true);
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.ic$b */
    public static class b implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            AbstractC7185ho.m43824c("CreativeHttpServer", "register socket listener error: %s", th2.getClass().getSimpleName());
        }
    }

    public C7209ic(Context context, InterfaceC7207ia interfaceC7207ia, InterfaceC7320iu interfaceC7320iu, InterfaceC7316iq interfaceC7316iq) {
        this.f33171a = interfaceC7207ia;
        this.f33172b = interfaceC7320iu;
        this.f33178h = interfaceC7316iq;
        this.f33180j = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m43910c() {
        if (this.f33175e == null) {
            return;
        }
        while (!Thread.currentThread().isInterrupted()) {
            try {
                AbstractC7185ho.m43820b("CreativeHttpServer", "register listener running...");
                final Socket socketAccept = this.f33175e.accept();
                AbstractC7185ho.m43818a("CreativeHttpServer", "accept a new socket: %s, data consume exceed max limit or stream error: %s ", socketAccept, Boolean.valueOf(this.f33179i));
                if (this.f33179i) {
                    return;
                } else {
                    AbstractC7834m.m48491k(new Runnable() { // from class: com.huawei.openalliance.ad.ic.2
                        @Override // java.lang.Runnable
                        public void run() {
                            C7209ic.this.m43913a(socketAccept);
                        }
                    });
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43826d("CreativeHttpServer", "register socket listener error! exception: " + th2.getClass().getSimpleName());
                return;
            }
        }
    }

    /* renamed from: a */
    public int m43911a() {
        return this.f33174d;
    }

    /* renamed from: b */
    public boolean m43915b() {
        return this.f33177g;
    }

    /* renamed from: a */
    public void m43912a(Context context) {
        if (this.f33177g) {
            return;
        }
        String string = context.getString(C6849R.string.player_local_host);
        this.f33175e = new ServerSocket(0, 8, InetAddress.getByName(string));
        this.f33176f = new b();
        int localPort = this.f33175e.getLocalPort();
        this.f33174d = localPort;
        C7215ii.m43938a(string, localPort);
        Thread thread = new Thread("mediaCache") { // from class: com.huawei.openalliance.ad.ic.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                C7209ic.this.m43910c();
            }
        };
        thread.setUncaughtExceptionHandler(this.f33176f);
        thread.start();
        this.f33177g = true;
    }

    /* renamed from: a */
    public void m43913a(Socket socket) {
        try {
            C7312io c7312io = new C7312io(this.f33180j, C7213ig.m43928a(socket.getInputStream()), this.f33172b, this.f33171a, this.f33173c);
            c7312io.m45053a(this.f33178h);
            c7312io.m45052a(new a(this));
            c7312io.m45054a(socket);
        } catch (Throwable th2) {
            if (AbstractC7185ho.m43819a()) {
                AbstractC7185ho.m43815a(3, th2);
            }
            AbstractC7185ho.m43827d("CreativeHttpServer", "process socket failed, %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m43914a(boolean z10) {
        this.f33179i = z10;
    }
}
