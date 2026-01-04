package com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.process.util.BackupRestoreConstans;
import com.huawei.hicloud.cloudbackup.p104v3.core.C4880b;
import com.huawei.hicloud.cloudbackup.store.database.status.CloudRestoreStatusV3;
import fk.C9721b;
import java.io.File;
import p015ak.C0209d;

/* loaded from: classes6.dex */
public class NextGalleryDataRestore extends NextModuleRestore {
    private static final String GALLERY_DB_PATH = "/files/CloudClone/database";

    public NextGalleryDataRestore(Context context, C4880b c4880b, CloudRestoreStatusV3 cloudRestoreStatusV3) {
        super(context, c4880b, cloudRestoreStatusV3);
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getApkModuleName() {
        return C0209d.m1184K0(this.mContext, NextRestoreConstants.PKG_NAME_GALLERY_DATA) ? NextRestoreConstants.PKG_NAME_GALLERY_DATA : NextRestoreConstants.PKG_NAME_GALLERY_DATA_3D;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getBackupProviderUri() {
        return "content://com.huawei.gallery.fullclone.provider.FullCloneDataProvider";
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getSrcPath() {
        return this.mTask.getLocation() + File.separator + this.mRestoreStatus.getAppId() + "/nextdata/data/storage/el2";
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public String getTargetPath() {
        if (this.mRestoreStatus.getUid() == 0) {
            return BackupRestoreConstans.DATA_PATH + this.mRestorePkgName + GALLERY_DB_PATH;
        }
        return BackupRestoreConstans.DATA_USER_PATH + this.mRestorePkgName + File.separator + this.mRestoreStatus.getAppId() + GALLERY_DB_PATH;
    }

    @Override // com.huawei.hicloud.cloudbackup.p104v3.core.module.nextrestore.nextmodule.NextModuleRestore
    public int restoreSandBoxFiles() throws C9721b {
        if ("com.huawei.hmos.photos".equals(this.mRestoreStatus.getAppId())) {
            return 100;
        }
        return super.restoreSandBoxFiles();
    }
}
