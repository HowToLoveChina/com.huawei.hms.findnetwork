package p633s5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.hicloud.bean.BasicBaseResp;
import p006a5.AbstractC0048c;
import p386j6.C10713c;

/* renamed from: s5.k */
/* loaded from: classes.dex */
public class C12714k extends AbstractC12706c {
    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupVideoImp", "onBackup");
        String strM65400j = C10713c.m65400j(BackupObject.getExecuteParameter(), "key_video_file_name");
        if (strM65400j == null) {
            strM65400j = "";
        }
        String str2 = strM65400j;
        int iM65394d = C10713c.m65394d(BackupObject.getExecuteParameter(), "key_media_backup_location");
        C12707d c12707d = new C12707d(context, abstractC0048c, callback, obj, str2);
        c12707d.m76517a(BasicBaseResp.TERM_NO_SIGN, iM65394d);
        return m76485c(c12707d);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        return null;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        int i10;
        String str2;
        C2111d.m12653i("BackupVideoImp", "onRestore");
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 1);
        String strM196n = "";
        if (iM65395e == 2 || iM65395e == 4) {
            i10 = 0;
            if (abstractC0048c != null) {
                strM196n = abstractC0048c.m196n();
            }
        } else {
            String strM65400j = C10713c.m65400j(BackupObject.getExecuteParameter(), "key_video_file_name");
            if (strM65400j != null) {
                str2 = strM65400j;
                i10 = 1;
                int iM65394d = C10713c.m65394d(BackupObject.getExecuteParameter(), "key_media_restore_location");
                C12718o c12718o = new C12718o(context, callback, obj, str, str2);
                c12718o.m76537m(BasicBaseResp.TERM_NO_SIGN, iM65394d, i10, true);
                return m76474T(c12718o);
            }
            i10 = 1;
        }
        str2 = strM196n;
        int iM65394d2 = C10713c.m65394d(BackupObject.getExecuteParameter(), "key_media_restore_location");
        C12718o c12718o2 = new C12718o(context, callback, obj, str, str2);
        c12718o2.m76537m(BasicBaseResp.TERM_NO_SIGN, iM65394d2, i10, true);
        return m76474T(c12718o2);
    }
}
