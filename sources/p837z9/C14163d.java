package p837z9;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.huawei.android.hicloud.datamigration.MigrationBatteryJobService;
import com.huawei.android.hicloud.datamigration.bean.DataStatusResp;
import com.huawei.android.hicloud.report.CloudCommonReport;
import fk.C9721b;
import gp.C10028c;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import p011aa.C0081a;
import p011aa.C0082b;
import p011aa.C0085e;
import p015ak.C0213f;
import p015ak.C0214f0;
import p422k9.C11019b;
import p448l9.C11262a;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p664u0.C13108a;
import tm.C13040c;

/* renamed from: z9.d */
/* loaded from: classes3.dex */
public class C14163d {

    /* renamed from: a */
    public Context f63318a;

    /* renamed from: b */
    public SharedPreferences f63319b;

    /* renamed from: c */
    public b f63320c;

    /* renamed from: d */
    public final ReentrantLock f63321d;

    /* renamed from: z9.d$a */
    public class a extends AbstractC12367d {
        public a() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            try {
                C10028c c10028cM62182c0 = C10028c.m62182c0();
                DataStatusResp dataStatusRespM84982n = new C14162c().m84982n();
                if (dataStatusRespM84982n != null && dataStatusRespM84982n.getCode() == 0) {
                    int dataStatus = dataStatusRespM84982n.getDataStatus();
                    C11839m.m70688i("MigrationManager", "queryDataStatusTask dataStatus = " + dataStatus);
                    int interval = dataStatusRespM84982n.getInterval();
                    C11839m.m70688i("MigrationManager", "interval = " + interval);
                    if (dataStatus == 3) {
                        c10028cM62182c0.m62416x2(dataStatus);
                        long j10 = interval;
                        C12515a.m75110o().m75172d(new C0082b(j10, j10));
                    } else if (dataStatus == 4) {
                        c10028cM62182c0.m62416x2(dataStatus);
                        C14163d.this.m85017w();
                    } else if (dataStatusRespM84982n.getDataStatus() == 5) {
                        C11019b.m66371t().m66375B0(C0213f.m1377a());
                    }
                }
            } catch (C9721b e10) {
                C11839m.m70687e("MigrationManager", "queryDataStatusTask error, " + e10.m60659c() + ", " + e10.getMessage());
            }
        }
    }

    /* renamed from: z9.d$b */
    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            C11839m.m70688i("MigrationManager.NetWorkChangedListener", "onAvailable");
            C14163d.this.m85017w();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            C11839m.m70688i("MigrationManager.NetWorkChangedListener", "onLost");
            new C11262a().m67599a(C0213f.m1377a(), 3);
        }
    }

    /* renamed from: z9.d$c */
    public static class c {

        /* renamed from: a */
        public static final C14163d f63324a = new C14163d(null);
    }

    public /* synthetic */ C14163d(a aVar) {
        this();
    }

    /* renamed from: g */
    public static C14163d m84990g() {
        return c.f63324a;
    }

    /* renamed from: A */
    public void m84991A(long j10) {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_show_notify_time", j10).commit();
        }
    }

    /* renamed from: B */
    public void m84992B(long j10) {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong("last_show_dialog_time", j10).commit();
        }
    }

    /* renamed from: C */
    public void m84993C(int i10) {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("show_notify_count", i10).commit();
        }
    }

    /* renamed from: D */
    public synchronized void m84994D(Context context) {
        m84997b(context);
    }

    /* renamed from: E */
    public synchronized void m84995E(Context context) {
        if (context == null) {
            C11839m.m70687e("MigrationManager", "unregisterNetWorkListener fail, context is null");
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && this.f63320c != null) {
            C11839m.m70688i("MigrationManager", "unregisterNetWorkListener succ");
            try {
                connectivityManager.unregisterNetworkCallback(this.f63320c);
            } catch (Exception unused) {
                C11839m.m70689w("MigrationManager", "unregisterNetWorkListener fail.");
            }
        }
        this.f63320c = null;
    }

    /* renamed from: a */
    public void m84996a(int i10) {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("allow_status", i10).commit();
        }
        C12515a.m75110o().m75172d(new C0081a(i10, CloudCommonReport.m17077a()));
    }

    /* renamed from: b */
    public final void m84997b(Context context) {
        if (context == null) {
            C11839m.m70687e("MigrationManager", "context is null");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70688i("MigrationManager", "cancel job, scheduler is null.");
        } else {
            jobScheduler.cancel(1122);
        }
    }

    /* renamed from: c */
    public void m84998c() throws C9721b {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62395t1("is_already_configed_NV4")) {
            return;
        }
        int iM78639c = C13040c.m78609F().m78639c();
        C11839m.m70688i("MigrationManager", "checkDefaultEncryptMode status is " + iM78639c);
        if (iM78639c == 2) {
            c10028cM62182c0.m62361m2(1);
        } else {
            c10028cM62182c0.m62361m2(0);
        }
    }

    /* renamed from: d */
    public void m84999d(Map<String, String> map) throws C9721b {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62395t1("is_already_configed_NV4")) {
            return;
        }
        int iM78641d = C13040c.m78609F().m78641d(map);
        C11839m.m70688i("MigrationManager", "checkDefaultEncryptMode from urlsmap,status is " + iM78641d);
        if (iM78641d == 2) {
            c10028cM62182c0.m62361m2(1);
        } else {
            c10028cM62182c0.m62361m2(0);
        }
    }

    /* renamed from: e */
    public void m85000e() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62378q() != 1 && m85004j() == 1 && c10028cM62182c0.m62219H() == 0) {
            m84996a(1);
        }
    }

    /* renamed from: f */
    public void m85001f() {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().commit();
        }
        m84995E(this.f63318a);
        m84994D(this.f63318a.getApplicationContext());
    }

    /* renamed from: h */
    public long m85002h() {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_show_notify_time", 0L);
        }
        return 0L;
    }

    /* renamed from: i */
    public long m85003i() {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            return sharedPreferences.getLong("last_show_dialog_time", 0L);
        }
        return 0L;
    }

    /* renamed from: j */
    public int m85004j() {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt("allow_status", 0);
    }

    /* renamed from: k */
    public int m85005k() {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("show_notify_count", 0);
        }
        return 0;
    }

    /* renamed from: l */
    public int m85006l() {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("show_dialog_count", 0);
        }
        return 0;
    }

    /* renamed from: m */
    public boolean m85007m() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62219H() != 0 || c10028cM62182c0.m62224I() != 1 || m85004j() == 1 || c10028cM62182c0.m62378q() == 1) {
            return true;
        }
        C11839m.m70688i("MigrationManager", "not agree migrate");
        return false;
    }

    /* renamed from: n */
    public final boolean m85008n(Context context) {
        if (context == null) {
            C11839m.m70687e("MigrationManager", "context is null");
            return false;
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("MigrationManager", "job scheduler is null");
            return false;
        }
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == 1122) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: o */
    public boolean m85009o() {
        C10028c c10028cM62182c0 = C10028c.m62182c0();
        if (c10028cM62182c0.m62219H() != 0 || c10028cM62182c0.m62224I() != 1 || m85004j() == 1 || c10028cM62182c0.m62378q() == 1) {
            return false;
        }
        C11839m.m70686d("MigrationManager", "ShowDataMigrateWarn");
        C13108a.m78878b(C0213f.m1377a()).m78881d(new Intent("com.huawei.hicloud.intent.action.MIGRATION_NOTICE"));
        return true;
    }

    /* renamed from: p */
    public boolean m85010p() {
        return C10028c.m62182c0().m62378q() == 1 || m85004j() == 1;
    }

    /* renamed from: q */
    public void m85011q(Context context) {
        if (context != null) {
            C13108a.m78878b(context).m78881d(new Intent("com.huawei.hicloud.MIGRATION_POLICY_HANDLED"));
        }
    }

    /* renamed from: r */
    public void m85012r() {
        this.f63321d.lock();
    }

    /* renamed from: s */
    public void m85013s() {
        this.f63321d.unlock();
    }

    /* renamed from: t */
    public void m85014t() {
        C12515a.m75110o().m75172d(new a());
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: u */
    public synchronized void m85015u(Context context) {
        if (context == null) {
            C11839m.m70687e("MigrationManager", "registeBatteryBroadcast context is null");
        } else {
            if (m85008n(context)) {
                return;
            }
            JobInfo.Builder builder = new JobInfo.Builder(1122, new ComponentName(context, (Class<?>) MigrationBatteryJobService.class));
            builder.setRequiresCharging(true).setPersisted(true);
            m85018x(builder.build(), context);
        }
    }

    /* renamed from: v */
    public synchronized void m85016v(Context context) {
        if (context == null) {
            C11839m.m70687e("MigrationManager", "registerNetWorkListener fail, context is null");
            return;
        }
        if (this.f63320c == null) {
            this.f63320c = new b();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                C11839m.m70688i("MigrationManager", "registerNetWorkListener succ");
                connectivityManager.requestNetwork(new NetworkRequest.Builder().build(), this.f63320c);
            }
        }
    }

    /* renamed from: w */
    public void m85017w() {
        if (C10028c.m62182c0().m62219H() == 4) {
            C11839m.m70688i("MigrationManager", "retryMigrationTask");
            C12515a.m75110o().m75172d(new C0085e());
        }
    }

    /* renamed from: x */
    public final void m85018x(JobInfo jobInfo, Context context) {
        if (context == null) {
            C11839m.m70687e("MigrationManager", "context is null");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70689w("MigrationManager", "scheduler job, scheduler is null");
        } else {
            jobScheduler.schedule(jobInfo);
        }
    }

    /* renamed from: y */
    public void m85019y(int i10) {
        C11839m.m70687e("MigrationManager", "Migration error, code =  " + i10);
        if (i10 == 800) {
            if (C10028c.m62182c0().m62219H() < 3) {
                m85014t();
            }
        } else {
            if (i10 != 801 || C10028c.m62182c0().m62219H() == 5) {
                return;
            }
            C11019b.m66371t().m66375B0(C0213f.m1377a());
        }
    }

    /* renamed from: z */
    public void m85020z(int i10) {
        SharedPreferences sharedPreferences = this.f63319b;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("show_dialog_count", i10).commit();
        }
    }

    public C14163d() {
        this.f63321d = new ReentrantLock();
        Context contextM1377a = C0213f.m1377a();
        this.f63318a = contextM1377a;
        this.f63319b = C0214f0.m1382b(contextM1377a, "migration_status_sp", 0);
    }
}
