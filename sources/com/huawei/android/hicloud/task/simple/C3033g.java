package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice.BackupSpaceInsufficientNotifyUtil;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import p015ak.C0209d;
import p052cb.C1412i;
import p514o9.C11829c;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12367d;

/* renamed from: com.huawei.android.hicloud.task.simple.g */
/* loaded from: classes3.dex */
public class C3033g extends AbstractC12367d {

    /* renamed from: a */
    public Context f13270a;

    /* renamed from: b */
    public BackupSpaceNotEnoughNeedData f13271b;

    /* renamed from: c */
    public C12295b f13272c;

    /* renamed from: d */
    public boolean f13273d;

    /* renamed from: e */
    public BaseSpaceNotifyBean f13274e;

    public C3033g(Context context, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, boolean z10, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        this.f13270a = context;
        this.f13271b = backupSpaceNotEnoughNeedData;
        this.f13272c = c12295b;
        this.f13273d = z10;
        this.f13274e = baseSpaceNotifyBean;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("BackupSpaceInsufficientNotifyTask", "BackupSpaceInsufficientNotifyTask start.");
        if (this.f13270a == null) {
            C11839m.m70687e("BackupSpaceInsufficientNotifyTask", "BackupSpaceInsufficientNotifyTask mContext is null.");
            return;
        }
        if (this.f13271b == null) {
            C11839m.m70687e("BackupSpaceInsufficientNotifyTask", "BackupSpaceInsufficientNotifyTask backupSpaceNotEnoughNeedData is null.");
            return;
        }
        int activityType = this.f13274e.getActivityType();
        if (this.f13273d && NotifyUtil.isDialogSilent(this.f13270a, this.f13274e)) {
            boolean zIsSilentDelay = NotifyUtil.isSilentDelay();
            C11839m.m70687e("BackupSpaceInsufficientNotifyTask", "BackupSpaceInsufficientNotifyTask in silent time, dialog not show silentDelay = " + zIsSilentDelay);
            if (zIsSilentDelay) {
                return;
            }
            ScreenListener.m18023c(this.f13270a).m18028g();
            UserSpaceUtil.checkAndClearDlgDelayInfo(this.f13272c);
            BackupSpaceInsufficientNotifyUtil backupSpaceInsufficientNotifyUtil = new BackupSpaceInsufficientNotifyUtil();
            NotificationBIReportUtil.reportDialogMuted(backupSpaceInsufficientNotifyUtil.getNotificationReportScreenPresentChcekType(activityType));
            NotificationReportUtil.reportDialogMuted(backupSpaceInsufficientNotifyUtil.getNotificationReportScreenPresentChcekType(activityType));
            return;
        }
        if (activityType == 0) {
            try {
                this.f13271b.setFamilyShareMember(C11829c.m70629x0(true));
            } catch (C1412i e10) {
                C11839m.m70687e("BackupSpaceInsufficientNotifyTask", e10.toString());
                return;
            }
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
        intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, this.f13271b);
        this.f13272c.m73864A(C0209d.m1295q(this.f13270a));
        intent.putExtra("backup_space_not_enough_need_info_key", this.f13272c);
        intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(this.f13274e));
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        C0209d.m1302r2(intent, this.f13270a.getPackageName());
        this.f13270a.startActivity(intent);
        ScreenListener.m18023c(this.f13270a).m18028g();
        UserSpaceUtil.checkAndClearDlgDelayInfo(this.f13272c);
    }
}
