package p633s5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.hicloud.cloudbackup.process.CloneService;
import com.huawei.hicloud.request.cbs.bean.CBSbkFlowHead;
import p006a5.AbstractC0048c;
import p386j6.C10713c;

/* renamed from: s5.a */
/* loaded from: classes.dex */
public class C12704a extends AbstractC12706c {
    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupDocumentImp", "onBackup");
        String strM65400j = C10713c.m65400j(BackupObject.getExecuteParameter(), "key_doc_file_name");
        int iM65394d = C10713c.m65394d(BackupObject.getExecuteParameter(), "key_media_backup_location");
        C12707d c12707d = new C12707d(context, abstractC0048c, callback, obj, strM65400j);
        c12707d.m76517a(CBSbkFlowHead.FLOW_CONTROL_ERR_CODE, iM65394d);
        return m76485c(c12707d);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        return null;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        int i10;
        String strM196n;
        C2111d.m12653i("BackupDocumentImp", "onRestore");
        int iM65395e = C10713c.m65395e(BackupObject.getExecuteParameter(), CloneService.KEY_ACTION_FLAG, 1);
        if (iM65395e == 2 || iM65395e == 4) {
            i10 = 0;
            strM196n = abstractC0048c != null ? abstractC0048c.m196n() : "";
        } else {
            strM196n = C10713c.m65400j(BackupObject.getExecuteParameter(), "key_doc_file_name");
            i10 = 1;
        }
        int iM65394d = C10713c.m65394d(BackupObject.getExecuteParameter(), "key_media_restore_location");
        C12718o c12718o = new C12718o(context, callback, obj, str, strM196n);
        c12718o.m76537m(CBSbkFlowHead.FLOW_CONTROL_ERR_CODE, iM65394d, i10, true);
        return m76474T(c12718o);
    }
}
