package com.huawei.openalliance.p169ad.inter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.openalliance.p169ad.AbstractC7185ho;
import com.huawei.openalliance.p169ad.C6982bz;
import com.huawei.openalliance.p169ad.constant.Constants;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.openalliance.ad.inter.c */
/* loaded from: classes2.dex */
public class C7288c {

    /* renamed from: b */
    private static C7288c f33531b;

    /* renamed from: c */
    private static final byte[] f33532c = new byte[0];

    /* renamed from: d */
    private Context f33534d;

    /* renamed from: f */
    private a f33536f;

    /* renamed from: a */
    private boolean f33533a = false;

    /* renamed from: e */
    private CopyOnWriteArrayList<WeakReference<b>> f33535e = new CopyOnWriteArrayList<>();

    /* renamed from: com.huawei.openalliance.ad.inter.c$a */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC7185ho.m43820b("ExSplashStartReceiver", "onReceive");
            if (intent == null) {
                return;
            }
            try {
                if (Constants.ACTION_EXSPLASH_BEGIN.equals(intent.getAction())) {
                    C7288c.this.f33533a = true;
                    C7288c.this.m44227d();
                    context.removeStickyBroadcast(intent);
                }
            } catch (Throwable th2) {
                AbstractC7185ho.m43824c("ExSplashStartReceiver", "ExSplashBeginReceiver err: %s", th2.getClass().getSimpleName());
            }
        }
    }

    /* renamed from: com.huawei.openalliance.ad.inter.c$b */
    public interface b {
        /* renamed from: a */
        void mo44234a();
    }

    private C7288c(Context context) {
        this.f33534d = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C7288c m44224a(Context context) {
        C7288c c7288c;
        synchronized (f33532c) {
            try {
                if (f33531b == null) {
                    f33531b = new C7288c(context);
                }
                c7288c = f33531b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return c7288c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m44227d() {
        if (this.f33535e.isEmpty()) {
            return;
        }
        Iterator<WeakReference<b>> it = this.f33535e.iterator();
        while (it.hasNext()) {
            WeakReference<b> next = it.next();
            if (next.get() != null) {
                next.get().mo44234a();
            }
        }
    }

    /* renamed from: b */
    public void m44231b() {
        String str;
        try {
            m44233c();
            if (!C6982bz.m41152b(this.f33534d)) {
                AbstractC7185ho.m43823c("ExSplashStartReceiver", "not inner device, no need to register");
                return;
            }
            IntentFilter intentFilter = new IntentFilter(Constants.ACTION_EXSPLASH_BEGIN);
            Intent intentM47537a = AbstractC7741ao.m47537a(this.f33534d, null, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
            if (intentM47537a != null && intentM47537a.getAction() != null && intentM47537a.getAction().equals(Constants.ACTION_EXSPLASH_BEGIN)) {
                AbstractC7185ho.m43820b("ExSplashStartReceiver", "isExSplashStart");
                this.f33533a = true;
                this.f33534d.removeStickyBroadcast(intentM47537a);
            }
            if (this.f33536f == null) {
                this.f33536f = new a();
            }
            AbstractC7185ho.m43820b("ExSplashStartReceiver", "register receiver");
            AbstractC7741ao.m47537a(this.f33534d, this.f33536f, intentFilter, Constants.PERMISSION_PPS_DOWNLOAD, null);
        } catch (IllegalStateException unused) {
            str = "registerReceiver IllegalStateException";
            AbstractC7185ho.m43823c("ExSplashStartReceiver", str);
        } catch (Throwable unused2) {
            str = "registerReceiver Exception";
            AbstractC7185ho.m43823c("ExSplashStartReceiver", str);
        }
    }

    /* renamed from: c */
    public void m44233c() {
        String str;
        try {
            AbstractC7185ho.m43820b("ExSplashStartReceiver", "unregister receiver");
            a aVar = this.f33536f;
            if (aVar != null) {
                this.f33534d.unregisterReceiver(aVar);
                this.f33536f = null;
            }
        } catch (IllegalStateException unused) {
            str = "unregisterReceiver IllegalStateException";
            AbstractC7185ho.m43823c("ExSplashStartReceiver", str);
        } catch (Throwable unused2) {
            str = "unregisterReceiver exception";
            AbstractC7185ho.m43823c("ExSplashStartReceiver", str);
        }
    }

    /* renamed from: a */
    public void m44228a(b bVar) {
        if (bVar != null) {
            this.f33535e.add(new WeakReference<>(bVar));
        }
    }

    /* renamed from: b */
    public void m44232b(b bVar) {
        try {
            CopyOnWriteArrayList<WeakReference<b>> copyOnWriteArrayList = this.f33535e;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                Iterator<WeakReference<b>> it = this.f33535e.iterator();
                while (it.hasNext()) {
                    WeakReference<b> next = it.next();
                    b bVar2 = next.get();
                    if (bVar2 == null || bVar2 == bVar) {
                        this.f33535e.remove(next);
                    }
                }
            }
        } catch (Throwable th2) {
            AbstractC7185ho.m43821b("ExSplashStartReceiver", "removeStartListener err: %s", th2.getClass().getSimpleName());
        }
    }

    /* renamed from: a */
    public void m44229a(boolean z10) {
        this.f33533a = z10;
    }

    /* renamed from: a */
    public boolean m44230a() {
        return this.f33533a;
    }
}
