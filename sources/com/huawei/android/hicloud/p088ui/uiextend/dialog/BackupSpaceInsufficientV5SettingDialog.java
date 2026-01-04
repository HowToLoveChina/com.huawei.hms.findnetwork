package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.p088ui.uiextend.bean.DialogNoRemindShowData;
import com.huawei.android.hicloud.p088ui.uiextend.bean.NotEnoughDialogDataV5;
import com.huawei.android.hicloud.p088ui.uiextend.bean.SecondaryRetentionContent;
import com.huawei.android.p073ds.R$color;
import com.huawei.android.p073ds.R$id;
import com.huawei.android.p073ds.R$layout;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import com.huawei.hms.feature.dynamic.InterfaceC5323b;
import java.util.LinkedHashMap;
import je.C10811y;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11829c;
import p514o9.C11839m;
import p581qk.AbstractC12368e;
import p616rk.C12515a;
import p676ud.AlertDialogC13154a;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import sk.C12809f;

/* loaded from: classes3.dex */
public class BackupSpaceInsufficientV5SettingDialog extends AlertDialogC13154a {
    private static final String TAG = "BackupSpaceInsufficientV5SettingDialog";
    private final Activity activity;
    private int buttonNums;
    private TextView contentView;
    private DialogNoRemindShowData dialogNoRemindShowData;
    LinkedHashMap<String, String> extendReportMap;
    private boolean isContainDownAppOrCampaginButton;
    private long mLastClickTime;
    private NotEnoughDialogDataV5 notEnoughDialogDataV5;
    private SecondaryRetentionDialog secondaryRetentionDialog;
    private TextView title;

    public class DialogOnCancelListener implements DialogInterface.OnCancelListener {
        public DialogOnCancelListener() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            C12515a.m75110o().m75172d(BackupSpaceInsufficientV5SettingDialog.this.new ReportTask("3", ""));
            if (BackupSpaceInsufficientV5SettingDialog.this.isContainDownAppOrCampaginButton) {
                BackupSpaceInsufficientV5SettingDialog.this.finish();
            } else {
                BackupSpaceInsufficientV5SettingDialog.this.showSecondaryRetentionDialog();
            }
        }
    }

    public class ReportTask extends AbstractC12368e {
        String clickId;
        String remindType;

        public ReportTask(String str, String str2) {
            this.clickId = str;
            this.remindType = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x003e A[Catch: Exception -> 0x004e, TRY_LEAVE, TryCatch #1 {Exception -> 0x004e, blocks: (B:53:0x0034, B:55:0x003e), top: B:69:0x0034 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0051  */
        @Override // p616rk.AbstractRunnableC12516b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void call() throws fk.C9721b {
            /*
                r21 = this;
                r1 = r21
                r2 = 0
                ap.b r0 = p020ap.C1007b.m5980s()     // Catch: java.lang.Exception -> L2f
                r4 = 0
                r5 = 1
                com.huawei.hicloud.router.data.UserBackupInfo r0 = r0.m6026q(r5, r5, r5, r4)     // Catch: java.lang.Exception -> L2f
                if (r0 == 0) goto L33
                java.util.List r0 = r0.getUserBackupInfos()     // Catch: java.lang.Exception -> L2f
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L2f
            L18:
                boolean r4 = r0.hasNext()     // Catch: java.lang.Exception -> L2f
                if (r4 == 0) goto L33
                java.lang.Object r4 = r0.next()     // Catch: java.lang.Exception -> L2f
                com.huawei.hicloud.router.data.UserBackupInfo$UserDeviceInfo r4 = (com.huawei.hicloud.router.data.UserBackupInfo.UserDeviceInfo) r4     // Catch: java.lang.Exception -> L2f
                boolean r5 = r4.isCurrent()     // Catch: java.lang.Exception -> L2f
                if (r5 == 0) goto L18
                long r4 = r4.getSize()     // Catch: java.lang.Exception -> L2f
                goto L34
            L2f:
                r0 = move-exception
                r4 = r2
                r6 = r4
                goto L56
            L33:
                r4 = r2
            L34:
                v8.e r0 = p703v8.C13368e.m80184F()     // Catch: java.lang.Exception -> L4e
                com.huawei.hicloud.base.bean.QuotaSpaceInfo r0 = r0.m80224M()     // Catch: java.lang.Exception -> L4e
                if (r0 == 0) goto L51
                long r6 = r0.getTotal()     // Catch: java.lang.Exception -> L4e
                long r2 = r0.getUsed()     // Catch: java.lang.Exception -> L4c
                r19 = r2
                r2 = r6
                r6 = r19
                goto L52
            L4c:
                r0 = move-exception
                goto L56
            L4e:
                r0 = move-exception
                r6 = r2
                goto L56
            L51:
                r6 = r2
            L52:
                r11 = r2
                r15 = r4
                r13 = r6
                goto L73
            L56:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r9 = "ReportTask error: "
                r8.append(r9)
                java.lang.String r0 = r0.toString()
                r8.append(r0)
                java.lang.String r0 = r8.toString()
                java.lang.String r8 = "BackupSpaceInsufficientV5SettingDialog"
                p514o9.C11839m.m70688i(r8, r0)
                r13 = r2
                r15 = r4
                r11 = r6
            L73:
                java.lang.String r9 = r1.clickId
                java.lang.String r10 = r1.remindType
                com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientV5SettingDialog r0 = com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupSpaceInsufficientV5SettingDialog.this
                int r17 = com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupSpaceInsufficientV5SettingDialog.access$000(r0)
                com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientV5SettingDialog r0 = com.huawei.android.hicloud.p088ui.uiextend.dialog.BackupSpaceInsufficientV5SettingDialog.this
                java.util.LinkedHashMap<java.lang.String, java.lang.String> r0 = r0.extendReportMap
                r18 = r0
                je.C10811y.m65825i(r9, r10, r11, r13, r15, r17, r18)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.android.hicloud.ui.uiextend.dialog.BackupSpaceInsufficientV5SettingDialog.ReportTask.call():void");
        }
    }

    public BackupSpaceInsufficientV5SettingDialog(Activity activity, NotEnoughDialogDataV5 notEnoughDialogDataV5, int i10, boolean z10) {
        super(activity);
        this.buttonNums = 0;
        this.isContainDownAppOrCampaginButton = false;
        this.extendReportMap = new LinkedHashMap<>();
        this.activity = activity;
        this.notEnoughDialogDataV5 = notEnoughDialogDataV5;
        this.dialogNoRemindShowData = notEnoughDialogDataV5.getV5DialogNoRemindShowContent();
        this.buttonNums = i10;
        this.isContainDownAppOrCampaginButton = z10;
        setCanceledOnTouchOutside(false);
        initView();
        initData();
        this.extendReportMap.put("v5_dialog_version_key", InterfaceC5323b.f24693t);
        C10811y.m65826j(this.dialogNoRemindShowData.getRemindType(), i10, this.extendReportMap);
    }

    private boolean checkRetentionContentInvalid(SecondaryRetentionContent secondaryRetentionContent) {
        return secondaryRetentionContent == null || TextUtils.isEmpty(secondaryRetentionContent.getMessage()) || TextUtils.isEmpty(secondaryRetentionContent.getTitle()) || TextUtils.isEmpty(secondaryRetentionContent.getNegativeText()) || TextUtils.isEmpty(secondaryRetentionContent.getPositiveText());
    }

    private void clickCancel() {
        C11839m.m70689w(TAG, "click too clickCancel");
        C12515a.m75110o().m75172d(new ReportTask("1", "0"));
        if (this.isContainDownAppOrCampaginButton) {
            finish();
        } else if (isFastClick()) {
            C11839m.m70689w(TAG, "click too fast");
        } else {
            showSecondaryRetentionDialog();
        }
    }

    private void clickConfirm() {
        C11839m.m70689w(TAG, "click too clickConfirm");
        if (isFastClick()) {
            C11839m.m70689w(TAG, "click too fast");
            return;
        }
        if (this.dialogNoRemindShowData.getRemindType().equals(NotifyConstants.HICLOUD_BACKUP_REMIND_DELETE)) {
            deleteAndCloseBackup();
        }
        if (this.dialogNoRemindShowData.getRemindType().equals(NotifyConstants.HICLOUD_BACKUP_REMIND_CLOSE)) {
            closeBackup();
        }
        C12515a.m75110o().m75172d(new ReportTask("2", String.valueOf(this.dialogNoRemindShowData.getRemindType())));
        finish();
    }

    private void closeBackup() {
        CloudBackupService.getInstance().cloudbackupOpr(false);
        Message messageObtain = Message.obtain();
        messageObtain.what = 33036;
        CBCallBack.getInstance().sendMessage(messageObtain);
    }

    public void finish() {
        onDestory();
        Activity activity = this.activity;
        if (activity != null) {
            activity.finish();
        }
    }

    private void initData() {
        this.title.setText(this.dialogNoRemindShowData.getTitle());
        this.contentView.setText(this.dialogNoRemindShowData.getContent());
    }

    private void initView() {
        setOnCancelListener(new DialogOnCancelListener());
        View viewInflate = C0209d.m1195O(C0213f.m1377a()) >= 1.75f ? LayoutInflater.from(this.activity).inflate(R$layout.space_not_enough_v5_setting_dialog_big, (ViewGroup) null) : LayoutInflater.from(this.activity).inflate(R$layout.space_not_enough_v5_setting_dialog, (ViewGroup) null);
        this.title = (TextView) C12809f.m76831d(viewInflate, R$id.title);
        this.contentView = (TextView) C12809f.m76831d(viewInflate, R$id.description);
        setView(viewInflate);
        setButton(-1, this.dialogNoRemindShowData.getButton(), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19227a.lambda$initView$0(dialogInterface, i10);
            }
        });
        setButton(-2, this.activity.getString(R$string.cancel), new DialogInterface.OnClickListener() { // from class: com.huawei.android.hicloud.ui.uiextend.dialog.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                this.f19229a.lambda$initView$1(dialogInterface, i10);
            }
        });
    }

    private boolean isFastClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z10 = jCurrentTimeMillis - this.mLastClickTime <= 600;
        this.mLastClickTime = jCurrentTimeMillis;
        return z10;
    }

    public /* synthetic */ void lambda$initView$0(DialogInterface dialogInterface, int i10) {
        clickConfirm();
    }

    public /* synthetic */ void lambda$initView$1(DialogInterface dialogInterface, int i10) {
        clickCancel();
    }

    public void showSecondaryRetentionDialog() {
        SecondaryRetentionContent secondaryRetentionContent = this.notEnoughDialogDataV5.getSecondaryRetentionContent();
        if (checkRetentionContentInvalid(secondaryRetentionContent)) {
            finish();
            return;
        }
        SecondaryRetentionDialog secondaryRetentionDialog = new SecondaryRetentionDialog(this.activity, secondaryRetentionContent);
        this.secondaryRetentionDialog = secondaryRetentionDialog;
        secondaryRetentionDialog.show();
        if (secondaryRetentionContent.getPositiveGoto() != null) {
            C10811y.m65830n(secondaryRetentionContent.getPositiveGoto().getPopupUri(), secondaryRetentionContent.getDialogType(), this.buttonNums, this.extendReportMap);
        }
        if (isShowing()) {
            dismiss();
        }
    }

    public void deleteAndCloseBackup() {
        if (!C0209d.m1333z1(this.activity)) {
            dismiss();
            C11829c.m70612r1(this.activity);
            return;
        }
        C13225d.m79490f1().m79591l0("mecloud_backupdetail_delete_done", C13230i.m79499C(C13452e.m80781L().m80971t0()));
        UBAAnalyze.m29954O("PVC", "mecloud_backupdetail_delete_done", "1", "43");
        C11839m.m70688i(TAG, "mecloud_backupdetail_delete_done");
        CloudBackupService.getInstance().deleteRecordAndCloseBackup(C13452e.m80781L().m80954p(), 1, 0);
    }

    public void onDestory() {
        if (isShowing()) {
            dismiss();
        }
    }

    public void showDialog() {
        show();
        getButton(-1).setTextColor(this.activity.getResources().getColor(R$color.red));
    }
}
