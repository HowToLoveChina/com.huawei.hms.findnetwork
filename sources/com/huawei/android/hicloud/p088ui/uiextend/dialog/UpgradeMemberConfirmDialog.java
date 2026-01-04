package com.huawei.android.hicloud.p088ui.uiextend.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.android.hicloud.p088ui.activity.cloudpay.CloudSpaceUpgradeActivity;
import com.huawei.android.p073ds.R$string;
import com.huawei.hicloud.notification.constants.HNConstants;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import p514o9.C11839m;
import p676ud.AlertDialogC13154a;
import p684un.C13222a;
import p684un.C13225d;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class UpgradeMemberConfirmDialog extends AlertDialogC13154a {
    private Context context;
    private int targetFrequency;
    private String targetGradeCode;
    private String targetGradeName;

    public class UpgradeMemberConfirmListener implements DialogInterface.OnClickListener {
        private static final String TAG = "UpgradeMemberConfirmListener";
        private int targetFrequency;
        private String targetGradeCode;

        public UpgradeMemberConfirmListener(String str, int i10) {
            this.targetGradeCode = str;
            this.targetFrequency = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (-1 != i10) {
                if (-2 == i10) {
                    C13225d.m79490f1().m79585f0("mecloud_backup_member_upgrade_cancel_click", C13452e.m80781L().m80971t0());
                    UBAAnalyze.m29954O("PVC", "mecloud_backup_member_upgrade_cancel_click", "1", "45");
                    return;
                }
                return;
            }
            C11839m.m70688i(TAG, "targetGradeCode: " + this.targetGradeCode + ", targetFrequency: " + this.targetFrequency);
            Intent intent = new Intent(UpgradeMemberConfirmDialog.this.context, (Class<?>) CloudSpaceUpgradeActivity.class);
            intent.putExtra(HNConstants.PayIntentKey.RECOMMEND_GRADE_CODE_KEY, this.targetGradeCode);
            intent.putExtra("chosen_backup_frequency", this.targetFrequency);
            C13222a.m79471m(intent, 7);
            UpgradeMemberConfirmDialog.this.context.startActivity(intent);
            C13225d.m79490f1().m79585f0("mecloud_backup_member_upgrade_confirm_click", C13452e.m80781L().m80971t0());
            UBAAnalyze.m29954O("PVC", "mecloud_backup_member_upgrade_confirm_click", "1", "45");
        }
    }

    public UpgradeMemberConfirmDialog(Context context, int i10, String str, String str2) {
        super(context);
        this.context = context;
        this.targetFrequency = i10;
        this.targetGradeCode = str;
        this.targetGradeName = str2;
        initView();
    }

    private void initView() {
        UpgradeMemberConfirmListener upgradeMemberConfirmListener = new UpgradeMemberConfirmListener(this.targetGradeCode, this.targetFrequency);
        setMessage(this.context.getString(R$string.freqency_dialog_confirm_message_with_gradename, this.targetGradeName));
        setButton(-1, this.context.getString(R$string.upgrade_member), upgradeMemberConfirmListener);
        setButton(-2, this.context.getString(R$string.cloudbackup_Cancel), upgradeMemberConfirmListener);
    }

    public void updateView(int i10, String str, String str2) {
        this.targetFrequency = i10;
        this.targetGradeCode = str;
        this.targetGradeName = str2;
        initView();
    }
}
