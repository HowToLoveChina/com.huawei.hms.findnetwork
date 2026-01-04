package com.huawei.openalliance.p169ad;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.openalliance.p169ad.utils.AbstractC7741ao;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.openalliance.ad.ll */
/* loaded from: classes8.dex */
public class C7402ll {

    /* renamed from: b */
    private static C7402ll f34419b;

    /* renamed from: d */
    private Context f34421d;

    /* renamed from: e */
    private InterfaceC7146gc f34422e;

    /* renamed from: f */
    private Map<String, Class<? extends InterfaceC7401lk>> f34423f = new HashMap();

    /* renamed from: g */
    private BroadcastReceiver f34424g = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.ll.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || TextUtils.isEmpty(intent.getAction())) {
                AbstractC7185ho.m43817a("NotificationActionManager", "intent or action maybe empty.");
            } else {
                AbstractC7185ho.m43818a("NotificationActionManager", " action name:%s", intent.getAction());
                C7402ll.this.m45600a(context, intent);
            }
        }
    };

    /* renamed from: a */
    private static final byte[] f34418a = new byte[0];

    /* renamed from: c */
    private static final byte[] f34420c = new byte[0];

    private C7402ll(Context context) {
        this.f34421d = context.getApplicationContext();
        this.f34422e = C7124fh.m43316b(context);
    }

    /* renamed from: a */
    public static C7402ll m45597a(Context context) {
        synchronized (f34418a) {
            try {
                if (f34419b == null) {
                    f34419b = new C7402ll(context);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f34419b;
    }

    /* renamed from: b */
    private void m45598b() {
        this.f34423f.put("com.huawei.ads.notification.action.CLICK1", C7387lg.class);
        this.f34423f.put("com.huawei.ads.notification.action.DELETE1", C7389li.class);
    }

    /* renamed from: c */
    public boolean m45603c(String str) {
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("NotificationActionManager", "isPackageExist packageName is Empty.");
            return false;
        }
        synchronized (f34420c) {
            try {
                Set<String> setMo43433cd = this.f34422e.mo43433cd();
                if (setMo43433cd == null) {
                    return false;
                }
                return setMo43433cd.contains(str);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: a */
    public void m45599a() {
        String str;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.ads.notification.action.DELETE");
            AbstractC7741ao.m47536a(this.f34421d, this.f34424g, intentFilter);
        } catch (IllegalStateException unused) {
            str = "init IllegalStateException";
            AbstractC7185ho.m43823c("NotificationActionManager", str);
            m45598b();
        } catch (Exception unused2) {
            str = "init Exception";
            AbstractC7185ho.m43823c("NotificationActionManager", str);
            m45598b();
        }
        m45598b();
    }

    /* renamed from: b */
    public void m45602b(String str) {
        Set<String> setMo43433cd;
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("NotificationActionManager", "remove packageName is Empty.");
            return;
        }
        synchronized (f34420c) {
            try {
                setMo43433cd = this.f34422e.mo43433cd();
            } finally {
            }
            if (setMo43433cd != null) {
                setMo43433cd.remove(str);
                C7124fh.m43316b(this.f34421d).mo43372b(setMo43433cd);
            }
        }
    }

    /* renamed from: a */
    public void m45600a(Context context, Intent intent) {
        StringBuilder sb2;
        String str;
        String str2;
        try {
            int intExtra = intent.getIntExtra("type", 1);
            String str3 = intent.getAction() + intExtra;
            Class<? extends InterfaceC7401lk> cls = this.f34423f.get(str3);
            if (cls != null) {
                try {
                    cls.newInstance().mo45485a(this.f34421d, intent);
                } catch (InstantiationException unused) {
                    str2 = "InstantiationException can not instantiation notification Action";
                    AbstractC7185ho.m43823c("NotificationActionManager", str2);
                } catch (Throwable unused2) {
                    str2 = "Throwable can not instantiation notification Action";
                    AbstractC7185ho.m43823c("NotificationActionManager", str2);
                }
            } else {
                AbstractC7185ho.m43820b("NotificationActionManager", "can not find action key:" + str3);
            }
        } catch (IllegalStateException e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "actionReceiver.onReceive IllegalStateException:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("NotificationActionManager", sb2.toString());
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str = "actionReceiver.onReceive Exception:";
            sb2.append(str);
            sb2.append(e.getClass().getSimpleName());
            AbstractC7185ho.m43823c("NotificationActionManager", sb2.toString());
        }
    }

    /* renamed from: a */
    public void m45601a(String str) {
        Set<String> setMo43433cd;
        if (TextUtils.isEmpty(str)) {
            AbstractC7185ho.m43820b("NotificationActionManager", "add packageName is Empty.");
            return;
        }
        synchronized (f34420c) {
            try {
                setMo43433cd = this.f34422e.mo43433cd();
            } finally {
            }
            if (setMo43433cd != null) {
                setMo43433cd.add(str);
                C7124fh.m43316b(this.f34421d).mo43372b(setMo43433cd);
            }
        }
    }
}
