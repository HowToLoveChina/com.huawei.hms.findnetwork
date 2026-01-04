package id;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupNotificationV5Util;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.p106db.bean.BaseNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.backupspaceinsufficientconfig.BackupSpaceInsuffNoticeV5Configuration;
import fk.C9721b;
import p514o9.C11839m;

/* renamed from: id.d */
/* loaded from: classes3.dex */
public class C10470d extends AbstractC10468b {

    /* renamed from: f */
    public BackupSpaceInsuffNoticeV5Configuration f50456f;

    /* renamed from: g */
    public NotEnoughDialogDataV5 f50457g;

    /* renamed from: id.d$a */
    public static class a {

        /* renamed from: a */
        public static final C10470d f50458a = new C10470d();
    }

    /* renamed from: o */
    private boolean m64354o() {
        C11839m.m70688i("BackupFailCheckV5Timer", "backupFailDialogNotify start.");
        if (this.f50450b == null) {
            C11839m.m70687e("BackupFailCheckV5Timer", "backupFailDialogNotify mContext is null.");
            return false;
        }
        if (m64342c()) {
            BackupNotificationV5Util.startNotificationActivity(true, this.f50450b, this.f50457g, this.f50456f);
            return true;
        }
        C11839m.m70689w("BackupFailCheckV5Timer", "get familyshareInfo ok,but now can not show,delay.");
        return false;
    }

    /* renamed from: p */
    public static C10470d m64355p(Context context) {
        if (context != null && a.f50458a.f50450b == null) {
            a.f50458a.m64345g(context);
        }
        return a.f50458a;
    }

    @Override // id.AbstractC10468b, p616rk.AbstractRunnableC12516b
    public void call() {
        C11839m.m70688i("BackupFailCheckV5Timer", "BackupFailCheckV5Timer call isShowBackupFailDialog = " + this.f50449a);
        try {
            super.call();
        } catch (C9721b e10) {
            C11839m.m70687e("BackupFailCheckV5Timer", "call exception: " + e10.toString());
        }
    }

    @Override // id.AbstractC10468b
    /* renamed from: f */
    public BaseNotifyBean mo64336f() {
        return this.f50456f;
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
        if (m64354o()) {
            C11839m.m70688i("BackupFailCheckV5Timer", " backup fail onUserPresent check Home or Forground");
            this.f50449a = true;
            m64343d();
        }
    }

    /* renamed from: q */
    public void m64356q(NotEnoughDialogDataV5 notEnoughDialogDataV5) {
        this.f50457g = notEnoughDialogDataV5;
    }

    /* renamed from: r */
    public void m64357r(BackupSpaceInsuffNoticeV5Configuration backupSpaceInsuffNoticeV5Configuration) {
        this.f50456f = backupSpaceInsuffNoticeV5Configuration;
    }
}
