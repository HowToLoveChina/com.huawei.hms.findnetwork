package p418k5;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;

/* renamed from: k5.b */
/* loaded from: classes.dex */
public class C10989b extends C10988a {
    @Override // p418k5.C10988a, p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        int iMo303y = mo303y(context, str);
        boolean zMo299G = mo299G(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        C2111d.m12654j("BackupPasswordSafeImpl", "moduleName = ", str, ", totalItemNum = ", Integer.valueOf(iMo303y), ", packageSize = ", l10, ", isSupportClone : ", Boolean.valueOf(zMo299G));
        if (iMo303y < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iMo303y);
        bundle.putLong("ModuleSize", iMo303y * 1000);
        bundle.putBoolean("isSupportClone", zMo299G);
        return bundle;
    }
}
