package p362i9;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.android.hicloud.cloudbackup.bean.BackupNotEnoughDlgInfo;
import com.huawei.android.hicloud.cloudbackup.bean.BackupNotEnoughDlgSpInfo;
import com.huawei.android.hicloud.cloudbackup.p076db.operator.SettingOperator;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.MainActivity;
import com.huawei.android.hicloud.task.backup.ScreenListener;
import com.huawei.android.hicloud.task.simple.C3021d;
import com.huawei.android.hicloud.task.simple.C3025e;
import com.huawei.android.hicloud.task.simple.C3029f;
import com.huawei.android.hicloud.task.simple.C3033g;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.manager.NotificationBIReportUtil;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import gp.C10028c;
import java.util.LinkedHashMap;
import je.C10811y;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p571q9.C12295b;
import p581qk.AbstractC12367d;
import p616rk.AbstractRunnableC12516b;
import p616rk.C12515a;
import p618rm.C12590s0;
import p620rp.InterfaceC12614b;

/* renamed from: i9.a */
/* loaded from: classes3.dex */
public class C10454a extends AbstractC12367d {

    /* renamed from: i9.a$a */
    public static class a implements ScreenListener.ScreenStateListener {

        /* renamed from: a */
        public Context f50423a;

        /* renamed from: b */
        public BackupNotEnoughDlgInfo f50424b;

        public a(Context context, BackupNotEnoughDlgInfo backupNotEnoughDlgInfo) {
            this.f50423a = context;
            this.f50424b = backupNotEnoughDlgInfo;
        }

        /* renamed from: a */
        public final boolean m64261a() {
            try {
                if (C0209d.m1265i1(this.f50423a) || C0209d.m1245d1(this.f50423a, BackupMainActivity.class.getName())) {
                    return true;
                }
                return C0209d.m1245d1(this.f50423a, MainActivity.class.getName());
            } catch (Exception unused) {
                C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener isShowBackupSpaceNotEnoughDlg exception");
                return false;
            }
        }

        /* renamed from: b */
        public void m64262b() {
            C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener reportDlgShowCondition");
            try {
                if (m64261a()) {
                    NotificationBIReportUtil.reportDialogMutedShowCondition(true, C0209d.m1194N1(this.f50423a));
                    NotificationReportUtil.reportDialogMutedShowCondition(true, C0209d.m1194N1(this.f50423a));
                }
            } catch (Exception e10) {
                C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener reportDlgShowCondition exception, " + e10.toString());
            }
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOff() {
            C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener onScreenOff");
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onScreenOn() {
            C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener  screenOn");
        }

        @Override // com.huawei.android.hicloud.task.backup.ScreenListener.ScreenStateListener
        public void onUserPresent() {
            C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener onUserPresent");
            if (this.f50424b != null && m64261a()) {
                if (this.f50424b.getNotifyType() == 1) {
                    C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener onUserPresent NOTIFY_TYPE_NORMAL");
                    if (this.f50424b.getBaseSpaceNotifyBean() != null) {
                        C12515a.m75110o().m75175e(new C3033g(C0213f.m1377a(), this.f50424b.getmBackupSpaceNotEnoughNeedData(), this.f50424b.getNeedInfo(), true, this.f50424b.getBaseSpaceNotifyBean()), true);
                        return;
                    } else {
                        C12515a.m75110o().m75175e(new C3025e(C0213f.m1377a(), this.f50424b.getmBackupSpaceNotEnoughNeedData(), this.f50424b.getNeedInfo(), true, this.f50424b.getNotification()), true);
                        return;
                    }
                }
                if (this.f50424b.getNotifyType() != 2 && this.f50424b.getNotifyType() != 3) {
                    if (this.f50424b.getNotifyType() == 4) {
                        C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener onUserPresent NOTIFY_TYPE_V5");
                        C12515a.m75110o().m75175e(new C3029f(C0213f.m1377a(), this.f50424b.getNotEnoughDialogDataV5(), true, this.f50424b.getSpaceInsufficientV5()), true);
                        return;
                    }
                    return;
                }
                C11839m.m70688i("AutoBackupDlgCheckTask", "DlgCheckScreenStateListener onUserPresent NOTIFY_TYPE_ACTIVITY");
                if (this.f50424b.getBaseSpaceNotifyBean() == null) {
                    C12515a.m75110o().m75175e(new C3021d(C0213f.m1377a(), this.f50424b.getmBackupSpaceNotEnoughNeedData(), this.f50424b.getNeedInfo(), true, this.f50424b.getNotificationWithActivity()), true);
                } else if (!C12590s0.m75837c1()) {
                    C12515a.m75110o().m75175e(new C3033g(C0213f.m1377a(), this.f50424b.getmBackupSpaceNotEnoughNeedData(), this.f50424b.getNeedInfo(), true, this.f50424b.getBaseSpaceNotifyBean()), true);
                } else {
                    C11839m.m70688i("AutoBackupDlgCheckTask", "onUserPresent NOTIFY_TYPE_ACTIVITY, isJustBoot return");
                    NotificationReportUtil.reportCloudBackupActivityNoSpace("0035", "onUserPresent NOTIFY_TYPE_ACTIVITY, isJustBoot return");
                }
            }
        }
    }

    @Override // p616rk.AbstractRunnableC12516b
    public void call() {
        try {
            if (!C10028c.m62182c0().m62388s("backup_key")) {
                C11839m.m70687e("AutoBackupDlgCheckTask", "AutoBackupDlgCheckTask, backup switch is close.");
                C10028c.m62183d0(C0213f.m1377a()).m62239L1("");
                C10811y.m65820d("auto_backup_dlg_check_clear_sp", new LinkedHashMap());
                return;
            }
            String strM62398u = C10028c.m62183d0(C0213f.m1377a()).m62398u();
            C11839m.m70688i("AutoBackupDlgCheckTask", "call task");
            if (TextUtils.isEmpty(strM62398u)) {
                C11839m.m70688i("AutoBackupDlgCheckTask", "AutoBackupDlgCheckTask info is null.");
                return;
            }
            BackupNotEnoughDlgInfo backupNotEnoughDlgInfo = (BackupNotEnoughDlgInfo) new Gson().fromJson(strM62398u, BackupNotEnoughDlgInfo.class);
            long jCurrentTimeMillis = System.currentTimeMillis();
            C11839m.m70688i("AutoBackupDlgCheckTask", "call task start before info");
            if (backupNotEnoughDlgInfo != null) {
                C12295b needInfo = backupNotEnoughDlgInfo.getNeedInfo();
                if (backupNotEnoughDlgInfo.getNotifyType() != 4) {
                    if (needInfo == null) {
                        C11839m.m70688i("AutoBackupDlgCheckTask", "call task execute needInfo is null.");
                        return;
                    }
                    C11839m.m70688i("AutoBackupDlgCheckTask", "call task execute id=" + needInfo.m73887p());
                }
                if (jCurrentTimeMillis - backupNotEnoughDlgInfo.getTimeStamp() > new SettingOperator().queryFinalBackupCycle() * 86400000) {
                    C10028c.m62183d0(C0213f.m1377a()).m62239L1("");
                    InterfaceC12614b.get().clearConfigurable(BackupNotEnoughDlgSpInfo.class);
                    C10028c.m62183d0(C0213f.m1377a()).m62232J3(NotifyConstants.NotificationReport.PARAM_BACKUP_FAIL_DIALOG_MUTED_SCENE, String.valueOf(true));
                    return;
                }
                Context contextM1377a = C0213f.m1377a();
                if (contextM1377a != null) {
                    a aVar = new a(contextM1377a, backupNotEnoughDlgInfo);
                    C11839m.m70688i("AutoBackupDlgCheckTask", "register DlgCheckScreenStateListener onUserPresent");
                    ScreenListener.m18023c(contextM1377a).m18025b(aVar);
                    aVar.m64262b();
                }
            }
        } catch (Exception e10) {
            C11839m.m70687e("AutoBackupDlgCheckTask", "call exception:" + e10.getMessage());
        }
    }

    @Override // p581qk.AbstractC12367d, p616rk.AbstractRunnableC12516b
    public AbstractRunnableC12516b.a getEnum() {
        return AbstractRunnableC12516b.a.NOTIFY_TIMER_CHECK;
    }
}
