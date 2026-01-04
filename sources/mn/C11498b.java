package mn;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import cn.C1461a;
import com.huawei.hicloud.notify.scheduler.OMFileDownloadFlowControlJobService;
import p015ak.C0213f;
import p292fn.C9734g;

/* renamed from: mn.b */
/* loaded from: classes6.dex */
public class C11498b {

    /* renamed from: a */
    public static final C11498b f53396a = new C11498b();

    /* renamed from: a */
    public static final C11498b m68645a() {
        return f53396a;
    }

    /* renamed from: b */
    public void m68646b() {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C1461a.m8358e("ConfigJobManager", "jobscheduler is null");
            return;
        }
        int iM60768b = C9734g.m60767a().m60768b();
        C1461a.m8359i("ConfigJobManager", "registerFlowControlRetryScheduler oMConfigFileFlowControlInteval: " + iM60768b);
        jobScheduler.schedule(new JobInfo.Builder(10001, new ComponentName(C0213f.m1377a(), (Class<?>) OMFileDownloadFlowControlJobService.class)).setMinimumLatency(((long) (iM60768b * 60)) * 1000).setOverrideDeadline(86400000L).setRequiredNetworkType(1).setPersisted(true).build());
    }

    /* renamed from: c */
    public void m68647c() {
        C1461a.m8359i("ConfigJobManager", "unRegisterFlowControlRetryScheduler");
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C1461a.m8358e("ConfigJobManager", "jobscheduler is null");
        } else {
            jobScheduler.cancel(10001);
        }
    }
}
