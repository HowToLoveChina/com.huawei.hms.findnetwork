package p394jf;

import android.content.Context;
import android.content.IntentFilter;
import com.huawei.android.remotecontrol.lockscreen.LockReceiver;
import p521og.C11877j;
import p664u0.C13108a;
import p809yg.C13981a;

/* renamed from: jf.b */
/* loaded from: classes4.dex */
public class C10814b {

    /* renamed from: d */
    public static final C10814b f51609d = new C10814b();

    /* renamed from: a */
    public boolean f51610a = false;

    /* renamed from: b */
    public LockReceiver f51611b;

    /* renamed from: c */
    public LockReceiver f51612c;

    /* renamed from: a */
    public static C10814b m65858a() {
        return f51609d;
    }

    /* renamed from: b */
    public void m65859b(Context context) {
        if (C11877j.m71236U(context)) {
            m65860c(context, C11877j.m71232S(context, "user_lock_message"), C11877j.m71232S(context, "user_lock_phone"), C11877j.m71232S(context, "user_lock_email"));
        }
    }

    /* renamed from: c */
    public synchronized void m65860c(Context context, String str, String str2, String str3) {
        C13981a.m83989i("LockReceiverManager", "registerLockReceiver");
        this.f51611b = LockReceiver.m26251a(str, str2, str3);
        this.f51612c = LockReceiver.m26251a(str, str2, str3);
        if (context == null) {
            C13981a.m83988e("LockReceiverManager", "registerLockReceiver context null");
            return;
        }
        if (this.f51610a) {
            C13981a.m83989i("LockReceiverManager", "has register");
            return;
        }
        this.f51610a = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        context.registerReceiver(this.f51611b, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.huawei.android.remotecontrol.UNREGISTER_ACTION_SCREEN_ON");
        intentFilter2.addAction("com.huawei.android.remotecontrol.ACTION_START_LOCKACTIVITY");
        C13108a.m78878b(context).m78880c(this.f51612c, intentFilter2);
    }

    /* renamed from: d */
    public synchronized void m65861d(Context context) {
        C13981a.m83989i("LockReceiverManager", "unregisterLockReceiver");
        if (context == null) {
            C13981a.m83988e("LockReceiverManager", "unregisterLockReceiver context null");
            return;
        }
        if (!this.f51610a) {
            C13981a.m83989i("LockReceiverManager", "has register");
            return;
        }
        this.f51610a = false;
        try {
            LockReceiver lockReceiver = this.f51611b;
            if (lockReceiver != null) {
                context.unregisterReceiver(lockReceiver);
            }
            if (this.f51612c != null) {
                C13108a.m78878b(context).m78883f(this.f51612c);
            }
        } catch (Exception unused) {
            C13981a.m83988e("LockReceiverManager", "UnlockScreenReceiver unregisterReceiver exception");
        }
    }
}
