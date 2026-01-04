package com.huawei.hicloud.notify.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import cn.C1461a;
import com.huawei.hicloud.notification.manager.HiCloudAllOMConfigManager;
import p292fn.C9733f;
import p581qk.AbstractC12367d;
import p616rk.C12515a;

/* loaded from: classes6.dex */
public class OMFileDownloadFlowControlJobService extends JobService {

    /* renamed from: a */
    public long f22728a = 0;

    /* renamed from: b */
    public long f22729b = 0;

    /* renamed from: com.huawei.hicloud.notify.scheduler.OMFileDownloadFlowControlJobService$a */
    public class C4974a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ JobParameters f22730a;

        public C4974a(JobParameters jobParameters) {
            this.f22730a = jobParameters;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() {
            OMFileDownloadFlowControlJobService.this.m29937b(this.f22730a);
        }

        @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
        public void release() {
            super.release();
        }
    }

    /* renamed from: b */
    public final void m29937b(JobParameters jobParameters) {
        if (!C9733f.m60705z().m60720O("downloadOMConfigFileFlowControl")) {
            jobFinished(jobParameters, false);
        } else {
            HiCloudAllOMConfigManager.getInstance().downloadFlowControlOMConfig();
            jobFinished(jobParameters, false);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        C1461a.m8359i("OMFileDownloadFlowControlJobService", "OMFileDownloadFlowControlJobService onStartJob");
        C12515a.m75110o().m75172d(new C4974a(jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        C1461a.m8359i("OMFileDownloadFlowControlJobService", "OMFileDownloadFlowControlJobService onStopJob");
        return false;
    }
}
