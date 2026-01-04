package td;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.android.hicloud.p088ui.ScrollToTopListener;
import p514o9.C11839m;
import p664u0.C13108a;

/* renamed from: td.a */
/* loaded from: classes3.dex */
public class C13008a {

    /* renamed from: c */
    public static final C13008a f59260c = new C13008a();

    /* renamed from: a */
    public BroadcastReceiver f59261a;

    /* renamed from: b */
    public ScrollToTopListener f59262b;

    /* renamed from: td.a$a */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent == null) {
                    C11839m.m70687e("ScrollToTopManager", "ScrollToTop onReceive intent null");
                } else if ("com.huawei.intent.action.CLICK_STATUSBAR".equals(intent.getAction())) {
                    C13008a.this.m78303d();
                }
            } catch (Exception e10) {
                C11839m.m70687e("ScrollToTopManager", "ScrollToTop onReceive exception:" + e10.toString());
            }
        }
    }

    /* renamed from: b */
    public static C13008a m78300b() {
        return f59260c;
    }

    /* renamed from: a */
    public synchronized void m78301a(Context context) {
        if (this.f59261a != null) {
            try {
                C13108a.m78878b(context).m78883f(this.f59261a);
            } catch (Exception e10) {
                C11839m.m70687e("ScrollToTopManager", "unregisterReceiver failed:" + e10.toString());
            }
            this.f59261a = null;
        }
    }

    /* renamed from: c */
    public synchronized void m78302c(Context context) {
        this.f59261a = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.intent.action.CLICK_STATUSBAR");
        context.registerReceiver(this.f59261a, intentFilter, "huawei.permission.CLICK_STATUSBAR_BROADCAST", null);
    }

    /* renamed from: d */
    public void m78303d() {
        ScrollToTopListener scrollToTopListener = this.f59262b;
        if (scrollToTopListener != null) {
            scrollToTopListener.mo18481H();
        }
    }

    /* renamed from: e */
    public synchronized void m78304e(ScrollToTopListener scrollToTopListener) {
        this.f59262b = scrollToTopListener;
    }

    /* renamed from: f */
    public synchronized void m78305f(ScrollToTopListener scrollToTopListener) {
        if (scrollToTopListener == this.f59262b) {
            this.f59262b = null;
        }
    }
}
