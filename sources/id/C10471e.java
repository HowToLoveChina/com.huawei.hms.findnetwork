package id;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice.BackupSpaceInsufficientNotifyUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import p015ak.C0209d;
import p052cb.C1412i;
import p514o9.C11829c;
import p514o9.C11839m;

/* renamed from: id.e */
/* loaded from: classes3.dex */
public class C10471e extends AbstractC10468b {

    /* renamed from: f */
    public BaseSpaceNotifyBean f50459f;

    /* renamed from: id.e$a */
    public static class a {

        /* renamed from: a */
        public static C10471e f50460a = new C10471e();
    }

    /* renamed from: p */
    public static C10471e m64359p(Context context) {
        if (context != null && a.f50460a.f50450b == null) {
            a.f50460a.m64345g(context);
        }
        return a.f50460a;
    }

    @Override // id.AbstractC10468b, p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("BackupSpaceInsufficientNotifyFailCheckTimer", "BackupSpaceInsufficientNotifyFailCheckTimer call isShowBackupFailDialog = " + this.f50449a);
        try {
            super.call();
        } catch (C9721b e10) {
            C11839m.m70687e("BackupSpaceInsufficientNotifyFailCheckTimer", "call exception: " + e10.toString());
        }
    }

    @Override // id.AbstractC10468b
    /* renamed from: f */
    public BaseNotifyBean mo64336f() {
        return this.f50459f;
    }

    @Override // id.AbstractC10468b
    /* renamed from: h */
    public void mo64337h() {
        int activityType = this.f50459f.getActivityType();
        BackupSpaceInsufficientNotifyUtil backupSpaceInsufficientNotifyUtil = new BackupSpaceInsufficientNotifyUtil();
        NotificationBIReportUtil.reportDialogMuted(backupSpaceInsufficientNotifyUtil.getNotificationReportTimerType(activityType), NotifyConstants.DETAIL3);
        NotificationReportUtil.reportDialogMuted(backupSpaceInsufficientNotifyUtil.getNotificationReportTimerType(activityType), NotifyConstants.DETAIL3);
    }

    @Override // id.AbstractC10468b
    /* renamed from: n */
    public void mo64338n() {
        m64360o();
    }

    /* renamed from: o */
    public final void m64360o() {
        if (this.f50450b == null) {
            C11839m.m70687e("BackupSpaceInsufficientNotifyFailCheckTimer", "BackupSpaceInsufficientNotifyFailCheckTimer mContext is null.");
            return;
        }
        if (this.f50451c == null) {
            C11839m.m70687e("BackupSpaceInsufficientNotifyFailCheckTimer", "BackupSpaceInsufficientNotifyFailCheckTimer backupSpaceNotEnoughNeedData is null.");
            return;
        }
        if (this.f50459f.getActivityType() == 0) {
            try {
                this.f50451c.setFamilyShareMember(C11829c.m70629x0(true));
            } catch (C1412i e10) {
                C11839m.m70687e("BackupSpaceInsufficientNotifyFailCheckTimer", e10.toString());
                return;
            }
        }
        Intent intent = new Intent();
        intent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
        intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
        intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, this.f50451c);
        this.f50452d.m73864A(C0209d.m1295q(this.f50450b));
        intent.putExtra("backup_space_not_enough_need_info_key", this.f50452d);
        intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(this.f50459f));
        intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
        C0209d.m1302r2(intent, this.f50450b.getPackageName());
        this.f50450b.startActivity(intent);
        UserSpaceUtil.checkAndClearDlgDelayInfo(this.f50452d);
    }

    /* renamed from: q */
    public void m64361q(BaseSpaceNotifyBean baseSpaceNotifyBean) {
        this.f50459f = baseSpaceNotifyBean;
    }
}
