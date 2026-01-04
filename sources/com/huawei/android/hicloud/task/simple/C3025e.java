package com.huawei.android.hicloud.task.simple;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.CloudBackupDetailStateActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.notification.util.NotifyUtil;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import java.util.LinkedHashMap;
import p015ak.C0209d;
import p052cb.C1412i;
import p514o9.C11829c;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12367d;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;

/* renamed from: com.huawei.android.hicloud.task.simple.e */
/* loaded from: classes3.dex */
public class C3025e extends AbstractC12367d {

    /* renamed from: a */
    public Context f13218a;

    /* renamed from: b */
    public BackupSpaceNotEnoughNeedData f13219b;

    /* renamed from: c */
    public C12295b f13220c;

    /* renamed from: d */
    public boolean f13221d;

    /* renamed from: e */
    public SpaceNotification f13222e;

    public C3025e(Context context, BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, boolean z10, SpaceNotification spaceNotification) {
        this.f13218a = context;
        this.f13219b = backupSpaceNotEnoughNeedData;
        this.f13220c = c12295b;
        this.f13221d = z10;
        this.f13222e = spaceNotification;
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("BackupNotEnoughNotifyTask", "BackupNotEnoughNotifyTask start.");
        Context context = this.f13218a;
        if (context == null) {
            C11839m.m70687e("BackupNotEnoughNotifyTask", "BackupNotEnoughNotifyTask mContext is null.");
            return;
        }
        if (this.f13219b == null) {
            C11839m.m70687e("BackupNotEnoughNotifyTask", "BackupNotEnoughNotifyTask backupSpaceNotEnoughNeedData is null.");
            return;
        }
        if (this.f13221d && NotifyUtil.isDialogSilent(context, this.f13222e)) {
            boolean zIsSilentDelay = NotifyUtil.isSilentDelay();
            C11839m.m70687e("BackupNotEnoughNotifyTask", "BackupNotEnoughNotifyTask in silent time, dialog not show silentDelay = " + zIsSilentDelay);
            if (zIsSilentDelay) {
                return;
            }
            ScreenListener.m18023c(this.f13218a).m18028g();
            UserSpaceUtil.checkAndClearDlgDelayInfo(this.f13220c);
            NotificationBIReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_SCREEN_PRESENT_CHECK);
            NotificationReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_SCREEN_PRESENT_CHECK);
            return;
        }
        try {
            this.f13219b.setFamilyShareMember(C11829c.m70629x0(true));
            if (!C0209d.m1265i1(this.f13218a) && !C0209d.m1245d1(this.f13218a, BackupMainActivity.class.getName()) && !C0209d.m1245d1(this.f13218a, CloudBackupDetailStateActivity.class.getName()) && !C0209d.m1245d1(this.f13218a, MainActivity.class.getName())) {
                C11839m.m70687e("BackupNotEnoughNotifyTask", "call, current activity is invalid.");
                LinkedHashMap linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
                C13225d.m79490f1().m79591l0("notenough_dialog_invalid_acitivty", linkedHashMapM79499C);
                UBAAnalyze.m29958S("PVC", "notenough_dialog_invalid_acitivty", "4", "9", linkedHashMapM79499C);
                return;
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
            intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, this.f13219b);
            this.f13220c.m73864A(C0209d.m1295q(this.f13218a));
            intent.putExtra("backup_space_not_enough_need_info_key", this.f13220c);
            intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(this.f13222e));
            intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            C0209d.m1302r2(intent, this.f13218a.getPackageName());
            this.f13218a.startActivity(intent);
            ScreenListener.m18023c(this.f13218a).m18028g();
            UserSpaceUtil.checkAndClearDlgDelayInfo(this.f13220c);
        } catch (C1412i e10) {
            C11839m.m70687e("BackupNotEnoughNotifyTask", e10.toString());
        }
    }
}
