package p633s5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import p006a5.AbstractC0048c;
import p386j6.C10713c;

/* renamed from: s5.j */
/* loaded from: classes.dex */
public class C12713j extends AbstractC12706c {
    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        C2111d.m12653i("BackupRecordingsSdImp", "onBackup");
        C12707d c12707d = new C12707d(context, abstractC0048c, callback, obj, C10713c.m65400j(BackupObject.getExecuteParameter(), "key_audio_sd_file_name"));
        c12707d.m76517a(513, 3);
        return m76485c(c12707d);
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    @Override // com.huawei.android.backup.service.logic.BackupObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int onRestore(android.content.Context r12, p006a5.AbstractC0048c r13, android.os.Handler.Callback r14, java.lang.Object r15, java.lang.String r16) {
        /*
            r11 = this;
            java.lang.String r0 = "BackupRecordingsSdImp"
            java.lang.String r1 = "onRestore"
            com.huawei.android.backup.filelogic.utils.C2111d.m12653i(r0, r1)
            android.os.Bundle r0 = com.huawei.android.backup.service.logic.BackupObject.getExecuteParameter()
            java.lang.String r1 = "ActionFlag"
            r2 = 1
            int r0 = p386j6.C10713c.m65395e(r0, r1, r2)
            r1 = 0
            java.lang.String r3 = ""
            r4 = 2
            if (r0 == r4) goto L2c
            r5 = 4
            if (r0 != r5) goto L1c
            goto L2c
        L1c:
            android.os.Bundle r0 = com.huawei.android.backup.service.logic.BackupObject.getExecuteParameter()
            java.lang.String r5 = "key_audio_sd_file_name"
            java.lang.String r0 = p386j6.C10713c.m65400j(r0, r5)
            if (r0 != 0) goto L2a
        L28:
            r10 = r3
            goto L34
        L2a:
            r10 = r0
            goto L34
        L2c:
            if (r13 == 0) goto L32
            java.lang.String r3 = r13.m196n()
        L32:
            r2 = r1
            goto L28
        L34:
            r0 = 3
            r3 = r12
            boolean r5 = p699v4.C13345n.m80074m(r12, r0)
            if (r5 == 0) goto L3d
            r4 = r0
        L3d:
            s5.o r0 = new s5.o
            r5 = r0
            r6 = r12
            r7 = r14
            r8 = r15
            r9 = r16
            r5.<init>(r6, r7, r8, r9, r10)
            r3 = 513(0x201, float:7.19E-43)
            r0.m76537m(r3, r4, r2, r1)
            r1 = r11
            int r0 = r11.m76474T(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p633s5.C12713j.onRestore(android.content.Context, a5.c, android.os.Handler$Callback, java.lang.Object, java.lang.String):int");
    }
}
