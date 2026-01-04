package je;

import com.huawei.hicloud.cloudbackup.store.database.tags.BackupOptionItem;
import java.util.List;
import tl.C13026e;

/* renamed from: je.c */
/* loaded from: classes3.dex */
public class C10780c {
    /* renamed from: a */
    public static boolean m65629a() {
        List<BackupOptionItem> listM78397u = new C13026e().m78397u();
        if (listM78397u == null || listM78397u.isEmpty()) {
            return false;
        }
        for (BackupOptionItem backupOptionItem : listM78397u) {
            if (backupOptionItem != null && !backupOptionItem.getBackupSwitch()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m65630b() {
        BackupOptionItem backupOptionItemM78401y = new C13026e().m78401y("com.tencent.mm");
        if (backupOptionItemM78401y == null) {
            return false;
        }
        return backupOptionItemM78401y.getBackupSwitch();
    }
}
