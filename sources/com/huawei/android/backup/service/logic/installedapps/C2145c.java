package com.huawei.android.backup.service.logic.installedapps;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import com.huawei.android.backup.service.utils.C2157a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p006a5.AbstractC0048c;
import p601r4.C12462b;
import p632s4.C12701e;
import p633s5.AbstractC12706c;
import p633s5.C12718o;
import p699v4.C13332a;
import p699v4.C13348q;

/* renamed from: com.huawei.android.backup.service.logic.installedapps.c */
/* loaded from: classes.dex */
public class C2145c extends AbstractC12706c {

    /* renamed from: d */
    public boolean f9635d = false;

    /* renamed from: d0 */
    public final void m12906d0(Context context, String str, boolean z10) {
        C2111d.m12654j("BackupAppExternalData", "backup app external data begin, ", str, ", isTwin, ", Boolean.valueOf(z10));
        Set<String> setM13198f = C2157a.m13198f(context, str, z10);
        if (C13348q.m80082b(setM13198f)) {
            C2111d.m12657m("BackupAppExternalData", "externalFilePathSet is empty");
            return;
        }
        HashMap map = new HashMap();
        Iterator<String> it = setM13198f.iterator();
        while (it.hasNext()) {
            map.putAll(C13332a.m79950d(it.next()));
        }
        C12701e c12701e = new C12701e(context, str, false);
        for (Map.Entry entry : map.entrySet()) {
            c12701e.m76432i((String) entry.getKey(), ((Long) entry.getValue()).longValue());
        }
        c12701e.m76428e();
        map.clear();
        C2111d.m12654j("BackupAppExternalData", "backup app external data end, ", str);
    }

    /* renamed from: e0 */
    public void m12907e0() {
        this.f9635d = true;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (BackupObject.isBothPhoneSupportAppExternalData() && C2157a.m13183R(context, str)) {
            C2111d.m12654j("BackupAppExternalData", "onBackup begin ", str);
            m12906d0(context, str, false);
            if (this.f9635d) {
                m12906d0(context, str, true);
            }
        }
        return 1;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        C2111d.m12657m("BackupAppExternalData", "empty method");
        return new Bundle();
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (!BackupObject.isBothPhoneSupportAppExternalData() || !C2157a.m13183R(context, str) || context == null || abstractC0048c == null) {
            return 4;
        }
        C2111d.m12654j("BackupAppExternalData", "onRestore begin ", str);
        String str2 = abstractC0048c.m193k() + "/external";
        String str3 = C12462b.m74717a(abstractC0048c.m193k()).getParent() + File.separator + "packaged";
        if (!C12462b.m74717a(str2).exists() && !C12462b.m74717a(str2).mkdirs()) {
            C2111d.m12648d("BackupAppExternalData", "make srcFile dir fail");
            return 4;
        }
        C12718o c12718o = new C12718o(context, callback, obj, str, str2);
        c12718o.m76537m(507, 2, 0, false);
        c12718o.m76539o(str3);
        return m76475U(c12718o, null, null);
    }
}
