package p335hd;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import com.huawei.android.hicloud.task.DesktopDialogCheckJobService;
import java.util.Iterator;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;

/* renamed from: hd.b */
/* loaded from: classes3.dex */
public class C10139b {

    /* renamed from: a */
    public static final C10139b f49430a = new C10139b();

    /* renamed from: a */
    public static C10139b m63185a() {
        return f49430a;
    }

    /* renamed from: b */
    public final boolean m63186b(int i10) {
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70687e("BaseSyncJobSchedulerManager", "jobscheduler is null");
            return false;
        }
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (it.hasNext()) {
            if (it.next().getId() == i10) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m63187c(long j10) {
        if (C11829c.m70611r0()) {
            C11839m.m70689w("BaseSyncJobSchedulerManager", "is Ds Start Sticky true");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) C0213f.m1377a().getSystemService("jobscheduler");
        if (jobScheduler == null) {
            C11839m.m70689w("BaseSyncJobSchedulerManager", "jobscheduler is null");
            return;
        }
        C11839m.m70688i("BaseSyncJobSchedulerManager", "registerDesktopDialogJobScheduler");
        if (m63186b(2025)) {
            C11839m.m70688i("BaseSyncJobSchedulerManager", "Desktop Dialog JobServiceOn");
        } else {
            C11839m.m70688i("BaseSyncJobSchedulerManager", "registerDesktopDialogJobScheduler do job");
            jobScheduler.schedule(new JobInfo.Builder(2025, new ComponentName(C0213f.m1377a(), (Class<?>) DesktopDialogCheckJobService.class)).setMinimumLatency(j10).setRequiredNetworkType(1).setOverrideDeadline(j10 + 60000).build());
        }
    }
}
