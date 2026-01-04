package p510o5;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.utils.BackupConstant;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import p007a6.AbstractC0053b;
import p229di.C9142g;
import p669u5.C13124b;

/* renamed from: o5.a */
/* loaded from: classes.dex */
public class C11818a extends C13124b {

    /* renamed from: b */
    public static final String f54720b;

    static {
        f54720b = C9142g.m57463b() ? "com.hihonor.hiai" : "com.huawei.hiai";
    }

    /* renamed from: h0 */
    public static boolean m70390h0(Context context) {
        String str = f54720b;
        boolean z10 = true;
        if (str == null) {
            C2111d.m12653i("BackupHiAiModule", "isSupportHiAi packageName is null");
            return true;
        }
        try {
            int i10 = context.getPackageManager().getApplicationInfo(str, 128).metaData.getInt("support_cloudbackup");
            if (1 == i10) {
                z10 = false;
            }
            C2111d.m12653i("BackupHiAiModule", "isSupportHiAi: " + z10 + ", dataType = " + i10);
            return z10;
        } catch (Exception e10) {
            C2111d.m12648d("BackupHiAiModule", "isSupportHiAi: " + e10);
            return z10;
        }
    }

    @Override // p669u5.C13124b, p007a6.AbstractC0053b
    /* renamed from: C */
    public ArrayList<String> mo296C(Context context, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(BackupConstant.m13133g().containsKey(str) ? BackupConstant.m13133g().get(str) : null);
        return arrayList;
    }

    @Override // p007a6.AbstractC0053b
    /* renamed from: G */
    public boolean mo299G(Context context, String str, String str2) {
        if (m70390h0(context)) {
            return false;
        }
        return super.mo299G(context, str, str2);
    }

    @Override // p669u5.C13124b
    /* renamed from: J */
    public boolean mo70391J() {
        return false;
    }

    /* renamed from: g0 */
    public final long m70392g0(Context context, String str) {
        long jM321F = 0;
        for (AbstractC0053b.c cVar : mo301w(context, null, null, str, null)) {
            if (cVar != null) {
                jM321F += cVar.m321F();
            }
        }
        return jM321F;
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public boolean isSupported(Context context, String str) {
        if (m70390h0(context)) {
            return false;
        }
        return super.isSupported(context, str);
    }

    @Override // p007a6.AbstractC0053b, com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        boolean zMo299G = mo299G(context, str, CloudBackupConstant.Command.PMS_CMD_BACKUP);
        Bundle bundle = null;
        long j10 = 0;
        if (zMo299G) {
            long jM70392g0 = m70392g0(context, str);
            if (jM70392g0 > 0) {
                bundle = new Bundle();
                bundle.putInt("ModuleCount", 0);
                bundle.putLong("ModuleSize", jM70392g0);
                bundle.putBoolean("isSupportClone", zMo299G);
            }
            j10 = jM70392g0;
        }
        C2111d.m12654j("BackupHiAiModule", "moduleName = ", str, ", backupModuleSize = ", Long.valueOf(j10), ", packageSize = ", l10, ", isSupportClone : ", Boolean.valueOf(zMo299G));
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle reassembleExtra(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(RemoteMessageConst.FROM, "cloudDrive");
        return bundle;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Uri reassembleUri(Uri uri) {
        return uri.buildUpon().appendQueryParameter(RemoteMessageConst.FROM, "cloudDrive").build();
    }
}
