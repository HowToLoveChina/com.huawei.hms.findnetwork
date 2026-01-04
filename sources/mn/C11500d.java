package mn;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notify.scheduler.CommonDailyDelayService;
import com.huawei.hicloud.notify.scheduler.CommonDailyJobService;
import com.huawei.hms.findnetwork.comm.request.bean.DisconnectNotificationParams;
import com.huawei.openalliance.p169ad.constant.AiCoreSdkConstant;
import gp.C10028c;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import p015ak.C0209d;
import p015ak.C0213f;
import p459lp.C11326d;

/* renamed from: mn.d */
/* loaded from: classes6.dex */
public class C11500d {

    /* renamed from: b */
    public static final ReentrantLock f53397b = new ReentrantLock();

    /* renamed from: a */
    public List<InterfaceC11499c> f53398a;

    /* renamed from: mn.d$b */
    public static class b {

        /* renamed from: a */
        public static C11500d f53399a = new C11500d();
    }

    /* renamed from: g */
    public static C11500d m68648g() {
        return b.f53399a;
    }

    /* renamed from: a */
    public void m68649a(Bundle bundle) {
        if (this.f53398a == null) {
            NotifyLogger.m29914e("DailyJobManager", "DailyJobManager callbacks is null");
            NotificationReportUtil.reportDailyJobExecuteTask(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_EXECUTE_TASK_FAILED, 0);
        }
        if (this.f53398a.size() == 0) {
            NotifyLogger.m29914e("DailyJobManager", "DailyJobManager callbacks is empty");
            NotificationReportUtil.reportDailyJobExecuteTask(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_EXECUTE_TASK_FAILED, 0);
        }
        try {
            NotifyLogger.m29915i("DailyJobManager", "execute all " + this.f53398a.size() + " callbacks");
            for (InterfaceC11499c interfaceC11499c : this.f53398a) {
                if (interfaceC11499c != null) {
                    interfaceC11499c.mo57109b(bundle);
                }
            }
            NotificationReportUtil.reportDailyJobExecuteTask(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_EXECUTE_TASK, this.f53398a.size());
        } catch (Exception e10) {
            NotifyLogger.m29914e("DailyJobManager", "executeAllCallbacks exception: " + e10.getMessage());
        }
    }

    /* renamed from: b */
    public void m68650b(JobParameters jobParameters) {
        Uri uri = Uri.parse("content://com.huawei.android.hicloud.provider.dailyjob");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || jobParameters == null) {
            return;
        }
        PersistableBundle extras = jobParameters.getExtras();
        Bundle bundle = new Bundle();
        int i10 = extras.getInt("retryCountForNotGetConfig", 0);
        int i11 = extras.getInt("retryCountForHttpError", 0);
        int i12 = extras.getInt("fromMigration", 0);
        String string = extras.getString("taskStartChannel", "");
        bundle.putInt("retryCountForNotGetConfig", i10);
        bundle.putInt("retryCountForHttpError", i11);
        bundle.putInt("fromMigration", i12);
        bundle.putString("taskStartChannel", string);
        contextM1377a.getApplicationContext().getContentResolver().call(uri, "dailyJob", (String) null, bundle);
    }

    /* renamed from: c */
    public void m68651c(JobParameters jobParameters) {
        Uri uri = Uri.parse("content://com.huawei.android.hicloud.provider.dailyjob");
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null || jobParameters == null) {
            return;
        }
        contextM1377a.getApplicationContext().getContentResolver().call(uri, "refresh_last_daily_time", (String) null, new Bundle());
    }

    /* renamed from: d */
    public final long m68652d() {
        return C0209d.m1260h0(0, 300) * 1000;
    }

    /* renamed from: e */
    public long m68653e() {
        return C0209d.m1260h0(0, DisconnectNotificationParams.DEFAULT_NORMAL_ADV_DURATION) * 1000;
    }

    /* renamed from: f */
    public final long m68654f() {
        long jM1260h0 = C0209d.m1260h0(0, 7200) * 1000;
        NotifyLogger.m29915i("DailyJobManager", "getRandomHour:" + jM1260h0);
        return jM1260h0;
    }

    /* renamed from: h */
    public final long m68655h() {
        long jM1260h0 = C0209d.m1260h0(-7200, 0) * 1000;
        NotifyLogger.m29915i("DailyJobManager", "getRandomHour:" + jM1260h0);
        return jM1260h0;
    }

    /* renamed from: i */
    public final long m68656i() {
        return C0209d.m1260h0(7200, 28800) * 1000;
    }

    /* renamed from: j */
    public long m68657j() {
        int iM62209F = C10028c.m62183d0(C0213f.m1377a()).m62209F();
        long jM62214G = C10028c.m62183d0(C0213f.m1377a()).m62214G();
        long jM68655h = -7200000;
        if (jM62214G < -7200000) {
            jM68655h = 7200000;
        } else if (jM62214G <= AiCoreSdkConstant.CHECK_SUPPORT_INTERVAL) {
            if (iM62209F == 0) {
                long jM68654f = m68654f();
                C10028c.m62183d0(C0213f.m1377a()).m62406v2(iM62209F + 1);
                jM68655h = jM68654f;
            } else if (iM62209F == 1) {
                jM68655h = m68655h();
                C10028c.m62183d0(C0213f.m1377a()).m62406v2(0);
            } else {
                jM68655h = 0;
            }
        }
        long j10 = jM62214G + jM68655h;
        NotifyLogger.m29915i("DailyJobManager", "randomTimeSum = " + j10);
        C10028c.m62183d0(C0213f.m1377a()).m62411w2(j10);
        return jM68655h + 86400000;
    }

    /* renamed from: k */
    public boolean m68658k() {
        try {
            return C11326d.m68054p();
        } catch (Exception e10) {
            NotifyLogger.m29914e("DailyJobManager", "needDelay error:" + e10.getMessage());
            return false;
        }
    }

    /* renamed from: l */
    public void m68659l(InterfaceC11499c interfaceC11499c) {
        f53397b.lock();
        if (interfaceC11499c != null) {
            try {
                try {
                    Iterator<InterfaceC11499c> it = this.f53398a.iterator();
                    while (it.hasNext()) {
                        if (it.next().mo57108a().equals(interfaceC11499c.mo57108a())) {
                            return;
                        }
                    }
                    this.f53398a.add(interfaceC11499c);
                } catch (Exception e10) {
                    NotifyLogger.m29914e("DailyJobManager", "get lockToken exception:" + e10.toString());
                }
            } finally {
                f53397b.unlock();
            }
        }
    }

    /* renamed from: m */
    public void m68660m(Context context) {
        if (context == null) {
            NotifyLogger.m29914e("DailyJobManager", "context is null");
            NotificationReportUtil.reportDailyJobStartError(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_FAIL, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB);
            return;
        }
        NotifyLogger.m29915i("DailyJobManager", "startDailyJob");
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo.Builder builder = new JobInfo.Builder(90001, new ComponentName(context, (Class<?>) CommonDailyJobService.class));
            long jM68657j = m68657j();
            builder.setMinimumLatency(jM68657j);
            builder.setOverrideDeadline(60000 + jM68657j);
            builder.setRequiredNetworkType(1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("taskStartChannel", "from_job_schedule_default");
            builder.setExtras(persistableBundle);
            int iSchedule = jobScheduler.schedule(builder.build());
            C10028c.m62183d0(C0213f.m1377a()).m62277T2(true);
            C10028c.m62183d0(C0213f.m1377a()).m62228I3(System.currentTimeMillis());
            NotifyLogger.m29915i("DailyJobManager", "startDailyJob ret code is " + iSchedule + ", minLatency = " + jM68657j);
            NotificationReportUtil.reportDailyJobStartResult(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_INFORMATION, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB, iSchedule, jM68657j);
        }
    }

    /* renamed from: n */
    public void m68661n(Context context) {
        if (context == null) {
            NotifyLogger.m29914e("DailyJobManager", "context is null");
            NotificationReportUtil.reportDailyJobStartError(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_FAIL, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB_BY_APP);
            return;
        }
        NotifyLogger.m29915i("DailyJobManager", "startDailyJobByAppStart");
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JobInfo.Builder builder = new JobInfo.Builder(90001, new ComponentName(context, (Class<?>) CommonDailyJobService.class));
            long jM68657j = m68657j();
            long jM62339i0 = C10028c.m62183d0(C0213f.m1377a()).m62339i0();
            if (jM62339i0 != 0) {
                long j10 = jCurrentTimeMillis - jM62339i0;
                long jM62383r = jCurrentTimeMillis - C10028c.m62183d0(C0213f.m1377a()).m62383r();
                NotifyLogger.m29915i("DailyJobManager", "last time exist, currentTime=" + jCurrentTimeMillis + ",duration=" + j10 + ",schedule Time =" + jM68657j + ",lastAppStartDuration=" + jM62383r);
                if (jM62383r <= 93600000) {
                    return;
                }
                NotificationReportUtil.reportDailyJobByAppLastTime(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_LAST_TIME_EXIST, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB_BY_APP, jCurrentTimeMillis, j10, jM68657j, jM62383r);
                if (j10 <= 93600000) {
                    NotifyLogger.m29915i("DailyJobManager", "already execute daily job in MAX TIME");
                    NotificationReportUtil.reportDailyJobStartError(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_BY_APP_EXECUTE_IN_TIME, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB_BY_APP);
                    return;
                } else {
                    jM68656i = j10 <= 187200000 ? m68652d() : 0L;
                    C10028c.m62183d0(C0213f.m1377a()).m62326f2(jCurrentTimeMillis);
                }
            } else {
                long jM62394t0 = jCurrentTimeMillis - C10028c.m62183d0(C0213f.m1377a()).m62394t0();
                long jM62258P0 = C10028c.m62183d0(C0213f.m1377a()).m62258P0();
                long j11 = jCurrentTimeMillis - jM62258P0;
                NotifyLogger.m29915i("DailyJobManager", "last time not exist, currentTime=" + jCurrentTimeMillis + ",duration=" + j11 + ",schedule Time =" + jM68657j + ",lastVerDuration=" + jM62394t0);
                if (jM62394t0 <= 93600000) {
                    return;
                }
                NotificationReportUtil.reportDailyJobByAppLastTime(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_LAST_TIME_NOT_EXIST, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB_BY_APP, jCurrentTimeMillis, j11, jM68657j, jM62394t0);
                if (jM62258P0 != 0 && j11 > 93600000) {
                    long jM68652d = m68652d();
                    if (j11 <= 187200000) {
                        jM68656i = jM68652d;
                    }
                } else {
                    if (C10028c.m62183d0(C0213f.m1377a()).m62319e0()) {
                        NotifyLogger.m29915i("DailyJobManager", "already set daily job");
                        NotificationReportUtil.reportDailyJobStartError(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_BY_APP_ALREADY_SET, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB_BY_APP);
                        return;
                    }
                    jM68656i = m68656i();
                }
                C10028c.m62183d0(C0213f.m1377a()).m62342i3(jCurrentTimeMillis);
            }
            long j12 = jM68656i;
            builder.setMinimumLatency(j12);
            builder.setOverrideDeadline(60000 + j12);
            builder.setRequiredNetworkType(1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("taskStartChannel", "from_job_schedule_default");
            builder.setExtras(persistableBundle);
            int iSchedule = jobScheduler.schedule(builder.build());
            C10028c.m62183d0(C0213f.m1377a()).m62228I3(System.currentTimeMillis());
            NotifyLogger.m29915i("DailyJobManager", "startDailyJob ret code is " + iSchedule + ", minLatency = " + j12);
            NotificationReportUtil.reportDailyJobStartResult(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_INFORMATION, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB_BY_APP, iSchedule, j12);
        }
    }

    /* renamed from: o */
    public void m68662o(Context context) {
        if (context == null) {
            NotifyLogger.m29914e("DailyJobManager", "context is null");
            NotificationReportUtil.reportDailyJobStartError(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_FAIL, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB_INSTANTLY);
            return;
        }
        NotifyLogger.m29915i("DailyJobManager", "startDailyJobInstantly");
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo.Builder builder = new JobInfo.Builder(90001, new ComponentName(context, (Class<?>) CommonDailyJobService.class));
            builder.setMinimumLatency(0L);
            builder.setOverrideDeadline(60000L);
            builder.setRequiredNetworkType(1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("taskStartChannel", "from_job_schedule_default");
            builder.setExtras(persistableBundle);
            int iSchedule = jobScheduler.schedule(builder.build());
            long jCurrentTimeMillis = System.currentTimeMillis();
            C10028c.m62183d0(C0213f.m1377a()).m62277T2(true);
            C10028c.m62183d0(C0213f.m1377a()).m62342i3(jCurrentTimeMillis);
            C10028c.m62183d0(C0213f.m1377a()).m62326f2(jCurrentTimeMillis);
            C10028c.m62183d0(C0213f.m1377a()).m62228I3(jCurrentTimeMillis);
            NotifyLogger.m29915i("DailyJobManager", "startDailyJob ret code is " + iSchedule + ", minLatency = 0");
            NotificationReportUtil.reportDailyJobStartResult(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_INFORMATION, NotifyConstants.NotificationReport.SOURCE_DAILY_JOB_INSTANTLY, iSchedule, 0L);
        }
    }

    /* renamed from: p */
    public void m68663p(Context context) {
        if (context == null) {
            NotifyLogger.m29914e("DailyJobManager", "context is null");
            NotificationReportUtil.reportDailyJobStartError(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_FAIL, NotifyConstants.NotificationReport.SOURCE_DELAY_JOB);
            return;
        }
        NotifyLogger.m29915i("DailyJobManager", "startDelayJob");
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo.Builder builder = new JobInfo.Builder(90002, new ComponentName(context, (Class<?>) CommonDailyDelayService.class));
            long jM68653e = m68653e();
            builder.setMinimumLatency(jM68653e);
            builder.setOverrideDeadline(60000 + jM68653e);
            builder.setRequiredNetworkType(1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("taskStartChannel", "from_job_schedule_default");
            builder.setExtras(persistableBundle);
            int iSchedule = jobScheduler.schedule(builder.build());
            NotifyLogger.m29915i("DailyJobManager", "startDelayJob ret code is " + iSchedule + ", schedule Time = " + jM68653e);
            NotificationReportUtil.reportDailyJobStartResult(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_INFORMATION, NotifyConstants.NotificationReport.SOURCE_DELAY_JOB, iSchedule, jM68653e);
        }
    }

    /* renamed from: q */
    public void m68664q(Context context, int i10, int i11, String str) {
        m68666s(context, i10, i11, str, true);
    }

    /* renamed from: r */
    public void m68665r(Context context, int i10, int i11, String str) {
        m68666s(context, i10, i11, str, false);
    }

    /* renamed from: s */
    public void m68666s(Context context, int i10, int i11, String str, boolean z10) {
        if (context == null) {
            NotifyLogger.m29914e("DailyJobManager", "context is null");
            NotificationReportUtil.reportDailyJobStartError(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_FAIL, NotifyConstants.NotificationReport.SOURCE_RETRY_JOB_INTERNAL);
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo.Builder builder = new JobInfo.Builder(90003, new ComponentName(context, (Class<?>) CommonDailyDelayService.class));
            if (z10) {
                long jNextInt = new SecureRandom().nextInt(3601) * 1000;
                builder.setMinimumLatency(jNextInt);
                builder.setOverrideDeadline(60000 + jNextInt);
                NotifyLogger.m29915i("DailyJobManager", "schedule Time = " + jNextInt);
            } else {
                long j10 = i11 * 300000;
                builder.setMinimumLatency(j10);
                builder.setOverrideDeadline(60000 + j10);
                NotifyLogger.m29915i("DailyJobManager", "schedule Time = " + j10);
            }
            builder.setRequiredNetworkType(1);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("retryCountForNotGetConfig", i11);
            persistableBundle.putInt("retryCountForHttpError", i10);
            persistableBundle.putString("taskStartChannel", str);
            builder.setExtras(persistableBundle);
            int iSchedule = jobScheduler.schedule(builder.build());
            NotifyLogger.m29915i("DailyJobManager", "retry for no config error, ret code is " + iSchedule + ", retryTime = " + i11);
            NotificationReportUtil.reportDailyJobStartResult(NotifyConstants.NotificationReport.EVENT_NAME_DAILY_JOB_START_INFORMATION, NotifyConstants.NotificationReport.SOURCE_RETRY_JOB_INTERNAL, iSchedule, (long) i11);
        }
    }

    public C11500d() {
        this.f53398a = new ArrayList();
    }
}
