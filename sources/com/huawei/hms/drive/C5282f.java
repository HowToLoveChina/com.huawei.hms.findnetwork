package com.huawei.hms.drive;

import android.content.Context;
import com.huawei.cloud.base.util.C4633d0;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import p553pi.C12146d;
import p680ui.C13183g;
import p680ui.InterfaceC13180d;

/* renamed from: com.huawei.hms.drive.f */
/* loaded from: classes8.dex */
public class C5282f {

    /* renamed from: a */
    private static C13183g f24506a;

    /* renamed from: a */
    public static synchronized void m31717a(Context context, String str) {
        try {
            try {
                C13183g c13183g = new C13183g(new File(context.getCacheDir().getPath() + "/DriveSDK"));
                f24506a = c13183g;
                InterfaceC13180d interfaceC13180dM79226b = c13183g.m79226b(CommonConstant.KEY_UNION_ID);
                if (!str.equals(interfaceC13180dM79226b.mo79229c(CommonConstant.KEY_UNION_ID))) {
                    m31718a(f24506a, CommonConstant.KEY_UNION_ID);
                    m31718a(f24506a, "DriveConfig");
                    m31718a(f24506a, "UploadID");
                    interfaceC13180dM79226b.mo79228b(CommonConstant.KEY_UNION_ID, str);
                }
                InterfaceC13180d interfaceC13180dM79226b2 = f24506a.m79226b("UploadID");
                ArrayList arrayList = new ArrayList();
                for (C12146d c12146d : interfaceC13180dM79226b2.values()) {
                    if (c12146d.m72860d()) {
                        arrayList.add(c12146d.m72858b());
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    interfaceC13180dM79226b2.mo79227a((String) it.next());
                }
            } catch (IOException unused) {
                f24506a = null;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: b */
    public static void m31719b(String str, String str2) throws IOException {
        C13183g c13183g;
        if (C4633d0.m28404a(str) || C4633d0.m28404a(str2) || (c13183g = f24506a) == null) {
            return;
        }
        c13183g.m79226b(str).mo79227a(str2);
    }

    /* renamed from: a */
    public static <T extends Serializable> T m31714a(String str, String str2) throws IOException {
        C13183g c13183g;
        if (C4633d0.m28404a(str) || C4633d0.m28404a(str2) || (c13183g = f24506a) == null) {
            return null;
        }
        return (T) c13183g.m79226b(str).mo79229c(str2);
    }

    /* renamed from: a */
    public static <T extends Serializable> T m31715a(String str, String str2, T t10) throws IOException {
        C13183g c13183g;
        if (C4633d0.m28404a(str) || C4633d0.m28404a(str2) || t10 == null || (c13183g = f24506a) == null) {
            return null;
        }
        InterfaceC13180d interfaceC13180dM79226b = c13183g.m79226b(str);
        interfaceC13180dM79226b.mo79228b(str2, t10);
        return (T) interfaceC13180dM79226b.mo79229c(str2);
    }

    /* renamed from: a */
    public static <T extends Serializable> InterfaceC13180d<T> m31716a(String str) throws IOException {
        C13183g c13183g;
        if (C4633d0.m28404a(str) || (c13183g = f24506a) == null) {
            return null;
        }
        return c13183g.m79226b(str);
    }

    /* renamed from: a */
    private static void m31718a(C13183g c13183g, String str) throws IOException {
        InterfaceC13180d interfaceC13180dM79226b = c13183g.m79226b(str);
        if (interfaceC13180dM79226b != null) {
            interfaceC13180dM79226b.clear();
        }
    }
}
