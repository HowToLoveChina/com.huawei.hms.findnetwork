package p735wb;

import java.io.InputStream;
import p015ak.C0209d;
import p705vb.C13393b;

/* renamed from: wb.a */
/* loaded from: classes3.dex */
public class C13580a {

    /* renamed from: a */
    public C13393b f61082a = null;

    /* JADX WARN: Can't wrap try/catch for region: R(7:60|37|(2:64|38)|66|39|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005c, code lost:
    
        p514o9.C11839m.m70687e("NPSInfoConfig", "Close FileInputStream failed!");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p705vb.C13393b m81582a() throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "get Config From File"
            java.lang.String r2 = "NPSInfoConfig"
            p514o9.C11839m.m70688i(r2, r1)
            android.content.Context r1 = p015ak.C0213f.m1377a()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r1 = r1.getFilesDir()
            r3.append(r1)
            java.lang.String r1 = "/HiCloudNPSConfig.json"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "file.exists(): "
            r1.append(r4)
            boolean r4 = r3.exists()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            p514o9.C11839m.m70688i(r2, r1)
            r1 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L67
            java.lang.String r1 = r7.m81583b(r4)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r3.<init>()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            java.lang.Class<vb.b> r5 = p705vb.C13393b.class
            java.lang.Object r1 = r3.fromJson(r1, r5)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            vb.b r1 = (p705vb.C13393b) r1     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
            r7.f61082a = r1     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
        L58:
            r4.close()     // Catch: java.io.IOException -> L5c
            goto L9f
        L5c:
            p514o9.C11839m.m70687e(r2, r0)
            goto L9f
        L60:
            r7 = move-exception
            r1 = r4
            goto La2
        L63:
            r1 = move-exception
            goto L6a
        L65:
            r7 = move-exception
            goto La2
        L67:
            r3 = move-exception
            r4 = r1
            r1 = r3
        L6a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r3.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = "cloud config file not exist, msg:"
            r3.append(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r5 = r1.getMessage()     // Catch: java.lang.Throwable -> L60
            r3.append(r5)     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L60
            p514o9.C11839m.m70687e(r2, r3)     // Catch: java.lang.Throwable -> L60
            java.lang.String r3 = "om_file_parse_result"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r5.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r6 = " Exception: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L60
            r5.append(r1)     // Catch: java.lang.Throwable -> L60
            java.lang.String r1 = r5.toString()     // Catch: java.lang.Throwable -> L60
            com.huawei.hicloud.notification.manager.GuideH5ReportUtil.reportH5GuideDialogOperaitonResult(r3, r1)     // Catch: java.lang.Throwable -> L60
            if (r4 == 0) goto L9f
            goto L58
        L9f:
            vb.b r7 = r7.f61082a
            return r7
        La2:
            if (r1 == 0) goto Lab
            r1.close()     // Catch: java.io.IOException -> La8
            goto Lab
        La8:
            p514o9.C11839m.m70687e(r2, r0)
        Lab:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p735wb.C13580a.m81582a():vb.b");
    }

    /* renamed from: b */
    public final String m81583b(InputStream inputStream) {
        return C0209d.m1290o2(inputStream);
    }
}
