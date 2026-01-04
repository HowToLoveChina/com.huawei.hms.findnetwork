package com.huawei.android.hicloud.p088ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.process.UserSpaceUtil;
import com.huawei.android.hicloud.cloudbackup.process.notification.backupspaceinsufficientnotice.BackupSpaceInsufficientPopUpWindowNotify;
import com.huawei.android.hicloud.p088ui.notification.BackupNotification;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupDoubleBtnAlertDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationDoubleBtnDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationSingleBtnDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupNotificationTrebleBtnDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupSpaceInsufficientNewDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupTrebleBtnAlertDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.CheckUserSpaceNotEnoughDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ExpiredDeleteDialog;
import com.huawei.android.hicloud.p088ui.uiextend.dialog.ExpiredDeleteSecondDialog;
import com.huawei.android.hicloud.p088ui.views.RenewAgreementTextview;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.messagecenter.bean.DeskPopupMsgObj;
import com.huawei.hicloud.notification.bean.PortraitAndGrade;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.notification.data.BackupSpaceNotEnoughNeedData;
import com.huawei.hicloud.notification.manager.NotificationReportUtil;
import com.huawei.hicloud.notification.manager.NotifyBlackListManager;
import com.huawei.hicloud.notification.p106db.bean.BaseSpaceNotifyBean;
import com.huawei.hicloud.notification.p106db.bean.NotificationWithActivity;
import com.huawei.hicloud.notification.p106db.bean.SpaceNotification;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.secure.android.common.intent.SafeIntent;
import fk.C9721b;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import p015ak.C0209d;
import p015ak.C0212e0;
import p015ak.C0216g0;
import p015ak.C0219i;
import p015ak.C0226l0;
import p015ak.C0234s;
import p336he.C10155f;
import p514o9.C11829c;
import p514o9.C11839m;
import p514o9.C11842p;
import p550pb.C12126b;
import p571q9.C12295b;
import p581qk.AbstractC12367d;
import p616rk.C12515a;
import p618rm.C12540b1;
import p674ub.C13149f;
import p684un.C13222a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p746wn.C13622a;
import p783xp.C13843a;
import sk.C12808e;

/* loaded from: classes3.dex */
public class BackupNotificationActivity extends Activity implements RenewAgreementTextview.RenewAgreementTVCallback {

    /* renamed from: o */
    public static String f13668o = "";

    /* renamed from: p */
    public static String f13669p = "";

    /* renamed from: a */
    public BackupNotificationSingleBtnDialog f13670a;

    /* renamed from: b */
    public BackupNotificationDoubleBtnDialog f13671b;

    /* renamed from: c */
    public BackupDoubleBtnAlertDialog f13672c;

    /* renamed from: d */
    public BackupNotificationTrebleBtnDialog f13673d;

    /* renamed from: e */
    public ExpiredDeleteDialog f13674e;

    /* renamed from: f */
    public BackupTrebleBtnAlertDialog f13675f;

    /* renamed from: g */
    public BackupSpaceInsufficientNewDialog f13676g;

    /* renamed from: h */
    public CheckUserSpaceNotEnoughDialog f13677h;

    /* renamed from: j */
    public int f13679j;

    /* renamed from: m */
    public boolean f13682m;

    /* renamed from: i */
    public C13149f f13678i = new C13149f();

    /* renamed from: k */
    public DialogInterfaceOnDismissListenerC3139c f13680k = new DialogInterfaceOnDismissListenerC3139c(new WeakReference(this));

    /* renamed from: l */
    public int f13681l = 0;

    /* renamed from: n */
    public C3561c0 f13683n = new C3561c0(this);

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupNotificationActivity$a */
    public class C3137a extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ SafeIntent f13684a;

        public C3137a(SafeIntent safeIntent) {
            this.f13684a = safeIntent;
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            final List<PortraitAndGrade.UserTag> userTagsUseCache = UserSpaceUtil.getUserTagsUseCache("BackupNotificationActivity");
            final SafeIntent safeIntent = this.f13684a;
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16467a.m18863d(safeIntent, userTagsUseCache);
                }
            });
        }

        /* renamed from: d */
        public final /* synthetic */ void m18863d(SafeIntent safeIntent, List list) {
            BackupNotificationActivity.this.m18860l(safeIntent, list);
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupNotificationActivity$b */
    public class C3138b extends AbstractC12367d {

        /* renamed from: a */
        public final /* synthetic */ SafeIntent f13686a;

        public C3138b(SafeIntent safeIntent) {
            this.f13686a = safeIntent;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m18865d(SafeIntent safeIntent, List list) {
            BackupNotificationActivity.this.m18861m(safeIntent, list);
        }

        @Override // p616rk.AbstractRunnableC12516b
        public void call() throws C9721b {
            final List<PortraitAndGrade.UserTag> userTagsUseCache = UserSpaceUtil.getUserTagsUseCache("BackupNotificationActivity");
            final SafeIntent safeIntent = this.f13686a;
            C0226l0.m1584d(new Runnable() { // from class: com.huawei.android.hicloud.ui.activity.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16478a.m18865d(safeIntent, userTagsUseCache);
                }
            });
        }
    }

    /* renamed from: com.huawei.android.hicloud.ui.activity.BackupNotificationActivity$c */
    public static class DialogInterfaceOnDismissListenerC3139c implements DialogInterface.OnDismissListener {

        /* renamed from: a */
        public WeakReference<Activity> f13688a;

        public DialogInterfaceOnDismissListenerC3139c(WeakReference<Activity> weakReference) {
            this.f13688a = weakReference;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            WeakReference<Activity> weakReference = this.f13688a;
            if (weakReference == null) {
                C11839m.m70689w("BackupNotificationActivity", "mActivityRef is null");
                return;
            }
            Activity activity = weakReference.get();
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                C11839m.m70689w("BackupNotificationActivity", "activity is finishing or destroyed");
            } else {
                C11839m.m70688i("BackupNotificationActivity", "dialog dismiss, ensure finish current activity");
                activity.finish();
            }
        }
    }

    /* renamed from: g */
    private void m18850g() {
        int i10;
        SafeIntent safeIntent = new SafeIntent(getIntent());
        try {
            this.f13681l = safeIntent.getIntExtra(NotifyConstants.BackupNotificationType.FIELD, 0);
            f13668o = safeIntent.getStringExtra("user_operation_text");
            f13669p = safeIntent.getStringExtra("user_operation_type");
            C11839m.m70688i("BackupNotificationActivity", "initData: " + this.f13681l);
            i10 = this.f13681l;
        } catch (Throwable unused) {
            C11839m.m70687e("BackupNotificationActivity", "intent Serializable error.");
            finish();
        }
        if (i10 == 1) {
            C11839m.m70688i("BackupNotificationActivity", "BackupNotificationType.RESTORING");
            this.f13670a.show(getString(R$string.restoring_app_notification_title), getString(R$string.restoring_app_notification_message));
            return;
        }
        if (i10 == 2) {
            C11839m.m70688i("BackupNotificationActivity", "BackupNotificationType.RESTORE_BY_WLAN");
            this.f13671b.show(2);
            return;
        }
        if (i10 == 3) {
            this.f13670a.show(null, getString(R$string.restore_failed_tip));
            return;
        }
        if (i10 == 4) {
            C11839m.m70688i("BackupNotificationActivity", "Constant.BackupNotificationType.RESTORE_FINISH");
            finish();
            return;
        }
        if (i10 == 16) {
            C11839m.m70688i("BackupNotificationActivity", "DATA_EXPIRED_DELETE");
            DeskPopupMsgObj deskPopupMsgObj = (DeskPopupMsgObj) safeIntent.getSerializableExtra("desktop_pop_data", DeskPopupMsgObj.class);
            if (deskPopupMsgObj != null) {
                ExpiredDeleteDialog expiredDeleteDialog = new ExpiredDeleteDialog(this, deskPopupMsgObj);
                this.f13674e = expiredDeleteDialog;
                expiredDeleteDialog.show();
                return;
            } else {
                C11839m.m70689w("BackupNotificationActivity", "DATA_EXPIRED_DELETE, deskPopupMsgObj is null");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("from_where", getClass().getName());
                NotificationReportUtil.reportPageDialogEvent("event_id_data_expired_delete", "deskPopupMsgObj is null, not show", linkedHashMap);
                finish();
                return;
            }
        }
        if (i10 == 17) {
            C12515a.m75110o().m75172d(new C3138b(safeIntent));
            return;
        }
        switch (i10) {
            case 7:
                C12515a.m75110o().m75172d(new C3137a(safeIntent));
                break;
            case 8:
                C11839m.m70688i("BackupNotificationActivity", "SPACE_NOTIFY_PACKAGE_INFO");
                Bundle extras = safeIntent.getExtras();
                extras.putString("user_tags_key", C13622a.m81963i());
                if (!TextUtils.isEmpty(f13668o)) {
                    extras.putString("user_operation_text", f13668o);
                    extras.putString("user_operation_type", f13669p);
                }
                m18857j(safeIntent, extras);
                C12126b.m72707c("2", extras);
                finish();
                break;
            case 9:
                C11839m.m70688i("BackupNotificationActivity", "SPACE_NOT_ENOUGH_UPLOAD_FAIL ");
                this.f13677h.show(9);
                break;
            case 10:
                C11839m.m70688i("BackupNotificationActivity", "CLOSE ");
                finish();
                break;
            default:
                finish();
                break;
        }
    }

    /* renamed from: i */
    private void m18851i() {
        BackupNotificationSingleBtnDialog backupNotificationSingleBtnDialog = new BackupNotificationSingleBtnDialog(this);
        this.f13670a = backupNotificationSingleBtnDialog;
        backupNotificationSingleBtnDialog.setOnDismissListener(this.f13680k);
        this.f13671b = new BackupNotificationDoubleBtnDialog(this);
        this.f13672c = new BackupDoubleBtnAlertDialog(this);
        BackupNotificationTrebleBtnDialog backupNotificationTrebleBtnDialog = new BackupNotificationTrebleBtnDialog(this);
        this.f13673d = backupNotificationTrebleBtnDialog;
        backupNotificationTrebleBtnDialog.setOnDismissListener(this.f13680k);
        BackupTrebleBtnAlertDialog backupTrebleBtnAlertDialog = new BackupTrebleBtnAlertDialog(this);
        this.f13675f = backupTrebleBtnAlertDialog;
        backupTrebleBtnAlertDialog.setOnDismissListener(this.f13680k);
        CheckUserSpaceNotEnoughDialog checkUserSpaceNotEnoughDialog = new CheckUserSpaceNotEnoughDialog(this);
        this.f13677h = checkUserSpaceNotEnoughDialog;
        checkUserSpaceNotEnoughDialog.setOnDismissListener(this.f13680k);
        BackupSpaceInsufficientNewDialog backupSpaceInsufficientNewDialog = new BackupSpaceInsufficientNewDialog(this);
        this.f13676g = backupSpaceInsufficientNewDialog;
        backupSpaceInsufficientNewDialog.setOnDismissListener(this.f13680k);
    }

    /* renamed from: c */
    public final int m18852c(int i10) {
        return i10 & 48;
    }

    /* renamed from: d */
    public final void m18853d(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b) throws JSONException {
        int iM73878f = c12295b.m73878f();
        int iM73888q = c12295b.m73888q();
        if (iM73878f == 1) {
            if (iM73888q == 3) {
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0014", "0003");
                this.f13675f.show(backupSpaceNotEnoughNeedData, c12295b);
                return;
            } else if (iM73888q == 2) {
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0014", "0003");
                this.f13672c.show(backupSpaceNotEnoughNeedData, c12295b, this);
                return;
            } else {
                NotificationReportUtil.reportCloudBackupActivityNoSpace("0004", "0003");
                this.f13672c.show(backupSpaceNotEnoughNeedData, c12295b, this);
                return;
            }
        }
        if (iM73888q == 3) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0014", "0003");
            this.f13673d.show(backupSpaceNotEnoughNeedData, c12295b);
        } else if (iM73888q == 2) {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0014", "0003");
            this.f13671b.show(backupSpaceNotEnoughNeedData, c12295b);
        } else {
            NotificationReportUtil.reportCloudBackupActivityNoSpace("0004", "0003");
            this.f13671b.show(backupSpaceNotEnoughNeedData, c12295b);
        }
    }

    /* renamed from: e */
    public final void m18854e(BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData, C12295b c12295b, BaseSpaceNotifyBean baseSpaceNotifyBean) {
        this.f13676g.show(backupSpaceNotEnoughNeedData, c12295b, baseSpaceNotifyBean);
    }

    /* renamed from: f */
    public void m18855f() {
        if (!C11842p.m70753O0(this) || C11842p.m70771U0()) {
            C0209d.m1159C2(this);
        } else {
            C0209d.m1169F0(this);
        }
    }

    /* renamed from: h */
    public final void m18856h() {
        Configuration configuration;
        Resources resources = getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            this.f13679j = 0;
        } else {
            this.f13679j = m18852c(configuration.uiMode);
        }
    }

    /* renamed from: j */
    public final void m18857j(Intent intent, Bundle bundle) {
        if (intent == null || bundle == null) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        boolean booleanExtra = safeIntent.getBooleanExtra(HNConstants.C4906BI.DATA_IS_SUPPORT_ACTIVITY, false);
        boolean booleanExtra2 = safeIntent.getBooleanExtra(HNConstants.C4906BI.FROM_NOTIFY, false);
        if (booleanExtra && booleanExtra2) {
            bundle.putString("notify_id", safeIntent.getStringExtra(HNConstants.C4906BI.DATA_TYPE_ID));
        }
    }

    @Override // com.huawei.android.hicloud.ui.views.RenewAgreementTextview.RenewAgreementTVCallback
    /* renamed from: j0 */
    public void mo18858j0(boolean z10) {
        this.f13682m = true;
        LinkedHashMap<String, String> linkedHashMapM79497A = C13230i.m79497A(C13452e.m80781L().m80971t0());
        linkedHashMapM79497A.put("way_of_purchase", "backup_dialog_purchase");
        String str = z10 ? "UNIFORM_CLOUDPAY_UPGRADE_CLICK_USER_AGREEMENT" : "UNIFORM_CLOUDPAY_UPGRADE_CLICK_AUTO_PAY_AGREEMENT";
        C13225d.m79490f1().m79591l0(str, linkedHashMapM79497A);
        UBAAnalyze.m29958S("PVC", str, "4", "9", linkedHashMapM79497A);
    }

    /* renamed from: k */
    public void m18859k() throws IllegalAccessException, IllegalArgumentException {
        if (C0219i.m1463a() < 17 || !C11829c.m70563b0(this)) {
            return;
        }
        C11829c.m70591k1(this);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024);
    }

    /* renamed from: l */
    public final void m18860l(SafeIntent safeIntent, List<PortraitAndGrade.UserTag> list) {
        C11839m.m70688i("BackupNotificationActivity", "SPACE_NOT_ENOUGH");
        try {
            if (!C10155f.m63258K()) {
                C11839m.m70688i("BackupNotificationActivity", "the pop-up limit has been exceeded.");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("from_where", getClass().getName());
                NotificationReportUtil.reportPageDialogEvent("BackupNotEnoughDialog", "the pop-up limit has been exceeded.", linkedHashMap);
                finish();
                return;
            }
            Parcelable parcelableExtra = safeIntent.getParcelableExtra(NotifyConstants.BACKUP_SPACE_NOT_ENOUGH_NEED_DATA_KEY);
            if (parcelableExtra == null) {
                C11839m.m70687e("BackupNotificationActivity", "showBackupNotEnoughDialog notEnoughNeedDataParcelable is null.");
                finish();
                return;
            }
            Serializable serializableExtra = safeIntent.getSerializableExtra("backup_space_not_enough_need_info_key");
            if (serializableExtra == null) {
                C11839m.m70687e("BackupNotificationActivity", "showBackupNotEnoughDialog notEnoughNeedInfoSSerializable is null.");
                finish();
                return;
            }
            BackupSpaceNotEnoughNeedData backupSpaceNotEnoughNeedData = (BackupSpaceNotEnoughNeedData) parcelableExtra;
            C12295b c12295b = (C12295b) serializableExtra;
            if (NotifyBlackListManager.getInstance().isInBlackDialogList(NotifyBlackListManager.getInstance().getNotifyBackListConfigLocal(), 7, list)) {
                C11839m.m70687e("BackupNotificationActivity", "space not enough is inBlackList");
                finish();
                return;
            }
            if (c12295b.m73888q() == 3) {
                if (this.f13673d == null) {
                    C11839m.m70687e("BackupNotificationActivity", "SPACE_NOT_ENOUGH trebleBtnDialog is null.");
                    finish();
                    return;
                }
            } else if (this.f13671b == null) {
                C11839m.m70687e("BackupNotificationActivity", "SPACE_NOT_ENOUGH doubleBtnDialog is null.");
                finish();
                return;
            }
            int iM1357g = C0212e0.m1357g(this, "sp_desktop_dialog", "key_last_show_count", 0);
            C0212e0.m1370t(this, "sp_desktop_dialog", "key_last_show_time", System.currentTimeMillis());
            C0212e0.m1368r(this, "sp_desktop_dialog", "key_last_show_count", iM1357g + 1);
            String stringExtra = safeIntent.getStringExtra("backup_space_not_enough_notification_key");
            NotificationWithActivity notificationWithActivity = null;
            NotificationWithActivity notificationWithActivity2 = TextUtils.isEmpty(stringExtra) ? null : (NotificationWithActivity) C12540b1.m75483a(stringExtra, NotificationWithActivity.class);
            String stringExtra2 = safeIntent.getStringExtra("backup_space_not_enough_notification_key");
            SpaceNotification spaceNotification = TextUtils.isEmpty(stringExtra2) ? null : (SpaceNotification) C12540b1.m75483a(stringExtra2, SpaceNotification.class);
            String stringExtra3 = safeIntent.getStringExtra("backup_space_not_enough_notification_key");
            if (!TextUtils.isEmpty(stringExtra)) {
                notificationWithActivity = (NotificationWithActivity) C12540b1.m75483a(stringExtra3, NotificationWithActivity.class);
            }
            c12295b.m73871H(spaceNotification);
            c12295b.m73867D(notificationWithActivity2);
            c12295b.m73868E(notificationWithActivity);
            if (c12295b.m73878f() == 2 && new BackupSpaceInsufficientPopUpWindowNotify(backupSpaceNotEnoughNeedData, spaceNotification, c12295b).isSupportBackupSpaceInsufficientNewPopup()) {
                m18854e(backupSpaceNotEnoughNeedData, c12295b, spaceNotification);
            } else {
                m18853d(backupSpaceNotEnoughNeedData, c12295b);
            }
        } catch (Throwable th2) {
            C11839m.m70687e("BackupNotificationActivity", "Exception :" + th2.toString());
        }
    }

    /* renamed from: m */
    public final void m18861m(SafeIntent safeIntent, List<PortraitAndGrade.UserTag> list) {
        C11839m.m70688i("BackupNotificationActivity", "showBackupNotEnoughDialogV5");
        try {
            if (C10155f.m63258K()) {
                this.f13683n.m22710h(safeIntent.getStringExtra("backup_space_not_enough_notification_key_V5"), this, list);
                return;
            }
            C11839m.m70688i("BackupNotificationActivity", "showBackupNotEnoughDialogV5, the pop-up limit has been exceeded.");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("from_where", getClass().getName());
            NotificationReportUtil.reportPageDialogEvent("showBackupNotEnoughDialogV5", "the pop-up limit has been exceeded.", linkedHashMap);
            finish();
        } catch (Exception e10) {
            C11839m.m70687e("BackupNotificationActivity", "showBackupNotEnoughDialogV5 Exception :" + e10.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 10016) {
            this.f13682m = false;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws IllegalAccessException, IllegalArgumentException {
        BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog;
        C0234s.m1639q(this);
        if (configuration != null && m18852c(configuration.uiMode) != this.f13679j && (backupNotificationDoubleBtnDialog = this.f13671b) != null) {
            backupNotificationDoubleBtnDialog.dismiss();
            this.f13671b = null;
            C11839m.m70688i("BackupNotificationActivity", "doubleBtnDialog , uiMode change , finish activity.");
            finish();
        }
        super.onConfigurationChanged(configuration);
        BackupDoubleBtnAlertDialog backupDoubleBtnAlertDialog = this.f13672c;
        if (backupDoubleBtnAlertDialog != null) {
            backupDoubleBtnAlertDialog.onContentChanged();
        }
        m18855f();
        m18859k();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        C0216g0.m1402e(this).m1447y(new SafeIntent(getIntent()));
        C12808e.m76822a(this);
        if (!C13843a.m83076a0(this)) {
            setRequestedOrientation(1);
        }
        this.f13683n.m22704b();
        m18851i();
        m18850g();
        if (8 != this.f13681l) {
            this.f13678i.m79065c(this, getIntent(), C13222a.m79465g(this));
        }
        m18856h();
        m18855f();
        m18859k();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        C11839m.m70688i("BackupNotificationActivity", "onDestroy");
        BackupNotificationSingleBtnDialog backupNotificationSingleBtnDialog = this.f13670a;
        if (backupNotificationSingleBtnDialog != null) {
            backupNotificationSingleBtnDialog.dismiss();
            this.f13670a = null;
        }
        BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = this.f13671b;
        if (backupNotificationDoubleBtnDialog != null) {
            backupNotificationDoubleBtnDialog.dismiss();
            this.f13671b = null;
        }
        BackupDoubleBtnAlertDialog backupDoubleBtnAlertDialog = this.f13672c;
        if (backupDoubleBtnAlertDialog != null) {
            backupDoubleBtnAlertDialog.dismiss();
            this.f13672c = null;
        }
        BackupNotificationTrebleBtnDialog backupNotificationTrebleBtnDialog = this.f13673d;
        if (backupNotificationTrebleBtnDialog != null) {
            backupNotificationTrebleBtnDialog.dismiss();
            this.f13673d = null;
        }
        ExpiredDeleteDialog expiredDeleteDialog = this.f13674e;
        if (expiredDeleteDialog != null) {
            ExpiredDeleteSecondDialog expiredDeleteSecondDialog = expiredDeleteDialog.getExpiredDeleteSecondDialog();
            if (expiredDeleteSecondDialog != null) {
                expiredDeleteSecondDialog.dismiss();
            }
            this.f13674e.dismiss();
            this.f13674e = null;
        }
        BackupTrebleBtnAlertDialog backupTrebleBtnAlertDialog = this.f13675f;
        if (backupTrebleBtnAlertDialog != null) {
            backupTrebleBtnAlertDialog.dismiss();
            this.f13675f = null;
        }
        CheckUserSpaceNotEnoughDialog checkUserSpaceNotEnoughDialog = this.f13677h;
        if (checkUserSpaceNotEnoughDialog != null) {
            checkUserSpaceNotEnoughDialog.dismiss();
            this.f13677h = null;
        }
        BackupSpaceInsufficientNewDialog backupSpaceInsufficientNewDialog = this.f13676g;
        if (backupSpaceInsufficientNewDialog != null) {
            backupSpaceInsufficientNewDialog.dismiss();
            this.f13676g = null;
        }
        this.f13683n.m22705c();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null) {
            C11839m.m70688i("BackupNotificationActivity", "onNewIntent intent is null.");
            return;
        }
        C0216g0.m1402e(this).m1447y(new SafeIntent(getIntent()));
        this.f13683n.m22706d();
        setIntent(intent);
        m18850g();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        C11839m.m70688i("BackupNotificationActivity", "onPause");
        BackupDoubleBtnAlertDialog backupDoubleBtnAlertDialog = this.f13672c;
        if (backupDoubleBtnAlertDialog != null && backupDoubleBtnAlertDialog.isShowing()) {
            this.f13672c.stopFrameAnimation();
        }
        BackupTrebleBtnAlertDialog backupTrebleBtnAlertDialog = this.f13675f;
        if (backupTrebleBtnAlertDialog != null && backupTrebleBtnAlertDialog.isShowing()) {
            this.f13675f.stopFrameAnimation();
        }
        this.f13683n.m22707e();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        BackupDoubleBtnAlertDialog backupDoubleBtnAlertDialog = this.f13672c;
        if (backupDoubleBtnAlertDialog != null && backupDoubleBtnAlertDialog.isShowing()) {
            this.f13672c.startFrameAnimation();
        }
        BackupTrebleBtnAlertDialog backupTrebleBtnAlertDialog = this.f13675f;
        if (backupTrebleBtnAlertDialog != null && backupTrebleBtnAlertDialog.isShowing()) {
            this.f13675f.startFrameAnimation();
        }
        this.f13683n.m22708f();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13682m = false;
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        C11839m.m70688i("BackupNotificationActivity", "onStop");
        if (C0209d.m1245d1(this, BackupNotificationActivity.class.getName())) {
            C11839m.m70688i("BackupNotificationActivity", BackupNotification.KEY_IS_FOREGROUND);
            return;
        }
        if (this.f13682m) {
            return;
        }
        BackupNotificationDoubleBtnDialog backupNotificationDoubleBtnDialog = this.f13671b;
        if (backupNotificationDoubleBtnDialog != null) {
            backupNotificationDoubleBtnDialog.dismiss();
            this.f13671b = null;
            finish();
        }
        BackupDoubleBtnAlertDialog backupDoubleBtnAlertDialog = this.f13672c;
        if (backupDoubleBtnAlertDialog != null) {
            backupDoubleBtnAlertDialog.dismiss();
            this.f13672c = null;
            finish();
        }
        BackupNotificationTrebleBtnDialog backupNotificationTrebleBtnDialog = this.f13673d;
        if (backupNotificationTrebleBtnDialog != null) {
            backupNotificationTrebleBtnDialog.dismiss();
            this.f13673d = null;
            finish();
        }
        ExpiredDeleteDialog expiredDeleteDialog = this.f13674e;
        if (expiredDeleteDialog != null) {
            expiredDeleteDialog.dismiss();
            this.f13674e = null;
            finish();
        }
        this.f13683n.m22709g();
    }
}
