package com.huawei.android.hicloud.cloudbackup.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.android.hicloud.cloudbackup.callable.CBCallBack;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.android.hicloud.cloudbackup.util.CloudBackupUtil;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hicloud.base.common.HiCloudSafeIntent;
import com.huawei.hicloud.report.uba.UBAAnalyze;
import java.util.LinkedHashMap;
import p514o9.C11839m;
import p618rm.C12590s0;
import p684un.C13225d;
import p684un.C13230i;
import p709vj.C13452e;
import p711vl.C13467g;

/* loaded from: classes2.dex */
public class CloudBackupReceiver extends BroadcastReceiver {
    private static final String TAG = "CloudBackupReceiver";

    private void clearBackupRecordNums() {
        C13467g c13467gM81086c = C13467g.m81086c();
        Integer num = CloudBackupConstant.UserPackageInfo.VIP_BACKUP_RECORDS;
        if (c13467gM81086c.m81089d("about_number_of_backup_record", num.intValue()) <= CloudBackupConstant.UserPackageInfo.NORMAL_BACKUP_RECORDS.intValue()) {
            C13467g.m81086c().m81094i("about_number_of_backup_record", num.intValue());
        }
    }

    private void processGradeChange(String str) {
        if (C4633d0.m28404a(str) || C12590s0.m75823Z0()) {
            C11839m.m70689w(TAG, "processGradeChange gradeCode is null or empty ");
        } else {
            clearBackupRecordNums();
        }
    }

    private void saveSelectedFrequency(Intent intent) {
        if (intent == null) {
            C11839m.m70688i(TAG, "intent is null");
            return;
        }
        Bundle bundleExtra = new HiCloudSafeIntent(intent).getBundleExtra("pay_success_backup_freq_bundle_key");
        if (bundleExtra != null) {
            int i10 = bundleExtra.getInt("pay_success_chosen_backup_frequency", 0);
            String string = bundleExtra.getString("pay_success_current_grade_code");
            C11839m.m70688i(TAG, "targetFrequency: " + i10 + ", currentGradeCode: " + string);
            if (i10 == 0 || TextUtils.isEmpty(string) || CloudBackupUtil.getGradeMinFrequency(string) != i10) {
                return;
            }
            C11839m.m70688i(TAG, "pay success, save chosen frequency: " + i10);
            C13467g.m81086c().m81098m(i10);
            Message message = new Message();
            message.what = 33016;
            CBCallBack.getInstance().sendMessage(message);
            LinkedHashMap<String, String> linkedHashMapM79499C = C13230i.m79499C(C13452e.m80781L().m80971t0());
            linkedHashMapM79499C.put("gradeCode", string);
            linkedHashMapM79499C.put("backup_frequency", Integer.valueOf(i10));
            C13225d.m79490f1().m79567R("auto_backup_frequency_selected", linkedHashMapM79499C);
            UBAAnalyze.m29947H("CKC", "auto_backup_frequency_selected", linkedHashMapM79499C);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            C11839m.m70688i(TAG, "CloudBackupReceiver intent is null");
            return;
        }
        HiCloudSafeIntent hiCloudSafeIntent = new HiCloudSafeIntent(intent);
        String action = hiCloudSafeIntent.getAction();
        C11839m.m70686d(TAG, "onReceive: " + action);
        if ("com.huawei.hicloud.intent.action.ACTION_PAY_SUCCESS".equals(action)) {
            saveSelectedFrequency(hiCloudSafeIntent);
            clearBackupRecordNums();
        } else if ("com.huawei.hicloud.intent.action.ACTION_GRADE_CODE_CHANGE".equals(action)) {
            processGradeChange(hiCloudSafeIntent.getStringExtra("gradeCode"));
        }
    }
}
