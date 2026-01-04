package p394jf;

import android.content.Context;
import android.content.IntentFilter;
import com.huawei.android.remotecontrol.lockscreen.UnlockScreenReceiverBroadcast;
import p015ak.C0209d;
import p521og.C11877j;
import p809yg.C13981a;

/* renamed from: jf.f */
/* loaded from: classes4.dex */
public class C10818f {

    /* renamed from: c */
    public static final C10818f f51613c = new C10818f();

    /* renamed from: d */
    public static boolean f51614d;

    /* renamed from: a */
    public final UnlockScreenReceiverBroadcast f51615a = new UnlockScreenReceiverBroadcast();

    /* renamed from: b */
    public boolean f51616b = false;

    /* renamed from: a */
    public static C10818f m65874a() {
        return f51613c;
    }

    /* renamed from: b */
    public void m65875b(Context context) {
        C13981a.m83989i("UnlockScreenReceiver", "init");
        if (!C0209d.m1309t1(context)) {
            C13981a.m83989i("UnlockScreenReceiver", "not in main process");
        } else if (C11877j.m71236U(context)) {
            m65877d(context);
        } else {
            m65880g(false);
        }
    }

    /* renamed from: c */
    public boolean m65876c() {
        return f51614d;
    }

    /* renamed from: d */
    public final synchronized void m65877d(Context context) {
        C13981a.m83989i("UnlockScreenReceiver", "register");
        if (context == null) {
            C13981a.m83988e("UnlockScreenReceiver", "register context null");
        } else {
            if (this.f51616b) {
                return;
            }
            this.f51616b = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.registerReceiver(this.f51615a, intentFilter);
        }
    }

    /* renamed from: e */
    public final synchronized void m65878e(Context context) {
        C13981a.m83989i("UnlockScreenReceiver", "release");
        if (this.f51616b) {
            this.f51616b = false;
            try {
                context.unregisterReceiver(this.f51615a);
            } catch (Exception unused) {
                C13981a.m83988e("UnlockScreenReceiver", "UnlockScreenReceiver unregisterReceiver exception");
            }
        }
    }

    /* renamed from: f */
    public void m65879f(Context context, boolean z10) {
        C11877j.m71253b1(context, Boolean.valueOf(z10));
        if (z10) {
            m65877d(context);
            return;
        }
        m65878e(context);
        C11877j.m71254c(context, "user_lock_message");
        C11877j.m71254c(context, "user_lock_phone");
        C11877j.m71254c(context, "user_lock_email");
    }

    /* renamed from: g */
    public void m65880g(boolean z10) {
        f51614d = z10;
    }
}
