package com.huawei.android.hicloud.sync.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import com.huawei.android.hicloud.syncdrive.util.DriveSyncUtil;
import p015ak.C0213f;
import p514o9.C11839m;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes3.dex */
public class ContactKeepLockJobService extends JobService {

    /* renamed from: com.huawei.android.hicloud.sync.jobscheduler.ContactKeepLockJobService$a */
    public static class C2896a extends AbstractC12367d {

        /* renamed from: a */
        public String f12931a;

        /* renamed from: b */
        public String f12932b;

        /* renamed from: c */
        public String f12933c;

        /* renamed from: d */
        public String f12934d;

        public C2896a(String str, String str2, String str3, String str4) {
            this.f12931a = str;
            this.f12932b = str2;
            this.f12933c = str3;
            this.f12934d = str4;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws Throwable {
            try {
                DriveSyncUtil.m17978W(C0213f.m1377a(), this.f12931a, this.f12932b, this.f12933c, this.f12934d, true);
            } catch (Exception e10) {
                C11839m.m70687e("ContactKeepLockJobService", "syncV2 keepLockV2 error: " + e10.getMessage());
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C11839m.m70688i("ContactKeepLockJobService", "syncV2 keepLockV2 contact keeplock job start");
        if (jobParameters != null && jobParameters.getExtras() != null) {
            PersistableBundle extras = jobParameters.getExtras();
            String string = extras.getString("syncType");
            String string2 = extras.getString("sessionId");
            String string3 = extras.getString("callingPackageName");
            String string4 = extras.getString("traceId");
            C11839m.m70688i("ContactKeepLockJobService", "syncV2 keepLockV2 syncType: " + string + " traceId: " + string4);
            C12515a.m75110o().m75175e(new C2896a(string, string3, string2, string4), false);
        }
        jobFinished(jobParameters, false);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
