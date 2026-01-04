package p359i6;

import com.huawei.android.backup.filelogic.utils.C2111d;
import p699v4.C13342k;

/* renamed from: i6.b */
/* loaded from: classes.dex */
public class C10446b extends AbstractC10448d {

    /* renamed from: d */
    public String f50402d = null;

    @Override // p359i6.AbstractC10448d
    /* renamed from: b */
    public float mo64241b() throws Throwable {
        float f10 = -1000.0f;
        if (m64243e() == null) {
            C2111d.m12657m("SpareWindowTemp", "Failed to get thermal path");
            return -1000.0f;
        }
        String strM64244f = m64244f(this.f50402d);
        if (strM64244f.isEmpty()) {
            try {
                int iM80055d = C13342k.m80055d(strM64244f);
                f10 = (iM80055d > 1000 || iM80055d < -1000) ? iM80055d / 1000.0f : iM80055d;
            } catch (NumberFormatException unused) {
                C2111d.m12649e("SpareWindowTemp", "Exception when parse temperature: ", strM64244f);
            }
        }
        C2111d.m12654j("SpareWindowTemp", "batteryTemp is ", Float.valueOf(f10));
        return f10;
    }

    @Override // p359i6.AbstractC10448d
    /* renamed from: d */
    public boolean mo64242d() {
        return m64243e() != null;
    }

    /* renamed from: e */
    public final String m64243e() throws Throwable {
        String str = this.f50402d;
        if (str != null) {
            return str;
        }
        C2111d.m12646b("SpareWindowTemp", "enter getPath function!");
        int i10 = 0;
        while (true) {
            if (i10 >= 40) {
                break;
            }
            String str2 = "/sys/class/thermal/thermal_zone" + i10 + "/type";
            String strM64244f = m64244f(str2);
            if (strM64244f.isEmpty()) {
                C2111d.m12649e("SpareWindowTemp", "Failed to read node: ", str2);
            } else {
                C2111d.m12654j("SpareWindowTemp", "Node", Integer.valueOf(i10), " content: ", strM64244f);
                if ("battery".equalsIgnoreCase(strM64244f)) {
                    String str3 = "/sys/class/thermal/thermal_zone" + i10 + "/temp";
                    this.f50402d = str3;
                    C2111d.m12654j("SpareWindowTemp", "Get thermal node: ", str3);
                    break;
                }
            }
            i10++;
        }
        return this.f50402d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        r5.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        com.huawei.android.backup.filelogic.utils.C2111d.m12648d("SpareWindowTemp", "close IOException Exception when read file");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0050 A[EDGE_INSN: B:21:0x0049->B:62:0x0050 BREAK  A[LOOP:0: B:75:0x002b->B:79:?], EXC_TOP_SPLITTER, PHI: r4 r9
  0x0050: PHI (r4v5 ??) = (r4v3 ??), (r4v4 ??), (r4v10 ??), (r4v10 ??) binds: [B:38:0x006f, B:45:0x0080, B:23:0x004d, B:21:0x0049] A[DONT_GENERATE, DONT_INLINE]
  0x0050: PHI (r9v8 ??) = (r9v6 ??), (r9v7 ??), (r9v9 ??), (r9v9 ??) binds: [B:38:0x006f, B:45:0x0080, B:23:0x004d, B:21:0x0049] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.FileInputStream, java.io.InputStream] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m64244f(java.lang.String r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r8 = "fis close IOException Exception when read file"
            java.lang.String r0 = "close IOException Exception when read file"
            java.lang.String r1 = "SpareWindowTemp"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 10485760(0xa00000, float:1.469368E-38)
            r2.<init>(r3)
            if (r9 != 0) goto L14
            java.lang.String r8 = r2.toString()
            return r8
        L14:
            r4 = 0
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5d java.io.FileNotFoundException -> L5f
            r5.<init>(r9)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5d java.io.FileNotFoundException -> L5f
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5d java.io.FileNotFoundException -> L5f
            r9.<init>(r5)     // Catch: java.lang.Throwable -> L5a java.io.IOException -> L5d java.io.FileNotFoundException -> L5f
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L61 java.io.FileNotFoundException -> L72
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L61 java.io.FileNotFoundException -> L72
            java.lang.String r7 = "UTF-8"
            r6.<init>(r9, r7)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L61 java.io.FileNotFoundException -> L72
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L61 java.io.FileNotFoundException -> L72
        L2b:
            java.lang.String r4 = r5.readLine()     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L45 java.io.FileNotFoundException -> L47
            if (r4 == 0) goto L49
            int r6 = r4.length()     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L45 java.io.FileNotFoundException -> L47
            if (r6 <= r3) goto L38
            goto L49
        L38:
            r2.append(r4)     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L45 java.io.FileNotFoundException -> L47
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L42 java.io.IOException -> L45 java.io.FileNotFoundException -> L47
            if (r4 <= r3) goto L2b
            goto L49
        L42:
            r2 = move-exception
            r4 = r5
            goto L88
        L45:
            r4 = r5
            goto L61
        L47:
            r4 = r5
            goto L72
        L49:
            r5.close()     // Catch: java.io.IOException -> L4d
            goto L50
        L4d:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r0)
        L50:
            r9.close()     // Catch: java.io.IOException -> L54
            goto L83
        L54:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r8)
            goto L83
        L58:
            r2 = move-exception
            goto L88
        L5a:
            r2 = move-exception
            r9 = r4
            goto L88
        L5d:
            r9 = r4
            goto L61
        L5f:
            r9 = r4
            goto L72
        L61:
            java.lang.String r3 = "IOException Exception when read file"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L6f
            r4.close()     // Catch: java.io.IOException -> L6c
            goto L6f
        L6c:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r0)
        L6f:
            if (r9 == 0) goto L83
            goto L50
        L72:
            java.lang.String r3 = "FileNotFound Exception when read file"
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r3)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L80
            r4.close()     // Catch: java.io.IOException -> L7d
            goto L80
        L7d:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r0)
        L80:
            if (r9 == 0) goto L83
            goto L50
        L83:
            java.lang.String r8 = r2.toString()
            return r8
        L88:
            if (r4 == 0) goto L91
            r4.close()     // Catch: java.io.IOException -> L8e
            goto L91
        L8e:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r0)
        L91:
            if (r9 == 0) goto L9a
            r9.close()     // Catch: java.io.IOException -> L97
            goto L9a
        L97:
            com.huawei.android.backup.filelogic.utils.C2111d.m12648d(r1, r8)
        L9a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p359i6.C10446b.m64244f(java.lang.String):java.lang.String");
    }
}
