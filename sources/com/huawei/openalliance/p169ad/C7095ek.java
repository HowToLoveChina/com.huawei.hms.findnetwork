package com.huawei.openalliance.p169ad;

import android.content.Context;
import android.util.Pair;
import com.huawei.openalliance.p169ad.beans.metadata.App;
import com.huawei.openalliance.p169ad.beans.metadata.CellInfo;
import com.huawei.openalliance.p169ad.beans.metadata.Device;
import com.huawei.openalliance.p169ad.beans.metadata.Network;
import com.huawei.openalliance.p169ad.utils.AbstractC7834m;
import com.huawei.openalliance.p169ad.utils.C7775bv;

/* renamed from: com.huawei.openalliance.ad.ek */
/* loaded from: classes8.dex */
public class C7095ek {

    /* renamed from: a */
    private static C7095ek f32679a;

    /* renamed from: b */
    private static final byte[] f32680b = new byte[0];

    /* renamed from: c */
    private final byte[] f32681c = new byte[0];

    /* renamed from: d */
    private Network f32682d;

    /* renamed from: e */
    private InterfaceC7146gc f32683e;

    /* renamed from: f */
    private App f32684f;

    /* renamed from: g */
    private Device f32685g;

    /* renamed from: h */
    private Pair<Integer, Pair<String, String>> f32686h;

    /* renamed from: i */
    private Context f32687i;

    /* renamed from: com.huawei.openalliance.ad.ek$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f32688a;

        public AnonymousClass1(boolean z10) {
            z = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            C7095ek.this.m42938a(new App(C7095ek.this.f32687i));
            Pair<Integer, Pair<String, String>> pairM47832f = C7775bv.m47832f(C7095ek.this.f32687i);
            C7095ek.this.m42937a(pairM47832f);
            Network network = new Network(C7095ek.this.f32687i, false);
            if (z && pairM47832f != null) {
                CellInfo cellInfo = new CellInfo();
                cellInfo.m39877a(pairM47832f);
                network.m40360b().add(cellInfo);
            }
            C7095ek.this.m42940a(network);
            C7095ek.this.m42939a(new Device(C7095ek.this.f32687i, z));
        }
    }

    private C7095ek(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f32687i = applicationContext;
        this.f32683e = C7124fh.m43316b(applicationContext);
    }

    /* renamed from: b */
    public App m42941b() {
        App app;
        synchronized (this.f32681c) {
            app = this.f32684f;
        }
        return app;
    }

    /* renamed from: c */
    public Device m42942c() {
        Device device;
        synchronized (this.f32681c) {
            device = this.f32685g;
        }
        return device;
    }

    /* renamed from: d */
    public Pair<Integer, Pair<String, String>> m42943d() {
        Pair<Integer, Pair<String, String>> pair;
        synchronized (this.f32681c) {
            pair = this.f32686h;
        }
        return pair;
    }

    /* renamed from: e */
    public void m42944e() {
        AbstractC7834m.m48489i(new Runnable() { // from class: com.huawei.openalliance.ad.ek.1

            /* renamed from: a */
            final /* synthetic */ boolean f32688a;

            public AnonymousClass1(boolean z10) {
                z = z10;
            }

            @Override // java.lang.Runnable
            public void run() {
                C7095ek.this.m42938a(new App(C7095ek.this.f32687i));
                Pair<Integer, Pair<String, String>> pairM47832f = C7775bv.m47832f(C7095ek.this.f32687i);
                C7095ek.this.m42937a(pairM47832f);
                Network network = new Network(C7095ek.this.f32687i, false);
                if (z && pairM47832f != null) {
                    CellInfo cellInfo = new CellInfo();
                    cellInfo.m39877a(pairM47832f);
                    network.m40360b().add(cellInfo);
                }
                C7095ek.this.m42940a(network);
                C7095ek.this.m42939a(new Device(C7095ek.this.f32687i, z));
            }
        });
    }

    /* renamed from: f */
    public void m42945f() {
        m42937a((Pair<Integer, Pair<String, String>>) null);
    }

    /* renamed from: b */
    private static C7095ek m42935b(Context context) {
        C7095ek c7095ek;
        synchronized (f32680b) {
            try {
                if (f32679a == null) {
                    f32679a = new C7095ek(context);
                }
                c7095ek = f32679a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7095ek;
    }

    /* renamed from: a */
    public Network m42936a() {
        Network network;
        synchronized (this.f32681c) {
            network = this.f32682d;
        }
        return network;
    }

    /* renamed from: a */
    public static C7095ek m42934a(Context context) {
        return m42935b(context);
    }

    /* renamed from: a */
    public void m42937a(Pair<Integer, Pair<String, String>> pair) {
        synchronized (this.f32681c) {
            this.f32686h = pair;
        }
    }

    /* renamed from: a */
    public void m42938a(App app) {
        synchronized (this.f32681c) {
            this.f32684f = app;
        }
    }

    /* renamed from: a */
    public void m42939a(Device device) {
        synchronized (this.f32681c) {
            this.f32685g = device;
        }
    }

    /* renamed from: a */
    public void m42940a(Network network) {
        synchronized (this.f32681c) {
            this.f32682d = network;
        }
    }
}
