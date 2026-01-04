package com.huawei.android.hicloud.cloudbackup.process.util;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.process.task.QueryOmAppBackupScopeTask;
import com.huawei.android.hicloud.cloudbackup.report.CloudBackupReport;
import hk.C10278a;
import java.io.File;
import p015ak.C0209d;
import p015ak.C0213f;
import p514o9.C11839m;
import p616rk.C12515a;
import p617rl.C12517a;
import p617rl.C12519c;
import p617rl.C12520d;
import p617rl.C12521e;
import p617rl.C12522f;
import p617rl.C12526j;
import p742wj.C13612b;

/* loaded from: classes2.dex */
public class QueryOmBackupManager {
    private static final String TAG = "QueryOmBackupManager";

    public static class Holder {
        private static final QueryOmBackupManager INSTANCE = new QueryOmBackupManager();

        private Holder() {
        }
    }

    private void clearDb() {
        new C12517a().clear();
        new C12526j().clear();
        new C12520d().clear();
        new C12519c().clear();
        new C12521e().clear();
        new C12522f().clear();
    }

    private void clearOmConfigFile() {
        Context contextM1377a = C0213f.m1377a();
        if (contextM1377a == null) {
            C11839m.m70687e(TAG, "clearOmConfigFile context is null.");
            return;
        }
        File fileM63442h = C10278a.m63442h(contextM1377a.getFilesDir() + File.separator + "HiCloudAppFiles.json");
        if (fileM63442h.exists() && fileM63442h.delete()) {
            C11839m.m70688i(TAG, "clearOmConfigFile delete");
        }
    }

    public static QueryOmBackupManager getInstance() {
        return Holder.INSTANCE;
    }

    public void clear() {
        clearDb();
        clearOmConfigFile();
    }

    public void processBackupOmConfig() {
        if (!C13612b.m81829B().isLogin()) {
            C11839m.m70688i(TAG, "processBackupOmConfig no login");
            CloudBackupReport.reportOmError("processBackupOmConfig no login");
        } else if (C0209d.m1333z1(C0213f.m1377a())) {
            C12515a.m75110o().m75172d(new QueryOmAppBackupScopeTask());
        } else {
            C11839m.m70688i(TAG, "processBackupOmConfig no network");
            CloudBackupReport.reportOmError("processBackupOmConfig no network");
        }
    }
}
