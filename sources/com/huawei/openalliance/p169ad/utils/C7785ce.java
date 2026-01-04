package com.huawei.openalliance.p169ad.utils;

import android.content.Context;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C7124fh;
import com.huawei.openalliance.p169ad.InterfaceC7146gc;
import com.huawei.openalliance.p169ad.inter.PlacementAdLoader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.huawei.openalliance.ad.utils.ce */
/* loaded from: classes2.dex */
public class C7785ce {

    /* renamed from: b */
    private static C7785ce f35976b;

    /* renamed from: c */
    private static final byte[] f35977c = new byte[0];

    /* renamed from: i */
    private static final Set<String> f35978i = new HashSet();

    /* renamed from: k */
    private static final byte[] f35979k = new byte[0];

    /* renamed from: a */
    private Context f35980a;

    /* renamed from: d */
    private TimerTask f35981d;

    /* renamed from: e */
    private Timer f35982e;

    /* renamed from: f */
    private InterfaceC7146gc f35983f;

    /* renamed from: g */
    private long f35984g;

    /* renamed from: h */
    private int f35985h = 4;

    /* renamed from: j */
    private boolean f35986j = false;

    /* renamed from: com.huawei.openalliance.ad.utils.ce$a */
    public static class a extends TimerTask {

        /* renamed from: a */
        private Context f35987a;

        /* renamed from: b */
        private String[] f35988b;

        /* renamed from: c */
        private int f35989c;

        public a(Context context, String[] strArr, int i10) {
            this.f35987a = context;
            this.f35988b = (String[]) Arrays.copyOf(strArr, strArr.length);
            this.f35989c = i10;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            AbstractC7185ho.m43817a("PlacementRequestTimer", "task excute, preload placement ad");
            new PlacementAdLoader.Builder(this.f35987a).setAutoCache(true).setDeviceType(this.f35989c).setAdIds(this.f35988b).setTest(false).build().preLoadAds();
            C7785ce.m47890a(this.f35987a).m47893a(AbstractC7741ao.m47566c());
        }
    }

    private C7785ce(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f35980a = applicationContext;
        this.f35983f = C7124fh.m43316b(applicationContext);
    }

    /* renamed from: a */
    public static C7785ce m47890a(Context context) {
        C7785ce c7785ce;
        synchronized (f35977c) {
            try {
                if (f35976b == null) {
                    f35976b = new C7785ce(context);
                }
                c7785ce = f35976b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7785ce;
    }

    /* renamed from: b */
    public void m47895b() {
        AbstractC7185ho.m43817a("PlacementRequestTimer", "stop timer");
        Timer timer = this.f35982e;
        if (timer != null) {
            timer.cancel();
        }
        this.f35981d = null;
        this.f35982e = null;
        synchronized (f35979k) {
            this.f35986j = false;
        }
    }

    /* renamed from: c */
    public boolean m47896c() {
        boolean z10;
        synchronized (f35979k) {
            z10 = this.f35986j;
        }
        return z10;
    }

    /* renamed from: a */
    public void m47891a() {
        AbstractC7185ho.m43817a("PlacementRequestTimer", "start timer");
        synchronized (f35979k) {
            try {
                if (this.f35986j) {
                    AbstractC7185ho.m43823c("PlacementRequestTimer", "timer already running");
                    return;
                }
                this.f35986j = true;
                int iMo43411bl = this.f35983f.mo43411bl();
                AbstractC7185ho.m43818a("PlacementRequestTimer", "interval:%d", Integer.valueOf(iMo43411bl));
                if (iMo43411bl <= 0) {
                    return;
                }
                if (this.f35982e == null) {
                    this.f35982e = new Timer();
                }
                if (this.f35981d == null) {
                    this.f35981d = new a(this.f35980a, (String[]) f35978i.toArray(new String[0]), this.f35985h);
                }
                int i10 = iMo43411bl * 60000;
                long jM47566c = AbstractC7741ao.m47566c() - this.f35984g;
                long j10 = i10;
                long j11 = jM47566c < j10 ? j10 - jM47566c : 0L;
                AbstractC7185ho.m43818a("PlacementRequestTimer", "schedule task, delay:%s,intervalMills:%d", Long.valueOf(j11), Integer.valueOf(i10));
                this.f35982e.schedule(this.f35981d, j11, j10);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m47892a(int i10) {
        this.f35985h = i10;
    }

    /* renamed from: a */
    public void m47893a(long j10) {
        this.f35984g = j10;
    }

    /* renamed from: a */
    public void m47894a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        for (String str : strArr) {
            f35978i.add(str);
        }
    }
}
