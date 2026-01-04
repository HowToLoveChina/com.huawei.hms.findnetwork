package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.text.TextUtils;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupSpaceInsufficientV5Dialog;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.manager.NotifyBlackListManager;
import java.util.List;
import je.C10811y;
import p015ak.C0212e0;
import p514o9.C11839m;
import p618rm.C12540b1;

/* renamed from: com.huawei.android.hicloud.ui.activity.c0 */
/* loaded from: classes3.dex */
public class C3561c0 {

    /* renamed from: a */
    public final Activity f16488a;

    /* renamed from: b */
    public BackupSpaceInsufficientV5Dialog f16489b;

    public C3561c0(BackupNotificationActivity backupNotificationActivity) {
        this.f16488a = backupNotificationActivity;
    }

    /* renamed from: a */
    public final void m22703a() {
        Activity activity = this.f16488a;
        if (activity == null || activity.isFinishing() || this.f16488a.isDestroyed()) {
            return;
        }
        this.f16488a.finish();
    }

    /* renamed from: b */
    public void m22704b() {
        C11839m.m70688i("BackupNotificationV5Process", "onCreate");
    }

    /* renamed from: c */
    public void m22705c() {
        BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog = this.f16489b;
        if (backupSpaceInsufficientV5Dialog != null) {
            backupSpaceInsufficientV5Dialog.onDestroy();
        }
    }

    /* renamed from: d */
    public void m22706d() {
        C11839m.m70688i("BackupNotificationV5Process", "onNewIntent");
        BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog = this.f16489b;
        if (backupSpaceInsufficientV5Dialog != null) {
            backupSpaceInsufficientV5Dialog.onDestroy();
        }
    }

    /* renamed from: e */
    public void m22707e() {
        C11839m.m70688i("BackupNotificationV5Process", "onPause");
    }

    /* renamed from: f */
    public void m22708f() {
        C11839m.m70688i("BackupNotificationV5Process", "onRestart");
    }

    /* renamed from: g */
    public void m22709g() {
        C11839m.m70688i("BackupNotificationV5Process", "onStop");
    }

    /* renamed from: h */
    public boolean m22710h(String str, RenewAgreementTextview.RenewAgreementTVCallback renewAgreementTVCallback, List<PortraitAndGrade.UserTag> list) {
        if (TextUtils.isEmpty(str)) {
            C11839m.m70687e("BackupNotificationV5Process", "process v5 notificationStr is empty");
            return false;
        }
        NotEnoughDialogDataV5 notEnoughDialogDataV5 = (NotEnoughDialogDataV5) C12540b1.m75483a(str, NotEnoughDialogDataV5.class);
        if (notEnoughDialogDataV5 == null) {
            C11839m.m70687e("BackupNotificationV5Process", "process v5 notEnoughDialogDataV5 is empty");
            C10811y.m65822f("SpaceNotEnoughV5Error", "5", "process v5 notEnoughDialogDataV5 is empty");
            m22703a();
            return true;
        }
        if (!notEnoughDialogDataV5.checkDataValid()) {
            C11839m.m70687e("BackupNotificationV5Process", "process v5 notEnoughDialogDataV5 is invalid");
            C10811y.m65822f("SpaceNotEnoughV5Error", "5", "process v5 notEnoughDialogDataV5 is invalid");
            m22703a();
            return true;
        }
        if (NotifyBlackListManager.getInstance().isInBlackDialogList(NotifyBlackListManager.getInstance().getNotifyBackListConfigLocal(), 9, list)) {
            C11839m.m70687e("BackupNotificationV5Process", "process v5 is inBlackList");
            m22703a();
            return true;
        }
        C11839m.m70688i("BackupNotificationV5Process", "show V5Dialog");
        int iM1357g = C0212e0.m1357g(this.f16488a, "sp_desktop_dialog", "key_last_show_count", 0);
        C0212e0.m1370t(this.f16488a, "sp_desktop_dialog", "key_last_show_time", System.currentTimeMillis());
        C0212e0.m1368r(this.f16488a, "sp_desktop_dialog", "key_last_show_count", iM1357g + 1);
        BackupSpaceInsufficientV5Dialog backupSpaceInsufficientV5Dialog = new BackupSpaceInsufficientV5Dialog(this.f16488a, notEnoughDialogDataV5, renewAgreementTVCallback);
        this.f16489b = backupSpaceInsufficientV5Dialog;
        backupSpaceInsufficientV5Dialog.show();
        return true;
    }
}
