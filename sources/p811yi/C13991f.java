package p811yi;

import com.huawei.cloud.base.util.C4633d0;
import com.huawei.cloud.base.util.C4650r;
import com.huawei.cloud.services.drive.model.About;
import java.io.IOException;
import p680ui.InterfaceC13180d;

/* renamed from: yi.f */
/* loaded from: classes.dex */
public final class C13991f {

    /* renamed from: a */
    public static long f62695a;

    /* renamed from: b */
    public static final C4650r f62696b = C4650r.m28485f("NationalCode");

    /* renamed from: a */
    public static String m84026a(About about, String str) {
        if (about == null) {
            return null;
        }
        Object obj = about.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b9  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.cloud.services.drive.model.About m84027b(android.content.Context r4, p340hi.C10209a r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            com.huawei.hms.drive.h r1 = new com.huawei.hms.drive.h     // Catch: java.io.IOException -> Lf
            r1.<init>(r4)     // Catch: java.io.IOException -> Lf
            int r4 = p811yi.C13987b.m84004a()     // Catch: java.io.IOException -> Lf
            com.huawei.hms.drive.bc r4 = r1.mo31723a(r4)     // Catch: java.io.IOException -> Lf
            goto L17
        Lf:
            com.huawei.cloud.base.util.r r4 = p811yi.C13991f.f62696b
            java.lang.String r1 = "Use default OkHttpClient error"
            r4.m28489d(r1)
            r4 = r0
        L17:
            if (r4 != 0) goto L1a
            return r0
        L1a:
            boolean r1 = com.huawei.cloud.base.util.C4633d0.m28404a(r6)
            if (r1 == 0) goto L21
            return r0
        L21:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r6)
            java.lang.String r2 = "/"
            boolean r6 = r6.endsWith(r2)
            if (r6 != 0) goto L31
            r1.append(r2)
        L31:
            java.lang.String r6 = "drive/v1/about?fields=*"
            r1.append(r6)
            java.lang.String r5 = r5.m63355e()
            com.huawei.hms.drive.bf$a r6 = new com.huawei.hms.drive.bf$a
            r6.<init>()
            java.lang.String r1 = r1.toString()
            com.huawei.hms.drive.bf$a r1 = r6.m31120a(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Bearer "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            java.lang.String r2 = "Authorization"
            com.huawei.hms.drive.bf$a r5 = r1.m31125b(r2, r5)
            java.lang.String r1 = "version"
            java.lang.String r2 = "5.2.0.100"
            r5.m31125b(r1, r2)
            com.huawei.hms.drive.bf r5 = r6.m31123a()     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            com.huawei.hms.drive.aj r4 = r4.m31044a(r5)     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            com.huawei.hms.drive.bh r4 = r4.mo30836a()     // Catch: java.lang.Throwable -> L93 java.io.IOException -> L95
            oi.a r5 = p523oi.C11903a.m71435l()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L91
            com.huawei.hms.drive.bi r6 = r4.m31133f()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L91
            java.io.InputStream r6 = r6.m31160b()     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L91
            ni.e r5 = r5.m71437k(r6)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L91
            java.lang.Class<com.huawei.cloud.services.drive.model.About> r6 = com.huawei.cloud.services.drive.model.About.class
            java.lang.Object r5 = r5.m69886u(r6)     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L91
            com.huawei.cloud.services.drive.model.About r5 = (com.huawei.cloud.services.drive.model.About) r5     // Catch: java.lang.Throwable -> L8e java.io.IOException -> L91
            r4.close()
            r0 = r5
            goto Lb6
        L8e:
            r5 = move-exception
            r0 = r4
            goto Lb7
        L91:
            r5 = move-exception
            goto L97
        L93:
            r5 = move-exception
            goto Lb7
        L95:
            r5 = move-exception
            r4 = r0
        L97:
            com.huawei.cloud.base.util.r r6 = p811yi.C13991f.f62696b     // Catch: java.lang.Throwable -> L8e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8e
            r1.<init>()     // Catch: java.lang.Throwable -> L8e
            java.lang.String r2 = "get code error: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L8e
            r1.append(r5)     // Catch: java.lang.Throwable -> L8e
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L8e
            r6.m28489d(r5)     // Catch: java.lang.Throwable -> L8e
            if (r4 == 0) goto Lb6
            r4.close()
        Lb6:
            return r0
        Lb7:
            if (r0 == 0) goto Lbc
            r0.close()
        Lbc:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p811yi.C13991f.m84027b(android.content.Context, hi.a, java.lang.String):com.huawei.cloud.services.drive.model.About");
    }

    /* renamed from: c */
    public static void m84028c(InterfaceC13180d<String> interfaceC13180d, String str, String str2, String str3, long j10) {
        if (interfaceC13180d != null) {
            try {
                f62695a = j10 + 86400000;
                interfaceC13180d.mo79228b(str + "_time", String.valueOf(f62695a));
                if (!C4633d0.m28404a(str2)) {
                    interfaceC13180d.mo79228b(str, str2);
                }
                if (C4633d0.m28404a(str3)) {
                    interfaceC13180d.mo79227a(str + "_host");
                    return;
                }
                interfaceC13180d.mo79228b(str + "_host", str3);
            } catch (IOException e10) {
                f62696b.m28489d("init config error: " + e10.toString());
            }
        }
    }
}
