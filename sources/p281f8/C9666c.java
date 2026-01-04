package p281f8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.android.hicloud.album.service.p075vo.Version;
import com.huawei.secure.android.common.intent.SafeIntent;
import p015ak.C0209d;
import p031b7.C1120a;
import p664u0.C13108a;

/* renamed from: f8.c */
/* loaded from: classes2.dex */
public final class C9666c {

    /* renamed from: a */
    public a f47840a;

    /* renamed from: b */
    public b f47841b;

    /* renamed from: c */
    public C9664a f47842c;

    /* renamed from: d */
    public C9667d f47843d;

    /* renamed from: e */
    public C9674k f47844e;

    /* renamed from: f */
    public long f47845f;

    /* renamed from: g */
    public Context f47846g;

    /* renamed from: f8.c$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6676e("CommonReceiver", "Intent is null!");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            C1120a.m6675d("CommonReceiver", "onReceive: " + action);
            if (action != null) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                    C9666c.this.f47843d.m60370c(context, action);
                    return;
                }
                if ("android.intent.action.BATTERY_CHANGED".equals(action) || "android.intent.action.SCREEN_OFF".equals(action) || "android.intent.action.SCREEN_ON".equals(action)) {
                    C9666c.this.f47842c.m60343d(context, safeIntent, action);
                    return;
                }
                C1120a.m6678w("CommonReceiver", "not support action: " + action);
            }
        }
    }

    /* renamed from: f8.c$b */
    public class b extends BroadcastReceiver {
        public b() {
        }

        /* renamed from: a */
        public final void m60367a(SafeIntent safeIntent) {
            if (safeIntent == null) {
                C1120a.m6678w("LocalReceiver", "processMobileSwitch intent is null");
                return;
            }
            boolean booleanExtra = safeIntent.getBooleanExtra("MobileSwitch", false);
            C1120a.m6677i("LocalReceiver", "processMobileSwitch: " + booleanExtra);
            C9666c.this.f47844e.m60400F(booleanExtra ^ true);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C1120a.m6676e("LocalReceiver", "Intent is null!");
                return;
            }
            SafeIntent safeIntent = new SafeIntent(intent);
            String action = safeIntent.getAction();
            C1120a.m6675d("LocalReceiver", "onReceive: " + action);
            if (action != null) {
                if ("com.huawei.cg.action.SDK_NET_CHANGE".equals(action)) {
                    C9666c.this.f47843d.m60370c(context, action);
                    return;
                }
                if ("com.huawei.cg.action.SDK_BATTERY_CHANGE".equals(action)) {
                    C9666c.this.f47842c.m60340a(safeIntent);
                    return;
                }
                if ("com.huawei.cg.action.MOBILE_SWITCH".equals(action)) {
                    m60367a(safeIntent);
                    return;
                }
                if ("com.huawei.cg.action.MOBILE_SAVE_ORIGINAL_ACTION".equals(action)) {
                    C9666c.this.m60362l(safeIntent);
                    return;
                }
                if ("com.huawei.cg.action.CHECK_WIFI_ENV".equals(action)) {
                    C9666c.this.f47845f = System.currentTimeMillis();
                    C9666c.this.f47843d.m60370c(context, action);
                } else {
                    C1120a.m6678w("LocalReceiver", "not support action: " + action);
                }
            }
        }
    }

    public C9666c(Context context, C9674k c9674k) {
        this.f47846g = context;
        this.f47844e = c9674k;
        m60359i();
    }

    /* renamed from: f */
    public void m60356f() {
        if (m60358h()) {
            C13108a.m78878b(this.f47846g).m78881d(new Intent("com.huawei.cg.action.CHECK_WIFI_ENV"));
        }
    }

    /* renamed from: g */
    public void m60357g() {
        C1120a.m6677i("CommonReceiverManager", "destroy");
        m60366p(this.f47846g);
    }

    /* renamed from: h */
    public final boolean m60358h() {
        return System.currentTimeMillis() - this.f47845f > 12000;
    }

    /* renamed from: i */
    public final void m60359i() {
        C1120a.m6677i("CommonReceiverManager", "init");
        this.f47840a = new a();
        this.f47841b = new b();
        C9667d c9667d = new C9667d(this.f47846g, this.f47844e);
        this.f47843d = c9667d;
        c9667d.m60369a();
        C9664a c9664a = new C9664a(this.f47846g, this.f47844e);
        this.f47842c = c9664a;
        c9664a.m60342c();
        this.f47845f = System.currentTimeMillis();
        C9673j.m60393e(this.f47846g);
    }

    /* renamed from: j */
    public void m60360j() {
        this.f47842c.m60342c();
    }

    /* renamed from: k */
    public void m60361k() {
        m60364n(this.f47846g);
    }

    /* renamed from: l */
    public final void m60362l(SafeIntent safeIntent) {
        if (safeIntent.getBooleanExtra("mobile_save_original_force", false)) {
            this.f47844e.m60395A(63);
        }
    }

    /* renamed from: m */
    public final void m60363m(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.cg.action.MOBILE_SWITCH");
        intentFilter.addAction("com.huawei.cg.action.MOBILE_SAVE_ORIGINAL_ACTION");
        intentFilter.addAction("com.huawei.cg.action.SDK_NET_CHANGE");
        intentFilter.addAction("com.huawei.cg.action.SDK_BATTERY_CHANGE");
        intentFilter.addAction("com.huawei.cg.action.CHECK_WIFI_ENV");
        C13108a.m78878b(context).m78880c(this.f47841b, intentFilter);
    }

    /* renamed from: n */
    public final void m60364n(Context context) {
        if (Version.isSupportMemoryOptimize()) {
            this.f47844e.m60427q(16, !C0209d.m1254f2(context));
            this.f47844e.m60427q(2048, !C0209d.m1333z1(context));
            this.f47844e.m60427q(4096, C9672i.m60383c());
        } else {
            m60365o(context);
        }
        m60363m(context);
    }

    /* renamed from: o */
    public final void m60365o(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(this.f47840a, intentFilter, "com.huawei.cg.permission.SERVICE", null);
    }

    /* renamed from: p */
    public final void m60366p(Context context) {
        try {
            C13108a.m78878b(context).m78883f(this.f47841b);
        } catch (Exception unused) {
            C1120a.m6676e("CommonReceiverManager", "unregisterReceiver localReceiver error");
        }
        try {
            context.unregisterReceiver(this.f47840a);
        } catch (Exception unused2) {
            C1120a.m6676e("CommonReceiverManager", "unregisterReceiver commonReceiver error");
        }
    }
}
