package com.huawei.hms.feature.dynamic.p119f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.openalliance.p169ad.constant.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* renamed from: com.huawei.hms.feature.dynamic.f.d */
/* loaded from: classes8.dex */
public class C5334d {

    /* renamed from: a */
    public static final String f24722a = "SignVerifier";

    /* renamed from: b */
    public static final String f24723b = "com.huawei.hms.fingerprint_signature";

    /* renamed from: c */
    public static final String f24724c = "com.huawei.hms.sign_certchain";

    /* renamed from: a */
    public static String m31896a(PackageInfo packageInfo) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length == 0) {
            Logger.m30737e(f24722a, "Failed to get application signature certificate fingerprint.");
            return null;
        }
        byte[] byteArray = signatureArr[0].toByteArray();
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        return C5332b.m31891b(m31900a(byteArray), true);
    }

    /* renamed from: b */
    public static boolean m31901b(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "The context is null or module path is invalid.";
        } else if (!m31898a(str)) {
            str2 = "The module file is in wrong format.";
        } else {
            if (m31897a(context, str)) {
                return true;
            }
            str2 = "check signature failed.";
        }
        Logger.m30737e(f24722a, str2);
        return false;
    }

    /* renamed from: a */
    public static boolean m31897a(Context context, String str) {
        String string;
        ApplicationInfo applicationInfo;
        StringBuilder sb2;
        String str2;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 192);
        if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
            string = "PackageArchiveInfo is null.";
        } else {
            String str3 = packageArchiveInfo.packageName;
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null) {
                sb2 = new StringBuilder();
                sb2.append("Verify package ");
                sb2.append(str3);
                str2 = " failed for metadata is null.";
            } else if (!bundle.containsKey(f24723b)) {
                sb2 = new StringBuilder();
                sb2.append("Verify package ");
                sb2.append(str3);
                str2 = " failed for no signer.";
            } else if (bundle.containsKey(f24724c)) {
                String strM31896a = m31896a(packageArchiveInfo);
                if (TextUtils.isEmpty(strM31896a)) {
                    string = "Get PackageSignature failed: null.";
                } else {
                    if (m31899a(bundle.getString(f24723b), bundle.getString(f24724c), str3 + "&" + strM31896a)) {
                        Logger.m30740i(f24722a, "verify signature with cert chain success.");
                        return true;
                    }
                    string = "Check CertChain failed.";
                }
            } else {
                sb2 = new StringBuilder();
                sb2.append("Verify package ");
                sb2.append(str3);
                str2 = " failed for no cert chain.";
            }
            sb2.append(str2);
            string = sb2.toString();
        }
        Logger.m30737e(f24722a, string);
        return false;
    }

    /* renamed from: a */
    public static boolean m31898a(String str) throws IOException {
        String str2;
        try {
            new ZipFile(str).close();
            return true;
        } catch (ZipException unused) {
            str2 = "Check module file ZipException: not a valid zip.";
            Logger.m30744w(f24722a, str2);
            return false;
        } catch (IOException unused2) {
            str2 = "Check module file IOException";
            Logger.m30744w(f24722a, str2);
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m31899a(String str, String str2, String str3) throws UnsupportedEncodingException {
        String str4;
        byte[] bytes;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str4 = "Args is invalid.";
        } else {
            List<X509Certificate> listM31912b = C5335e.m31912b(str2);
            if (listM31912b.size() == 0) {
                str4 = "CertChain is empty.";
            } else if (C5335e.m31909a(C5335e.m31903a(), listM31912b)) {
                X509Certificate x509Certificate = listM31912b.get(0);
                if (!C5335e.m31907a(x509Certificate, "Huawei CBG HMS Kit")) {
                    str4 = "CN is invalid";
                } else if (C5335e.m31914b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                    try {
                        bytes = str3.getBytes(Constants.UTF_8);
                    } catch (UnsupportedEncodingException e10) {
                        Logger.m30738e(f24722a, "checkCertChain UnsupportedEncodingException:", e10);
                        bytes = null;
                    }
                    if (C5335e.m31910a(x509Certificate, bytes, AbstractC5331a.m31887a(str))) {
                        return true;
                    }
                    str4 = "signature is invalid: ";
                } else {
                    str4 = "OU is invalid";
                }
            } else {
                str4 = "failed to verify cert chain";
            }
        }
        Logger.m30737e(f24722a, str4);
        return false;
    }

    /* renamed from: a */
    public static byte[] m31900a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e10) {
            Logger.m30737e(f24722a, "NoSuchAlgorithmException" + e10.getMessage());
            return new byte[0];
        }
    }
}
