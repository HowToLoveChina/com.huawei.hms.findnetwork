package id;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import p015ak.C0209d;
import p514o9.C11839m;

/* renamed from: id.a */
/* loaded from: classes3.dex */
public class C10467a extends AbstractC10468b {

    /* renamed from: f */
    public NotificationWithActivity f50447f;

    /* renamed from: id.a$a */
    public static class a {

        /* renamed from: a */
        public static C10467a f50448a = new C10467a();
    }

    /* renamed from: p */
    public static C10467a m64335p(Context context) {
        if (context != null && a.f50448a.f50450b == null) {
            a.f50448a.m64345g(context);
        }
        return a.f50448a;
    }

    @Override // id.AbstractC10468b, p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("BackupActivityFailCheckTimer", "BackupActivityFailCheckTimer call isShowBackupFailDialog = " + this.f50449a);
        try {
            super.call();
        } catch (C9721b e10) {
            C11839m.m70687e("BackupActivityFailCheckTimer", "call exception: " + e10.toString());
        }
    }

    @Override // id.AbstractC10468b
    /* renamed from: f */
    public BaseNotifyBean mo64336f() {
        return this.f50447f;
    }

    @Override // id.AbstractC10468b
    /* renamed from: h */
    public void mo64337h() {
        NotificationBIReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_CHECK_TIMER);
        NotificationReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_ACTIVITY_CHECK_TIMER);
    }

    @Override // id.AbstractC10468b
    /* renamed from: n */
    public void mo64338n() {
        m64339o();
    }

    /* renamed from: o */
    public final void m64339o() {
        if (this.f50450b == null) {
            C11839m.m70687e("BackupActivityFailCheckTimer", "backupFailDialogNotifyActivity mContext is null.");
            return;
        }
        if (this.f50451c == null) {
            C11839m.m70687e("BackupActivityFailCheckTimer", "backupFailDialogNotifyActivity backupSpaceNotEnoughNeedData is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        this.f50452d.m73864A(C0209d.m1295q(this.f50450b));
        intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, this.f50451c);
        intent.putExtra("backup_space_not_enough_need_info_key", this.f50452d);
        intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(this.f50447f));
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        C0209d.m1302r2(intent, this.f50450b.getPackageName());
        this.f50450b.startActivity(intent);
        UserSpaceUtil.checkAndClearDlgDelayInfo(this.f50452d);
    }

    /* renamed from: q */
    public void m64340q(NotificationWithActivity notificationWithActivity) {
        this.f50447f = notificationWithActivity;
    }
}
