package p252e9;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.android.hicloud.task.schedule.RestoreNotifyJobService;
import com.huawei.android.p073ds.R$drawable;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.RestoreNotifyUtil;
import com.huawei.hicloud.notification.log.NotifyLogger;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyConfig;
import com.huawei.hicloud.notification.p106db.bean.RestoreNotifyContent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import fk.C9721b;
import gp.C10028c;
import il.C10542o;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p015ak.C0216g0;
import p015ak.C0230o;
import p015ak.C0241z;
import p684un.C13225d;
import p709vj.C13452e;

/* renamed from: e9.l */
/* loaded from: classes3.dex */
public class C9435l {
    /* renamed from: a */
    public final boolean m59169a(Context context, String str) {
        boolean zM59176h = m59176h(context);
        NotifyLogger.m29915i("RestoreNotifyManager", "isHicloudLogin: " + zM59176h);
        if (!zM59176h) {
            return false;
        }
        boolean zM59175g = m59175g(context);
        NotifyLogger.m29915i("RestoreNotifyManager", "hasLocalData: " + zM59175g);
        if (zM59175g) {
            return false;
        }
        if (C0209d.m1293p1()) {
            NotifyLogger.m29915i("RestoreNotifyManager", "checkCommon isInkScreen: return");
            return false;
        }
        boolean zCheckReleasedDevices = RestoreNotifyUtil.getInstance().checkReleasedDevices(str);
        NotifyLogger.m29915i("RestoreNotifyManager", "isReleaseDevice: " + zCheckReleasedDevices);
        if (!zCheckReleasedDevices) {
            return false;
        }
        boolean zM59174f = m59174f();
        NotifyLogger.m29915i("RestoreNotifyManager", "hasBackup: " + zM59174f);
        if (!zM59174f) {
            return false;
        }
        boolean haveRestored = RestoreNotifyUtil.getInstance().getHaveRestored(context);
        NotifyLogger.m29915i("RestoreNotifyManager", "haveRestored: " + haveRestored);
        return !haveRestored;
    }

    /* renamed from: b */
    public void m59170b(Context context) {
        NotifyLogger.m29915i("RestoreNotifyManager", "handleApplicationStart");
        String currentState = RestoreNotifyUtil.getInstance().getCurrentState(context);
        boolean zCheckNotifyTime = RestoreNotifyUtil.getInstance().checkNotifyTime(context, currentState);
        NotifyLogger.m29915i("RestoreNotifyManager", "isValidTime: " + zCheckNotifyTime);
        if (zCheckNotifyTime) {
            boolean isWaiting = RestoreNotifyUtil.getInstance().getIsWaiting(context);
            NotifyLogger.m29915i("RestoreNotifyManager", "isWaitingOOBE: " + isWaiting);
            if (isWaiting) {
                return;
            }
            boolean zCheckNotifyFrequency = RestoreNotifyUtil.getInstance().checkNotifyFrequency(context, currentState);
            NotifyLogger.m29915i("RestoreNotifyManager", "isValidCount: " + zCheckNotifyFrequency);
            if (zCheckNotifyFrequency && m59169a(context, currentState)) {
                m59178j(context, currentState);
            }
        }
    }

    /* renamed from: c */
    public void m59171c(Context context) {
        NotifyLogger.m29915i("RestoreNotifyManager", "handleHicloudStart");
        if (m59169a(context, "logout")) {
            boolean zCheckNotifyTime = RestoreNotifyUtil.getInstance().checkNotifyTime(context, "logout");
            NotifyLogger.m29915i("RestoreNotifyManager", "isValidTime: " + zCheckNotifyTime);
            if (zCheckNotifyTime) {
                boolean isWaiting = RestoreNotifyUtil.getInstance().getIsWaiting(context);
                NotifyLogger.m29915i("RestoreNotifyManager", "isWaitingOOBE: " + isWaiting);
                if (isWaiting) {
                    return;
                }
                m59178j(context, "logout");
            }
        }
    }

    /* renamed from: d */
    public void m59172d(Context context) {
        RestoreNotifyConfig restoreNotifyConfig;
        NotifyLogger.m29915i("RestoreNotifyManager", "handleOOBEFinish");
        if (m59169a(context, "login") && (restoreNotifyConfig = RestoreNotifyUtil.getInstance().getRestoreNotifyConfig("login")) != null) {
            int iM1685c = C0241z.m1685c(restoreNotifyConfig.getFirstTrigAfter());
            if (iM1685c == 0) {
                m59178j(context, "login");
                RestoreNotifyUtil.getInstance().saveOOBENotified(context, true);
            } else if (iM1685c > 0) {
                RestoreNotifyUtil.getInstance().saveIsWaiting(context, true);
                m59179k(context, iM1685c);
            }
        }
    }

    /* renamed from: e */
    public void m59173e(Context context) {
        boolean zM59176h = m59176h(context);
        boolean zM59175g = m59175g(context);
        boolean zM59174f = m59174f();
        boolean zCheckReleasedDevices = RestoreNotifyUtil.getInstance().checkReleasedDevices("login");
        boolean haveRestored = RestoreNotifyUtil.getInstance().getHaveRestored(context);
        boolean zCheckNotifyTime = RestoreNotifyUtil.getInstance().checkNotifyTime(context, "login");
        RestoreNotifyUtil.getInstance().saveOOBENotified(context, true);
        RestoreNotifyUtil.getInstance().saveIsWaiting(context, false);
        boolean zEquals = TextUtils.equals(C0209d.m1295q(context), "com.huawei.android.hicloud.ui.activity.CloudBackupRecordsActivity");
        NotifyLogger.m29915i("RestoreNotifyManager", "isHicloudLogin:" + zM59176h + "hasLocalData:" + zM59175g + "hasBackup:" + zM59174f + "isReleaseDevice:" + zCheckReleasedDevices + "haveRestored:" + haveRestored + "isValidTime:" + zCheckNotifyTime + "isRestoreForground:" + zEquals);
        if (zM59176h && !zM59175g && zM59174f && zCheckReleasedDevices && !haveRestored && zCheckNotifyTime && !zEquals) {
            m59178j(context, "login");
        }
    }

    /* renamed from: f */
    public boolean m59174f() {
        try {
            return new C10542o().m64679f1(true, true).getUserRecordItems().size() > 0;
        } catch (C9721b e10) {
            NotifyLogger.m29915i("RestoreNotifyManager", "query cloud backup records failed." + e10.getMessage());
            return false;
        }
    }

    /* renamed from: g */
    public boolean m59175g(Context context) {
        boolean zHasContactLocalData = RestoreNotifyUtil.hasContactLocalData(context);
        NotifyLogger.m29915i("RestoreNotifyManager", "hasContactLocalData: " + zHasContactLocalData);
        if (zHasContactLocalData) {
            return true;
        }
        boolean zHasCalendarLocalData = RestoreNotifyUtil.hasCalendarLocalData(context);
        NotifyLogger.m29915i("RestoreNotifyManager", "hasCalendarLocalData: " + zHasCalendarLocalData);
        if (zHasCalendarLocalData) {
            return true;
        }
        boolean zHasNoteLocalData = RestoreNotifyUtil.getInstance().hasNoteLocalData(context);
        NotifyLogger.m29915i("RestoreNotifyManager", "hasNoteLocalData: " + zHasNoteLocalData);
        return zHasNoteLocalData;
    }

    /* renamed from: h */
    public boolean m59176h(Context context) {
        return C13452e.m80781L().m80842P0() && C10028c.m62182c0().m62221H1();
    }

    /* renamed from: i */
    public final void m59177i(Context context) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("notify_time", String.valueOf(RestoreNotifyUtil.getInstance().getNotifiedCount(context)));
        C13225d.m79490f1().m79567R("restore_notify_send", linkedHashMap);
        UBAAnalyze.m29947H("CKC", "restore_notify_send", linkedHashMap);
    }

    /* renamed from: j */
    public void m59178j(Context context, String str) {
        NotifyLogger.m29915i("RestoreNotifyManager", "restoreNotify send start");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.hidisk", "com.huawei.android.hicloud.ui.activity.CloudBackupRecordsActivity"));
        intent.setAction("restore_notify_click");
        C0216g0.m1402e(context).m1408F(intent, "SOURCE_ID_OOBE_RESTORE_NOTIFY");
        PendingIntent pendingIntentM1248e0 = C0209d.m1248e0(context, 0, intent, 0);
        Bundle bundle = new Bundle();
        bundle.putString("android.substName", context.getResources().getString(R$string.HiCloud_app_name));
        RestoreNotifyContent noticeContent = RestoreNotifyUtil.getInstance().getNoticeContent(str);
        RestoreNotifyConfig restoreNotifyConfig = RestoreNotifyUtil.getInstance().getRestoreNotifyConfig(str);
        if (restoreNotifyConfig == null || noticeContent == null) {
            NotifyLogger.m29914e("RestoreNotifyManager", "RestoreNotifyConfig not found");
            return;
        }
        Notification notificationM3804d = C0230o.m1610e().m1613f(context, "").m3824y(R$drawable.logo_about_system).m3811l(noticeContent.getTitle()).m3825z(new NotificationCompat.C0605b().m3839h(noticeContent.getSubTitle())).m3809j(pendingIntentM1248e0).m3821v(C0241z.m1685c(restoreNotifyConfig.getPriority())).m3807h(true).m3817r("com.huawei.android.hicloud").m3803c(bundle).m3804d();
        NotifyLogger.m29915i("RestoreNotifyManager", "restoreNotify send end");
        ((NotificationManager) context.getSystemService("notification")).notify(1, notificationM3804d);
        RestoreNotifyUtil.getInstance().saveNotifiedCount(context, RestoreNotifyUtil.getInstance().getNotifiedCount(context) + 1);
        RestoreNotifyUtil.getInstance().saveNotifyTime(context);
        m59177i(context);
    }

    /* renamed from: k */
    public void m59179k(Context context, int i10) {
        NotifyLogger.m29915i("RestoreNotifyManager", "setScheduleJob RecoverRemindJobService");
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null) {
            NotifyLogger.m29914e("RestoreNotifyManager", "jobscheduler is null");
        } else {
            long j10 = i10 * 60000;
            jobScheduler.schedule(new JobInfo.Builder(1, new ComponentName(context, (Class<?>) RestoreNotifyJobService.class)).setMinimumLatency(j10).setOverrideDeadline(j10 + 60000).setRequiredNetworkType(1).build());
        }
    }
}
