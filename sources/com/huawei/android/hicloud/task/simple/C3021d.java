package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p052cb.C1412i;
import p514o9.C11829c;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.d */
/* loaded from: classes3.dex */
public class C3021d extends AbstractC12367d {

    /* renamed from: a */
    public Context f13175a;

    /* renamed from: b */
    public C12295b f13176b;

    /* renamed from: c */
    public BackupSpaceNotEnoughNeedData f13177c;

    /* renamed from: d */
    public boolean f13178d;

    /* renamed from: e */
    public NotificationWithActivity f13179e;

    public C3021d(Context context, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, boolean z10, NotificationWithActivity notificationWithActivity) {
        this.f13175a = context;
        this.f13177c = backupSpaceNotEnoughNeedData;
        this.f13176b = c12295b;
        this.f13178d = z10;
        this.f13179e = notificationWithActivity;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        boolean zM70629x0;
        C11839m.m70688i("BackupNotEnoughNotifyActivityTask", "BackupNotEnoughNotifyActivityTask start.");
        Context context = this.f13175a;
        if (context == null) {
            C11839m.m70687e("BackupNotEnoughNotifyActivityTask", "BackupNotEnoughNotifyActivityTask mContext is null.");
            return;
        }
        if (this.f13177c == null) {
            C11839m.m70687e("BackupNotEnoughNotifyActivityTask", "BackupNotEnoughNotifyActivityTask backupSpaceNotEnoughNeedData is null.");
            return;
        }
        if (this.f13178d && NotifyUtil.isDialogSilent(context, this.f13179e)) {
            boolean zIsSilentDelay = NotifyUtil.isSilentDelay();
            C11839m.m70687e("BackupNotEnoughNotifyActivityTask", "BackupNotEnoughNotifyActivityTask in silent time, dialog not show silentDelay = " + zIsSilentDelay);
            if (zIsSilentDelay) {
                return;
            }
            ScreenListener.m18023c(this.f13175a).m18028g();
            UserSpaceUtil.checkAndClearDlgDelayInfo(this.f13176b);
            NotificationBIReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_SCREEN_PRESENT_CHECK);
            NotificationReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_SCREEN_PRESENT_CHECK);
            return;
        }
        try {
            zM70629x0 = C11829c.m70629x0(true);
        } catch (C1412i unused) {
            C11839m.m70687e("BackupNotEnoughNotifyActivityTask", "Show task center dialog, but user is share member");
            zM70629x0 = false;
        }
        this.f13177c.setFamilyShareMember(zM70629x0);
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, this.f13177c);
        this.f13176b.m73864A(C0209d.m1295q(this.f13175a));
        intent.putExtra("backup_space_not_enough_need_info_key", this.f13176b);
        intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(this.f13179e));
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        C0209d.m1302r2(intent, this.f13175a.getPackageName());
        this.f13175a.startActivity(intent);
        ScreenListener.m18023c(this.f13175a).m18028g();
        UserSpaceUtil.checkAndClearDlgDelayInfo(this.f13176b);
    }
}
