package com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.bean.ApkBean;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import p744wl.C13619c;

/* loaded from: classes6.dex */
public class NextCommonModuleRestore extends NextModuleRestore {
    public NextCommonModuleRestore(Context context, C4880b c4880b, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        super(context, c4880b, cloudRestoreStatusV3);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getApkModuleName() throws Throwable {
        ApkBean apkBeanM81949e = C13619c.m81949e(getAppId());
        if (apkBeanM81949e == null) {
            return null;
        }
        return apkBeanM81949e.getName();
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getBackupProviderUri() throws Throwable {
        ApkBean apkBeanM81949e = C13619c.m81949e(getAppId());
        if (apkBeanM81949e == null) {
            return null;
        }
        return apkBeanM81949e.getBackupUri();
    }
}
