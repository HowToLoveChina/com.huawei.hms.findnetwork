package id;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.uikit.hwrecyclerview.widget.HwRecyclerView;
import fk.C9721b;
import p015ak.C0209d;
import p052cb.C1412i;
import p514o9.C11829c;
import p514o9.C11839m;

/* renamed from: id.c */
/* loaded from: classes3.dex */
public class C10469c extends AbstractC10468b {

    /* renamed from: f */
    public SpaceNotification f50454f;

    /* renamed from: id.c$a */
    public static class a {

        /* renamed from: a */
        public static final C10469c f50455a = new C10469c();
    }

    /* renamed from: p */
    public static C10469c m64350p(Context context) {
        if (context != null && a.f50455a.f50450b == null) {
            a.f50455a.m64345g(context);
        }
        return a.f50455a;
    }

    @Override // id.AbstractC10468b, p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("BackupFailCheckTimer", "BackupFailCheckTimer call isShowBackupFailDialog = " + this.f50449a);
        try {
            super.call();
        } catch (C9721b e10) {
            C11839m.m70687e("BackupFailCheckTimer", "call exception: " + e10.toString());
        }
    }

    @Override // id.AbstractC10468b
    /* renamed from: f */
    public BaseNotifyBean mo64336f() {
        return this.f50454f;
    }

    @Override // id.AbstractC10468b
    /* renamed from: h */
    public void mo64337h() {
        NotificationBIReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_CHECK_TIMER);
        NotificationReportUtil.reportDialogMuted(NotifyConstants.NotificationReport.VALUE_BACKUP_CHECK_TIMER);
    }

    @Override // id.AbstractC10468b
    /* renamed from: n */
    public void mo64338n() {
        if (m64351o()) {
            C11839m.m70688i("BackupFailCheckTimer", " backup fail onUserPresent check Home or Forground");
            this.f50449a = true;
            m64343d();
        }
    }

    /* renamed from: o */
    public final boolean m64351o() {
        C11839m.m70688i("BackupFailCheckTimer", "backupFailDialogNotify start.");
        if (this.f50450b == null) {
            C11839m.m70687e("BackupFailCheckTimer", "backupFailDialogNotify mContext is null.");
            return false;
        }
        if (this.f50451c == null) {
            C11839m.m70687e("BackupFailCheckTimer", "backupFailDialogNotify backupSpaceNotEnoughNeedData is null.");
            return false;
        }
        try {
            this.f50451c.setFamilyShareMember(C11829c.m70629x0(true));
            if (!m64342c()) {
                C11839m.m70689w("BackupFailCheckTimer", "get familyshareInfo ok,but now can not show,delay.");
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("com.huawei.android.hicloud.BackupNotificationActivity");
            intent.putExtra(NotifyConstants.BackupNotificationType.FIELD, 7);
            this.f50452d.m73864A(C0209d.m1295q(this.f50450b));
            intent.putExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY, this.f50451c);
            intent.putExtra("backup_space_not_enough_need_info_key", this.f50452d);
            intent.putExtra("backup_space_not_enough_notification_key", new Gson().toJson(this.f50454f));
            intent.addFlags(HwRecyclerView.ITEM_TYPE_NO_SNAP_MASK);
            C0209d.m1302r2(intent, this.f50450b.getPackageName());
            this.f50450b.startActivity(intent);
            UserSpaceUtil.checkAndClearDlgDelayInfo(this.f50452d);
            return true;
        } catch (C1412i e10) {
            C11839m.m70687e("BackupFailCheckTimer", e10.toString());
            return false;
        }
    }

    /* renamed from: q */
    public void m64352q(SpaceNotification spaceNotification) {
        this.f50454f = spaceNotification;
    }
}
