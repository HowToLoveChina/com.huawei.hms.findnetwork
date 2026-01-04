package com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule;

import android.content.Context;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;

/* loaded from: classes6.dex */
public class NextMemoRestore extends NextModuleRestore {
    public NextMemoRestore(Context context, C4880b c4880b, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        super(context, c4880b, cloudRestoreStatusV3);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getApkModuleName() {
        return NextRestoreConstants.PKG_NAME_MEMO;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getBackupProviderUri() {
        return "content://com.huawei.provider.NotePad.backup";
    }
}
