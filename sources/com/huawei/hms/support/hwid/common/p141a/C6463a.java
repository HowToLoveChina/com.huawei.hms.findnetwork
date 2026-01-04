package com.huawei.hms.support.hwid.common.p141a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hwid.common.p145d.C6469a;
import com.huawei.hms.support.hwid.common.p146e.C6477g;
import java.util.UUID;

/* renamed from: com.huawei.hms.support.hwid.common.a.a */
/* loaded from: classes8.dex */
public class C6463a {

    /* renamed from: a */
    private static String f30007a = "";

    /* renamed from: a */
    public static String m36838a() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "unknown" : str;
    }

    /* renamed from: b */
    public static String m36840b() {
        if (TextUtils.isEmpty(f30007a)) {
            String string = UUID.randomUUID().toString();
            f30007a = string;
            if (TextUtils.isEmpty(string)) {
                return "NULL";
            }
        }
        return f30007a;
    }

    /* renamed from: a */
    public static String m36839a(Context context) {
        C6477g.m36904a("TerminalInfo", "generateUuid start.", true);
        String strM36866b = C6469a.m36860a(context).m36866b("UUID", "");
        if (!TextUtils.isEmpty(strM36866b)) {
            return strM36866b;
        }
        C6477g.m36904a("TerminalInfo", "uuid is null.", true);
        String strM36840b = m36840b();
        C6469a.m36860a(context).m36867c("UUID", strM36840b);
        return strM36840b;
    }
}
