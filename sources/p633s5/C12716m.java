package p633s5;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.backup.service.logic.BackupObject;
import java.io.File;
import java.util.List;
import p006a5.AbstractC0048c;
import p544p4.C12086a;
import p566q4.C12284c;
import p699v4.C13334c;
import p699v4.C13340i;
import p699v4.C13341j;
import p699v4.C13345n;

/* renamed from: s5.m */
/* loaded from: classes.dex */
public class C12716m extends AbstractC12706c {
    /* renamed from: d0 */
    public final String m76518d0(String str, String str2) {
        int iM79963G = C13334c.m79963G(str, File.separator, 3);
        if (iM79963G == -1) {
            C2111d.m12648d("BackupWechatRecordImp", "file root path is not right");
            return str;
        }
        return str2 + str.substring(iM79963G);
    }

    /* renamed from: e0 */
    public final boolean m76519e0(Context context) {
        boolean z10 = context.getSharedPreferences("config_info", 4).getBoolean("isNoMediaFilesRestoreDone", false);
        C2111d.m12654j("BackupWechatRecordImp", "isNoMediaRestoreDone, ", Boolean.valueOf(z10));
        return z10;
    }

    /* renamed from: f0 */
    public final void m76520f0(Context context, String str, String str2) {
        C2111d.m12653i("BackupWechatRecordImp", "restoreNoMediaFiles begin");
        List<String> listM80031q = C13340i.m80031q(str + File.separator + C12284c.m73809b(str2));
        C2111d.m12654j("BackupWechatRecordImp", "noMediaFilePaths size ", Integer.valueOf(listM80031q.size()));
        String strM72257d = C12086a.m72257d(context);
        String strM80072k = C13345n.m80072k(context, 2);
        for (String strM76518d0 : listM80031q) {
            if (!strM76518d0.startsWith(strM80072k)) {
                strM76518d0 = m76518d0(strM76518d0, strM72257d);
            }
            C13334c.m79976i(new File(strM76518d0));
        }
        C2111d.m12653i("BackupWechatRecordImp", "restoreNoMediaFiles end");
    }

    /* renamed from: g0 */
    public final void m76521g0(Context context) {
        C2111d.m12653i("BackupWechatRecordImp", "saveNoMediaRestoreDone");
        context.getSharedPreferences("config_info", 4).edit().putBoolean("isNoMediaFilesRestoreDone", true).apply();
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onBackup(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        return 0;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public Bundle onBackupModulesDataItemTotal(Context context, Long l10, int i10, String str) {
        return null;
    }

    @Override // com.huawei.android.backup.service.logic.BackupObject
    public int onRestore(Context context, AbstractC0048c abstractC0048c, Handler.Callback callback, Object obj, String str) {
        if (!BackupObject.isWechatRestoreSuccess()) {
            C2111d.m12648d("BackupWechatRecordImp", "wechat restore fail, no need restore wechat record, return fail");
            sendMsg(5, 0, 0, callback, obj);
            return 5;
        }
        String strM196n = abstractC0048c != null ? abstractC0048c.m196n() : "";
        C13341j.m80037d(context);
        if (!m76519e0(context)) {
            m76520f0(context, strM196n, str);
            m76521g0(context);
        }
        C12718o c12718o = new C12718o(context, callback, obj, str, strM196n);
        c12718o.m76537m(517, 2, 0, false);
        return m76474T(c12718o);
    }
}
