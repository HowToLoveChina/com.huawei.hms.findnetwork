package ao;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hicloud.notification.constants.NotifyConstants;
import fk.C9721b;
import java.util.HashMap;
import p015ak.C0213f;
import p429kk.C11060c;
import p514o9.C11839m;
import p746wn.C13622a;

/* renamed from: ao.a */
/* loaded from: classes6.dex */
public class C1005a {

    /* renamed from: a */
    public static final Gson f5035a = new Gson();

    /* renamed from: ao.a$a */
    public static class a {

        /* renamed from: a */
        public static C1005a f5036a = new C1005a();
    }

    /* renamed from: b */
    public static C1005a m5932b() {
        return a.f5036a;
    }

    /* renamed from: a */
    public final <T> T m5933a(String str, Class<T> cls) throws C9721b {
        try {
            return (T) f5035a.fromJson(str, (Class) cls);
        } catch (JsonSyntaxException e10) {
            throw new C9721b(1001, "json err " + e10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009b, code lost:
    
        r15.m66665u(java.lang.String.valueOf(r3.m85530a()));
        r15.m66635A(r3.m85531b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ad, code lost:
    
        return r6;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m5934c(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, p429kk.C11060c r15) throws fk.C9721b {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "AgEventReportService"
            r2 = 1
        L5:
            r3 = 0
            r4 = 1001(0x3e9, float:1.403E-42)
            r5 = 3
            yn.a r6 = new yn.a     // Catch: java.lang.Exception -> L19
            java.lang.String r7 = r15.m66661q()     // Catch: java.lang.Exception -> L19
            r6.<init>(r0, r0, r7, r14)     // Catch: java.lang.Exception -> L19
            java.lang.Object r6 = ro.C12612a.m76107g(r12, r6, r15)     // Catch: java.lang.Exception -> L19
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L19
            goto L3d
        L19:
            r6 = move-exception
            int r7 = r2 + 1
            if (r2 >= r5) goto L3b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38
            r2.<init>()     // Catch: java.lang.Exception -> L38
            java.lang.String r3 = "reportAGEvent retry error:"
            r2.append(r3)     // Catch: java.lang.Exception -> L38
            java.lang.String r3 = r6.getMessage()     // Catch: java.lang.Exception -> L38
            r2.append(r3)     // Catch: java.lang.Exception -> L38
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L38
            p514o9.C11839m.m70688i(r1, r2)     // Catch: java.lang.Exception -> L38
            r2 = r7
            goto L5
        L38:
            r9 = move-exception
            goto Lc7
        L3b:
            r6 = r3
            r2 = r7
        L3d:
            if (r6 == 0) goto Lae
            boolean r7 = r6.isEmpty()     // Catch: java.lang.Exception -> L38
            if (r7 == 0) goto L46
            goto Lae
        L46:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38
            r3.<init>()     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = "reportAGEvent adId: "
            r3.append(r7)     // Catch: java.lang.Exception -> L38
            r3.append(r10)     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = " uniqueId:"
            r3.append(r7)     // Catch: java.lang.Exception -> L38
            r3.append(r11)     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = " type:"
            r3.append(r7)     // Catch: java.lang.Exception -> L38
            r3.append(r13)     // Catch: java.lang.Exception -> L38
            java.lang.String r7 = " response: "
            r3.append(r7)     // Catch: java.lang.Exception -> L38
            r3.append(r6)     // Catch: java.lang.Exception -> L38
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L38
            p514o9.C11839m.m70688i(r1, r3)     // Catch: java.lang.Exception -> L38
            java.lang.Class<zn.a> r3 = p849zn.C14349a.class
            java.lang.Object r3 = r9.m5933a(r6, r3)     // Catch: java.lang.Exception -> L38
            zn.a r3 = (p849zn.C14349a) r3     // Catch: java.lang.Exception -> L38
            int r7 = r3.m85530a()     // Catch: java.lang.Exception -> L38
            if (r7 == 0) goto L9b
            int r8 = r2 + 1
            if (r2 >= r5) goto L9b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38
            r2.<init>()     // Catch: java.lang.Exception -> L38
            java.lang.String r3 = "reportAGEvent retry rtnCode:"
            r2.append(r3)     // Catch: java.lang.Exception -> L38
            r2.append(r7)     // Catch: java.lang.Exception -> L38
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L38
            p514o9.C11839m.m70688i(r1, r2)     // Catch: java.lang.Exception -> L38
            r2 = r8
            goto L5
        L9b:
            int r9 = r3.m85530a()     // Catch: java.lang.Exception -> L38
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Exception -> L38
            r15.m66665u(r9)     // Catch: java.lang.Exception -> L38
            java.lang.String r9 = r3.m85531b()     // Catch: java.lang.Exception -> L38
            r15.m66635A(r9)     // Catch: java.lang.Exception -> L38
            return r6
        Lae:
            int r6 = r2 + 1
            if (r2 >= r5) goto Lba
            java.lang.String r2 = "reportAGEvent retry response null"
            p514o9.C11839m.m70688i(r1, r2)     // Catch: java.lang.Exception -> L38
            r2 = r6
            goto L5
        Lba:
            java.lang.String r9 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> L38
            r15.m66665u(r9)     // Catch: java.lang.Exception -> L38
            java.lang.String r9 = "resp is null"
            r15.m66635A(r9)     // Catch: java.lang.Exception -> L38
            return r3
        Lc7:
            java.lang.String r10 = java.lang.String.valueOf(r4)
            r15.m66665u(r10)
            java.lang.String r10 = r9.getMessage()
            r15.m66635A(r10)
            fk.b r10 = new fk.b
            java.lang.String r11 = r9.getMessage()
            r10.<init>(r4, r11, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ao.C1005a.m5934c(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kk.c):java.lang.String");
    }

    /* renamed from: d */
    public String m5935d(String str, String str2, String str3, String str4, C11060c c11060c) {
        HashMap map = new HashMap();
        map.put(NotifyConstants.CloudStorageConstants.AD_NAME_KEY, str);
        map.put("unique_id", str2);
        map.put("reportType", str4);
        try {
            try {
                C11839m.m70686d("AgEventReportService", "reportAGEvent url: " + str3);
                return m5934c(str, str2, str3, str4, "GET", c11060c);
            } catch (C9721b e10) {
                C11839m.m70687e("AgEventReportService", "reportAGEvent error. " + e10.getMessage());
                C13622a.m81969o(C0213f.m1377a(), c11060c, map);
                return null;
            }
        } finally {
            C13622a.m81969o(C0213f.m1377a(), c11060c, map);
        }
    }
}
