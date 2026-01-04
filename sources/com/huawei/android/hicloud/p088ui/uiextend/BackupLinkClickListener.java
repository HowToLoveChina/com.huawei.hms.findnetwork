package com.huawei.android.hicloud.p088ui.uiextend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.huawei.android.hicloud.cloudbackup.process.CBAccess;
import com.huawei.android.hicloud.cloudbackup.service.CloudBackupService;
import com.huawei.android.hicloud.commonlib.view.SpanClickText;
import com.huawei.android.hicloud.p088ui.activity.BackupMainActivity;
import com.huawei.android.hicloud.p088ui.activity.RestoreMainActivity;
import p015ak.C0209d;
import p514o9.C11839m;
import p709vj.C13452e;

/* loaded from: classes3.dex */
public class BackupLinkClickListener implements SpanClickText.ISpanClickListener {
    private static final String TAG = "BackupLinkClikListener";
    private Context mContext;
    private TextView textView;

    public BackupLinkClickListener(Context context, TextView textView) {
        this.mContext = context;
        this.textView = textView;
    }

    private void gotoBackup() {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "context is null");
            return;
        }
        if (C13452e.m80781L().m80887a1()) {
            CloudBackupService.getInstance().getBackupLinkAddress(3216);
            return;
        }
        int iM80916g0 = C13452e.m80781L().m80916g0();
        C11839m.m70688i(TAG, "restoreStatus = " + iM80916g0);
        if (iM80916g0 == 0 || iM80916g0 == 3 || iM80916g0 == 8 || iM80916g0 == 5) {
            Intent intent = new Intent();
            intent.setClass(this.mContext, BackupMainActivity.class);
            if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
                this.mContext.startActivity(intent);
                return;
            }
            return;
        }
        if (CBAccess.inRestoreTask()) {
            startRestoreMainActivity(2, iM80916g0);
            C11839m.m70688i(TAG, "inRestore = " + CBAccess.inRestore());
            return;
        }
        if (C0209d.m1150A1(this.mContext)) {
            if (iM80916g0 == 1) {
                C13452e.m80781L().m80914f3(7);
            } else if (iM80916g0 != 2) {
                C13452e.m80781L().m80914f3(6);
            }
        } else if (iM80916g0 == 1) {
            C13452e.m80781L().m80914f3(7);
        }
        startRestoreMainActivity(2, iM80916g0);
    }

    private void startRestoreMainActivity(int i10, int i11) {
        if (this.mContext == null) {
            C11839m.m70687e(TAG, "context is null");
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) RestoreMainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("current_status", i10);
        bundle.putInt("restore_status", i11);
        intent.putExtras(bundle);
        if (intent.resolveActivity(this.mContext.getPackageManager()) != null) {
            this.mContext.startActivity(intent);
        }
    }

    @Override // com.huawei.android.hicloud.commonlib.view.SpanClickText.ISpanClickListener
    public void onClick() {
        if (this.textView == null) {
            return;
        }
        gotoBackup();
    }
}
