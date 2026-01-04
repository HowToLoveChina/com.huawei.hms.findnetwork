package p699v4;

import com.huawei.android.backup.filelogic.utils.C2111d;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import java.io.IOException;

/* renamed from: v4.d */
/* loaded from: classes.dex */
public class C13335d {
    /* renamed from: a */
    public static void m79994a() {
        for (int i10 = 0; i10 <= 2; i10++) {
            try {
                if (C13334c.m79990w()[i10] != null) {
                    C13334c.m79965I(new String[]{C13334c.m79990w()[i10], CloudBackupConstant.Command.PMS_CMD_BACKUP, "App"});
                    C13334c.m79965I(new String[]{C13334c.m79990w()[i10], CloudBackupConstant.Command.PMS_CMD_BACKUP, "Data"});
                }
            } catch (IOException unused) {
                C2111d.m12648d("FileHelperCMCC", "createAllLocation error.");
                return;
            }
        }
    }

    /* renamed from: b */
    public static void m79995b() {
        m79994a();
    }
}
