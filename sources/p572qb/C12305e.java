package p572qb;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.huawei.android.hicloud.common.service.ChargeJobService;
import com.huawei.hms.videokit.player.common.PlayerConstants;
import fk.C9721b;
import gp.C10028c;
import java.util.Iterator;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0213f;
import p020ap.C1007b;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p709vj.C13452e;

/* renamed from: qb.e */
/* loaded from: classes3.dex */
public class C12305e {

    /* renamed from: qb.e$b */
    public static class b extends AbstractC12367d {
        public b() {
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            C12305e.m73982f().m73984c();
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public AbstractRunnableC12516b.a getEnum() {
            return AbstractRunnableC12516b.a.COLLECT_DEVICE_INFO;
        }
    }

    /* renamed from: qb.e$c */
    public static class c {

        /* renamed from: a */
        public static final C12305e f57009a = new C12305e();
    }

    /* renamed from: f */
    public static C12305e m73982f() {
        return c.f57009a;
    }

    /* renamed from: b */
    public final void m73983b() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CollectDeviceInfoManager", "context is null");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) contextM1377a.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70688i("CollectDeviceInfoManager", "cancel job, scheduler is null.");
        } else {
            jobScheduler.cancel(PlayerConstants.ErrorCode.URL_ARRAY_LENGTH_ERROR);
        }
    }

    /* renamed from: c */
    public final void m73984c() {
        if (m73988h()) {
            m73985d();
        }
    }

    /* renamed from: d */
    public final void m73985d() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CollectDeviceInfoManager", "doCollectDeviceInfo context null");
            return;
        }
        C0212e0.m1370t(contextM1377a, "sp_device_use_info", "key_collect_time_mills", System.currentTimeMillis());
        C0212e0.m1365o(contextM1377a, "sp_device_use_info", "key_has_data_change", false);
        C1007b.m5980s().m5990J();
    }

    /* renamed from: e */
    public void m73986e() {
        C12515a.m75110o().m75175e(new b(), true);
    }

    /* renamed from: g */
    public final boolean m73987g() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CollectDeviceInfoManager", "context is null");
            return false;
        }
        JobScheduler jobScheduler = (JobScheduler) contextM1377a.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("CollectDeviceInfoManager", "job scheduler is null");
            return false;
        }
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == 1121) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public final boolean m73988h() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CollectDeviceInfoManager", "isSatisfyCollectLogic context null");
            return false;
        }
        boolean zM62221H1 = C10028c.m62182c0().m62221H1();
        boolean zM80842P0 = C13452e.m80781L().m80842P0();
        C11839m.m70686d("CollectDeviceInfoManager", "isSatisfyCollectLogic isHiCloudLogin " + zM80842P0 + " isAgreedHiCloudTerms " + zM62221H1);
        if (!zM80842P0) {
            C11839m.m70687e("CollectDeviceInfoManager", "isSatisfyCollectLogic not login hw account");
            return false;
        }
        if (!zM62221H1) {
            C11839m.m70687e("CollectDeviceInfoManager", "isSatisfyCollectLogic not agree hicloud terms");
            return false;
        }
        boolean z10 = System.currentTimeMillis() - C0212e0.m1359i(contextM1377a, "sp_device_use_info", "key_collect_time_mills", 0L) > 259200000;
        C11839m.m70686d("CollectDeviceInfoManager", "isSatisfyCollectLogic isOver3Days " + z10);
        if (!z10) {
            C11839m.m70687e("CollectDeviceInfoManager", "isSatisfyCollectLogic not satisfy over 3 days logic");
            return false;
        }
        if (C0209d.m1196O0(contextM1377a)) {
            return true;
        }
        C11839m.m70687e("CollectDeviceInfoManager", "isSatisfyCollectLogic not satisfy charging logic");
        m73989i();
        return false;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: i */
    public void m73989i() {
        C11839m.m70688i("CollectDeviceInfoManager", "registerInChargeScheduler");
        if (m73987g()) {
            C11839m.m70688i("CollectDeviceInfoManager", "job in charge have been on");
            return;
        }
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CollectDeviceInfoManager", "registerInChargeScheduler context null");
            return;
        }
        JobInfo.Builder builder = new JobInfo.Builder(PlayerConstants.ErrorCode.URL_ARRAY_LENGTH_ERROR, new ComponentName(contextM1377a, (Class<?>) ChargeJobService.class));
        builder.setRequiresCharging(true).setPersisted(true);
        m73990j(builder.build());
    }

    /* renamed from: j */
    public final void m73990j(JobInfo jobInfo) {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e("CollectDeviceInfoManager", "context is null");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) contextM1377a.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70689w("CollectDeviceInfoManager", "scheduler job, scheduler is null");
        } else {
            jobScheduler.schedule(jobInfo);
        }
    }

    /* renamed from: k */
    public void m73991k() {
        C11839m.m70688i("CollectDeviceInfoManager", "unRegisterInChargeScheduler");
        m73983b();
    }

    public C12305e() {
    }
}
