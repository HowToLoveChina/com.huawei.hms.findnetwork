package p752wu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;
import su.C12860b;

/* renamed from: wu.c */
/* loaded from: classes9.dex */
public class C13641c {

    /* renamed from: a */
    public static Context f61336a;

    /* renamed from: a */
    public static Context m82014a() {
        return f61336a;
    }

    /* renamed from: b */
    public static Intent m82015b(Intent intent) {
        Context context = f61336a;
        if (context == null) {
            C12860b.m77197a("PackageUtil", "createExplicitFromImplicitIntent context is null");
            throw null;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            C12860b.m77197a("PackageUtil", "getPackageManager is null");
            return null;
        }
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() != 1) {
            C12860b.m77205i("PackageUtil", "createExplicitFromImplicitIntent implicitIntent List are null");
            return null;
        }
        ActivityInfo activityInfo = listQueryIntentActivities.get(0).activityInfo;
        String str = activityInfo.packageName;
        String str2 = activityInfo.name;
        if (!m82021h(str)) {
            C12860b.m77197a("PackageUtil", "createExplicitActivityIntent verifyAppIdentity failed");
            return null;
        }
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    /* renamed from: c */
    public static File m82016c(String str) throws IOException {
        File file = new File(str);
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            C12860b.m77197a("WearEngineFileUtil", "createFileFromPfd parentFile is invalid");
            return null;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x00ef: MOVE (r2 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:62:0x00ef */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #2 {all -> 0x0012, blocks: (B:4:0x0003, B:7:0x000e, B:15:0x001e, B:17:0x0022, B:29:0x0079, B:31:0x007f, B:37:0x0095, B:52:0x00cc, B:83:0x0133, B:84:0x013c, B:80:0x0128, B:64:0x00f4, B:70:0x010a, B:20:0x002c, B:21:0x0050, B:23:0x0056, B:24:0x005e, B:25:0x0063, B:27:0x0068, B:28:0x0071), top: B:89:0x0003, inners: #3, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.io.BufferedInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.io.File m82017d(java.lang.String r8, android.os.ParcelFileDescriptor r9) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p752wu.C13641c.m82017d(java.lang.String, android.os.ParcelFileDescriptor):java.io.File");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m82018e(android.content.Context r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "getPackageCertificate IOException"
            r1 = 0
            java.lang.String r2 = "PackageUtil"
            if (r5 == 0) goto L95
            boolean r3 = android.text.TextUtils.isEmpty(r6)
            if (r3 == 0) goto Lf
            goto L95
        Lf:
            android.content.pm.PackageManager r5 = r5.getPackageManager()
            r3 = 0
            if (r5 != 0) goto L1d
            java.lang.String r5 = "getPackageManager is null"
        L18:
            su.C12860b.m77197a(r2, r5)
            r5 = r1
            goto L67
        L1d:
            r4 = 64
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r4)     // Catch: java.lang.Throwable -> L4a java.security.cert.CertificateException -> L4c android.content.pm.PackageManager.NameNotFoundException -> L55
            if (r5 == 0) goto L64
            android.content.pm.Signature[] r5 = r5.signatures     // Catch: java.lang.Throwable -> L4a java.security.cert.CertificateException -> L4c android.content.pm.PackageManager.NameNotFoundException -> L55
            int r6 = r5.length     // Catch: java.lang.Throwable -> L4a java.security.cert.CertificateException -> L4c android.content.pm.PackageManager.NameNotFoundException -> L55
            if (r6 <= 0) goto L64
            r5 = r5[r3]     // Catch: java.lang.Throwable -> L4a java.security.cert.CertificateException -> L4c android.content.pm.PackageManager.NameNotFoundException -> L55
            byte[] r5 = r5.toByteArray()     // Catch: java.lang.Throwable -> L4a java.security.cert.CertificateException -> L4c android.content.pm.PackageManager.NameNotFoundException -> L55
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L4a java.security.cert.CertificateException -> L4c android.content.pm.PackageManager.NameNotFoundException -> L55
            r6.<init>(r5)     // Catch: java.lang.Throwable -> L4a java.security.cert.CertificateException -> L4c android.content.pm.PackageManager.NameNotFoundException -> L55
            java.lang.String r5 = "X.509"
            java.security.cert.CertificateFactory r5 = java.security.cert.CertificateFactory.getInstance(r5)     // Catch: java.lang.Throwable -> L47 java.security.cert.CertificateException -> L4d android.content.pm.PackageManager.NameNotFoundException -> L56
            java.security.cert.Certificate r5 = r5.generateCertificate(r6)     // Catch: java.lang.Throwable -> L47 java.security.cert.CertificateException -> L4d android.content.pm.PackageManager.NameNotFoundException -> L56
            r6.close()     // Catch: java.io.IOException -> L43
            goto L67
        L43:
            su.C12860b.m77197a(r2, r0)
            goto L67
        L47:
            r5 = move-exception
            r1 = r6
            goto L8b
        L4a:
            r5 = move-exception
            goto L8b
        L4c:
            r6 = r1
        L4d:
            java.lang.String r5 = "getPackageCertificate CertificateException"
            su.C12860b.m77197a(r2, r5)     // Catch: java.lang.Throwable -> L47
            if (r6 == 0) goto L64
            goto L5d
        L55:
            r6 = r1
        L56:
            java.lang.String r5 = "getPackageCertificate NameNotFoundException"
            su.C12860b.m77197a(r2, r5)     // Catch: java.lang.Throwable -> L47
            if (r6 == 0) goto L64
        L5d:
            r6.close()     // Catch: java.io.IOException -> L61
            goto L64
        L61:
            su.C12860b.m77197a(r2, r0)
        L64:
            java.lang.String r5 = "getPackageCertificate failed to get certificate"
            goto L18
        L67:
            if (r5 == 0) goto L8a
            byte[] r5 = r5.getEncoded()     // Catch: java.security.cert.CertificateEncodingException -> L85
            java.lang.String r6 = "SHA-256"
            java.security.MessageDigest r6 = java.security.MessageDigest.getInstance(r6)     // Catch: java.security.NoSuchAlgorithmException -> L78 java.security.cert.CertificateEncodingException -> L85
            byte[] r5 = r6.digest(r5)     // Catch: java.security.NoSuchAlgorithmException -> L78 java.security.cert.CertificateEncodingException -> L85
            goto L7f
        L78:
            java.lang.String r5 = "digest NoSuchAlgorithmException"
            su.C12860b.m77197a(r2, r5)     // Catch: java.security.cert.CertificateEncodingException -> L85
            byte[] r5 = new byte[r3]     // Catch: java.security.cert.CertificateEncodingException -> L85
        L7f:
            r6 = 1
            java.lang.String r5 = p752wu.C13639a.m82009c(r5, r6)     // Catch: java.security.cert.CertificateEncodingException -> L85
            return r5
        L85:
            java.lang.String r5 = "getPackageFingerprint CertificateEncodingException"
            su.C12860b.m77197a(r2, r5)
        L8a:
            return r1
        L8b:
            if (r1 == 0) goto L94
            r1.close()     // Catch: java.io.IOException -> L91
            goto L94
        L91:
            su.C12860b.m77197a(r2, r0)
        L94:
            throw r5
        L95:
            java.lang.String r5 = "getPackageFingerprint params is empty"
            su.C12860b.m77205i(r2, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p752wu.C13641c.m82018e(android.content.Context, java.lang.String):java.lang.String");
    }

    /* renamed from: f */
    public static void m82019f(Context context) {
        f61336a = context.getApplicationContext();
    }

    /* renamed from: g */
    public static void m82020g(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                C12860b.m77197a("WearEngineFileUtil", "closeQuietly IOException");
            }
        }
    }

    /* renamed from: h */
    public static boolean m82021h(String str) throws Throwable {
        C12860b.m77203g("PackageUtil", "verifyAppIdentity package name is : " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.equals("com.huawei.health")) {
            C12860b.m77197a("PackageUtil", "verifyAppIdentity app's queryPkgName is not equal");
            return false;
        }
        String strM82018e = m82018e(f61336a, str);
        if (TextUtils.isEmpty(strM82018e)) {
            C12860b.m77197a("PackageUtil", "verifyAppIdentity app's fp is empty");
            return false;
        }
        if (strM82018e.equals("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05") || strM82018e.equals("B2881B2EE3D4EFA03342AE07DAFC0466B63EDE959EC2E2F58C05A54266F45748")) {
            return true;
        }
        C12860b.m77197a("PackageUtil", "verifyAppIdentity app's fp is not equal");
        return false;
    }
}
