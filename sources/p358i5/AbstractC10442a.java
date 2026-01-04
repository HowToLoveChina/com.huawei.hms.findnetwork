package p358i5;

import android.content.Context;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.hicloud.notification.constants.HNConstants;

/* renamed from: i5.a */
/* loaded from: classes.dex */
public abstract class AbstractC10442a extends BackupObject {
    /* renamed from: a */
    public void m64218a(Context context) {
        if (BackupObject.getFollowingRestoreModules().contains(HNConstants.DataType.CONTACT)) {
            C2111d.m12657m("BackupCallLogs", "wait contact restore done");
        } else {
            BackupObject.sendBroadcastToContactAfterRestore(context);
        }
    }
}
