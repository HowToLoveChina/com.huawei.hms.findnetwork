package p424kb;

import java.io.InputStream;
import p015ak.C0209d;
import p391jb.C10772e;

/* renamed from: kb.a */
/* loaded from: classes3.dex */
public class C11024a {

    /* renamed from: a */
    public C10772e f52103a = null;

    /* JADX WARN: Can't wrap try/catch for region: R(7:60|37|(2:64|38)|66|39|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005e, code lost:
    
        p514o9.C11839m.m70687e("GuideInfoConfig", "Close FileInputStream failed!");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p391jb.C10772e m66464a() throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.String r0 = "om_file_parse_result"
            java.lang.String r1 = "Close FileInputStream failed!"
            java.lang.String r2 = "get Config From File"
            java.lang.String r3 = "GuideInfoConfig"
            p514o9.C11839m.m70688i(r3, r2)
            android.content.Context r2 = p015ak.C0213f.m1377a()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.io.File r2 = r2.getFilesDir()
            r4.append(r2)
            java.lang.String r2 = "/HiCloudOperPageHints.json"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.io.File r4 = new java.io.File
            r4.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "file.exists(): "
            r2.append(r5)
            boolean r5 = r4.exists()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            p514o9.C11839m.m70688i(r3, r2)
            r2 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L69
            java.lang.String r2 = r9.m66465b(r5)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r4.<init>()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            java.lang.Class<jb.e> r6 = p391jb.C10772e.class
            java.lang.Object r2 = r4.fromJson(r2, r6)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            jb.e r2 = (p391jb.C10772e) r2     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r9.f52103a = r2     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
        L5a:
            r5.close()     // Catch: java.io.IOException -> L5e
            goto Lbb
        L5e:
            p514o9.C11839m.m70687e(r3, r1)
            goto Lbb
        L62:
            r9 = move-exception
            r2 = r5
            goto Lbe
        L65:
            r2 = move-exception
            goto L6c
        L67:
            r9 = move-exception
            goto Lbe
        L69:
            r4 = move-exception
            r5 = r2
            r2 = r4
        L6c:
            java.lang.String r4 = "HiCloudOperPageHints"
            long r6 = p459lp.C11327e.m68063f(r4)     // Catch: java.lang.Throwable -> L62
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r8 = "versionCode: "
            r4.append(r8)     // Catch: java.lang.Throwable -> L62
            r4.append(r6)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = " Exception: "
            r4.append(r6)     // Catch: java.lang.Throwable -> L62
            java.lang.String r2 = r2.getMessage()     // Catch: java.lang.Throwable -> L62
            r4.append(r2)     // Catch: java.lang.Throwable -> L62
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Throwable -> L62
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = "cloud config file not exist: "
            r4.append(r6)     // Catch: java.lang.Throwable -> L62
            r4.append(r2)     // Catch: java.lang.Throwable -> L62
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L62
            p514o9.C11839m.m70687e(r3, r4)     // Catch: java.lang.Throwable -> L62
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L62
            r4.<init>()     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = "event_name"
            r4.put(r6, r0)     // Catch: java.lang.Throwable -> L62
            java.lang.String r6 = "result"
            r4.put(r6, r2)     // Catch: java.lang.Throwable -> L62
            com.huawei.hicloud.notification.manager.GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(r4)     // Catch: java.lang.Throwable -> L62
            com.huawei.hicloud.notification.manager.GuideH5BIReportUtil.reportGuideH5Dialog(r0, r2)     // Catch: java.lang.Throwable -> L62
            if (r5 == 0) goto Lbb
            goto L5a
        Lbb:
            jb.e r9 = r9.f52103a
            return r9
        Lbe:
            if (r2 == 0) goto Lc7
            r2.close()     // Catch: java.io.IOException -> Lc4
            goto Lc7
        Lc4:
            p514o9.C11839m.m70687e(r3, r1)
        Lc7:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p424kb.C11024a.m66464a():jb.e");
    }

    /* renamed from: b */
    public final String m66465b(InputStream inputStream) {
        return C0209d.m1290o2(inputStream);
    }
}
