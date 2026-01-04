package p545p5;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import p669u5.C13124b;
import p699v4.C13349r;

/* renamed from: p5.a */
/* loaded from: classes.dex */
public class C12087a extends C13124b {
    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        if (C13349r.m80088d()) {
            return !mo301w(context, null, null, str, "restore").isEmpty();
        }
        C2111d.m12653i("BackupHiAIDecision", "SDK version is before P, not support clone HiAIDecision.");
        return false;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        if (!C13349r.m80088d()) {
            C2111d.m12653i("BackupHiAIDecision", "SDK version is before P, not support clone HiAIDecision.");
            return null;
        }
        int iMo303y = mo303y(context, str);
        boolean zMo299G = mo299G(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        C2111d.m12654j("BackupHiAIDecision", "moduleName = ", str, ", totalItemNum = ", Integer.valueOf(iMo303y), ", isSupportClone = ", Boolean.valueOf(zMo299G));
        if (iMo303y < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iMo303y);
        bundle.putLong("ModuleSize", l10.longValue());
        bundle.putBoolean("isSupportClone", zMo299G);
        return bundle;
    }
}
