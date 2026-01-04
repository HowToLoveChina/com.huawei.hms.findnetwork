package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.u0 */
/* loaded from: classes8.dex */
public class C5570u0 {
    /* renamed from: a */
    public static C5529f0 m32780a(String str, String str2, String str3, String str4) {
        C5529f0 c5529f0 = new C5529f0();
        c5529f0.m32601a(str);
        c5529f0.m32602b(AbstractC5562q0.m32712f());
        c5529f0.m32605e(str2);
        c5529f0.m32603c(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        c5529f0.m32604d(stringBuffer.toString());
        return c5529f0;
    }

    /* renamed from: b */
    public static C5536h1 m32783b(String str, String str2) {
        C5551m1.m32643d().m32645a(str, str2);
        if (!TextUtils.isEmpty(C5551m1.m32643d().m32644a())) {
            return new C5536h1(C5551m1.m32643d().m32647c());
        }
        C5571v.m32797f("hmsSdk", "event chifer is empty");
        return null;
    }

    /* renamed from: c */
    public static Map<String, String> m32784c(String str, String str2) {
        HashMap map = new HashMap();
        map.put("App-Id", AbstractC5562q0.m32712f());
        map.put("App-Ver", AbstractC5562q0.m32714g());
        map.put("Sdk-Name", "hianalytics");
        map.put("Sdk-Ver", "2.2.0.315");
        map.put("Device-Type", Build.MODEL);
        map.put("servicetag", str);
        C5571v.m32786a("hmsSdk", "sendData RequestId : " + str2);
        map.put("Request-Id", str2);
        return map;
    }

    /* renamed from: a */
    public static C5546l m32781a(String str, String str2) {
        C5546l c5546l = new C5546l();
        c5546l.m32772a(C5540j.m32576a().m32577a(str, str2));
        return c5546l;
    }

    /* renamed from: a */
    public static C5578y0 m32782a(String str, String str2, String str3) {
        C5578y0 c5578y0 = new C5578y0();
        c5578y0.m32775c(AbstractC5562q0.m32719j());
        c5578y0.m32777e(AbstractC5562q0.m32721l());
        c5578y0.m32773a(str3);
        c5578y0.m32774b(C5540j.m32576a().m32580b(str2, str));
        return c5578y0;
    }
}
