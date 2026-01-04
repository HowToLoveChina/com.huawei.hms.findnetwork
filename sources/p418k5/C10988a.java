package p418k5;

import android.content.Context;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.backup.service.utils.C2157a;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import p386j6.C10713c;
import p669u5.C13124b;

/* renamed from: k5.a */
/* loaded from: classes.dex */
public class C10988a extends C13124b {
    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle getExtraInfo(Context context, String str) {
        C2111d.m12653i("BackupCommonEncryptModule", "getExtraInfo() start...");
        String str2 = BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null;
        boolean zM13194b = C2157a.m13194b(context, str2);
        C2111d.m12654j("BackupCommonEncryptModule", "query provider module ", str, "result is : ", Boolean.valueOf(zM13194b));
        if (!zM13194b) {
            C2111d.m12653i("BackupCommonEncryptModule", "Uri is not exist, func getExtraInfo(...) end!");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_encrypt", true);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bundle bundleM12616b = C2108a.m12616b(context, str2, "backup_query", "restore", reassembleExtra(bundle));
        C2111d.m12654j("BackupCommonEncryptModule", "Get certificate cost time: [", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), "] ms!");
        if (bundleM12616b != null && C10713c.m65393c(bundleM12616b, "extra_value") != null) {
            C2111d.m12653i("BackupCommonEncryptModule", "getExtraInfo() end...");
            return C10713c.m65393c(bundleM12616b, "extra_value");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("public_key", null);
        bundle2.putString("certificate", null);
        C2111d.m12653i("BackupCommonEncryptModule", "getExtraInfo() end...");
        return bundle2;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        int iMo303y = mo303y(context, str);
        boolean zMo299G = mo299G(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        C2111d.m12654j("BackupCommonEncryptModule", "moduleName = ", str, ", totalItemNum = ", Integer.valueOf(iMo303y), ", packageSize = ", l10, ", isSupportClone : ", Boolean.valueOf(zMo299G));
        if (iMo303y < 0) {
            return null;
        }
        long jLongValue = (iMo303y != 0 || zMo299G) ? l10.longValue() : 0L;
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iMo303y);
        bundle.putLong("ModuleSize", jLongValue);
        bundle.putBoolean("isSupportClone", zMo299G);
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public void setExtraInfo(Context context, String str) {
        Bundle bundleM65393c;
        C2111d.m12653i("BackupCommonEncryptModule", "BackupCommonEncryptModule:setExtraInfo() start...");
        Bundle bundle = null;
        String str2 = BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null;
        boolean zM13194b = C2157a.m13194b(context, str2);
        C2111d.m12654j("BackupCommonEncryptModule", "query provider module ", str, " result is : ", Boolean.valueOf(zM13194b));
        if (!zM13194b) {
            C2111d.m12653i("BackupCommonEncryptModule", "Uri is not exist, BackupCommonEncryptModule:setExtraInfo() end...");
            return;
        }
        Bundle bundleM65393c2 = C10713c.m65393c(BackupObject.getExecuteParameter(), "ModuleExtraValue");
        if (bundleM65393c2 != null && (bundleM65393c = C10713c.m65393c(bundleM65393c2, str)) != null) {
            bundle = new Bundle();
            bundle.putString("public_key", bundleM65393c.getString("public_key"));
            bundle.putString("certificate", bundleM65393c.getString("certificate"));
        }
        C2108a.m12616b(context, str2, "backup_query", CloudBackupConstant.Command.PMS_CMD_BACKUP, reassembleExtra(bundle));
        C2111d.m12653i("BackupCommonEncryptModule", "BackupCommonEncryptModule:setExtraInfo() end...");
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public void toNewSession(Context context, String str, String str2) {
        C2111d.m12653i("BackupCommonEncryptModule", "toNewSession start...");
        String str3 = BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null;
        boolean zM13194b = C2157a.m13194b(context, str3);
        C2111d.m12654j("BackupCommonEncryptModule", "query provider module ", str, " result is : ", Boolean.valueOf(zM13194b));
        if (!zM13194b) {
            C2111d.m12653i("BackupCommonEncryptModule", "Uri is not exist, BackupCommonEncryptModule:toNewSession() end...");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("session", "com.hicloud.android.clone");
        C2108a.m12616b(context, str3, "backup_query", str2, reassembleExtra(bundle));
        C2111d.m12653i("BackupCommonEncryptModule", "BackupCommonEncryptModule:toNewSession() end...");
    }
}
