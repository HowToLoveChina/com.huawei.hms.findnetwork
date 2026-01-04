package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupNotificationV5Util;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration;
import com.huawei.hicloud.notification.util.NotifyUtil;
import p514o9.C11839m;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.f */
/* loaded from: classes3.dex */
public class C3029f extends AbstractC12367d {

    /* renamed from: a */
    public Context f13264a;

    /* renamed from: b */
    public boolean f13265b;

    /* renamed from: c */
    public BackupSpaceInsuffNoticeV5Configuration f13266c;

    /* renamed from: d */
    public NotEnoughDialogDataV5 f13267d;

    public C3029f(Context context, NotEnoughDialogDataV5 notEnoughDialogDataV5, boolean z10, BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        this.f13264a = context;
        this.f13267d = notEnoughDialogDataV5;
        this.f13265b = z10;
        this.f13266c = backupSpaceInsuffNoticeV5Configuration;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("BackupNotEnoughV5NotifyTask", "BackupNotEnoughV5NotifyTask start.");
        Context context = this.f13264a;
        if (context == null) {
            C11839m.m70687e("BackupNotEnoughV5NotifyTask", "BackupNotEnoughV5NotifyTask mContext is null.");
            return;
        }
        if (this.f13267d == null) {
            C11839m.m70687e("BackupNotEnoughV5NotifyTask", "BackupNotEnoughV5NotifyTask notEnoughDialogDataV5 is null.");
            return;
        }
        if (!this.f13265b || !NotifyUtil.isDialogSilent(context, this.f13266c)) {
            BackupNotificationV5Util.startNotificationActivity(true, this.f13264a, this.f13267d, this.f13266c);
            return;
        }
        boolean zIsSilentDelay = NotifyUtil.isSilentDelay();
        C11839m.m70687e("BackupNotEnoughV5NotifyTask", "BackupNotEnoughV5NotifyTask in silent time, dialog not show silentDelay = " + zIsSilentDelay);
        if (zIsSilentDelay) {
            return;
        }
        ScreenListener.m18023c(this.f13264a).m18028g();
        UserSpaceUtil.checkAndClearDlgDelayInfo(this.f13267d.getTaskId());
        NotificationBIReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_SCREEN_PRESENT_CHECK);
        NotificationReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_SCREEN_PRESENT_CHECK);
    }
}
