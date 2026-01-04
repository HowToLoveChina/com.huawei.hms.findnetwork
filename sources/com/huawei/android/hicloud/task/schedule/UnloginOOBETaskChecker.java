package com.huawei.android.hicloud.task.schedule;

import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import com.huawei.android.hicloud.task.simple.C3052k2;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import gp.C10028c;
import java.util.Timer;
import java.util.TimerTask;
import je.C10806t;
import p015ak.C0209d;
import p015ak.C0224k0;
import p514o9.C11839m;
import p616rk.C12515a;
import p681uj.C13195l;
import p709vj.InterfaceC13449b;
import p709vj.InterfaceC13456i;
import p742wj.C13612b;

/* loaded from: classes3.dex */
public class UnloginOOBETaskChecker implements InterfaceC13449b {

    /* renamed from: f */
    public static boolean f13069f = false;

    /* renamed from: c */
    public Context f13072c;

    /* renamed from: a */
    public int f13070a = 0;

    /* renamed from: b */
    public int f13071b = 0;

    /* renamed from: d */
    public C3004b f13073d = new C3004b(this, null);

    /* renamed from: e */
    public Timer f13074e = new Timer();

    /* renamed from: com.huawei.android.hicloud.task.schedule.UnloginOOBETaskChecker$a */
    public class C3003a implements InterfaceC13456i {
        public C3003a() {
        }

        @Override // p709vj.InterfaceC13456i
        public void loginResult(boolean z10) {
            UnloginOOBETaskChecker.this.m18053k(z10);
        }
    }

    /* renamed from: com.huawei.android.hicloud.task.schedule.UnloginOOBETaskChecker$b */
    public class C3004b extends TimerTask {
        public C3004b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            UnloginOOBETaskChecker.m18051m(true);
            if (UnloginOOBETaskChecker.this.f13072c == null) {
                C11839m.m70687e("UnloginOOBETaskChecker", "context null");
                return;
            }
            Context applicationContext = UnloginOOBETaskChecker.this.f13072c.getApplicationContext();
            try {
                UnloginOOBETaskChecker.this.f13070a = Settings.Secure.getInt(applicationContext.getContentResolver(), C0224k0.f834b);
            } catch (Settings.SettingNotFoundException e10) {
                C11839m.m70687e("UnloginOOBETaskChecker", "userSetupComplete not found error: " + e10.toString());
            }
            try {
                UnloginOOBETaskChecker.this.f13071b = Settings.Secure.getInt(applicationContext.getContentResolver(), "device_provisioned");
            } catch (Settings.SettingNotFoundException e11) {
                C11839m.m70687e("UnloginOOBETaskChecker", "deviceProvisioned not found error: " + e11.toString());
            }
            C11839m.m70688i("UnloginOOBETaskChecker", "userSetupComplete = " + UnloginOOBETaskChecker.this.f13070a + " ,deviceProvisioned = " + UnloginOOBETaskChecker.this.f13071b);
            if (UnloginOOBETaskChecker.this.f13070a == 1 && UnloginOOBETaskChecker.this.f13071b == 1) {
                UnloginOOBETaskChecker.m18051m(false);
                cancel();
                UnloginOOBETaskChecker unloginOOBETaskChecker = UnloginOOBETaskChecker.this;
                unloginOOBETaskChecker.m18054l(unloginOOBETaskChecker.f13072c);
            }
        }

        public /* synthetic */ C3004b(UnloginOOBETaskChecker unloginOOBETaskChecker, C3003a c3003a) {
            this();
        }
    }

    public UnloginOOBETaskChecker(Context context) {
        this.f13072c = context;
    }

    /* renamed from: j */
    public static boolean m18050j() {
        return f13069f;
    }

    /* renamed from: m */
    public static void m18051m(boolean z10) {
        f13069f = z10;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: L */
    public void mo13808L(Exception exc) {
        C11839m.m70688i("UnloginOOBETaskChecker", "authFailed;");
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: Q */
    public boolean mo13814Q(Bundle bundle) {
        return false;
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: W */
    public void mo13820W(Bundle bundle) {
        C11839m.m70688i("UnloginOOBETaskChecker", "authTokenSuccess;");
        C10806t.m65784k(true);
        C10806t.m65776c(this.f13072c);
        C10806t.m65777d(this.f13072c);
        C10806t.m65781h();
        RestoreNotifyUtil.getInstance().saveOOBEState(this.f13072c);
        C0209d.m1318v2(this.f13072c);
        C12515a.m75110o().m75175e(new C3052k2(this.f13072c, 1), false);
        C10806t.m65783j(this.f13072c);
        C10806t.m65780g(this.f13072c);
        C10806t.m65779f(this.f13072c);
        C10028c.m62182c0().m62377p3("quick_migrate_flag", false);
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: e */
    public void mo13829e(OperationCanceledException operationCanceledException) {
    }

    /* renamed from: i */
    public void m18052i() {
        if (f13069f) {
            return;
        }
        C11839m.m70687e("UnloginOOBETaskChecker", "UnloginOOBEChecker start");
        this.f13074e.schedule(this.f13073d, 0L, 10000L);
    }

    /* renamed from: k */
    public final void m18053k(boolean z10) {
        if (z10) {
            C13195l.m79272J().m79337u0(this, true);
        } else {
            C10028c.m62182c0().m62353l("encrypt_mode");
            C10028c.m62182c0().m62353l("basic_encrypt_mode");
        }
    }

    /* renamed from: l */
    public final void m18054l(Context context) {
        C11839m.m70688i("UnloginOOBETaskChecker", "isLogin;" + C13612b.m81829B().isLogin());
        C11839m.m70688i("UnloginOOBETaskChecker", "CONFIG_TAG;" + C10028c.m62182c0().m62395t1("is_already_configed_NV4"));
        boolean zM62403v = C10028c.m62182c0().m62403v("quick_migrate_flag", false);
        RestoreNotifyUtil.getInstance().saveOOBEFinishTime(this.f13072c, System.currentTimeMillis());
        if (!C13612b.m81829B().isLogin() && C10028c.m62182c0().m62395t1("is_already_configed_NV4") && zM62403v) {
            C13612b.m81829B().mo80999a(context, new C3003a());
            return;
        }
        RestoreNotifyUtil.getInstance().saveOOBEFinishTime(context, System.currentTimeMillis());
        if (RestoreNotifyUtil.getInstance().isOOBELogin(context)) {
            C11839m.m70688i("UnloginOOBETaskChecker", "quickMigrate Restore Notify;");
            C12515a.m75110o().m75175e(new C3052k2(this.f13072c, 1), false);
        }
    }

    @Override // p709vj.InterfaceC13449b
    /* renamed from: m0 */
    public void mo13838m0(Bundle bundle) {
    }
}
