package p285fc;

import com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean;
import java.io.InputStream;
import p015ak.C0209d;

/* renamed from: fc.a */
/* loaded from: classes3.dex */
public class C9682a {

    /* renamed from: a */
    public SafeConfigBean f47899a = null;

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|33|3|(2:28|4)|30|5|19|20|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0044, code lost:
    
        p514o9.C11839m.m70687e("SafeInfoConfig", "Close FileInputStream failed!");
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean m60506a() throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "Close FileInputStream failed!"
            java.lang.String r1 = "get Config From File"
            java.lang.String r2 = "SafeInfoConfig"
            p514o9.C11839m.m70688i(r2, r1)
            android.content.Context r1 = p015ak.C0213f.m1377a()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.io.File r1 = r1.getFilesDir()
            r3.append(r1)
            java.lang.String r1 = "/HiCloudFooterLink.json"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.io.File r3 = new java.io.File
            r3.<init>(r1)
            r1 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L4d java.lang.Exception -> L4f
            java.lang.String r1 = r6.m60507b(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r3.<init>()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.Class<com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean> r5 = com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean.class
            java.lang.Object r1 = r3.fromJson(r1, r5)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean r1 = (com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean) r1     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r6.f47899a = r1     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
        L40:
            r4.close()     // Catch: java.io.IOException -> L44
            goto L6d
        L44:
            p514o9.C11839m.m70687e(r2, r0)
            goto L6d
        L48:
            r6 = move-exception
            r1 = r4
            goto L70
        L4b:
            r1 = move-exception
            goto L52
        L4d:
            r6 = move-exception
            goto L70
        L4f:
            r3 = move-exception
            r4 = r1
            r1 = r3
        L52:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
            r3.<init>()     // Catch: java.lang.Throwable -> L48
            java.lang.String r5 = "cloud config file not exist, msg:"
            r3.append(r5)     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L48
            r3.append(r1)     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L48
            p514o9.C11839m.m70687e(r2, r1)     // Catch: java.lang.Throwable -> L48
            if (r4 == 0) goto L6d
            goto L40
        L6d:
            com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean r6 = r6.f47899a
            return r6
        L70:
            if (r1 == 0) goto L79
            r1.close()     // Catch: java.io.IOException -> L76
            goto L79
        L76:
            p514o9.C11839m.m70687e(r2, r0)
        L79:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p285fc.C9682a.m60506a():com.huawei.android.hicloud.safeinfo.bean.SafeConfigBean");
    }

    /* renamed from: b */
    public final String m60507b(InputStream inputStream) {
        return C0209d.m1290o2(inputStream);
    }
}
