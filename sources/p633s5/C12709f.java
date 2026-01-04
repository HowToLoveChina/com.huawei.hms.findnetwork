package p633s5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import p006a5.AbstractC0048c;
import p386j6.C10713c;
import p699v4.C13345n;

/* renamed from: s5.f */
/* loaded from: classes.dex */
public class C12709f extends AbstractC12706c {
    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupNormalSdFileImp", "onBackup");
        C12707d c12707d = new C12707d(context, abstractC0048c, callback, obj, C10713c.m65400j(BackupObject.getExecuteParameter(), "key_other_sd_file_name"));
        c12707d.m76517a(516, 3);
        return m76485c(c12707d);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        return null;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        String strM196n;
        C2111d.m12653i("BackupNormalSdFileImp", "onRestore");
        int i10 = 1;
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 1);
        if (iM65395e == 2 || iM65395e == 4) {
            strM196n = abstractC0048c != null ? abstractC0048c.m196n() : "";
            i10 = 0;
        } else {
            strM196n = C10713c.m65400j(BackupObject.getExecuteParameter(), "key_other_sd_file_name");
        }
        int i11 = C13345n.m80074m(context, 3) ? 3 : 2;
        C12718o c12718o = new C12718o(context, callback, obj, str, strM196n);
        c12718o.m76537m(516, i11, i10, false);
        return m76474T(c12718o);
    }
}
