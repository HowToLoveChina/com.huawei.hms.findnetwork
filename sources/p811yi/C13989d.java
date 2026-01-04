package p811yi;

import android.content.Context;
import com.huawei.android.hicloud.cloudbackup.constant.CloudBackupConstant;
import com.huawei.cloud.base.http.InterfaceC4614q;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.client.grs.GRSRouting;
import com.huawei.cloud.services.drive.model.About;
import com.huawei.hms.support.feature.result.CommonConstant;
import gi.C9946a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p340hi.C10209a;
import p680ui.C13183g;
import p680ui.InterfaceC13180d;

/* renamed from: yi.d */
/* loaded from: classes.dex */
public class C13989d {

    /* renamed from: a */
    public static C13183g f62689a;

    /* renamed from: b */
    public static Map<String, Long> f62690b = new HashMap();

    /* renamed from: c */
    public static long f62691c = 60000000;

    /* renamed from: d */
    public static String f62692d;

    /* renamed from: e */
    public static String f62693e;

    /* renamed from: a */
    public static void m84018a() {
        if (!C4633d0.m28404a(f62692d)) {
            if ("primary".equals(f62692d) && f62690b.containsKey("primary")) {
                f62690b.remove("primary");
            } else if (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(f62692d)) {
                f62690b.remove(CloudBackupConstant.Command.PMS_CMD_BACKUP);
            }
        }
        if (C4633d0.m28404a(f62693e) || !f62690b.containsKey(f62693e)) {
            return;
        }
        f62690b.remove("nearby");
    }

    /* renamed from: b */
    public static boolean m84019b(long j10, String str) {
        if (!f62690b.containsKey(str)) {
            f62690b.put(str, Long.valueOf(j10));
            return false;
        }
        if (j10 - f62690b.get(str).longValue() < f62691c) {
            return false;
        }
        f62690b.remove(str);
        return true;
    }

    /* renamed from: c */
    public static synchronized void m84020c(Context context, String str, InterfaceC4614q interfaceC4614q) {
        try {
            C13183g c13183g = new C13183g(new File(context.getCacheDir().getPath() + "/DriveSDK"));
            f62689a = c13183g;
            InterfaceC13180d interfaceC13180dM79226b = c13183g.m79226b("DriveDomain");
            InterfaceC13180d interfaceC13180dM79226b2 = f62689a.m79226b(CommonConstant.KEY_UNION_ID);
            InterfaceC13180d interfaceC13180dM79226b3 = f62689a.m79226b("DriveConfig");
            String str2 = (String) interfaceC13180dM79226b2.mo79229c(CommonConstant.KEY_UNION_ID);
            String str3 = (String) interfaceC13180dM79226b3.mo79229c(str2 + "_host");
            f62693e = str3;
            if (str3 == null || !str3.equals(str)) {
                String str4 = (String) interfaceC13180dM79226b.mo79229c("DriveDomain");
                f62692d = str4;
                if (str4 != null && m84019b(System.currentTimeMillis(), f62692d)) {
                    if ("primary".equals(f62692d) && C13991f.m84027b(context, (C10209a) interfaceC4614q, GRSRouting.getBackUpDomain()) != null) {
                        interfaceC13180dM79226b.clear();
                        interfaceC13180dM79226b.mo79228b("DriveDomain", CloudBackupConstant.Command.PMS_CMD_BACKUP);
                    } else if (CloudBackupConstant.Command.PMS_CMD_BACKUP.equals(f62692d) && C13991f.m84027b(context, (C10209a) interfaceC4614q, GRSRouting.getPrimaryDomain()) != null) {
                        interfaceC13180dM79226b.clear();
                        interfaceC13180dM79226b.mo79228b("DriveDomain", "primary");
                    }
                }
            } else if (m84019b(System.currentTimeMillis(), "nearby")) {
                About aboutM84027b = C13991f.m84027b(context, (C10209a) interfaceC4614q, GRSRouting.getDriveURL(context));
                C13991f.m84028c(interfaceC13180dM79226b3, str2, C13991f.m84026a(aboutM84027b, "nationalCode"), C13991f.m84026a(aboutM84027b, "domain"), System.currentTimeMillis());
                C9946a.m61628b(false);
            }
        } catch (IOException unused) {
            f62689a = null;
        }
    }
}
