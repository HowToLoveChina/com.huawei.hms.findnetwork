package p552pd;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import com.huawei.android.hicloud.task.simple.C3052k2;
import com.huawei.android.hicloud.task.simple.C3071p1;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import gp.C10028c;
import java.util.Timer;
import java.util.TimerTask;
import p015ak.C0224k0;
import p015ak.C0236u;
import p514o9.C11839m;
import p616rk.C12515a;

/* renamed from: pd.c */
/* loaded from: classes3.dex */
public class C12131c {

    /* renamed from: c */
    public Context f56271c;

    /* renamed from: d */
    public Bundle f56272d;

    /* renamed from: a */
    public int f56269a = 0;

    /* renamed from: b */
    public int f56270b = 0;

    /* renamed from: e */
    public boolean f56273e = false;

    /* renamed from: f */
    public b f56274f = new b();

    /* renamed from: g */
    public Timer f56275g = new Timer();

    /* renamed from: pd.c$b */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C12131c.this.f56273e = true;
            if (C12131c.this.f56271c == null) {
                C11839m.m70687e("OOBEInitTaskChecker", "context null");
                return;
            }
            Context applicationContext = C12131c.this.f56271c.getApplicationContext();
            try {
                C12131c.this.f56269a = Settings.Secure.getInt(applicationContext.getContentResolver(), C0224k0.f834b);
            } catch (Settings.SettingNotFoundException e10) {
                C11839m.m70687e("OOBEInitTaskChecker", "userSetupComplete not found error: " + e10.toString());
            }
            try {
                C12131c.this.f56270b = Settings.Secure.getInt(applicationContext.getContentResolver(), "device_provisioned");
            } catch (Settings.SettingNotFoundException e11) {
                C11839m.m70687e("OOBEInitTaskChecker", "deviceProvisioned not found error: " + e11.toString());
            }
            C11839m.m70688i("OOBEInitTaskChecker", "userSetupComplete = " + C12131c.this.f56269a + " ,deviceProvisioned = " + C12131c.this.f56270b);
            if (C12131c.this.f56269a == 1 && C12131c.this.f56270b == 1) {
                C12131c c12131c = C12131c.this;
                c12131c.m72747l(c12131c.f56271c);
                C12131c.this.f56273e = false;
                cancel();
                C12131c c12131c2 = C12131c.this;
                c12131c2.m72748m(c12131c2.f56271c);
            }
        }
    }

    /* renamed from: pd.c$c */
    public static class c {

        /* renamed from: a */
        public static final C12131c f56277a = new C12131c();
    }

    /* renamed from: j */
    public static C12131c m72744j() {
        return c.f56277a;
    }

    /* renamed from: i */
    public final void m72745i() {
        C0236u.m1655f(true);
        if (this.f56273e) {
            return;
        }
        try {
            this.f56275g.schedule(this.f56274f, 0L, 10000L);
        } catch (RuntimeException e10) {
            C11839m.m70687e("OOBEInitTaskChecker", "time schedule error: " + e10.getMessage());
        }
    }

    /* renamed from: k */
    public void m72746k(Context context, Bundle bundle) {
        this.f56271c = context;
        this.f56272d = bundle;
        m72745i();
    }

    /* renamed from: l */
    public final void m72747l(Context context) {
        if (this.f56272d == null) {
            C11839m.m70687e("OOBEInitTaskChecker", "initOOBEtask mSwitchStatusBundle null");
            return;
        }
        boolean zM62388s = C10028c.m62182c0().m62388s("recovery by backup");
        C11839m.m70688i("OOBEInitTaskChecker", "enterAfterRecovery=" + zM62388s);
        if (zM62388s) {
            return;
        }
        C12515a.m75110o().m75172d(new C3071p1(context.getApplicationContext(), this.f56272d));
    }

    /* renamed from: m */
    public final void m72748m(Context context) {
        if (RestoreNotifyUtil.getInstance().getOOBEFishTime(context) > 0) {
            C11839m.m70688i("OOBEInitTaskChecker", "have oobe notified");
            return;
        }
        RestoreNotifyUtil.getInstance().saveOOBEState(context);
        RestoreNotifyUtil.getInstance().saveOOBEFinishTime(context, System.currentTimeMillis());
        C12515a.m75110o().m75175e(new C3052k2(context, 1), false);
    }
}
