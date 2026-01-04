package p799y5;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2108a;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import p229di.C9142g;
import p669u5.C13124b;
import p699v4.C13347p;

/* renamed from: y5.a */
/* loaded from: classes.dex */
public class C13910a extends C13124b {

    /* renamed from: b */
    public static final String f62269b;

    static {
        f62269b = C9142g.m57463b() ? "content://com.hihonor.soundrecorder.backupProvider/normal_record_table" : "content://com.huawei.soundrecorder.backupProvider/normal_record_table";
    }

    /* renamed from: g0 */
    public final int m83343g0(Context context, String str) {
        Bundle bundleM12616b;
        Cursor cursorM12618d = null;
        if (f62269b.equals(str) && (bundleM12616b = C2108a.m12616b(context, str, "backup_query", CloudBackupConstant.Command.PMS_CMD_BACKUP, reassembleExtra(null))) != null) {
            int i10 = bundleM12616b.getInt("file_num");
            C2111d.m12653i("BackupRecorderModule", "getOneUriCount sound recorder file count: " + i10);
            if (i10 != 0) {
                return i10;
            }
        }
        try {
            try {
                cursorM12618d = C2108a.m12618d(context, C13347p.m80079b(str), null, null, null, null);
                count = cursorM12618d != null ? cursorM12618d.getCount() : 0;
            } catch (IllegalArgumentException unused) {
                C2111d.m12648d("BackupRecorderModule", "getTotalNum numbers exception");
                if (cursorM12618d != null) {
                }
            } catch (Exception unused2) {
                C2111d.m12648d("BackupRecorderModule", "getTotalNum numbers failed");
                if (cursorM12618d != null) {
                }
            }
            return count;
        } finally {
            if (cursorM12618d != null) {
                cursorM12618d.close();
            }
        }
    }

    /* renamed from: h0 */
    public final int m83344h0(Context context, String str) {
        String str2;
        if ("soundrecorder".equals(str)) {
            str2 = f62269b;
        } else {
            if (!"callRecorder".equals(str)) {
                return mo303y(context, str);
            }
            str2 = "content://com.android.phone.autorecordbackup/call_record_file";
        }
        return m83343g0(context, str2);
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        if (context == null) {
            return null;
        }
        int iM83344h0 = m83344h0(context, str);
        boolean zMo299G = mo299G(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        C2111d.m12654j("BackupRecorderModule", "moduleName = ", str, ", totalItemNum = ", Integer.valueOf(iM83344h0), ", packageSize = ", l10, ", isSupportClone : ", Boolean.valueOf(zMo299G));
        if (iM83344h0 < 0) {
            return null;
        }
        long jLongValue = iM83344h0 == 0 ? 0L : l10.longValue();
        Bundle bundle = new Bundle();
        bundle.putInt("ModuleCount", iM83344h0);
        bundle.putLong("ModuleSize", jLongValue);
        bundle.putBoolean("isSupportClone", zMo299G);
        return bundle;
    }
}
