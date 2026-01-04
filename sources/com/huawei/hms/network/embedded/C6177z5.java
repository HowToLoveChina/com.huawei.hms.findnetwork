package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;

/* renamed from: com.huawei.hms.network.embedded.z5 */
/* loaded from: classes8.dex */
public class C6177z5 {

    /* renamed from: a */
    public static final String f29236a = "PingNet";

    /* renamed from: b */
    public static final String f29237b = "\n";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f4 A[PHI: r2 r4 r9 r10 r11
  0x00f4: PHI (r2v3 com.huawei.hms.network.embedded.a6) = (r2v1 com.huawei.hms.network.embedded.a6), (r2v4 com.huawei.hms.network.embedded.a6) binds: [B:55:0x00cf, B:62:0x00f2] A[DONT_GENERATE, DONT_INLINE]
  0x00f4: PHI (r4v7 java.io.BufferedReader) = (r4v5 java.io.BufferedReader), (r4v8 java.io.BufferedReader) binds: [B:55:0x00cf, B:62:0x00f2] A[DONT_GENERATE, DONT_INLINE]
  0x00f4: PHI (r9v12 java.lang.Process) = (r9v17 java.lang.Process), (r9v18 java.lang.Process) binds: [B:55:0x00cf, B:62:0x00f2] A[DONT_GENERATE, DONT_INLINE]
  0x00f4: PHI (r10v6 java.io.InputStreamReader) = (r10v4 java.io.InputStreamReader), (r10v7 java.io.InputStreamReader) binds: [B:55:0x00cf, B:62:0x00f2] A[DONT_GENERATE, DONT_INLINE]
  0x00f4: PHI (r11v11 java.io.InputStream) = (r11v19 java.io.InputStream), (r11v20 java.io.InputStream) binds: [B:55:0x00cf, B:62:0x00f2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0101  */
    /* JADX WARN: Type inference failed for: r11v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.hms.network.embedded.C5849a6 m35908a(java.lang.String r8, int r9, int r10, java.lang.StringBuffer r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.C6177z5.m35908a(java.lang.String, int, int, java.lang.StringBuffer):com.huawei.hms.network.embedded.a6");
    }

    /* renamed from: a */
    public static C5849a6 m35904a(String str, C5849a6 c5849a6) {
        String strM35905a = m35905a(str);
        if (strM35905a != null) {
            c5849a6.m33807d(strM35905a);
            Logger.m32143v(f29236a, "ping time:" + strM35905a);
        }
        if (str.contains("avg")) {
            int iIndexOf = str.indexOf("/", 20);
            int iIndexOf2 = str.indexOf(".", iIndexOf);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ping avg time:");
            int i10 = iIndexOf + 1;
            sb2.append(str.substring(i10, iIndexOf2));
            sb2.append("ms");
            Logger.m32143v(f29236a, sb2.toString());
            c5849a6.m33798a(str.substring(i10, iIndexOf2) + "ms");
        }
        if (str.contains("packet loss")) {
            int iIndexOf3 = str.indexOf("%");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("packet loss rate:");
            int i11 = iIndexOf3 - 2;
            sb3.append(str.substring(i11, iIndexOf3));
            Logger.m32143v(f29236a, sb3.toString());
            c5849a6.m33805c(str.substring(i11, iIndexOf3));
        }
        return c5849a6;
    }

    /* renamed from: a */
    public static String m35905a(String str) {
        String strSubstring = null;
        for (String str2 : str.split("\n")) {
            if (str2.contains("time=")) {
                strSubstring = str2.substring(str2.indexOf("time=") + 5);
                Logger.m32143v(f29236a, "the ping time is : " + strSubstring);
            }
        }
        return strSubstring;
    }

    /* renamed from: a */
    public static void m35906a(StringBuffer stringBuffer, String str) {
        if (stringBuffer != null) {
            stringBuffer.append(str);
            stringBuffer.append("\n");
        }
    }

    /* renamed from: a */
    public static String[] m35907a(C5849a6 c5849a6) {
        return new String[]{"ping", "-c", String.valueOf(c5849a6.m33806d()), "-w", String.valueOf(c5849a6.m33809f()), c5849a6.m33801b()};
    }
}
