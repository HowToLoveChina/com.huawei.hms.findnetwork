package com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import fk.C9721b;
import hk.C10278a;
import java.io.File;
import p514o9.C11839m;
import p617rl.C12526j;

/* loaded from: classes6.dex */
public class NextFileManagerRestore extends NextModuleRestore {
    private static final String TAG = "NextFileManagerRestore";

    public NextFileManagerRestore(Context context, C4880b c4880b, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        super(context, c4880b, cloudRestoreStatusV3);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getApkModuleName() {
        return NextRestoreConstants.PKG_NAME_FILE_MANAGER;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getBackupProviderUri() {
        return CloudBackupConstant.SAFEBOX_DATA_CONTENT_URI;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public int restoreSandBoxFiles() throws C9721b {
        if (!C10278a.m63442h(this.mTask.getLocation() + File.separator + getAppId() + "/nextdata").exists()) {
            C11839m.m70688i(TAG, "no nextdata, success.");
            return 100;
        }
        if (C12526j.m75322e1(NextRestoreConstants.PKG_NAME_FILE_MANAGER)) {
            return super.restoreSandBoxFiles();
        }
        C11839m.m70688i(TAG, "restoreSandBoxFiles. metadata not support");
        return -7;
    }
}
