package com.huawei.android.hicloud.task.simple;

import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.NotifyTimerSpManager;
import com.huawei.hicloud.notification.util.TimerCheckCallback;
import com.huawei.hms.network.embedded.C5843a0;
import java.util.HashMap;
import java.util.Timer;
import p015ak.C0209d;
import p514o9.C11839m;

/* renamed from: com.huawei.android.hicloud.task.simple.a */
/* loaded from: classes3.dex */
public class C3009a implements TimerCheckCallback {

    /* renamed from: a */
    public Timer f13129a = new Timer();

    /* renamed from: b */
    public BackupSpaceNotEnoughNeedData f13130b;

    public C3009a(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData) {
        this.f13130b = backupSpaceNotEnoughNeedData;
    }

    /* renamed from: a */
    public void m18128a() {
        C11839m.m70688i("AutoBackupNotifyTimer", "timer execute");
        NotifyTimerSpManager.getInstance().recordAutoBackupNotifyTimerStart(this.f13130b);
        C3013b c3013b = new C3013b(this);
        int iM1260h0 = C0209d.m1260h0(0, C5843a0.f26297c);
        C11839m.m70688i("AutoBackupNotifyTimer", "timer schedule millisecond: " + iM1260h0);
        this.f13129a.schedule(c3013b, (long) iM1260h0);
        m18130c(iM1260h0);
    }

    /* renamed from: b */
    public final void m18129b() {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.KEY_AUTO_BACKUP_NOTICE_DELAY_EVENT, NotifyConstants.NotificationReport.EVENT_NAME_DELAY_TIMER_CHECK_SUCCESS);
        map.put(NotifyConstants.NotificationReport.KEY_BACKUP_NOTICE_NEED_DATA, this.f13130b.toString());
        NotificationReportUtil.reportAutoBackupNoticeDelay(map);
    }

    /* renamed from: c */
    public final void m18130c(int i10) {
        HashMap map = new HashMap();
        map.put(NotifyConstants.NotificationReport.KEY_AUTO_BACKUP_NOTICE_DELAY_EVENT, NotifyConstants.NotificationReport.EVENT_NAME_START_DELAY_TIMER);
        map.put(NotifyConstants.NotificationReport.KEY_DELAY_RANDOM_TIME, String.valueOf(i10));
        map.put(NotifyConstants.NotificationReport.KEY_BACKUP_NOTICE_NEED_DATA, this.f13130b.toString());
        NotificationReportUtil.reportAutoBackupNoticeDelay(map);
    }

    @Override // com.huawei.hicloud.notification.util.TimerCheckCallback
    public void checkFailed() {
        C11839m.m70688i("AutoBackupNotifyTimer", "check failed");
        this.f13129a.cancel();
    }

    @Override // com.huawei.hicloud.notification.util.TimerCheckCallback
    public void checkSuccess() {
        C11839m.m70688i("AutoBackupNotifyTimer", "check success");
        m18129b();
        this.f13129a.cancel();
        UserSpaceUtil.sendSpaceNotEnough(true, this.f13130b);
    }
}
