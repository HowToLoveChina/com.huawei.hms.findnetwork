package com.huawei.hms.ads.identifier;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.feature.dynamic.p119f.C5335e;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;

/* renamed from: com.huawei.hms.ads.identifier.f */
/* loaded from: classes8.dex */
public class C5072f {
    /* renamed from: a */
    public static String m30263a(Context context) {
        return m30264a(context, "com.huawei.hwid") ? "com.huawei.hwid" : m30264a(context, "com.huawei.hms") ? "com.huawei.hms" : m30264a(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    /* renamed from: b */
    public static PackageInfo m30265b(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "getPackageInfo NameNotFoundException";
            Log.w("ApkUtil", str2);
            return null;
        } catch (Exception unused2) {
            str2 = "getPackageInfo Exception";
            Log.w("ApkUtil", str2);
            return null;
        }
    }

    /* renamed from: c */
    public static String m30266c(Context context, String str) {
        byte[] bArrM30267d = m30267d(context, str);
        if (bArrM30267d == null || bArrM30267d.length == 0) {
            return null;
        }
        return C5073g.m30268a(C5075i.m30315a(bArrM30267d));
    }

    /* renamed from: d */
    private static byte[] m30267d(Context context, String str) {
        String str2;
        PackageInfo packageInfo;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr.length > 0) {
                        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                        try {
                            byte[] encoded = CertificateFactory.getInstance(C5335e.f24726b).generateCertificate(byteArrayInputStream2).getEncoded();
                            AbstractC5076j.m30317a(byteArrayInputStream2);
                            return encoded;
                        } catch (RuntimeException e10) {
                            e = e10;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes RuntimeException:" + e.getClass().getSimpleName();
                            Log.e("ApkUtil", str2);
                            AbstractC5076j.m30317a(byteArrayInputStream);
                            Log.i("ApkUtil", "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayInputStream = byteArrayInputStream2;
                            str2 = "getPackageSignatureBytes Exception:" + th.getClass().getSimpleName();
                            Log.e("ApkUtil", str2);
                            AbstractC5076j.m30317a(byteArrayInputStream);
                            Log.i("ApkUtil", "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        }
                    }
                }
            } catch (RuntimeException e11) {
                e = e11;
            } catch (Throwable th3) {
                th = th3;
            }
            AbstractC5076j.m30317a(byteArrayInputStream);
            Log.i("ApkUtil", "Failed to get application signature certificate fingerprint.");
            return new byte[0];
        } catch (Throwable th4) {
            AbstractC5076j.m30317a(byteArrayInputStream);
            throw th4;
        }
    }

    /* renamed from: a */
    public static boolean m30264a(Context context, String str) {
        return m30265b(context, str) != null;
    }
}
