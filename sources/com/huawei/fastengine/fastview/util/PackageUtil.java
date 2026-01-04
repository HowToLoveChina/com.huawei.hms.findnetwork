package com.huawei.fastengine.fastview.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

/* loaded from: classes5.dex */
public class PackageUtil {
    private static final String TAG = "PackageUtil";

    public static String getAppSignSha256(PackageManager packageManager, String str) {
        PackageInfo packageInfo = getPackageInfo(packageManager, str);
        if (packageInfo == null) {
            return null;
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr.length > 0) {
            return getSha256(signatureArr[0].toByteArray());
        }
        return null;
    }

    public static PackageInfo getPackageInfo(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d(TAG, "getPackageInfo exception");
            return null;
        }
    }

    public static String getSha256(byte[] bArr) throws NoSuchAlgorithmException {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return String.format("%1$032X", new BigInteger(1, messageDigest.digest())).toLowerCase(Locale.ENGLISH);
        } catch (NoSuchAlgorithmException e10) {
            Log.w(TAG, "getSha256 error", e10);
            return null;
        }
    }

    public static boolean isAppInstalled(Context context, String str) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }
}
