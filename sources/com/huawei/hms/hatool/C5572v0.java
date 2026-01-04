package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import java.util.List;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.v0 */
/* loaded from: classes8.dex */
public class C5572v0 implements InterfaceRunnableC5531g {

    /* renamed from: a */
    private Context f25318a = AbstractC5562q0.m32718i();

    /* renamed from: b */
    private String f25319b;

    /* renamed from: c */
    private String f25320c;

    /* renamed from: d */
    private String f25321d;

    public C5572v0(String str, String str2, String str3) {
        this.f25319b = str;
        this.f25320c = str2;
        this.f25321d = str3;
    }

    /* renamed from: a */
    private void m32798a(String str, List<C5518b1> list) {
        Pair<String, String> pairM32658a = AbstractC5554n1.m32658a(str);
        new C5569u(list, (String) pairM32658a.first, (String) pairM32658a.second, this.f25321d).m32779a();
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, List<C5518b1>> mapM32469a;
        C5571v.m32786a("hmsSdk", "eventReportTask is running");
        boolean zM32464a = C5520c0.m32464a(this.f25318a);
        if (zM32464a) {
            C5571v.m32792c("hmsSdk", "workKey is refresh,begin report all data");
            this.f25320c = "alltype";
        }
        try {
            try {
                try {
                    mapM32469a = C5521c1.m32469a(this.f25318a, this.f25319b, this.f25320c);
                } catch (Exception e10) {
                    C5571v.m32796e("hmsSdk", "readEventRecords handData Exception:" + e10.getMessage());
                    if ("alltype".equals(this.f25320c)) {
                        C5522d.m32478a(this.f25318a, "stat_v2_1", new String[0]);
                        C5522d.m32478a(this.f25318a, "cached_v2_1", new String[0]);
                    } else {
                        String strM32660a = AbstractC5554n1.m32660a(this.f25319b, this.f25320c);
                        C5522d.m32478a(this.f25318a, "stat_v2_1", strM32660a);
                        C5522d.m32478a(this.f25318a, "cached_v2_1", strM32660a);
                    }
                }
            } catch (IllegalArgumentException e11) {
                C5571v.m32796e("hmsSdk", "readEventRecords handData IllegalArgumentException:" + e11.getMessage());
                if ("alltype".equals(this.f25320c)) {
                    C5522d.m32478a(this.f25318a, "stat_v2_1", new String[0]);
                    C5522d.m32478a(this.f25318a, "cached_v2_1", new String[0]);
                } else {
                    String strM32660a2 = AbstractC5554n1.m32660a(this.f25319b, this.f25320c);
                    C5522d.m32478a(this.f25318a, "stat_v2_1", strM32660a2);
                    C5522d.m32478a(this.f25318a, "cached_v2_1", strM32660a2);
                }
            }
            if (mapM32469a.size() == 0) {
                C5571v.m32790b("hmsSdk", "no events to report, tag: %s, type: %s", this.f25319b, this.f25320c);
                if ("alltype".equals(this.f25320c)) {
                    C5522d.m32478a(this.f25318a, "stat_v2_1", new String[0]);
                    C5522d.m32478a(this.f25318a, "cached_v2_1", new String[0]);
                    return;
                } else {
                    String strM32660a3 = AbstractC5554n1.m32660a(this.f25319b, this.f25320c);
                    C5522d.m32478a(this.f25318a, "stat_v2_1", strM32660a3);
                    C5522d.m32478a(this.f25318a, "cached_v2_1", strM32660a3);
                    return;
                }
            }
            for (Map.Entry<String, List<C5518b1>> entry : mapM32469a.entrySet()) {
                m32798a(entry.getKey(), entry.getValue());
            }
            if ("alltype".equals(this.f25320c)) {
                C5522d.m32478a(this.f25318a, "stat_v2_1", new String[0]);
                C5522d.m32478a(this.f25318a, "cached_v2_1", new String[0]);
            } else {
                String strM32660a4 = AbstractC5554n1.m32660a(this.f25319b, this.f25320c);
                C5522d.m32478a(this.f25318a, "stat_v2_1", strM32660a4);
                C5522d.m32478a(this.f25318a, "cached_v2_1", strM32660a4);
            }
            if (zM32464a) {
                C5571v.m32792c("hmsSdk", "refresh local key");
                C5556o0.m32677d().m32682b();
            }
        } catch (Throwable th2) {
            if ("alltype".equals(this.f25320c)) {
                C5522d.m32478a(this.f25318a, "stat_v2_1", new String[0]);
                C5522d.m32478a(this.f25318a, "cached_v2_1", new String[0]);
            } else {
                String strM32660a5 = AbstractC5554n1.m32660a(this.f25319b, this.f25320c);
                C5522d.m32478a(this.f25318a, "stat_v2_1", strM32660a5);
                C5522d.m32478a(this.f25318a, "cached_v2_1", strM32660a5);
            }
            throw th2;
        }
    }
}
