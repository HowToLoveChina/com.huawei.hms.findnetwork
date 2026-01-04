package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import com.bumptech.glide.manager.InterfaceC1605c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p630s2.C12671f;
import p630s2.C12677l;

/* renamed from: com.bumptech.glide.manager.s */
/* loaded from: classes.dex */
public final class C1621s {

    /* renamed from: d */
    public static volatile C1621s f7137d;

    /* renamed from: a */
    public final c f7138a;

    /* renamed from: b */
    public final Set<InterfaceC1605c.a> f7139b = new HashSet();

    /* renamed from: c */
    public boolean f7140c;

    /* renamed from: com.bumptech.glide.manager.s$a */
    public class a implements C12671f.b<ConnectivityManager> {

        /* renamed from: a */
        public final /* synthetic */ Context f7141a;

        public a(Context context) {
            this.f7141a = context;
        }

        @Override // p630s2.C12671f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.f7141a.getSystemService("connectivity");
        }
    }

    /* renamed from: com.bumptech.glide.manager.s$b */
    public class b implements InterfaceC1605c.a {
        public b() {
        }

        @Override // com.bumptech.glide.manager.InterfaceC1605c.a
        /* renamed from: a */
        public void mo8993a(boolean z10) {
            ArrayList arrayList;
            C12677l.m76278a();
            synchronized (C1621s.this) {
                arrayList = new ArrayList(C1621s.this.f7139b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InterfaceC1605c.a) it.next()).mo8993a(z10);
            }
        }
    }

    /* renamed from: com.bumptech.glide.manager.s$c */
    public interface c {
        /* renamed from: a */
        boolean mo9226a();

        /* renamed from: b */
        void mo9227b();
    }

    /* renamed from: com.bumptech.glide.manager.s$d */
    public static final class d implements c {

        /* renamed from: a */
        public boolean f7144a;

        /* renamed from: b */
        public final InterfaceC1605c.a f7145b;

        /* renamed from: c */
        public final C12671f.b<ConnectivityManager> f7146c;

        /* renamed from: d */
        public final ConnectivityManager.NetworkCallback f7147d = new a();

        /* renamed from: com.bumptech.glide.manager.s$d$a */
        public class a extends ConnectivityManager.NetworkCallback {

            /* renamed from: com.bumptech.glide.manager.s$d$a$a, reason: collision with other inner class name */
            public class RunnableC14418a implements Runnable {

                /* renamed from: a */
                public final /* synthetic */ boolean f7149a;

                public RunnableC14418a(boolean z10) {
                    this.f7149a = z10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.m9228a(this.f7149a);
                }
            }

            public a() {
            }

            /* renamed from: a */
            public void m9228a(boolean z10) {
                C12677l.m76278a();
                d dVar = d.this;
                boolean z11 = dVar.f7144a;
                dVar.f7144a = z10;
                if (z11 != z10) {
                    dVar.f7145b.mo8993a(z10);
                }
            }

            /* renamed from: b */
            public final void m9229b(boolean z10) {
                C12677l.m76297t(new RunnableC14418a(z10));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                m9229b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                m9229b(false);
            }
        }

        public d(C12671f.b<ConnectivityManager> bVar, InterfaceC1605c.a aVar) {
            this.f7146c = bVar;
            this.f7145b = aVar;
        }

        @Override // com.bumptech.glide.manager.C1621s.c
        @SuppressLint({"MissingPermission"})
        /* renamed from: a */
        public boolean mo9226a() {
            this.f7144a = this.f7146c.get().getActiveNetwork() != null;
            try {
                this.f7146c.get().registerDefaultNetworkCallback(this.f7147d);
                return true;
            } catch (RuntimeException e10) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e10);
                }
                return false;
            }
        }

        @Override // com.bumptech.glide.manager.C1621s.c
        /* renamed from: b */
        public void mo9227b() {
            this.f7146c.get().unregisterNetworkCallback(this.f7147d);
        }
    }

    public C1621s(Context context) {
        this.f7138a = new d(C12671f.m76261a(new a(context)), new b());
    }

    /* renamed from: a */
    public static C1621s m9220a(Context context) {
        if (f7137d == null) {
            synchronized (C1621s.class) {
                try {
                    if (f7137d == null) {
                        f7137d = new C1621s(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f7137d;
    }

    /* renamed from: b */
    public final void m9221b() {
        if (this.f7140c || this.f7139b.isEmpty()) {
            return;
        }
        this.f7140c = this.f7138a.mo9226a();
    }

    /* renamed from: c */
    public final void m9222c() {
        if (this.f7140c && this.f7139b.isEmpty()) {
            this.f7138a.mo9227b();
            this.f7140c = false;
        }
    }

    /* renamed from: d */
    public synchronized void m9223d(InterfaceC1605c.a aVar) {
        this.f7139b.add(aVar);
        m9221b();
    }

    /* renamed from: e */
    public synchronized void m9224e(InterfaceC1605c.a aVar) {
        this.f7139b.remove(aVar);
        m9222c();
    }
}
