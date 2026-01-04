package p448l9;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import com.huawei.android.hicloud.commonlib.jobscheduler.CommonJobCallBack;
import com.huawei.android.hicloud.commonlib.jobscheduler.HiCloudJobService;
import gp.C10028c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p015ak.C0209d;
import p514o9.C11839m;
import p709vj.C13452e;

/* renamed from: l9.a */
/* loaded from: classes3.dex */
public class C11262a {

    /* renamed from: a */
    public static List<CommonJobCallBack> f52871a = new ArrayList();

    /* renamed from: c */
    public static boolean m67596c(Class cls) {
        Iterator<CommonJobCallBack> it = f52871a.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().getName().equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static void m67597f(CommonJobCallBack commonJobCallBack) {
        if (commonJobCallBack != null) {
            C11839m.m70686d("HiCloudJobManager", "registerCallback = " + commonJobCallBack.getClass().getSimpleName());
            f52871a.add(commonJobCallBack);
        }
    }

    /* renamed from: i */
    public static void m67598i(CommonJobCallBack commonJobCallBack) {
        if (commonJobCallBack != null) {
            C11839m.m70686d("HiCloudJobManager", "unRegisterCallback = " + commonJobCallBack.getClass().getSimpleName());
            f52871a.remove(commonJobCallBack);
        }
    }

    /* renamed from: a */
    public void m67599a(Context context, int i10) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(i10);
        }
    }

    /* renamed from: b */
    public void m67600b(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancelAll();
        }
    }

    /* renamed from: d */
    public List<CommonJobCallBack> m67601d() {
        return f52871a;
    }

    /* renamed from: e */
    public final long m67602e() {
        long jM1260h0 = C0209d.m1260h0(-7200, 7200) * 1000;
        C11839m.m70688i("HiCloudJobManager", "getRandomHour:" + jM1260h0);
        return jM1260h0;
    }

    /* renamed from: g */
    public void m67603g(Context context, int i10, CommonJobCallBack commonJobCallBack, int i11) {
        if (context == null) {
            C11839m.m70689w("HiCloudJobManager", "context is null");
            return;
        }
        if (i10 == 3) {
            boolean zM80842P0 = C13452e.m80781L().m80842P0();
            int iM62219H = C10028c.m62182c0().m62219H();
            if (!zM80842P0 || iM62219H != 4) {
                C11839m.m70687e("HiCloudJobManager", "account not login or data status is not 4, isLogin: " + zM80842P0 + ", data status: " + iM62219H);
                return;
            }
        }
        if (!m67596c(commonJobCallBack.getClass())) {
            m67597f(commonJobCallBack);
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo.Builder builder = new JobInfo.Builder(i10, new ComponentName(context, (Class<?>) HiCloudJobService.class));
            long j10 = i11 * 300000;
            builder.setMinimumLatency(j10);
            builder.setOverrideDeadline(60000 + j10);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("retryTime", i11);
            builder.setExtras(persistableBundle);
            int iSchedule = jobScheduler.schedule(builder.build());
            C11839m.m70688i("HiCloudJobManager", "scheduleJobRetry ret code is " + iSchedule + "JobId is " + i10 + " schedule Time = " + j10 + ", retryTime = " + i11);
            if (iSchedule <= 0) {
                C11839m.m70688i("HiCloudJobManager", "scheduleJobRetry some thing going wrong! ret = " + iSchedule);
            }
        }
    }

    /* renamed from: h */
    public void m67604h(Context context) {
        if (context == null) {
            C11839m.m70689w("HiCloudJobManager", "context is null");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null) {
            JobInfo.Builder builder = new JobInfo.Builder(6, new ComponentName(context, (Class<?>) HiCloudJobService.class));
            long jM62384r0 = C10028c.m62183d0(context).m62384r0();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jMax = 604800000;
            if (jM62384r0 < jCurrentTimeMillis) {
                long j10 = 604800000 - (jCurrentTimeMillis - jM62384r0);
                C11839m.m70688i("HiCloudJobManager", "scheduleReportPushTokenJob origin nextScheduleTime:" + j10);
                jMax = Math.max(0L, j10);
            }
            if (jMax != 0) {
                long jM67602e = jMax + m67602e();
                C11839m.m70688i("HiCloudJobManager", "scheduleReportPushTokenJob random nextScheduleTime:" + jM67602e);
                jMax = Math.max(0L, jM67602e);
            }
            builder.setMinimumLatency(jMax);
            builder.setOverrideDeadline(60000 + jMax);
            builder.setRequiredNetworkType(1);
            int iSchedule = jobScheduler.schedule(builder.build());
            C11839m.m70688i("HiCloudJobManager", "scheduleReportPushTokenJob ret code is " + iSchedule + ", schedule Time = " + jMax);
            if (iSchedule <= 0) {
                C11839m.m70688i("HiCloudJobManager", "scheduleReportPushTokenJob some thing going wrong! ret = " + iSchedule);
            }
        }
    }
}
